/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.models.IDepartment;
import data.interfaces.models.ILeague;
import data.interfaces.models.ISport;
import data.interfaces.models.ITournamentTeam;

/**
 *
 * @author Michael
 */
public class TournamentTeam extends TrainingTeam implements ITournamentTeam {
    
    protected ILeague league;

    public TournamentTeam() {
        super();
    }

    public TournamentTeam(IDepartment department, String name, ISport sport) {
        super(department, name, sport);
    }

    public TournamentTeam(ILeague league, IDepartment department, String name, ISport sport) {
        super(department, name, sport);
        this.league = league;
    }

    @Override
    public ILeague getLeague() {
        return league;
    }

    @Override
    public void setLeague(ILeague league) {
        this.league = league;
    }
    
    
    
    
    
}
