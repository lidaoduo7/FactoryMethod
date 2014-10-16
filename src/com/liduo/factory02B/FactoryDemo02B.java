/**
 * 进阶方式理解工厂02
 */
package com.liduo.factory02B;

/**
 * @author lab404
 *水果接口，苹果、橘子实现类
 *“这个例子演示”静态工厂方法模式（简单工厂模式）“
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
//进阶---->引出“工厂方法模式”
//添加一个工厂，工厂方法函数负责创建产品对象，
//!!!!如果现在客户（main）要求既可以使用Apple对象，也可以使用Orange对象，则无法通过工厂完成
//进阶---->引出“多个工厂方法模式”
//这里的不足就是我们在每一次创建水果（fruit）实例需要使用工厂类时，都需要创建一个工厂对象。
//进阶---->引出“静态工厂方法模式（简单工厂模式）”
//将工厂方法设置为静态的，可以直接引用工厂类的方法来创建产品
class Factory
{
	public static Fruit getApple()
	{
		return new Apple();
	}
	public static Fruit getOrange()
	{
		return new Orange();
	}
}

public class FactoryDemo02B {//主方法相当于一个客户端
	public static void main(String[] args) {
		Fruit o=Factory.getOrange();//
		o.grow();
		o.pick();
		Fruit a=Factory.getApple();//
		a.grow();
		a.pick();
	}
}
