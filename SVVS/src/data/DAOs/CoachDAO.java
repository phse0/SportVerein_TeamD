/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ICoachDAO;
import data.interfaces.DTOs.ICoachDTO;
import data.interfaces.models.ICoach;
import data.models.Coach;

/**
 *
 * @author uubu
 */
public class CoachDAO extends AbstractDAO<ICoach, ICoachDTO> implements ICoachDAO {

    private static ICoachDAO instance;
    
    private CoachDAO() {
        super("data.models.Coach");
    }
    
    public static ICoachDAO getInstance(){
        if ( instance == null){
            instance = new CoachDAO();
        }
        return instance;
    }
    
    @Override
    public ICoach create() {
        return new Coach();
    }

    @Override
    public ICoachDTO extractDTO(ICoach model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
