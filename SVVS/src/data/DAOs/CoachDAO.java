/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.interfaces.DAOs.ICoachDAO;
import data.interfaces.models.ICoach;

/**
 *
 * @author uubu
 */
public class CoachDAO extends AbstractDAO<ICoach> implements ICoachDAO {

    private static CoachDAO instance;
    
    private CoachDAO() {
        super("data.models.Coach");
    }
    
    private static CoachDAO getInstance(){
        if ( instance == null){
            instance = new CoachDAO();
        }
        return instance;
    }
    
    @Override
    public ICoach create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
