package com.xtm.translatorapp.util;

import org.springframework.stereotype.Component;

import java.util.*;

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

    public static Map<String,Integer> getWordFrequency(Map<String,String> dictionaryDb){

        HashMap<String,Integer > duplicateMap = new HashMap<>();

        Set<Map.Entry<String, String>> entrySet = dictionaryDb.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String value = entry.getValue();

            if(duplicateMap.containsKey(value)) {

                duplicateMap.replace(value, duplicateMap.get(value) + 1);
            } else {
                duplicateMap.put(value, 1);
            }
        }
        return sortByValue(duplicateMap);
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        //function to sort the word frequency result
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}

