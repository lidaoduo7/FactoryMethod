/**
 * 进阶方式理解工厂07，对06的改进升级
 * 在项目中可能有几十个类同时实现了同一个接口，那么此时用户如何知道已有的接口子类？
 * 用一种代号---》去代表子类的包.类名称（key--value）
 * 要有一个文件列表，给用户列出全部的代码 --》子类的映射
 * 这种实现解决了用户无法知道全部子类的问题，同时通过Properties保存了全部的子类信息，之后
 * 通过代码操作进行。
 * 程序中依然存在问题：如果程序现扩充了一个子类，则需要修改设置的属性
 * 解决的途径，就是通过保存Properties中的内容，以后修改文件即可，而不用去修改类
 * 
 * 最后，一个接口需要一个工厂的话，那么如果有100个接口，则会出现100个工厂，程序的维护就会很困难了！
 */
package com.liduo.factory07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * @author lab404
 *在eclipse中包下配置，然后运行
 */
interface Fruit {
	//生长
	public void grow();
	//采摘
	public void pick();
}

class Apple implements Fruit
{
	public void grow()
	{
		System.out.println("苹果在生长。。。");
	}
	public void pick()
	{
		System.out.println("摘苹果。。。");
	}
}

class Orange implements Fruit
{
	public void grow()
	{
		System.out.println("橘子在生长。。。");
	}
	public void pick()
	{
		System.out.println("摘橘子。。。");
	}
}
//2-如果现在扩充了一个子类，则要修改工厂
class Cherry implements Fruit
{
	public void grow()
	{
		System.out.println("樱桃在生长。。。");
	}
	public void pick()
	{
		System.out.println("摘樱桃。。。");
	}
}
class Banana implements Fruit
{
	public void grow()
	{
		System.out.println("香蕉在生长。。。");
	}
	public void pick()
	{
		System.out.println("摘香蕉。。。");
	}
}
//工厂类是工厂方法模式的核心，这个类包含了创建产品的jue策策略，它jueding如何和何时创建what产品对象
//!!!!这种实现存在问题：
//1-如果输入的参数错误，则会出现空指向异常（由于没有定义类，而却在命令行参数中传入）
//2-如果现在扩充了一个子类，则要修改工厂（工厂中如果没有子类的判断，则无法使用这个子类）
class Factory
{
	public static Fruit getFruitInstance(String type)
	{
		Fruit f = null ;
	//通过Class类完成实例化过程
		//解决了工厂由于增加子类需要修改的问题，但是新的问题又出现了：在项目中可能有几十个类同时
		//实现了同一个接口，那么此时用户如何知道已有的接口子类？
		try {
			f=(Fruit) Class.forName(type).newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		return f ;
	}
}
//定义一个新类，此类可以从键盘输入数据
class InputData
{
	BufferedReader buf=null;
	public InputData()
	{
		buf=new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString()
	{
		String str=null;
		try {
			str=buf.readLine();
		} catch (Exception e) {
		}
		return str;
	}
}
//通过保存Properties中的内容到外部配置文件xml中，以后修改文件即可，而不用去修改类
class Init
{
	public static Properties getPropertiesInit() throws Exception
	{
		Properties p=new Properties();
		p.loadFromXML(new FileInputStream("lxh.xml"));
		return p;
	}
}
public class FactoryDemo07 {//主方法相当于一个客户端
	public static void main(String[] args) throws Exception {
		Properties p=new Properties();
		p=Init.getPropertiesInit();
		System.out.println(p);
		
		//加入一个从键盘输入数据的类
		System.out.println("输入要使用的子类代码：");
		String code=new InputData().getString();
		
		//Fruit f=Factory.getFruitInstance(code);
		/*
		f.grow();
		f.pick();
		*/
		//1-如果输入的参数错误，则会出现空指向异常（由于没有定义类，而却在命令行参数中传入），
		//加判断
		System.out.println(p.getProperty(code));
		Fruit f=Factory.getFruitInstance(p.getProperty(code));
		if(f!=null)
		{
			f.grow();
			f.pick();
		}
		else
		{
			System.out.println("没有发现这个类型");
		}
	}
}
