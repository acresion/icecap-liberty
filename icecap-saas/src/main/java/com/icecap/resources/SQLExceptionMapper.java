package com.icecap.resources;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.icecap.dto.ExceptionRecord;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

  @Override
  // We configured this to return JSON, but this returns as a TXT file. SO this
  // is why things are going wrong
  public Response toResponse(SQLException exception) {
    // TODO Auto-generated method stub
    Gson gson = new Gson();

    return Response
        .status(500)
          .entity(gson.toJson(new ExceptionRecord(500, exception.getMessage())))
          .type(MediaType.APPLICATION_JSON)
          .build();
  }

}
