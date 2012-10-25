/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

import java.util.List;

/**
 *
 * @author uubu
 */
public interface ISport {

    void addTeam(ITeam team);

    int getMaxPlayers();

    String getName();

    int getSportID();

    List<ITeam> getTeams();

    void removeTeam(ITeam team);

    void setMaxPlayers(int maxPlayers);

    void setName(String name);

    void setSportID(int sportID);

    void setTeams(List<ITeam> teams);
    
}