/**
 * 进阶方式理解工厂05，对04的改进升级
 */
package com.liduo.factory05;
/**
 * @author lab404
 *在eclipse中包下配置，然后运行
 *水果接口，苹果、香蕉实现类，多了一个草莓类，现在又多了一个香蕉类
 *通过在工厂中使用Class类完成实例化过程
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
//添加一个工厂
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
			f=(Fruit) Class.forName("com.liduo.factory05."+type).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f ;
	}
}

public class FactoryDemo05 {//主方法相当于一个客户端
	public static void main(String[] args) {
		if(args.length==0)
		{
			System.out.println("必须输入一个要使用的名称");
			System.exit(1);
		}
		
		Fruit f=Factory.getFruitInstance(args[0]);//
		/*
		f.grow();
		f.pick();
		*/
		//1-如果输入的参数错误，则会出现空指向异常（由于没有定义类，而却在命令行参数中传入），
		//加判断
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
