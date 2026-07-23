package com.ledgerpulse.controller;

import com.ledgerpulse.controller.VirtualThreadCheckController.ThreadCheckResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = "spring.threads.virtual.enabled=true")
class VirtualThreadIntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private RestClient.Builder restClientBuilder;

  @Test
  @DisplayName("Verify incoming HTTP requests are handled on Virtual Threads")
  void httpRequestsShouldExecuteOnVirtualThreads() {
    RestClient restClient = restClientBuilder.baseUrl("http://localhost:" + port).build();

    ThreadCheckResponse response = restClient.get()
        .uri("/api/thread-check")
        .retrieve()
        .body(ThreadCheckResponse.class);

    assertThat(response).isNotNull();
    assertThat(response.isVirtual()).isTrue();
  }
}
