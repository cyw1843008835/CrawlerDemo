package Demo1.CrawlerDemo1;

import java.io.File;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class Demo8 {
   
	@Test
	public void domTest()throws Exception{
		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"),
				"utf-8");
		Element element = doc.getElementById("city");
		System.out.println(element.text());
		
		Element element1 = doc.getElementsByTag("h1").first();
		System.out.println(element1.text());
		
		Element element2 = doc.getElementsByClass("c2").first();
		System.out.println(element2.text());
		
		Element element3 = doc.getElementsByAttribute("abc").first();
		System.out.println(element3.text());
		
		Element element4 = doc.getElementsByAttributeValue("href", "www.local.com1").first();
		System.out.println(element4.text());
		
}
	/**
	 * 从元素中获取id
	 * 从元素中获取classname
	 * 从元素中获取attr
	 * 从元素中获取attributes
	 * 从元素中获取文本内容
	 */
	
	@Test
	public void testData()throws Exception{
		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"),
				"utf-8");
		String str = "";
		
		Element e1 = doc.getElementById("list");
		str = e1.id();
		str = e1.className();
		str = e1.attr("id");
		str = e1.text();
		System.out.println(str);
		
		Attributes at = e1.attributes();
		System.out.println(at.toString());
		
	
		
		
		
		
		
		
		
		
	}
}
