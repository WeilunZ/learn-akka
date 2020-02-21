package com.example.model;

/**
 * @program: akka-quickstart-java
 * @description:
 * @author: wl.zhou
 * @create: 2020-02-20 17:57
 **/
public class SetRequest {
    private final String key;
    private final Object value;

    public SetRequest(String key, Object value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
