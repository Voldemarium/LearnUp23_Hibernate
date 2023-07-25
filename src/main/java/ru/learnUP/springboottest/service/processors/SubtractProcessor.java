package ru.learnUP.springboottest.service.processors;

import org.springframework.stereotype.Component;
import ru.learnUP.springboottest.service.Operation;
import ru.learnUP.springboottest.service.Processor;

@Component
//@Profile("production")         //Профиль (определяется в свойствах (application.properties))
public class SubtractProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.MINUS;
    }

    @Override
    public int process(int a, int b) {
        return a - b;
    }
}
