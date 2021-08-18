package com.xtm.translatorapp;

import com.xtm.translatorapp.service.DictionaryService;
import com.xtm.translatorapp.service.DictionaryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TranslatorAppApplicationTests {

    @Autowired
	TranslatorAppApplication translatorAppApplication;
	@Autowired
	DictionaryServiceImpl dictionaryService;

	@Test
	void contextLoads() {

		Assertions.assertNotNull(translatorAppApplication.runner(dictionaryService));
		 Assertions.assertFalse(dictionaryService.getDictionaryDB().isEmpty());

	}


}
