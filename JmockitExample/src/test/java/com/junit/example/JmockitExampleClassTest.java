package com.junit.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class JmockitExampleClassTest {

	@Tested
	private  JmockitExampleClass jmockitExampleClass;
	
	@Injectable
	private JmockitDependentClass jmockitDependent;
	
	@Injectable
	private int testField;
	
	@Before
	public void setup() {
		
		testField = 5;
	}
	
	@Test
	public void testBasicJmockitTestMethod() {
		
		new MockUp<JmockitExampleClass>() {
			
			@Mock
			int privateMethod() {
				return 4;
			}
			
			@Mock
			int staticMethod(int testField) {
				return 3;
			}
			
		};
		
		new Expectations() {
			{
				jmockitDependent.dependentClassMethod();
				result = 1;
			}
		};
		
		assertEquals(8, jmockitExampleClass.jmockitTest());
	}
}
