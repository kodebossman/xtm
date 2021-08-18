package com.xtm.translatorapp.controller;


import com.xtm.translatorapp.common.SentenceMode;
import com.xtm.translatorapp.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DictionaryController {

    private DictionaryService dictionaryService;

    @SneakyThrows
    @GetMapping(value = "/dictionary/translate/{sentence}/{mode}")

    public ResponseEntity<String> getSentenceTranslation(@PathParam("sentence") String sentence, @PathParam("mode") SentenceMode mode) throws IOException {

        log.info("Get Sentence translation for : {} ", sentence);

        String translation = dictionaryService.getSentenceTranslation(sentence,mode);
        return new ResponseEntity<>( translation, HttpStatus.OK);

    }

    @GetMapping(value = "/dictionary/frequency")

    public ResponseEntity<Map<String,Integer>> getSortedWordFrequency() throws IOException {

        Map<String,Integer> frequencyWordUsage = dictionaryService.getSortedWordsUsage();
        return new ResponseEntity<>( frequencyWordUsage, HttpStatus.OK);

    }

    }
