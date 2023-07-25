package ru.learnUP.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import ru.learnUP.springboottest.service.Operation;
//import ru.learnUP.springboottest.service.Processor;
//import ru.learnUP.springboottest.service.registry.ProcessorRegistry;
//import java.util.Map;
//
//@Configuration  //аннотация @Configuration подразумевает формирование внутри себя бинов
//public class AppConfig {
//
//    @Bean    //формирование бинов внутри этого метода
//    public ProcessorRegistry processorRegistry(
//            Processor sumProcessor,
//            Processor subtractProcessor,
//            Processor multiplyProcessor
//    ) {
//        return new ProcessorRegistry(Map.of(
//                Operation.PLUS, sumProcessor,
//                Operation.MINUS, subtractProcessor,
//                Operation.MULTIPLY, multiplyProcessor
//        ));
//    }
//
//}
