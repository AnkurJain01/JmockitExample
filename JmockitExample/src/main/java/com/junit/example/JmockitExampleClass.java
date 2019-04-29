package com.junit.example;

public class JmockitExampleClass {

	private int testField;
	
	// TO demonstrate the use of dependency injection, we shall not assign explicit value
	// to members of this class in a constructor
	// We shall inject these values using Jmockit framework
	private JmockitDependentClass jmockitDependent;

	public int jmockitTest() {
		System.out.println("This is Jmockit Test Example");
		
		return jmockitDependent.dependentClassMethod() + staticMethod(testField) + privateMethod();
	}
	
	// we will mock this private method to return 2
	private int privateMethod() {
		return testField + 2;
	}

	//we will mock this method to always return 5
	private static int staticMethod(int testField) {
		return testField + 1;
	}
	
	
}
