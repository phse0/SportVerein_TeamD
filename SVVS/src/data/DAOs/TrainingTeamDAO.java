/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ITrainingTeamDAO;
import data.interfaces.models.ITrainingTeam;
import data.models.TrainingTeam;

/**
 *
 * @author uubu
 */
public class TrainingTeamDAO extends AbstractDAO<ITrainingTeam> implements ITrainingTeamDAO{

    private static ITrainingTeamDAO instance;
    
    private TrainingTeamDAO(){
        super("data.models.TrainingTeamDAO");
    }
    
    public static ITrainingTeamDAO getInstance(){
        if(instance == null){
            instance = new TrainingTeamDAO();
        }
        return instance;
    }
    
    @Override
    public ITrainingTeam create() {
        return new TrainingTeam();
    }
    
}
