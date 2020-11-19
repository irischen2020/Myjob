import com.atguigu.bean.Person;
import com.atguigu.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestPerson {
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void test01(){
		Person person = (Person) ioc.getBean("person");
		System.out.println(person);
	}
	@Test
	public void test02() throws SQLException {
		//1、从容器中拿到连接池
		//2、按照类型获取组件，可以获取到这个类型下的所有实现类子类等等……
		DataSource bean = ioc.getBean("dataSource",DataSource.class);
		System.out.println(bean.getConnection());
	}
	@Test
	public void test03(){
		BookDao  bookDao = (BookDao) ioc.getBean("bookDao");
		System.out.println(bookDao);
	}
}
