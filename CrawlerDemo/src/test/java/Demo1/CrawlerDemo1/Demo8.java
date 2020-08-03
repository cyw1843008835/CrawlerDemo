package Demo1.CrawlerDemo1;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class Demo8 {

	@Test
	public void domTest() throws Exception {
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
	 * 从元素中获取id 从元素中获取classname 
	 * 从元素中获取attr 
	 * 从元素中获取attributes 
	 * 从元素中获取文本内容
	 */

	@Test
	public void testData() throws Exception {
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

	/**
	 * tagname :通过标签查找元素
	 *  #id：通过id查找元素 
        class:通过class查找元素 
        attribute:通过属性查找元素
	 * attr=value:利用属性值查找元素
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSelector() throws Exception {

		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"),
				"utf-8");

		Elements e1s = doc.select("span");
		for (Element e1 : e1s) {
			System.out.println(e1);
		}

		Element e2 = doc.select("#city").first();
		System.out.println(e2.text());

		Element e3 = doc.select(".c2").first();
		System.out.println(e3.text());

		Element e4 = doc.select("[abc]").first();
		System.out.println(e4.text());

		Element e5 = doc.select("[abc=123]").first();
		System.out.println(e5.text());
	}

	/**
	 * 选择器组合使用  
	 * 元素+id 
	 * 元素+class 
	 * 元素+属性名 任意组合
	 */
	@Test
	public void testSelector2() throws Exception {
		Document doc = Jsoup.parse(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\test.html"),
				"utf-8");
		
        Element e1 = doc.select("h1#city") .first();
        System.out.println(e1.text());
        
        Element e2 = doc.select("div.c1") .first();
        System.out.println(e2.text());
        
        Element e3 = doc.select("span[abc]") .first();
        System.out.println(e3.text());
                
        Element e4 = doc.select("span[abc].cj") .first();
        System.out.println(e4.text());
	}
}
