/*
 *  Copyright 2019, Liwei Wang <daveywang@live.com>.
 *  All rights reserved.
 *  Author: Liwei Wang
 *  Date: 06/2019
 */

package com.ascending.training.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = {"/test"})
public class TestController {
    @Autowired private Logger logger;

    @RequestMapping(value = "/path/{pathValue1}/{pathValue2}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getPath(@PathVariable(name = "pathValue1") String p1, @PathVariable(name = "pathValue2") String p2) {
        logger.info(String.format(">>>>>>>>>> Path value: %s, %s", p1, p2));
        return p1 + ", " + p2;
    }

   
}