import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

import java.util.logging.Logger;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class ProducerB {
    private static Logger logger = Logger.getAnonymousLogger();

  public static void main(String[] args) {
    Vertx.clusteredVertx(new VertxOptions(),
        ar -> {
          Vertx vertx = ar.result();
          vertx.setPeriodic(5000,
              l -> {
                vertx.eventBus().publish("events",
                        new JsonObject()
                            .put("message", "hello!I'm ProducerB")
                            .put("from", "ProducerB"));
            });

            vertx.eventBus().consumer("events",
                    m -> {
                        JsonObject json = (JsonObject) m.body();
                        logger.info("ProducerB Receiving " + json.getString("message") + " from " + json.getString("from"));
                    });
    });
  }
}
