package com.monopay.wallet.configuration;

import com.monopay.wallet.properties.ElasticsearchProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonoPayConfiguration {

  @Autowired
  private ElasticsearchProperties elasticsearchProperties;

  @Bean
  public RestHighLevelClient restHighLevelClient() {
    return new RestHighLevelClient(
      RestClient.builder(new HttpHost(elasticsearchProperties.getHost(), elasticsearchProperties.getPort()))
    );
  }

}
