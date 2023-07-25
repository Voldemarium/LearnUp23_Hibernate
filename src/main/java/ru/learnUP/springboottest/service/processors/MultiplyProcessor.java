package ru.learnUP.springboottest.service.processors;

import org.springframework.stereotype.Component;
import ru.learnUP.springboottest.service.Operation;
import ru.learnUP.springboottest.service.Processor;

@Component
public class MultiplyProcessor implements Processor {
    @Override
    public Operation getOperation() {
        return Operation.MULTIPLY;
    }

    @Override
    public int process(int a, int b) {
        return a * b;
    }
}
