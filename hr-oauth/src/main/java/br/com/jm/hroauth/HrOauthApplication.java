package br.com.jm.hroauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication implements CommandLineRunner {

    //@Value("${oauth.client.name}")
    //private String clientName;

    public static void main(String[] args) {
        SpringApplication.run(HrOauthApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // System.out.println("Client ->>>>>>>>>>>>>> " + clientName);
    }
}
