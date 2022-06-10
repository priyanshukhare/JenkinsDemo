package com;

public class Calculator {
	
	public int add(int a, int b)
	{
		return a+b;
	}

	public int sub(int a, int b)
	{
		return a-b;
	}

	public int divide(int a, int b)
	{
		return a/b;
	}

	public int multiply(int a, int b)
	{
		return a*b;
	}
	
	public void printSquare(int a)
	{
		System.out.println(a*a);
	}
	
	public static void main(String[] args)
	{
		Calculator c = new Calculator();
		System.out.println("**************Started*************** ");
		System.out.println("Adding operation: "+c.add(20,30));
		System.out.println("Subtraction operation: "+c.sub(40,10));
		System.out.println("Multiply operation: "+c.multiply(40,10));
		System.out.println("**************Finished*************** ");
	}

}
