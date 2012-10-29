/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.DAOs.AddressDAO;
import data.DAOs.AdministratorDAO;
import data.DAOs.CaretakerDAO;
import data.DAOs.CoachDAO;
import data.DAOs.ContributionDAO;
import data.DAOs.CountryDAO;
import data.DAOs.DepartmentDAO;
import data.DAOs.LeagueDAO;
import data.DAOs.ManagerDAO;
import data.DAOs.MatchDAO;
import data.DAOs.PersonDAO;
import data.DAOs.RightDAO;
import data.DAOs.RoleDAO;
import data.DAOs.RoleRightsDAO;
import data.DAOs.SportDAO;
import data.DAOs.SportsmanDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.DAOs.TournamentTeamDAO;
import data.DAOs.TrainingTeamDAO;
import data.interfaces.DAOs.IAddressDAO;
import data.interfaces.DAOs.IAdministratorDAO;
import data.interfaces.DAOs.ICaretakerDAO;
import data.interfaces.DAOs.ICoachDAO;
import data.interfaces.DAOs.IContributionDAO;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DAOs.IDepartmentDAO;
import data.interfaces.DAOs.ILeagueDAO;
import data.interfaces.DAOs.IManagerDAO;
import data.interfaces.DAOs.IMatchDAO;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DAOs.IRightDAO;
import data.interfaces.DAOs.IRoleDAO;
import data.interfaces.DAOs.IRoleRightsDAO;
import data.interfaces.DAOs.ISportDAO;
import data.interfaces.DAOs.ISportsmanDAO;
import data.interfaces.DAOs.ITeamDAO;
import data.interfaces.DAOs.ITournamentDAO;
import data.interfaces.DAOs.ITournamentTeamDAO;
import data.interfaces.DAOs.ITrainingTeamDAO;

/**
 *
 * @author Michael
 */
public class DataFacade {

    public static IAddressDAO getAddressDAO() {
        return AddressDAO.getInstance();
    }

    public static IAdministratorDAO getAdministratorDAO() {
        return AdministratorDAO.getInstance();
    }

    public static ICaretakerDAO getCaretakerDAO() {
        return CaretakerDAO.getInstance();
    }

    public static ICoachDAO getCoachDAO() {
        return CoachDAO.getInstance();
    }

    public static IContributionDAO getContributionDAO() {
        return ContributionDAO.getInstance();
    }

    public static ICountryDAO getCountryDAO() {
        return CountryDAO.getInstance();
    }

    public static IDepartmentDAO getDepartmentDAO() {
        return DepartmentDAO.getInstance();
    }

    public static ILeagueDAO getLeagueDAO() {
        return LeagueDAO.getInstance();
    }

    public static IManagerDAO getManagerDAO() {
        return ManagerDAO.getInstance();
    }

    public static IMatchDAO getMatchDAO() {
        return MatchDAO.getInstance();
    }

    public static IRightDAO getRightDAO() {
        return RightDAO.getInstance();
    }

    public static IRoleDAO getRoleDAO() {
        return RoleDAO.getInstance();
    }

    public static IPersonDAO getPersonDAO() {
        return PersonDAO.getInstance();
    }

    public static IRoleRightsDAO getRoleRightsDAO() {
        return RoleRightsDAO.getInstance();
    }

    public static ISportDAO getSportDAO() {
        return SportDAO.getInstance();
    }

    public static ISportsmanDAO getSportsmanDAO() {
        return SportsmanDAO.getInstance();
    }

    public static ITeamDAO getTeamDAO() {
        return TeamDAO.getInstance();
    }

    public static ITournamentDAO getTournamentDAO() {
        return TournamentDAO.getInstance();
    }

    public static ITournamentTeamDAO getTournamentTeamDAO() {
        return TournamentTeamDAO.getInstance();
    }

    public static ITrainingTeamDAO getTrainingTeamDAO() {
        return TrainingTeamDAO.getInstance();
    }
}
