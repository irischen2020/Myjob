package apple.littletest;

import apple.baks.JDBCUtil;
import org.testng.annotations.Test;


public class JdbcDemo {
	@Test
	//查询,改成读取配置文件的数据库信息。JDBC类库的封装。返回MAP
	public void testutils(){
		String sql = "select id,regname,leaveamount from member where mobilephone=? and Type=?";
		Object[] values = {"18330372028","1"};
		JDBCUtil.query(sql,values);
	}

}
