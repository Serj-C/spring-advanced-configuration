package com.example;

import com.example.profiles.FoodProviderService;
import com.example.profiles.configuration.HighSchoolConfig;
import com.example.profiles.configuration.KindergartenConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {HighSchoolConfig.class, KindergartenConfig.class})
@ActiveProfiles("kindergarten") // This annotation can be used only for tests
class ProfilesJavaConfigTest {

	@Autowired
	FoodProviderService foodProviderService;

	@Test
	void foodProviderServiceTest() {
		Assertions.assertNotNull(foodProviderService.provideLunchSet());
		Assertions.assertFalse(foodProviderService.provideLunchSet().isEmpty());
		Assertions.assertEquals(2, foodProviderService.provideLunchSet().size());
	}

}
