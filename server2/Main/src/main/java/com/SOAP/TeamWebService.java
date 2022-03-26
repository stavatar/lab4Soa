package com.SOAP;

import com.EJB.TeamEJB;
import com.FactoriesKt;
import com.JsonDTO.*;
import com.fasterxml.jackson.core.JsonParseException;
import org.hibernate.exception.JDBCConnectionException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.ProcessingException;
import java.io.NotSerializableException;
import java.util.*;

@WebService(endpointInterface = "com.SOAP.TeamWebServiceI",serviceName = "service",portName = "port")
public class TeamWebService implements TeamWebServiceI {
    TeamEJB ejb= (TeamEJB) FactoriesKt.getFromEJBPool("java:global/two/TeamEJBImpl");

    @WebMethod
    public String getMsg( @WebParam(name = "team") TeamDTO newTeam) {
       try {
           return ejb.createTeam(newTeam.getNameTeam(),newTeam.getIdhumans());
       }catch (Exception e){
           if (e.getCause().getClass().equals(JsonParseException.class)
                   || e.getCause().getClass().equals(BadRequestException.class)
                   || e.getCause().getClass().equals(NotSerializableException.class))
               throw  new RuntimeException( "400");

           if (e.getCause().getClass().equals(NoSuchElementException.class))
               throw  new RuntimeException( "404");
           if (e.getCause().getClass().equals(ProcessingException.class) || e.getCause().getClass().equals(JDBCConnectionException.class))
               throw  new RuntimeException( "503");
           throw  new RuntimeException( "500");
       }

    }

    @WebMethod
    public String test()  {
        try {
            return  ejb.test("OK 2 ");
        }catch (Exception e){
            if (e.getCause().getClass().equals(JsonParseException.class)
                    || e.getCause().getClass().equals(BadRequestException.class)
                    || e.getCause().getClass().equals(NotSerializableException.class))
                throw  new RuntimeException( "400");
            if (e.getCause().getClass().equals(NoSuchElementException.class))
                throw  new RuntimeException( "404");
            if (e.getCause().getClass().equals(ProcessingException.class) || e.getCause().getClass().equals(JDBCConnectionException.class))
                throw  new RuntimeException( "503");
            throw  new RuntimeException( "500");
        }
    }

    @WebMethod
    public String changeMood(@WebParam(name = "team-id") String id_team){
        try {
            return ejb.changeMood(Long.valueOf(id_team));
        }catch (Exception e){
            if (e.getCause().getClass().equals(JsonParseException.class)
                    || e.getCause().getClass().equals(BadRequestException.class)
                    || e.getCause().getClass().equals(NotSerializableException.class))
                throw  new RuntimeException( "400");
            if (e.getCause().getClass().equals(NoSuchElementException.class))
                throw  new RuntimeException( "404");
            if (e.getCause().getClass().equals(ProcessingException.class) || e.getCause().getClass().equals(JDBCConnectionException.class))
                throw  new RuntimeException( "503");
            throw  new RuntimeException( "500");
        }
    }

    @WebMethod
    public String getTeams(){
        try {
            String jsonList= ejb.getTeams();
            JSONObject array=new JSONObject(jsonList);
            return array.toString();
        }catch (Throwable e){
            if (e.getCause().getClass().equals(JsonParseException.class)
                    || e.getCause().getClass().equals(BadRequestException.class)
                    || e.getCause().getClass().equals(NotSerializableException.class))
                throw  new RuntimeException( "400");
            if (e.getCause().getClass().equals(NoSuchElementException.class))
                throw  new RuntimeException( "404");
            if (e.getCause().getClass().equals(ProcessingException.class) || e.getCause().getClass().equals(JDBCConnectionException.class))
                throw  new RuntimeException( "503");
            throw  new RuntimeException( "500");
        }
    }
}
