package com.example.springbootkafkademo.controller;

import com.example.springbootkafkademo.kafka.Sender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mertcan Özarslan
 */

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final Sender sender;

    @GetMapping
    public ResponseEntity<String> init(){
        return ResponseEntity.ok("hello  kafka");
    }

    @GetMapping("/sendKafka")
    public void sayHello(){
        List<String> textList = new ArrayList<>();
        textList.add("Hello");
        textList.add("Kafka");
        textList.add("Demo");
        sender.send(textList);
    }
}
