# 프로젝트 구성
##### Spring boot   : 2.0.5.RELEASE
##### Java          : oralce Jdk 1.8.0_151
##### was 서버       :  Embedded Tomcat
##### Database 서버  :  Embedded H2 
##### ORM           : JPA

## Spring Rest Docs Overview
Spring REST Docs helps you to doucment RESTful services.<br>

It combines hand-written documentation written with Asciidoctor and auto-generated snippets<br>
produced with Spring MVC Test. This approach frees you from the limitations of the <br>
documentation produced by tools like Swagger.<br>

It helps you to produce documentation that is accurate, concise, and well-structured. <br>
This documentation then allows your users to get the information they need with a minimum of fuss.<br>

spring boot - Selected Dependencies

## application.properties
spring.jooq.sql-dialect=org.hibernate.dialect.H2Dialect
.# Table 자동 생성
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
.# 하이버네이트 'hibernate.format_sql'을 'true'로 설정하면 SQL문을 보기 좋게 출력해 준다
spring.jpa.properties.hibernate.format_sql=true


logging.level.org.hibernate.SQL=debug
.# 위의 출력된 SQL문 중 물음표로 표기된 부분을 하이버네이트에서는 바인드 파라미터Bind Parameter라고 한다.
.#logging.level.org.hibernate.type.descriptor.sql=true
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE



## pom.xml
    <groupId>yunjae.cho</groupId>
    <artifactId>spring-rest-doc</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>spring-rest-doc</name>
    <description>spring restful Document</description>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.5.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <asciidoctorj.version>1.5.3</asciidoctorj.version>
        <spring-restdocs.version>2.0.2.RELEASE</spring-restdocs.version>
    </properties>

    <dependencies>
        <!-- Web 환경 Spring Mvc  -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- Data Access JPA -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <!-- Spring boot Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Spring Rest Docs -->
        <!-- 자동 문서화 작업을 하기 위해서 만드시 필요함 -->
        <dependency>
            <groupId>org.springframework.restdocs</groupId>
            <artifactId>spring-restdocs-mockmvc</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- lombook -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!-- H2 Embedded Database -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <!-- 자동 문서화 생성을 위한 플러그인 설정 -->
            <plugin>
                <groupId>org.asciidoctor</groupId>
                <artifactId>asciidoctor-maven-plugin</artifactId>
                <version>${asciidoctorj.version}</version>
                <executions>
                    <!--Surefire Plugin 은 unit test들을 실행하기 위해 build lifecycle의 test phase동안 사용되어 진다.-->
                    <execution>
                        <id>generate-docs</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>process-asciidoc</goal>
                        </goals>
                        <configuration>
                            <backend>html</backend>
                            <doctype>book</doctype>
                            <!-- 자동화된 문서 html 경로
                                 targer/static/docs jar파일로 서버 실행시
                                 http://localhost:8080/docs/index.html 호출시 해당 페이지 조회
                            -->
                            <outputDirectory>
                                ${project.build.outputDirectory}/static/docs
                            </outputDirectory>
                            <attributes>
                                <!-- 프로퍼티스에 스니펫디렉토리를 추가해 준다. (생성된 코드조각을 output 경로를 설정) -->
                                <snippets>${project.build.directory}/generated-snippets</snippets>
                            </attributes>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.restdocs</groupId>
                        <artifactId>spring-restdocs-asciidoctor</artifactId>
                        <version>${spring-restdocs.version}</version>
                    </dependency>
                </dependencies>
            </plugin>

        </plugins>
    </build>


</project>

