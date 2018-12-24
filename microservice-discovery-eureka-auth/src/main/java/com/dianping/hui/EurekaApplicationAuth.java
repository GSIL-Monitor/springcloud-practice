package com.dianping.hui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author: lanxinyu@meituan.com  2018-11-06 下午9:12
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationAuth {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationAuth.class, args);
        //openHomePage("http://localhost:8761");
    }

    private static void openHomePage(String uri) {
        try {
            if(Desktop.isDesktopSupported())
                Desktop.getDesktop().browse(new URI(uri));
            else
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
