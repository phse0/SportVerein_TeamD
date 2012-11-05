/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ISportsmanTrainingTeam;

/**
 *
 * @author uubu
 */
public interface ISportsmanTrainingTeamDTO extends IDTO<ISportsmanTrainingTeam>{

    String getPosition();

    ISportsmanDTO getSportsman();

    ITrainingTeamDTO getTeam();

    void setPosition(String position);

    void setSportsman(ISportsmanDTO sportsman);

    void setTeam(ITrainingTeamDTO team);
    
}
