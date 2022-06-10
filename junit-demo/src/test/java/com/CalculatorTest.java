package com;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class CalculatorTest {
	
	static Calculator c1;
	@BeforeEach // earlier @Before
	@DisplayName(value = "run before all")
	public void adc()
	{
		System.out.println("Before each test case...");
	}
	
	@BeforeAll
	public static void first()
	{
		System.out.println("...Started...");
		c1 = new Calculator();
	}
	
	@AfterEach // @After
	public void xyz()
	{
		System.out.println("After each test case...");
	}
	
	@AfterAll
	public static void last()
	{
		c1 = null;
		System.out.println("...Ended...");
	}

	@Test
	@Tag("Math")
	void testAdd() {
		assertEquals(50, c1.add(20,30));
	}
	
	@Test
	@Tag("Math")
	void testSub() {
		assertAll(
				()->assertEquals(-10, c1.sub(20,30)),
				()->assertEquals(-20, c1.sub(40,60)),
				()->assertEquals(20, c1.sub(20,0)),
				()->assertEquals(-10, c1.sub(20,30))
				);
		
	}
	
	@Test
	@Tag("Math")
	void testMultiply() {
		assertEquals(600, c1.multiply(20,30));
	}
	
	@Test
	@Tag("Math")
	void testDivide() {
		assertEquals(2, c1.devide(40,20));
	}
	
	@Test
	@Tag("Demo")
	@EnabledOnJre(JRE.JAVA_8)
	void testDefaultMethodInInterface()
	{
		System.out.println("test method");
	}
	
	@Test
	@Tag("Demo")
	@EnabledOnOs(value = OS.WINDOWS)
	void testWindows()
	{
		System.out.println("test method");
	}
	
	@Test
	@Tag("Demo")
	@EnabledOnOs(value = OS.LINUX)
	@Disabled // @Ignore
	void testLinux()
	{
		System.out.println("test method");
	}
	
	@Test
	@Tag("Demo")
	void testDynamically()
	{
		assumeTrue(true);
		assertEquals(20, c1.add(20, 0));
	}
	
	@Test
	public void testVoidMethod()
	{
		Calculator cal = mock(Calculator.class);
		
	    doNothing().when(cal).printSquare(isA(Integer.class));
	    
	    cal.printSquare(2);
	 
	    verify(cal, times(1)).printSquare(2);
	}
	
	@Test
	public void testInterfaceMethod()
	{
		ExampleInterface ex = mock(ExampleInterface.class);
		doNothing().when(ex).demo();
		ex.demo();
		verify(ex, times(1)).demo();
	}
}
