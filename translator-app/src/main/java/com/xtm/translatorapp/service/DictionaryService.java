package com.xtm.translatorapp.service;

import com.xtm.translatorapp.common.SentenceMode;

import java.util.HashMap;
import java.util.Map;

public interface DictionaryService {

    Map<String,String> write(HashMap<String,String> dictionary);
    String getSentenceTranslation(String sentence, SentenceMode mode);
    Map<String,Integer> getSortedWordsUsage();

}
