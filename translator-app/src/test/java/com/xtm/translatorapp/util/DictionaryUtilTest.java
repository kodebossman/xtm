package com.xtm.translatorapp.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryUtilTest {

    Map<String, String> dictionaryDB = new HashMap<>();
    String sentence ="";
    @BeforeEach
    void setUp() {
        dictionaryDB.put("sample1","sample trans1");
        dictionaryDB.put("a","A");
        dictionaryDB.put("b","B");
        dictionaryDB.put("c","C");
        dictionaryDB.put("e","E");
        dictionaryDB.put("d","E");
        sentence+="a b c e";
    }

    @Test
    void splitSentenceByWords() {

        Assertions.assertTrue(DictionaryUtil.splitSentenceByWords(sentence).length==5);
        Assertions.assertTrue(DictionaryUtil.splitSentenceByWords("").length==0);

    }

    @Test
    void insertQuotes() {
        String quotedString = '\u0022' +"a"+'\u0022'+'\u0022' +"b"+'\u0022'+'\u0022' +"c"+'\u0022'+'\u0022' +"e"+'\u0022';
        Assertions.assertFalse(DictionaryUtil.insertQuotes(sentence).equals(sentence));
        Assertions.assertTrue(DictionaryUtil.insertQuotes(sentence).equals(quotedString));
    }

    @Test
    void getWordFrequency() {
       Map<String, Integer> frequencyMap= DictionaryUtil.getWordFrequency(dictionaryDB);
        Assertions.assertTrue(frequencyMap.containsKey("A"));
    }

    @Test
    void sortByValue() {
        Assertions.assertTrue(DictionaryUtil.getWordFrequency(dictionaryDB).containsValue(2));
    }

    @Test
    void getKeyByValue() {
     Assertions.assertTrue(DictionaryUtil.getKeyByValue(dictionaryDB,"C").equals("c"));
    }
}