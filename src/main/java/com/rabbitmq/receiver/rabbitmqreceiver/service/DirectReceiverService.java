package com.rabbitmq.receiver.rabbitmqreceiver.service;

import com.rabbitmq.receiver.rabbitmqreceiver.domain.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DirectReceiverService {

    @RabbitListener(queues = "direct1")
    @RabbitHandler
    public void process1(Project project) {

        log.info("Receive Project(direct1): ");
        log.info("        Project Id: {}", project.getProjectId());
        log.info("        Project Name: {}", project.getProjectName());
        log.info("        Client Id: {}", project.getClientId());
        log.info("        Start Date: {}", project.getStartDate());
        log.info("        Close Date: {}", project.getCloseDate());
    }
}
