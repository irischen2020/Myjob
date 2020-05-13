import com.sun.deploy.util.StringUtils;
import com.test.utils.StringsUtils;
import org.junit.Test;

public class TestStringsToFiles {
	@Test
	public void test(){
		StringsUtils.StringsToFiles("123","f:\\11.txt");
		System.out.println("写入成功");
	}
}
