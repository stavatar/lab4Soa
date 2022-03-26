package com.SOAP;

import com.JsonDTO.TeamDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface TeamWebServiceI{
    @WebMethod
    public String getMsg( @WebParam(name = "team") TeamDTO newTeam) ;
    @WebMethod
    public String test();
    @WebMethod
    public String changeMood(@WebParam(name = "team-id") String id_team);
    @WebMethod
    public String getTeams();
}
