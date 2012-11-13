/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament;

import business.controller.RMI.AController;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.DTOs.SportDTO;
import data.DTOs.TeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.IDepartmentDTO;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentController extends AController implements ITournamentController {

    private static TournamentController instance;

    private TournamentController() throws RemoteException {
        super();
    }

    public static TournamentController getInstance() throws RemoteException {
        if (instance == null) {
            return (instance = new TournamentController());
        }
        return instance;
    }

    @Override
    public LinkedList<ISportDTO> loadSport(IDepartmentDTO department) throws RemoteException {
        LinkedList<ISportDTO> sports = new LinkedList<>();

        for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iS.getDepartment() == department) {
                sports.add(new SportDTO(iS));
            }
        }

        return sports;
    }

    @Override
    public LinkedList<ITeamDTO> loadTeams(String sportname) throws RemoteException {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<>();
        for (ITeam iTeam : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(new TeamDTO(iTeam));
        }
        return teams;
    }

    @Override
    public LinkedList<ITournamentDTO> loadTournaments() throws RemoteException {
        return new LinkedList<ITournamentDTO>(TournamentDAO.getInstance().getAllDTO(HibernateUtil.getCurrentSession()));
    }

    @Override
    public ITournament loadTournament(int ID) throws RemoteException {
        List<ITournament> tournaments = TournamentDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (ITournament iT : tournaments) {
            if (iT.getTournamentID() == ID) {
                return iT;
            }
        }
        return null;
    }
}
