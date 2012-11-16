/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.touramentTeam;

import business.controller.RMI.AController;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.models.ITrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 *
 * @author uubu
 */
public class TournamentTeamController extends AController implements ITournamentTeamController {

    private static TournamentTeamController instance;

    private TournamentTeamController() throws RemoteException {
        super();
    }

    public static TournamentTeamController getInstance() throws RemoteException {
        if (instance == null) {
            return (instance = new TournamentTeamController());
        }
        return instance;
    }

    @Override
    public LinkedList<ITournamentInviteDTO> loadTournamentTeams() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportsmanDTO> loadPlayersOfTeam(ITournamentDTO tournament, ITrainingTeam team) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LinkedList<ISportsmanDTO> loadNotAssignedPlayersOfTeam(ITournamentDTO tournament, ITrainingTeam team) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void assignPlayers(ITournamentDTO tournament, ITrainingTeam team, ISportsmanDTO sportsman) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
