package com.layman;

import com.layman.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName VoteDemoApplication
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/19 19:18
 * @Version 3.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.layman.mapper")
public class VoteDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoteDemoApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }
}
