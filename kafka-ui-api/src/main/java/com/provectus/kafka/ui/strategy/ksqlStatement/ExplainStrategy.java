package com.provectus.kafka.ui.strategy.ksqlStatement;

import com.fasterxml.jackson.databind.JsonNode;
import com.provectus.kafka.ui.model.KsqlCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class ExplainStrategy extends KsqlStatementStrategy {
  private final String requestPath = "/ksql";
  private final String responseValueKey = "queryDescription";

  @Override
  public KsqlCommandResponse serializeResponse(JsonNode response) {
    return serializeTableResponse(response, responseValueKey);
  }

  @Override
  protected String getRequestPath() {
    return requestPath;
  }

  @Override
  protected String getTestRegExp() {
    return "explain (.*);";
  }
}
