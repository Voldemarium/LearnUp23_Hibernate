package ru.learnUP.springboottest.service.processors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.learnUP.springboottest.service.Operation;
import ru.learnUP.springboottest.service.Processor;

@Component
//@Primary                  //приоритетный бин, назначится бином, остальные не сделаются бинами
@Scope(value = "singleton") //управление временем жизни бина
//@Profile("testing")         //Профиль (определяется в свойствах (application.properties))
//можно разные бины относить к тому или иному профилю, при определении в application.properties конкретного профиля
//будут формироваться только бины, относящиеся к этому профилю
public class SumProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.PLUS;
    }

    @Override
    public int process(int a, int b) {
        return a + b;
    }
}
