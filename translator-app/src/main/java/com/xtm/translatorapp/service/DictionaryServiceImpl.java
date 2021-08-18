package com.xtm.translatorapp.service;

import com.xtm.translatorapp.common.SentenceMode;
import com.xtm.translatorapp.util.DictionaryUtil;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@Data
public class DictionaryServiceImpl implements DictionaryService {

    private  Map<String,String> dictionaryDB = new HashMap<>();
    @Override
    public Map<String, String> write(HashMap<String, String> dictionary) {
        log.info("The dictionary is being saved "+dictionary);
        dictionaryDB.putAll(dictionary);
        return dictionaryDB;
    }

    @Override
    public String getSentenceTranslation(String sentence, SentenceMode mode) {

        String translatedSentence = null;
       String[] words = DictionaryUtil.splitSentenceByWords(sentence);
       for(String word: words){
           //check if word exist in db
           if(dictionaryDB.containsKey(word)){
               translatedSentence+= dictionaryDB.get(word);
           }
           else if(dictionaryDB.containsValue(word)){
               String mapKey = DictionaryUtil.getKeyByValue(dictionaryDB,word);
               if(mapKey==null){
                   //TODO handle these exception
                   return "This word can not be translated";
               }else {
                   translatedSentence+= mapKey;
               }
           }
           else {
               return "This word can not be translated: "+ word;
           }
       }
       if(mode.equals(SentenceMode.IN_WORDS)) {
           return translatedSentence;
       }else {
           return DictionaryUtil.insertQuotes(translatedSentence);
       }
    }

    @Override
    public Map<String, Integer> getSortedWordsUsage() {

        return DictionaryUtil.getWordFrequency(dictionaryDB);
    }

}
