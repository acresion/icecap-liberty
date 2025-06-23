package com.icecap.resources;

import java.sql.SQLException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

  @Override
  // We configured this to return JSON, but this returns as a TXT file. SO this
  // is why things are going wrong
  public Response toResponse(SQLException exception) {
    // TODO Auto-generated method stub
    return Response.status(500).entity("A wild server error appeared!").build();
  }

}
