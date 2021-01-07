package com.example.demo;

import com.example.demo.model.Calculation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient(timeout = "PT1M")
@ActiveProfiles("test")
@SpringBootTest
public
class DemoApplicationTests {

	public static final List<Integer> testValues = new ArrayList<>();

	public static final List<Integer> testResult = new ArrayList<>();


	public static final String user = "TestUser";
	public static final Integer total = 5;

	public static final Calculation calculation = new Calculation(user, total, testValues, testResult);

	@Test
	void contextLoads() {
		testValues.add(1);
		testValues.add(2);
		testValues.add(3);
		testResult.add(2);
		testResult.add(3);

	}

}
