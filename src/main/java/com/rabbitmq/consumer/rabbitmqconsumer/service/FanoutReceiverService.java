package com.rabbitmq.consumer.rabbitmqconsumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.consumer.rabbitmqconsumer.domain.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FanoutReceiverService {

    @Autowired
    ObjectMapper objectMapper;

    @RabbitListener(queues = "fanout")
    @RabbitHandler
    public void process(Project project) {

        log.info("Receive Project(fanout): ");
        log.info("        Project Id: {}", project.getProjectId());
        log.info("        Project Name: {}", project.getProjectName());
        log.info("        Client Id: {}", project.getClientId());
        log.info("        Start Date: {}", project.getStartDate());
        log.info("        Close Date: {}", project.getCloseDate());
    }
}
