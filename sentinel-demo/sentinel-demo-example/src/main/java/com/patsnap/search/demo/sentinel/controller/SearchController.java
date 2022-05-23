package com.patsnap.search.demo.sentinel.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.patsnap.search.demo.sentinel.model.PatentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author bing
 * @date 4/26/22
 **/
@RestController
public class SearchController {

    @ResponseBody
    @PostMapping("/search")
    @SentinelResource(value = "search", entryType = EntryType.IN, fallback = "searchFallback")
    public String search(@RequestBody PatentRequest patentRequest) {
        return (patentRequest.getUserId() + ":" + patentRequest.getQuery() + "\n Time:" + LocalDateTime.now().toString());
    }

    public String searchFallback() {
        return "search fall back, timestamp: " + System.currentTimeMillis();
    }

}
