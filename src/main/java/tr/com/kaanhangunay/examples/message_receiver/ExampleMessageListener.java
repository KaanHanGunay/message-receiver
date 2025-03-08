package tr.com.kaanhangunay.examples.message_receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import tr.com.kaanhangunay.examples.messages.ExampleMessage;
import tr.com.kaanhangunay.examples.models.GenericApplicationEvent;

@Component
public class ExampleMessageListener {

  private static final Logger log = LoggerFactory.getLogger(ExampleMessageListener.class);

  @EventListener(
      condition =
          "#message.body instanceof T(tr.com.kaanhangunay.examples.messages.ExampleMessage)")
  public void onMessage(GenericApplicationEvent<ExampleMessage> message) {
    ExampleMessage msg = message.body();
    log.info(msg.getMessage());
    throw new RuntimeException("Test Exception");
  }
}
