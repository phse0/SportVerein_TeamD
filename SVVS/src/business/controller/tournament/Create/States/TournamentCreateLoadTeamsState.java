/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament.Create.States;

import business.controller.tournament.Create.TournamentCreation;
import business.controller.tournament.TournamentController;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentCreateLoadTeamsState implements ITournamentCreateState {

    TournamentCreation _creator;

    public TournamentCreateLoadTeamsState(TournamentCreation creator){
        _creator = creator;
    }

    @Override
    public LinkedList<ISportDTO> loadSport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sport) throws RemoteException{
        /*LinkedList<ITeam> teams = new LinkedList<ITeam>();
        for (ITeam iTeam : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(iTeam);
        }
        _creator.setCurState(new TournamentCreateState(_creator));
        return teams;*/
        _creator.setCurState(new TournamentCreateState(_creator));
        return TournamentController.getInstance().loadTeams(sport);
    }

    @Override
    public void CreateTournament(String name, String location, BigDecimal fee, String sportname, List<String> TeamNames) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
