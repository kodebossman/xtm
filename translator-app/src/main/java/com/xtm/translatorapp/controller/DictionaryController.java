package com.xtm.translatorapp.controller;


import com.xtm.translatorapp.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DictionaryController {

    private DictionaryService dictionaryService;


}
