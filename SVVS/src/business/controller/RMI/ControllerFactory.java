/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.RMI;

import business.controller.departments.DepartmentController;
import business.controller.departments.IDepartmentController;
import business.controller.person.IPersonController;
import business.controller.person.PersonController;
import business.controller.person.create.IPersonCreation;
import business.controller.person.create.PersonCreation;
import business.controller.person.delete.IPersonDelete;
import business.controller.person.delete.PersonDelete;
import business.controller.person.edit.IPersonEdit;
import business.controller.person.edit.PersonEdit;
import business.controller.team.ITeamController;
import business.controller.team.TeamController;
import business.controller.team.playerToTeam.IPlayerToTeam;
import business.controller.team.playerToTeam.PlayerToTeam;
import business.controller.tournament.Create.ITournamentCreation;
import business.controller.tournament.Create.TournamentCreation;
import business.controller.tournament.ITournamentController;
import business.controller.tournament.TournamentController;
import business.controller.tournament.edit.ITournamentEdit;
import business.controller.tournament.edit.TournamentEdit;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author phil
 */
public class ControllerFactory extends UnicastRemoteObject implements IControllerFactory {

    public ControllerFactory() throws RemoteException {
        super();
    }

    @Override
    public IPersonCreation loadPersonCreateController() throws RemoteException {
        return new PersonCreation();
    }

    @Override
    public IPersonEdit loadPersonEditController() throws RemoteException {
        return new PersonEdit();
    }

    @Override
    public IPersonController loadPersonController() throws RemoteException {
        return PersonController.getInstance();
    }

    @Override
    public ITournamentCreation loadTournamentCreateController() throws RemoteException {
        return new TournamentCreation();
    }

    @Override
    public ITournamentEdit loadTournamentEditController() throws RemoteException {
        return new TournamentEdit();
    }

    @Override
    public ITournamentController loadTournamentController() throws RemoteException {
        return TournamentController.getInstance();
    }

    @Override
    public IDepartmentController loadDepartmentController() throws RemoteException {
        return DepartmentController.getInstance();
    }

    @Override
    public IPersonDelete loadPersonDeleteController() throws RemoteException {
        return new PersonDelete();
    }

    @Override
    public ITeamController loadTeamController() throws RemoteException {
        return TeamController.getInstance();
    }

    @Override
    public IPlayerToTeam loadPlayerToTeamController() throws RemoteException {
        return new PlayerToTeam();
    }
}
