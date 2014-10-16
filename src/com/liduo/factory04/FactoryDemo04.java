/**
 * 进阶方式理解工厂04
 */
package com.liduo.factory04;
/**
 * @author lab404
 *在eclipse中包下配置，然后运行
 *水果接口，苹果、橘子实现类，现在又多了一个草莓类
 *现在扩充了一个子类，则要修改工厂了
 *这个例子是一个说明！
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
//工厂
//!!!!这种实现存在问题：
//1-如果输入的参数错误，则会出现空指向异常（由于没有定义类，而却在命令行参数中传入）
//2-如果现在扩充了一个子类，则要修改工厂（工厂中如果没有子类的判断，则无法使用这个子类）
class Factory
{
	public static Fruit getFruitInstance(String type)
	{
		Fruit f = null ;
		if("Apple".equals(type))
		{
			f = new Apple() ;
		}
		if("Orange".equals(type))
		{
			f = new Orange() ;
		}
		//2-如果现在扩充了一个子类，则要修改工厂
		if("Cherry".equals(type))
		{
			f = new Cherry() ;
		}
		return f ;
	}
}

public class FactoryDemo04 {//主方法相当于一个客户端
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
