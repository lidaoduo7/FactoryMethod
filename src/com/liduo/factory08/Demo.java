package com.liduo.factory08;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */

/**
 * @author lab404
 *
 */
public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties p=new Properties();
		p.setProperty("a", "com.liduo.factory07.Apple");
		p.setProperty("o", "com.liduo.factory07.Orange");
		p.setProperty("b", "com.liduo.factory07.Banana");
		p.setProperty("c", "com.liduo.factory07.Cherry");
		//在文件中保存一段数据，此数据是以上的数据内容
		p.storeToXML(new FileOutputStream("lxh.xml"), "MLDN-->LXH");
		
		//需要从文件中读取Properties中的属性
		p.loadFromXML(new FileInputStream("lxh.xml"));
		System.out.println(p);
	}

}
