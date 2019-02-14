package fyihan.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"fyihan.cn"})
@MapperScan(basePackages = {"fyihan.cn.repository"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
