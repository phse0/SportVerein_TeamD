/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces;

/**
 *
 * @author uubu
 */
public interface ISportsmanTrainingTeam {

    String getPosition();

    ISportsman getSportsman();

    ITrainingTeam getTeam();

    void setPosition(String position);

    void setSportsman(ISportsman sportsman);

    void setTeam(ITrainingTeam team);
    
}
