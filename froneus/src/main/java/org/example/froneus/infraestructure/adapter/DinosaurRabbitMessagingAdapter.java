package org.example.froneus.infraestructure.adapter;

import org.example.froneus.application.mapper.DinosaurMessagingMapper;
import org.example.froneus.domain.model.Dinosaur;
import org.example.froneus.domain.model.request.DinosaurMessageRequest;
import org.example.froneus.domain.port.DinosaurMessagePublisherPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DinosaurRabbitMessagingAdapter implements DinosaurMessagePublisherPort {
    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public DinosaurRabbitMessagingAdapter(RabbitTemplate rabbitTemplate,
                                    @Value("${rabbitmq.exchange}") String exchange,
                                    @Value("${rabbitmq.routingKey}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Override
    public void publishDinosaurUpdated(Dinosaur dinosaur) {
        DinosaurMessageRequest message = DinosaurMessagingMapper.toDto(dinosaur);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
