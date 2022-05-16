package com.wellsfargo.hackett.diversificationidentitytool.dataaccess;

import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventsDAO {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  private static final String INSERT_EVENT_QUERY = "INSERT INTO T_DIVERSIFICATIONIDENTITY_EVENTS_LOGGING (EVENT_ID, SEARCH_INPUT, SEACH_OUTPUT, CREATE_DATE) VALUES(:eventId, :inputText, :outputResult, SYSDATE)";

  public EventsDAO(DataSource dataSource) {

    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public int recordEvents(String inputText, String outputResult) {

    return namedParameterJdbcTemplate.update(INSERT_EVENT_QUERY,
        new MapSqlParameterSource().addValue("eventId", UUID.randomUUID().toString())
            .addValue("inputText", inputText).addValue("outputResult", outputResult));
  }
}