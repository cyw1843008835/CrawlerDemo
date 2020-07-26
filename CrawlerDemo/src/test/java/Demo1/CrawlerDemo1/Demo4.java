package Demo1.CrawlerDemo1;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Demo4 {
public static void main(String[] args) throws Exception {
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");
	//申明list封装表单中的参数
	List<NameValuePair> params = new ArrayList<NameValuePair>();
	params.add(new BasicNameValuePair("keys","java"));
	
	//创建表单entity对象
	UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf-8");
	
	//设置表单entity对象到post请求中
	httpPost.setEntity(formEntity);
	
	CloseableHttpResponse response = null;
	try {
		response = httpClient.execute(httpPost);
		if(response.getStatusLine().getStatusCode() == 200) {
			String content = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(content);
		}
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
