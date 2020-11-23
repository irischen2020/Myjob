//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class TestJDBCTemplate {
//
//	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext02.xml");
//	//不用以下方法自己创建，在XML文件里面配置好，直接从IOC容器里面拿
////		JdbcTemplate jdbcTemplate = new JdbcTemplate(bean);
//	JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
//
//	@Test
//	public void test01() throws SQLException {
//		DataSource bean = applicationContext.getBean(DataSource.class);
////		Connection connection = bean.getConnection();
////		System.out.println(connection);
//
//	}
//}
