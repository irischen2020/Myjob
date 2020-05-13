import com.test.web.Webpage;
import org.junit.Test;


public class TestWebpage {
	
	@Test
	public void getUrlHtml(){
		
		Webpage webpage = new Webpage();
		webpage.setPageUrl("http://www.baidu.com");
		String s = webpage.getPageSource();
		System.out.println(s);
	}
}
