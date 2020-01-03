package top.oldwei.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:weizd
 * @Date:19-12-30
 */

@SpringBootApplication
@EnableAdminServer
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }


}
