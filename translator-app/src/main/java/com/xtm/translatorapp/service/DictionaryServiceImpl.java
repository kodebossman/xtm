package com.xtm.translatorapp.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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

}
