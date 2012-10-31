/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ISportsmanTrainingTeamDAO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.models.SportsmanTrainingTeam;

/**
 *
 * @author uubu
 */
public class SportsmanTrainingTeamDAO extends AbstractDAO<ISportsmanTrainingTeam, ISportsmanTrainingTeamDTO> implements ISportsmanTrainingTeamDAO{

    private static ISportsmanTrainingTeamDAO instance;
    
    private SportsmanTrainingTeamDAO(){
        super("data.models.SportsmanTrainingTeam");
    }
    
    public static ISportsmanTrainingTeamDAO getInstance(){
        if(instance == null){
            instance = new SportsmanTrainingTeamDAO();
        }
        return instance;
    }
    
    @Override
    public ISportsmanTrainingTeam create() {
        return new SportsmanTrainingTeam();
    }

    @Override
    public ISportsmanTrainingTeamDTO extractDTO(ISportsmanTrainingTeam model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
