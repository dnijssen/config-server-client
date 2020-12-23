package org.example.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableConfigurationProperties(ClientProperties.class)
public class ConfigClientApplication {

    private final ClientProperties clientProperties;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    public ConfigClientApplication(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void initAfterStartup() {
        System.out.println(clientProperties.getTest());
    }
}

@ConfigurationProperties(prefix = "config-client")
class ClientProperties {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}