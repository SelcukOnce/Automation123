package com.automationpractice.demos.staticdemo;

public class App {

	public static void main(String[] args) {
		
		A a1 = new A();
		A a2 = new A();
		A.name="new name";
		
		B b1 = new B();
		B b2 = new B();
		b1.setName("new b name");
		
		
		
		
		System.out.println(a1.getName());//?
		System.out.println(a2.getName());//?
		
		System.out.println(b1.getName());//?
		System.out.println(b2.getName());//?

	}

}

