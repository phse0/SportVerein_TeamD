/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

import data.models.TrainingTeam;
import java.util.List;

/**
 *
 * @author uubu
 */
public interface ICoach extends IRole {

    List<ITrainingTeam> getTeams();

    void setTeams(List<ITrainingTeam> teams);
    
}
