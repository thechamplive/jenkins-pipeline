package com.example.jenkinspipelinedocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsPipelineDockerApplication {


    @GetMapping("/message")
    public String message(){
        return "jenkins pipeline ci-cd with docker";
    }

    public static void main(String[] args) {
        SpringApplication.run(JenkinsPipelineDockerApplication.class, args);
    }

}
