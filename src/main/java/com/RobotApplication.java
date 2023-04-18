package com;

import com.bot.FixProtocolVersion;
import com.bot.JavaMain;
import com.gpt.GPTService;
import com.gpt.chat.ChatService;
import com.gpt.model.ModelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class RobotApplication {
    public static void main(String[] args) {
        init();
        ConfigurableApplicationContext run = SpringApplication.run(RobotApplication.class, args);
        run.getBean(JavaMain.class).startBot();
//        run.getBean(ModelService.class).modelList();
    }

    static void init() {
        // System.setProperty("jdk.tls.useExtendedMasterSecret", "false");
        // 暂时修复mirai登录版本问题
        FixProtocolVersion.update();
        // System.out.println(FixProtocolVersion.info());
        // System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,SSLv3");
    }
}
