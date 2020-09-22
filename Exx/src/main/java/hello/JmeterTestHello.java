package hello;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class JmeterTestHello extends AbstractJavaSamplerClient {
	
	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
		SampleResult sr = new SampleResult();
		sr.sampleStart();
		try {
			Hi hi = new Hi();
			//获取JMETER的参数
			String name = javaSamplerContext.getParameter("name");
			if(name.equals("bbb")){
				int x = 1/0;
			}
			String str = hi.hello(name);
			
			//设置响应数据
			sr.setResponseData(str, null);
			//设置是否成功
			sr.setSuccessful(true);
			sr.sampleEnd();
		}catch(Exception e){
			sr.setResponseData(e.getMessage(),null);
			sr.setSuccessful(false);
			sr.sampleEnd();
			e.printStackTrace();
		}
		return sr;
	}
	
	//设置默认参数
	public Arguments getDefaultParameters() {
		Arguments arguments = new Arguments();
		arguments.addArgument("name","aaa");
		return arguments;
	}
	

}
