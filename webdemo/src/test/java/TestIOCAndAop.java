import com.atguigu.aop.Calculator;
import com.atguigu.aop.MyMathCalculator;
import com.atguigu.bean.Person;
import com.atguigu.dao.BookDao;
import com.atguigu.service.BookService;
import com.atguigu.service.UserService;
import com.atguigu.servlet.BookServlet;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestIOCAndAop {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext04-aop.xml");
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
	@Test
	public void test04(){
		BookServlet bookServlet = (BookServlet) ioc.getBean("bookServlet");
		bookServlet.doGet();
	}
	
	@Test
	public void test05(){
		BookService bookService = ioc.getBean(BookService.class);
		UserService userService = ioc.getBean(UserService.class);
		bookService.save();
		userService.save();
	}
	
	
	@Test
	public void test06(){
		//从IOC容器中拿到目标对象。注意：如果想要用类型，一定用他的接口类型，不要用它本类
		Calculator calculator = ioc.getBean(Calculator.class);
		calculator.add(1,2);
		calculator.div(2,0);
	}
}
