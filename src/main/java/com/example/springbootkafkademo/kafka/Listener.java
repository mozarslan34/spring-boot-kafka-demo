package com.example.springbootkafkademo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class Listener {

    @KafkaListener(topics = "${spring.kafka.topics.demo}" , groupId = "${spring.kafka.consumer.groupId}")
    public void listenTextList(List<String> textList){
        try{
            log.info("Listener says :");
           textList.forEach(System.out::println);
        }catch(RuntimeException e){
            log.warn("ERROR : "+e.getMessage());
        }

    }



}
