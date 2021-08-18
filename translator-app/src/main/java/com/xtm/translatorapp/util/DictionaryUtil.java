package com.xtm.translatorapp.util;

import org.springframework.stereotype.Component;

@Component
public class DictionaryUtil {

    public static String[] splitSentenceByWords(String str){

        if(str == null || str.equals(""))
            return new String[0];

        String[] words = str.split(" ");

        return words;
    }

    public static String insertQuotes(String sentence){
        String quotedSentence="";

      String[] words =splitSentenceByWords(sentence);
        for(String word: words) {
            quotedSentence += '\u0022' + word + '\u0022';
        }
        return quotedSentence;
    }

}

