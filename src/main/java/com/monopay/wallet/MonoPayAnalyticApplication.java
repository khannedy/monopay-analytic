package com.monopay.wallet;

import com.monopay.wallet.properties.ElasticsearchProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
  ElasticsearchProperties.class
})
public class MonoPayAnalyticApplication {

  public static void main(String[] args) {
    SpringApplication.run(MonoPayAnalyticApplication.class, args);
  }

}
