/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.IDepartment;
import data.interfaces.ILeague;
import data.interfaces.ISport;
import data.interfaces.ITournamentTeam;

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
