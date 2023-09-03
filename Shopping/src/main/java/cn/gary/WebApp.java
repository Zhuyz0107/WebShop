package cn.gary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//网站启动器
@SpringBootApplication
@EnableTransactionManagement
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class,args);
    }
}
