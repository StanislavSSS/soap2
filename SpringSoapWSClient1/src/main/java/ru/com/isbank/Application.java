package ru.com.isbank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.com.isbank.ws.HelloWSResponce;

/**
 * Created by sk10271 on 13.04.2017.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean
    CommandLineRunner lookup(final SpringSoapWSClient springSoapWSClient) {
        return args -> {
            String word = "MSFT";

            if (args.length > 0) {
                word = args[0];
            }

            HelloWSResponce helloWSResponce = springSoapWSClient.getHelloWSResponceSpring(word);
            System.err.println(helloWSResponce.getWord());
        };
    }
}