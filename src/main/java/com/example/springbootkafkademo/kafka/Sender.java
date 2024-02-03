package com.example.springbootkafkademo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Value("${spring.kafka.topics.demo}")
    private String topic;

    public void send(String text){
        try {
            kafkaTemplate.send(new ProducerRecord<>(topic, text ));
        }catch (Exception e){
            log.warn("Error while sending text!");
        }
    }

    public void send(List<String> testList) {
        testList.parallelStream().forEach(
                this::send
        );
    }
}
