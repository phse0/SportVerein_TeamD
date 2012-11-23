/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.controller.team.teamTOplayer;

import business.controller.RMI.AController;
import business.controller.team.TeamController;
import data.DAOs.SportsmanDAO;
import data.DAOs.SportsmanTrainingTeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.DTOs.SportsmanDTO;
import data.DTOs.SportsmanTrainingTeamDTO;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.ITrainingTeamDAO;
import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.DTOs.ISportsmanTrainingTeamDTO;
import data.interfaces.DTOs.ITrainingTeamDTO;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITrainingTeam;
import data.models.SportsmanTrainingTeam;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author phil
 */
public class TeamToPlayer extends AController implements ITeamToPlayer {

    public TeamToPlayer() throws RemoteException {
        super();
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams() throws RemoteException {
        return TeamController.getInstance().loadTrainingTeams();
    }

    @Override
    public LinkedList<ITrainingTeamDTO> loadTrainingTeams(String sportname) throws RemoteException {
        return TeamController.getInstance().loadTrainingTeams(sportname);
    }

    @Override
    public LinkedList<ISportsmanDTO> loadSportsman(String sportname, List<ISportsmanDTO> ignoreList) throws RemoteException {

        LinkedList<ISportsmanDTO> sportsmen = new LinkedList<ISportsmanDTO>();

        for (ISportsman iS : SportsmanDAO.getInstance().getAll(HibernateUtil.getCurrentSession())) {
            if (iS.getSport().getName().equals(sportname)) {
                sportsmen.add(new SportsmanDTO(iS));
            }
        }

        for (ISportsmanDTO dto : ignoreList) {
            sportsmen.remove(dto);
        }
        //_context.setState(new PlayerToTeamState(_context));
        return sportsmen;
    }

    @Override
    public ISportsmanTrainingTeamDTO AddTeamToPlayer(ITrainingTeamDTO TrainingTeam, ISportsmanDTO Sportsman, String position) throws RemoteException {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.getTransaction();
        ISportsman sm = SportsmanDAO.getInstance().getById(s, Sportsman.getId());
        ITrainingTeam t = TrainingTeamDAO.getInstance().getById(s, TrainingTeam.getId());
        ISportsmanTrainingTeam sttModel = new SportsmanTrainingTeam(sm, t, position);

        tx.begin();
        SportsmanTrainingTeamDAO.getInstance().add(HibernateUtil.getCurrentSession(), sttModel);

        SportsmanTrainingTeamDTO addedPlayer = new SportsmanTrainingTeamDTO(sttModel);
        tx.commit();

        return addedPlayer;
    }
}
