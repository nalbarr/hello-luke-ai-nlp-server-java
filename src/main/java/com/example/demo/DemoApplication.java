package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class DemoApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @GetMapping("/hello")
    public String hello() {
        return "hello world.";
    }

    // NAA
    // - https://www.baeldung.com/spring-request-param
    @GetMapping("/hello2")
    public String hello2(@RequestParam(name="name", required = false, defaultValue = "xyz") String name)
    {
        return "Hello " + name;
    }

    @GetMapping("/")
        public String qzzz(@RequestParam(name="answer", required = false, defaultValue = "Donald Trump is president.") String name)
    {
        INLPProcessor processor = new OpenNLPProcessor(logger);
        String[] tokens = processor.process(name);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tokens.length; i++) {
            int last = tokens.length - 1;
            if (i != last) {
                sb.append(tokens[i] + ' ');
            } else {
                sb.append(tokens[i] + '.');
            }
        }
        return sb.toString();
    }

}
