package com.tenco.class_mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

    /**
     * 주소 설계 - http://localhost:8080/temp1
     * 
     * @return
     */
    @GetMapping("/temp1")
    public String index() {
        log.debug("디버그");
        log.info("인포");
        log.warn("경고");
        log.error("에러");
        return "Log Test ok";
    }
}
