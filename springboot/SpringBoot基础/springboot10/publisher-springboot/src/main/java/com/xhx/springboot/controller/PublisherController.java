package com.xhx.springboot.controller;

import com.xhx.springboot.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xuhaixing
 * 2018/5/6 17:57
 */
@RestController
@RequestMapping("publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping("{name}")
    public String sendMessage(@PathVariable("name") String name) {
        return publisherService.sendMessage(name);
    }
}
