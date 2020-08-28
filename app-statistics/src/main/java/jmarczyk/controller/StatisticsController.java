package jmarczyk.controller;

import jmarczyk.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StatisticsController {
    @Autowired
    public StatisticsService testService;

    @GetMapping(path = "stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> testController() {
        log.info("Stats incremented");
        return Mono.empty();
    }
}