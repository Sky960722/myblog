package com.sry.springboot.myblog;

import com.sry.springboot.myblog.config.Constants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.context.WebServerPortFileWriter;

import java.io.File;

@MapperScan("com.sry.springboot.myblog.dao")
@SpringBootApplication
public class MyblogApplication {

    public static void main(String[] args) {
        // 开启了devtools工具，这个才是真正的地方关闭reload
        SpringApplication springApplication = new SpringApplication(MyblogApplication.class);
        // 将当前程序启动的pid和端口都写入文件中
        springApplication.addListeners(new ApplicationPidFileWriter() );
        springApplication.run(args);
    }

}
