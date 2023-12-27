package ch.wiss.lb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

@SpringBootApplication
@EnableCaching
@EnableAsync
public class M151ProjectApplication {
    private static final Logger log = LoggerFactory.getLogger(M151ProjectApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(M151ProjectApplication.class, args);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .sorted()
                .forEach(name -> log.trace(name));
    }
}