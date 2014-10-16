/**
 * 进阶方式理解工厂03
 */
package com.liduo.factory03;
/**
 * @author lab404
 *在eclipse中包下配置
 *水果接口，苹果、橘子实现类
 *工厂方法模式，
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
//!!!!这种实现存在问题：
//1-如果输入的参数错误，则会出现空指向异常（由于没有定义类，而却在命令行参数中传入）
//2-如果现在扩充了一个子类，则要修改工厂
class Factory
{
	//通过向函数提供一个type参数，根据该参数来创建不同的产品的对象
	//解决前面漏洞问题“如果现在客户（main）要求既可以使用Apple对象，也可以使用Orange对象，则无法通过工厂完成”
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
		return f ;
	}
}
public class FactoryDemo03 {//主方法相当于一个客户端
	public static void main(String[] args) {
		//这里是通过命令行参数传入，在eclipse中包下配置
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
		//一种解决途径是加判断
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
