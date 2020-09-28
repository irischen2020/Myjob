package apple.utils;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JDBCUtil {
	
	//静态代码块，拿到配置文件中的配置信息
	public static Properties prop;
	static {
		prop = FileUtil.readProp("src/test/resources/jdbc.properties");

	}
	/*
	
	 */
	public static Map<String,Object> query(String sql, Object ... values){
		Map<String,Object> columnLabelandValues = null;
		try {
			Connection conn = getConnection();
			//2、获取PreparedStatement对象（此类型的对象有提供数据库操作方法）
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			//3、根据传入的数组（可变参数），设置条件字段的值
			for(int i = 0; i < values.length; i++){
				ps.setObject(i+1, values[i] );
			}
//			ps.setObject(1,"18330372028");
		
			//4、调用查询方法，执行查询，返回ResultSet结果集
			ResultSet rs = ps.executeQuery();
			//获取查询SQL中的查询信息
			ResultSetMetaData metaData = rs.getMetaData();
			int columCount = metaData.getColumnCount();
		
			//5、从结果集取查询数据
			while (rs.next()){
				columnLabelandValues = new HashMap<String,Object>();
				//根据metaData依次取每个列名,并且循环取出每个字段的值
				for (int i =1;i<=columCount;i++){
					String columnLabel = metaData.getColumnLabel(i);
					String columnValue = rs.getObject(columnLabel).toString();
					columnLabelandValues.put(columnLabel,columnValue);
				}
//				String regname = rs.getObject("RegName").toString();
//				String leaveamount = rs.getObject("LeaveAmount").toString();
//				System.out.println(regname);
//				System.out.println(leaveamount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnLabelandValues;
	}
	
	public static Connection getConnection() throws SQLException {
		String url = prop.getProperty("jdbc.url");
		String user = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");
		//1、根据连接信息，获得数据库连接
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
}
