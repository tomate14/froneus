package org.example.froneus.infraestructure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "dinosaur.exchange";
    public static final String QUEUE = "dinosaur.status.queue";
    public static final String ROUTING_KEY = "dinosaur.status";

    @Bean
    public DirectExchange dinosaurExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue dinosaurStatusQueue() {
        return new Queue(QUEUE);
    }

    @Bean
    public Binding binding(Queue dinosaurStatusQueue, DirectExchange dinosaurExchange) {
        return BindingBuilder.bind(dinosaurStatusQueue).to(dinosaurExchange).with(ROUTING_KEY);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }
}
