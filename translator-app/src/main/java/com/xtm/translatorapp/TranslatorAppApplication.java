package com.xtm.translatorapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xtm.translatorapp.service.DictionaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@SpringBootApplication
public class TranslatorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DictionaryService dictionaryService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<HashMap<String,String>> typeReference = new TypeReference<HashMap<String,String>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/dictionary.json");
			try {
				HashMap<String,String> dictionary = mapper.readValue(inputStream,typeReference);
				dictionaryService.write(dictionary);
				System.out.println("Dictionary Loaded!");
			} catch (IOException e){
				System.out.println("Unable to Load Dictionary File: " + e.getMessage());
			}
		};
	}
}
