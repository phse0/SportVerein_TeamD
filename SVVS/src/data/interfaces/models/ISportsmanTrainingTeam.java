/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.models;

/**
 *
 * @author uubu
 */
public interface ISportsmanTrainingTeam extends IModel {

    String getPosition();

    ISportsman getSportsman();

    ITrainingTeam getTeam();

    void setPosition(String position);

    void setSportsman(ISportsman sportsman);

    void setTeam(ITrainingTeam team);

    int getSportsmanTrainingTeamID();

    void setSportsmanTrainingTeamID(int sportsmanTrainingTeamID);

    String getTeamName();

    String getSportsmanName();
    
}
