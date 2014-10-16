/**
 * 提交到git
 * 进阶方式理解工厂01
 */
package com.liduo.factory01;

/**
 * @author lab404
 *水果接口，苹果、橘子实现类
 *通过new实例化对象，这种情况子类必须与父类结合，耦合度较高
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

public class FactoryDemo01 {
	public static void main(String[] args) {
		Fruit f=new Orange();//子类必须与父类结合，耦合度较高
		//f.grow();
		f.pick();
	}
}
