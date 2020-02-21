package com.example;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.example.model.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: akka-quickstart-java
 * @description: akka kv db
 * @author: wl.zhou
 * @create: 2020-02-20 17:59
 **/
public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String,Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(SetRequest.class, message -> {
            log.info("Received Set request: {}", message);
            map.put(message.getKey(), message.getValue());
        }).matchAny(o -> log.info("received unkown message: {}", o)).build();
    }
}
