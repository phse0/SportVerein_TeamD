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
public interface ITrainingTeam extends ITeam {

    void addCoach(ICoach coach);

    void addSportsman(ISportsmanTrainingTeam sportsman);

    List<ICoach> getCoaches();

    IDepartment getDepartment();

    List<ISportsmanTrainingTeam> getSportsmen();

    void removeCoach(ICoach coach);

    void removeSportsman(ISportsmanTrainingTeam sportsman);

    void setCoaches(List<ICoach> coaches);

    void setDepartment(IDepartment department);

    void setSportsmen(List<ISportsmanTrainingTeam> sportsmen);
    
}
