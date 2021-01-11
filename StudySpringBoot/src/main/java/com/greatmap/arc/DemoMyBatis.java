package com.greatmap.arc;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;

import java.net.InetAddress;

@SpringBootApplication
public class DemoMyBatis {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoMyBatis.class);
        ConfigurableApplicationContext context = app.run(args);

        try {
            app.setBannerMode(Banner.Mode.CONSOLE);
            app.setBanner(new ResourceBanner(new ClassPathResource("banner.txt")));

            ConfigurableEnvironment ev = context.getEnvironment();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            String port = ev.getProperty("server.port");
            String contextPath = ev.getProperty("server.servlet.context-path") ;

            System.out.println(String.format("服务地址:http://%s:%s%s", hostAddress, port, contextPath == null ? "" : contextPath) );
            System.out.println(String.format("Swagger地址:http://%s:%s%s/swagger-ui.html", hostAddress, port, contextPath == null ? "" : contextPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
