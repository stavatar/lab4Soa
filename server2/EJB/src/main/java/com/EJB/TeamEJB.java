package com.EJB;


import com.JsonDTO.TeamDTO;
import com.fasterxml.jackson.core.JsonParseException;
import org.hibernate.exception.JDBCConnectionException;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public interface TeamEJB {
    public String createTeam(String nameTeam, Set<Integer> idsHuman)  throws JsonParseException, NoSuchElementException, ProcessingException, JDBCConnectionException;
    public String test(String nameServer)  throws JsonParseException,NoSuchElementException,ProcessingException,JDBCConnectionException;;
    public String changeMood(Long id_team) throws JsonParseException,NoSuchElementException,ProcessingException,JDBCConnectionException; ;
    public String getTeams()  throws JsonParseException,NoSuchElementException,ProcessingException,JDBCConnectionException;;
}
