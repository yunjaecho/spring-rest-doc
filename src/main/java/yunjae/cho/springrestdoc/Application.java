package yunjae.cho.springrestdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
/*  jar 파일 실행 */
//public class Application {
public class Application extends SpringBootServletInitializer {

    /*  jar 파일 실행 *
    /*public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application .class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application .class, args);
    }
}
