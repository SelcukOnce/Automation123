package com.automationpractice.demos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	
	
	@Test
	public void testOne() {
	System.err.println("I am a test 1");
	}
	@Test
	public void testTwo() {
	System.out.println("I am a test 2");
	}
	@BeforeMethod
	public void before() {
	System.out.println("I run always before any test executes");
	}
	@AfterMethod
	public void after() {
	System.out.println("I run always after any test executes");
	}

	@BeforeClass
	public void beforeClass() {
	System.err.println("I run before a class");
	}

	@AfterClass
	public void afterClass() {
	System.err.println("I run class a class");
	}

	@BeforeSuite
	public void beforeSuite() {
	System.out.println("I run once and before entire suites run");
	}

	@AfterSuite
	public void afterSuite() {
	System.err.println("I run once and after entire suites run");
	}
	
}
