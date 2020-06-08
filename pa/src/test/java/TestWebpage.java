import com.test.leis.Webpage;
import org.junit.Test;


public class TestWebpage {
	
	@Test
	public void getUrlHtml(){
		
		Webpage webpage = new Webpage();
		webpage.setPageUrl("https://www.58pic.com/tupian/zhongguoqiantuwang.html");
		String s = webpage.getPageSource();
		webpage.getImageUrls();
	}
}
