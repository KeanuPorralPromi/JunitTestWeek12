package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	@Test
	public void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSqaured = mockDemo.randomNumberSquared();
		assertThat(fiveSqaured).isEqualTo(25);
	
	
	}
	@Test
	public void assertThatCorrectMessageIsReturned() {
	
	 assertEquals("Yes, it is cold outside", testDemo.doINeedAJacket(60));
	 assertEquals("Yes, it is cold outside", testDemo.doINeedAJacket(70));
	 assertEquals("Not really, it is pretty warm outside", testDemo.doINeedAJacket(75));
	 assertEquals("Not really, it is pretty warm outside", testDemo.doINeedAJacket(80));
	 assertEquals("No, unless if want to sweat like hell", testDemo.doINeedAJacket(85));
	
  }
	
	
	
	@Test 
 public	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
	assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
	assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPostiveNumbers")
	void assertThatTwoPostiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		

		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}

	}
 static Stream<Arguments> argumentsForAddPostiveNumbers () {
	// @formatter:off
	 return Stream.of(
			 arguments(2, 4, 6, false)
			 );
	// @formatter:on
 }





}

