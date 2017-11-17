package io.vertx.demo;

import io.vertx.core.Vertx;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class Main {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("dashboard.groovy");
    vertx.deployVerticle("producer.js");
    vertx.deployVerticle("producer.rb");
  }

}
