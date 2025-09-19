package com.cb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@MapperScan("com.cb.mapper") // 扫描MyBatis Mapper
@EnableJpaRepositories("com.cb.entity.dataBaseEntity") // 扫描JPA仓库,主要用于自动创建表的，不需要建表时可省略）
public class PickingReportsMain {
    public static void main(String[] args) {
        SpringApplication.run(PickingReportsMain.class,args);
    }
}
