/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.playerToTeam;

import business.controller.team.playerToTeam.state.IPlayerToTeamState;
import business.controller.team.playerToTeam.state.PlayerToTeamTeamLoadState;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 * First loadTeam
 * Second LoadSportsman
 * Third AddPlayerToTeam
 * @author phil
 */
public class PlayerToTeam implements IPlayerToTeam{
    IPlayerToTeamState _state;

    public PlayerToTeam() {
        setState(new PlayerToTeamTeamLoadState(this));
    }
    
    public void setState(IPlayerToTeamState state) {
        _state = state;
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeam() throws RemoteException {
        return _state.loadTeam();
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTeams(String sportname) throws RemoteException {
        return _state.loadTeams(sportname);
    }

    @Override
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname) throws RemoteException {
        return  _state.loadSportsman(sportname);
    }

    @Override
    public void AddPlayerToTeam(int TrainingTeamID, int SportsmanID, String position) throws RemoteException {
        _state.AddPlayerToTeam(TrainingTeamID, SportsmanID, position);
    }

    @Override
    public LinkedList<ISportsman> loadPlayersOfTeam(String TeamName) throws RemoteException {
        return _state.loadPlayersOfTeam(TeamName);
    }
    
}
