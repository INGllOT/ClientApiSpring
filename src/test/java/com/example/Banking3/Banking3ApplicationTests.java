package com.example.Banking3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class Banking3ApplicationTests {

	Calculator underTest = new Calculator();

	@Test
	void itAddNumb() {
		// given
		int n1 = 20;
		int n2 = 30;

		// when
		int result = underTest.add(n1, n2);

		// then
		assertThat(result).isEqualTo(51);
	}

	class Calculator {
		int add(int a, int b) {
			return a + b;
		}
	}
}
