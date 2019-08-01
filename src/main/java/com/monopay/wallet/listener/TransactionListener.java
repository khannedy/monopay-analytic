package com.monopay.wallet.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monopay.wallet.event.SaveTransactionEvent;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class TransactionListener {

  @Autowired
  private RestHighLevelClient restHighLevelClient;

  @Autowired
  private ObjectMapper objectMapper;

  @KafkaListener(topics = "monopay-save-transaction-event")
  public void onSaveTransactionListener(String payload) throws IOException {
    log.info(payload);
    SaveTransactionEvent event = objectMapper.readValue(payload, SaveTransactionEvent.class);

    IndexRequest indexRequest = new IndexRequest("transactions")
      .id(event.getId())
      .source(payload, XContentType.JSON);

    restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
  }

}
