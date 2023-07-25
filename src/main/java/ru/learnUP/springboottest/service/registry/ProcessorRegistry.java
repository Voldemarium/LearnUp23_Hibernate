package ru.learnUP.springboottest.service.registry;

//import ru.learnUP.springboottest.service.Operation;
//import ru.learnUP.springboottest.service.Processor;
//import java.util.Map;
//
//public class ProcessorRegistry {
//
//    private final Map<Operation, Processor> registry;
//
//    public ProcessorRegistry(Map<Operation, Processor> registry) {
//        this.registry = registry;
//    }
//
//    public Processor findByType (Operation operation) {
//        if (!registry.containsKey(operation)) {
//            throw new RuntimeException("unknown operation");
//        }
//        return registry.get(operation);
//    }
//}
