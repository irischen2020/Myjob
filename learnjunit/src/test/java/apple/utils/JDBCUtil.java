package apple.utils;

import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
	
	//静态代码块，拿到配置文件中的配置信息
	public static Properties prop;
	public static String url;
	public static String user;
	public static String password;
	static {
		prop = FileUtil.ResolvePro("src/test/resources/jdbc.properties");
		url = prop.getProperty("jdbc.url");
		user = prop.getProperty("jdbc.username");
		password = prop.getProperty("jdbc.password");
	}
	
	public static void query(String sql,Object...values){
		
		try {
			//1、根据连接信息，获得数据库连接
			Connection conn = DriverManager.getConnection(url,user,password);
			//2、获取PreparedStatement对象（此类型的对象有提供数据库操作方法）
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(ps);
			//3、设置条件字段的值
			ps.setObject(1,"18330372028");
			//4、调用查询方法，执行查询，返回ResultSet结果集
			ResultSet rs = ps.executeQuery();
			//5、从结果集取查询数据
			while (rs.next()){
				String regname = rs.getObject("RegName").toString();
				String leaveamount = rs.getObject("LeaveAmount").toString();
				System.out.println(regname);
				System.out.println(leaveamount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
