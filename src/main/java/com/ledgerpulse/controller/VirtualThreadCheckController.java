package com.ledgerpulse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirtualThreadCheckController {

  @GetMapping("/api/thread-check")
  public ThreadCheckResponse checkThread() {
    return new ThreadCheckResponse(
        Thread.currentThread().isVirtual(),
        Thread.currentThread().toString());
  }

  public record ThreadCheckResponse(boolean isVirtual, String threadName) {
  }
}


