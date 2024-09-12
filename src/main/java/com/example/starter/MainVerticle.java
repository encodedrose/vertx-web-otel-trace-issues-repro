package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Router restAPI = Router.router(vertx);

    restAPI.get("/products/:productID").handler(ctx -> {

      // TODO Handle the lookup of the product....
      ctx.response().end();

    });

    restAPI.put("/products/:productID").handler(ctx -> {

      // TODO Add a new product...
      ctx.response().end();

    });

    restAPI.delete("/products/:productID").handler(ctx -> {

      // TODO delete the product...
      ctx.response().end();

    });

    Router mainRouter = Router.router(vertx);
    mainRouter.route("/productsAPI/*").handler(k -> {
      // some logic (e.g. auth check) before passing the request to the subrouter
      k.next();
    });
    mainRouter.route("/productsAPI/*")
      .subRouter(restAPI);


    vertx.createHttpServer().requestHandler(mainRouter).listen(8888).onComplete(http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
}
