/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import data.models.SportsmanTrainingTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ISportsman extends IRole{

    List<SportsmanTrainingTeam> getTeams();

    void setTeams(List<SportsmanTrainingTeam> teams);
    
}
