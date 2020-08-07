package ru.example.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCLIRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner output:");
        for (String arg : args) {
            System.out.println("   arg:" + arg);
        }
    }
}
