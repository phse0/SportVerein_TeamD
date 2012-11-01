/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.tournament;

import business.controller.RMI.IController;
import data.DAOs.SportDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.DTOs.SportDTO;
import data.DTOs.TeamDTO;
import data.DTOs.TournamentDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportDTO;
import data.interfaces.DTOs.ITeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.models.ISport;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import java.rmi.Remote;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author phil
 */
public class TournamentController implements Remote, IController {

    private static TournamentController instance;

    private TournamentController() {
    }

    public static TournamentController getInstance() {
        if (instance == null) {
            return (instance = new TournamentController());
        }
        return instance;
    }

    public LinkedList<ISportDTO >loadSport() {
        LinkedList<ISportDTO> sports = new LinkedList<ISportDTO>();

        for (ISport iS : SportDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            sports.add(new SportDTO(iS));
        }

        return sports;
    }

    public LinkedList<ITeamDTO> loadTeams(String sportname) {
        ISport sport = SportDAO.getInstance().getByName(HibernateUtil.getCurrentSession(), sportname);
        LinkedList<ITeamDTO> teams = new LinkedList<ITeamDTO>();
        for (ITeam iTeam : TeamDAO.getInstance().getBySport(HibernateUtil.getCurrentSession(), sport)) {
            teams.add(new TeamDTO(iTeam));
        }
        return teams;
    }

    public LinkedList<ITournamentDTO> loadTournaments() {
        LinkedList<ITournamentDTO> tournaments = new LinkedList<ITournamentDTO>();
        for (ITournament iT : TournamentDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            tournaments.add(new TournamentDTO(iT));
        }
        return tournaments;
    }
    
     public ITournament loadTournament(int ID) {
        List<ITournament> tournaments = TournamentDAO.getInstance().getAll(HibernateUtil.getCurrentSession());
        for (ITournament iT : tournaments) {
            if (iT.getTournamentID() == ID) {
                return iT;
            }
        }
        return null;
    }
}
