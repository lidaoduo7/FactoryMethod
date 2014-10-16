/**
 * 进阶方式理解工厂02
 */
package com.liduo.factory02;

/**
 * @author lab404
 *水果接口，苹果、橘子实现类
 *这个例子演示“工厂方法模式”
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
//添加一个工厂，工厂方法函数负责创建产品对象，
//!!!!如果现在客户（main）要求既可以使用Apple对象，也可以使用Orange对象，则无法通过工厂完成
//进阶
class Factory
{
	public static Fruit getFruitInstance()
	{
		return new Orange();
	}
}

public class FactoryDemo02 {//主方法相当于一个客户端
	public static void main(String[] args) {
		Fruit f=Factory.getFruitInstance();//
		f.grow();
		f.pick();
	}
}
