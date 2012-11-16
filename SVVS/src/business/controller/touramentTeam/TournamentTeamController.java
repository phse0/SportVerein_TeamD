/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.touramentTeam;

import business.controller.RMI.AController;
import data.DAOs.SportsmanDAO;
import data.DAOs.TournamentDAO;
import data.DAOs.TournamentInviteDAO;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.SportsmanDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITournamentDTO;
import data.interfaces.DTOs.ITournamentInviteDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ITournament;
import data.interfaces.models.ITournamentInvite;
import data.interfaces.models.ITrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public List<ITournamentInviteDTO> loadTournamentTeams() throws RemoteException {

        return TournamentInviteDAO.getInstance().getAllTeamDTOs(HibernateUtil.getCurrentSession());

    }

    @Override
    public List<ISportsmanDTO> loadPlayersOfTeam(ITournamentDTO tournament, ITrainingTeamDTO team) throws RemoteException {

        Session s = HibernateUtil.getCurrentSession();
        ITournament t = TournamentDAO.getInstance().getById(s, tournament.getId());
        ITrainingTeam tt = TrainingTeamDAO.getInstance().getById(s, team.getId());

        List<ISportsmanDTO> smdto = new LinkedList<>();

        for (ITournamentInvite ti : TournamentInviteDAO.getInstance().getByTournamentAndTeam(s, t, tt)) {
            smdto.add(new SportsmanDTO(ti.getSportsman()));
        }

        return smdto;
    }

    @Override
    public List<ISportsmanDTO> loadNotAssignedPlayersOfTeam(ITournamentDTO tournament, ITrainingTeamDTO team) throws RemoteException {

        List<ISportsmanDTO> allAssignedSportsman = loadPlayersOfTeam(tournament, team);
        List<ISportsmanDTO> returnList = new LinkedList<>();

        for (ISportsmanTrainingTeamDTO stt : team.getSportsmen()) {
            ISportsmanDTO smdto = stt.getSportsman();
            if (!allAssignedSportsman.contains(smdto)) {
                returnList.add(smdto);
            }

        }
        return returnList;

    }

    @Override
    public void assignPlayer(ITournamentDTO tournament, ITrainingTeamDTO team, ISportsmanDTO sportsman) throws RemoteException {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.getTransaction();

        ITournament tournamentM = TournamentDAO.getInstance().getById(s, tournament.getId());
        ITrainingTeam teamM = TrainingTeamDAO.getInstance().getById(s, team.getId());
        ISportsman sportsmanM = SportsmanDAO.getInstance().getById(s, sportsman.getId());


        ITournamentInvite ti = TournamentInviteDAO.getInstance().create();
        ti.setTournament(tournamentM);
        ti.setTeam(teamM);
        ti.setSportsman(sportsmanM);
        ti.setAccepted(false);
        
        TournamentInviteDAO.getInstance().add(s, ti);
        tx.commit();

    }
}
