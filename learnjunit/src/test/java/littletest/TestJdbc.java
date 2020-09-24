package littletest;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestJdbc {
	@Test
	//查询,改成读取配置文件的数据库信息。JDBC类库的封装。返回MAP
	public void query(){
		String url = "jdbc:mysql://test.lemonban.com/future?useUnicode=true&characterEncoding=utf-8";
		String user = "test";
		String password = "test";
		String sql = "select regname,leaveamount from member where mobilephone=?";
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
