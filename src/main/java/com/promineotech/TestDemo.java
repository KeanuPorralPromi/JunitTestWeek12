package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int randomNumberSquared() {
		
	int randomNumber = getRandomInt();
		
		return randomNumber * randomNumber;
		
	}

	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
		
	}

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive");
		}
		return a + b;
	}

	public String doINeedAJacket(int i) {
		String message;
		if (i < 75) {
			message = "Yes, it is cold outside";
		} else if (i < 85) {
			message = "Not really, it is pretty warm outside";
		} else {
			message = "No, unless if want to sweat like hell";
		}
		return message;
	}

}
