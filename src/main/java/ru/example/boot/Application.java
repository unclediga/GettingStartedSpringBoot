package ru.example.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
// @SpringBootApplication consist of:
//      @EnableAutoConfiguration
//      @ComponentScan
//      @Configuration
@SpringBootApplication
public class Application {
    @Value("${name}")
    String name;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @RequestMapping("/")
//    public String hello() {
//        return "Hello from " + name + "!";
//    }

    @Autowired
    String message;

    @RequestMapping("/message")
    public String helloBean() {
        return message;
    }

    @Autowired
    MyRandomNumber randomNumber;

    @RequestMapping("/rnd")
    public String randNum() {
        return "Random number is " + randomNumber.getNumber();
    }

    // if there are no one profiles provided, then need qualifiers
//    @Qualifier("myMessageA")
//    @Qualifier("myMessageB")
    @Autowired
    MyMessage myMessage;

    @RequestMapping("/profile")
    public String profileMessage() {
        return myMessage.getMessage();
    }

    @Autowired
    MyAutoConfigMessage autoConfigMessage;

    @RequestMapping("/automsg")
    public String autoConfMessage() {
        return autoConfigMessage.getMessageValue1() + "//" +
                autoConfigMessage.getMessageValue2() + "//" +
                autoConfigMessage.getMessageValue3();
    }

    @RequestMapping("/cat")
    @ResponseBody
    public Cat cat() {
        return new Cat("CatName", "CatBreed", 2);
    }

    @RequestMapping("/mustache")
    public ModelAndView mustache(Model model) {
        model.addAttribute("company", "Mega Power Inc.");
        return new ModelAndView("template", model.asMap());
    }
    // NOT WORKING ! :-(
//    @RequestMapping("/mustache")
//    public String mustache(Model model){
//        model.addAttribute("company", "Mega Power Inc.");
//        return "template";
//    }
}
