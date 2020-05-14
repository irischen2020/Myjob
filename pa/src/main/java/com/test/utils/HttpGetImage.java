package com.test.utils;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetImage {
	
	//将得到的输入流图片保存到本地
	public static void saveImageToDisk(URL url,String filePath) throws IOException {
		InputStream inputStream = getInputStream(url);
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/**
	 * 获得服务器端数据，以InputStream形式返回
	 *
	 * @return
	 * @throws IOException
	 */
	public static InputStream getInputStream(URL url) throws IOException {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;
		try {
//			URL url = new URL(URL_PATH);
			if (url != null) {
				httpURLConnection = (HttpURLConnection) url.openConnection();
				// 设置连接网络的超时时间
				httpURLConnection.setConnectTimeout(3000);
				httpURLConnection.setDoInput(true);
				// 设置本次http请求使用get方式请求
				httpURLConnection.setRequestMethod("GET");
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == 200) {
					// 从服务器获得一个输入流
					inputStream = httpURLConnection.getInputStream();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inputStream;
	}

//	/**
//	 * 获取图片
//	 * @param request
//	 * @param response
//	 */
//	public static void GetImage(HttpServletRequest request
//			, HttpServletResponse response){
//		try {
//			URL url = new URL("http://csdnimg.cn/www/images/csdnindex_logo.gif");
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//			conn.setRequestMethod("GET");
//			conn.setConnectTimeout(5 * 1000);
//			InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
//			byte data[] = readInputStream(inStream);
//			inStream.read(data);  //读数据
//			inStream.close();
//			response.setContentType("image/jpg"); //设置返回的文件类型
//			OutputStream os = response.getOutputStream();
//			os.write(data);
//			os.flush();
//			os.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	public static byte[] readInputStream(InputStream inStream) throws Exception{
//		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//		byte[] buffer = new byte[2048];
//		int len = 0;
//		while( (len=inStream.read(buffer)) != -1 ){
//			outStream.write(buffer, 0, len);
//		}
//		inStream.close();
//		return outStream.toByteArray();
//	}
//
//	/**
//	 * 上传首页图片
//	 * @param request
//	 * @param response
//	 */
//	public void UploadHomeImage(HttpServletRequest request
//			, HttpServletResponse response){
//		//存储文件，同时获取表单中的输入值对
//		Map<String, String> nameValuePair = new HashMap<String, String>();
//
//		//户型图片存储对象
//		HomeImage homeImage = new HomeImage();
//
//		//获取存储的地址，同时捕获参数值对
//		String imageUrl = saveUploadFile(request,  "/Upload/HomeImage/", nameValuePair);
//
//		homeImage.setImageUrl(imageUrl);
//		homeImage.setUploadDate(new Date());
//
//		settingService.saveOrUpdateHomeImage(homeImage);
//
//		//获取信息界面显示类
//		HomeImagePage responsePage = settingService.getWebHomePage();
//
//		//将页面显示数据类转化为JSON，返回前端
//		responseOutWithJson(response, responsePage);
//		response.setStatus(HttpServletResponse.SC_OK);
//	}
}
