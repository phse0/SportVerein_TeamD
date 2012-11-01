/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.DAOs.AddressDAO;
import data.DAOs.CoachDAO;
import data.DAOs.CountryDAO;
import data.DAOs.PersonDAO;
import data.DAOs.SportsmanDAO;
import data.DAOs.TeamDAO;
import data.DAOs.TournamentDAO;
import data.DAOs.TrainingTeamDAO;
import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IAddressDAO;
import data.interfaces.DAOs.ICoachDAO;
import data.interfaces.DAOs.ICountryDAO;
import data.interfaces.DAOs.IPersonDAO;
import data.interfaces.DAOs.ISportsmanDAO;
import data.interfaces.DAOs.ITeamDAO;
import data.interfaces.DAOs.ITournamentDAO;
import data.interfaces.DAOs.ITrainingTeamDAO;
import data.interfaces.DTOs.ICountryDTO;
import data.interfaces.models.IAddress;
import data.interfaces.models.ICoach;
import data.interfaces.models.ICountry;
import data.interfaces.models.IMatch;
import data.interfaces.models.IPerson;
import data.interfaces.models.ISportsman;
import data.interfaces.models.ISportsmanTrainingTeam;
import data.interfaces.models.ITeam;
import data.interfaces.models.ITournament;
import data.interfaces.models.ITrainingTeam;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class test {

    public static void main(String args[]) {

        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();

        System.out.println("######## COUNTRY ########");

        ICountryDAO countryDAO = CountryDAO.getInstance();
        List<ICountry> countryList = countryDAO.getAll(s);

        for (ICountry country : countryList) {
            System.out.println(country.getName() + ", " + country.getCode());
        }

        System.out.println("######## ADDRESS ########");
        IAddressDAO addressDAO = AddressDAO.getInstance();
        List<IAddress> addressList = addressDAO.getAll(s);

        for (IAddress address : addressList) {
            System.out.println(address);
        }

        System.out.println("######## PERSON ########");

        IPersonDAO personDAO = PersonDAO.getInstance();
        List<IPerson> personList = personDAO.getLikeName(s, "ste");

        for (IPerson person : personList) {
            System.out.println(person.getLastname() + " " + person.getFirstname()
                    + ", " + person.getSex() + ", " + person.getBirthdate());
        }

        System.out.println("######## TRAINING TEAM ########");

        ITrainingTeamDAO trainingTeamDAO = TrainingTeamDAO.getInstance();
        ITrainingTeam trainingTeam = trainingTeamDAO.getByName(s, "tiger");

        if (trainingTeam != null) {

            System.out.println(trainingTeam.getName());

            for (ISportsmanTrainingTeam i : trainingTeam.getSportsmen()) {
                System.out.print(i.getSportsmanName());
                System.out.print(", " + i.getPosition());
                System.out.println();
            }

            System.out.print("Coach/es: ");
            for (ICoach c : trainingTeam.getCoaches()) {
                System.out.print(c.getPersonName() + ", ");
            }

            System.out.println();
        }

        System.out.println("######## TEAM ########");

        ITeamDAO teamDAO = TeamDAO.getInstance();
        List<ITeam> teams = teamDAO.getAll(s);

        for (ITeam t : teams) {
            System.out.println(t.getTeamID() + ", " + t.getName());
        }

        System.out.println("######## COACH ########");
        
        ICoachDAO coachDAO = CoachDAO.getInstance();
        List<ICoach> coaches = coachDAO.getAll(s);
        
        for(ICoach c : coaches) {
            System.out.println(c.getPersonName());
            System.out.println("TEAMS: ");
            
            for(ITrainingTeam tt : c.getTeams()) {
                System.out.println(tt.getName());
            }
            
            System.out.println();
        }
        
        System.out.println("######## SPORTSMAN ########");
        
        ISportsmanDAO sportsmanDAO = SportsmanDAO.getInstance();
        List<ISportsman> sportsmen = sportsmanDAO.getAll(s);
        
        for(int i = 0; i < 3; i++) {
            ISportsman sm = sportsmen.get(i);
            System.out.println(sm.getPersonName());
            
            System.out.println("TEAMS: ");
            for(ISportsmanTrainingTeam stt : sm.getTeams()) {
                System.out.println(stt.getTeamName());
            }
            
            System.out.println("\n");
        }
        
        System.out.println("######## PERSON ADDRESS ########");

        List<IPerson> persons = personDAO.getAll(s);
        
        for(IPerson p : persons) {
            System.out.println(p.getName());
            
            for(IAddress a : p.getAddresses()) {
                System.out.println(a);
            }
            
            System.out.println();
        }
        
        System.out.println("######## TOURNAMENT ########");
        
        ITournamentDAO tournamentDAO = TournamentDAO.getInstance();
        List<ITournament> tournaments = tournamentDAO.getAll(s);
        
        for(ITournament tm : tournaments) {
            System.out.println(tm.getName());
            
            System.out.println("\nTEAMS:");
            for(ITeam t : tm.getTeams()) {
                System.out.println(t.getName());
            }
            
            System.out.println("\nMATCHES");
            for(IMatch m : tm.getMatches()) {
                System.out.println(m.getTeam1().getName() + " vs " + m.getTeam2().getName());
                System.out.println(m.getResult() + "\n");
            }
            
            System.out.println("\n\n");
        }
        
        System.out.println("######## TEST COUNTRYDTO ########");
        
        countryDAO = CountryDAO.getInstance();
        countryList = countryDAO.getAll(s);
        List<ICountryDTO> countryDTOs = new LinkedList<>();
        
         for (ICountry country : countryList) {
            countryDTOs.add(countryDAO.extractDTO(country));
        }
        
         for (int i = 0; i < countryDTOs.size(); i++) {
            ICountry iCountry = countryList.get(i);
            ICountryDTO iCountryDTO = countryDTOs.get(i);
            
            System.out.println(iCountry.getName() + ", " + iCountry.getCode());
            System.out.println(iCountryDTO.getName() + ", " + iCountryDTO.getCode());
            System.out.println();
                               
        }
         
  

    }
}
