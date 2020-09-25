package apple.littletest;

import apple.utils.JDBCUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcDemo {
	@Test
	//查询,改成读取配置文件的数据库信息。JDBC类库的封装。返回MAP
	public void testutils(){
		String sql = "select id,regname,leaveamount from member where mobilephone=? and Type=?";
		Object[] values = {"18330372028","1"};
		JDBCUtil.query(sql,values);
		Ass
	}

}
