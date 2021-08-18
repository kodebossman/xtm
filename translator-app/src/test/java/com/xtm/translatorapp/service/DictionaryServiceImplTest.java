package com.xtm.translatorapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryServiceImplTest {


    DictionaryServiceImpl dictionaryService = new DictionaryServiceImpl();

    @Test
    void write() {
        HashMap<String, String > sampleDictionary = new HashMap<>();
        sampleDictionary.put("sample word", "sample translation");
        sampleDictionary.put("sampleword1","sample translation1");
        Assertions.assertFalse(dictionaryService.write(sampleDictionary).isEmpty());
    }

}