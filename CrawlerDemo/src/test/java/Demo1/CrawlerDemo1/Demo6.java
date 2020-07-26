package Demo1.CrawlerDemo1;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ResponseAuthCache;
import org.apache.http.impl.client.CloseableHttpClient;

public class Demo6 {
	public static void main(String[] args) {
		
		CloseableHttpClient httpClient=HttpClients.createDefault();
		
		HttpGet httpGet=new HttpGet("http://www.itcast.cn");
	//配置请求信息
		RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)//设置创建连接的最长时间
				.setConnectionRequestTimeout(500)//设置获取连接的最长时间
				.setSocketTimeout(10*1000)//设置数据传输的最长时间
				.build();
		//给请求设置请求信息
		httpGet.setConfig(config);
		
		CloseableHttpResponse response=null;
		try {
			response=httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==200) {
				HttpEntity httpEntity=response.getEntity();
				String content=EntityUtils.toString(httpEntity,"utf-8");
				System.out.println(content);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				//4.get response
		
	}
    
	
}
