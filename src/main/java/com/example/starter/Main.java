package com.example.starter;

import io.vertx.core.Vertx;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello, World!");

    Vertx vertx = Vertx.builder().build();
    vertx.deployVerticle(new MainVerticle());
  }
}
