package com.marketplace.propertiesservice.backend;

import com.marketplace.propertiesservice.configuration.QueueConfiguration;
import com.marketplace.propertiesservice.model.Property;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PropertyReceiver {

    @RabbitListener(queues = QueueConfiguration.queueName)
    public void receiveMessage(Property message) {
        System.out.println(message.toString());
        // TODO: Retrieve users with a search matching this new property
        // TODO: send email
    }
}
