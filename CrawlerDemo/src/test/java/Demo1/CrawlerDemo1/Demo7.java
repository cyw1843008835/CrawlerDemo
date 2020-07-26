package Demo1.CrawlerDemo1;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class Demo7 {
	@Test
	public void testUrl() throws Exception {
		// 解析url
		Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
		// 使用标签选择器获取title标签内容
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);

	}

	@Test
	public void testString() throws Exception {
		// 解析字符串
		String content = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"), "utf-8");
		Document doc = Jsoup.parse(content);
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);
	}

	@Test
	public void testFile() throws Exception {
		// 解析文件
		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"),
				"utf-8");
		String title = doc.getElementsByTag("title").first().text();
		System.out.println(title);
	}

}
