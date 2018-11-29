package graphqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GraphqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlDemoApplication.class, args);
    }
}
