package ru.learnUP.springboottest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component  //@Component = значит этот класс - Бин
@Lazy       //Бины с аннотацией Lazy(ленивый) инициализируются не сразу при старте приложения, а при их использовании
            //(для экономии оперативной памяти)
public class ValueService {

    private static final Logger log = LoggerFactory.getLogger(ValueService.class);

    private final String value;

    public ValueService(
            @Value("${service.value}") String value) {  //@Value означает, что переменная является свойством
        this.value = value;                             //service.value - ключ из resources/application.properties
    }

    public void print() {
          log.info("{}", value);
    }

}

