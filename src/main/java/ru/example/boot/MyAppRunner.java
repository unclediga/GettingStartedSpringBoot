package ru.example.boot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner output:");
        for (String optionName : args.getOptionNames()) {
            System.out.println("   optName:" + optionName);
        }
    }
}
