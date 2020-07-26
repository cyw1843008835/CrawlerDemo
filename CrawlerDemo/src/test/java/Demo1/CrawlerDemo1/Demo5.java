package Demo1.CrawlerDemo1;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class Demo5 {
public static void main(String[] args) {
	//创建连接池管理器
	PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	//设置连接数
	cm.setMaxTotal(100);
	//设置每个主机的最大连接数
	cm.setDefaultMaxPerRoute(10);
	//使用连接池管理器发起请求
	doGet(cm);

}
private static void doGet(PoolingHttpClientConnectionManager cm) {
CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
HttpGet httpGet = new HttpGet("http://www.itcast.cn");
CloseableHttpResponse response = null; 
try {
	response =httpClient.execute(httpGet);
	if(response.getStatusLine().getStatusCode() == 200) {
	String content	 = EntityUtils.toString(response.getEntity(),"utf-8");
	System.out.println(content.length());
	}
} catch (ClientProtocolException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	//httpclient有连接池管理，不能关闭
	if(response != null) {
		try {
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
}
