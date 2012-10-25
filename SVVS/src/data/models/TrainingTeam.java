/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.models;

import data.interfaces.ICoach;
import data.interfaces.IDepartment;
import data.interfaces.ISport;
import data.interfaces.ISportsmanTrainingTeam;
import data.interfaces.ITrainingTeam;
import java.util.List;

/**
 *
 * @author Michael
 */
public class TrainingTeam extends Team implements ITrainingTeam {
    
    protected IDepartment department;
    protected List<ISportsmanTrainingTeam> sportsmen;
    protected List<ICoach> coaches;

    public TrainingTeam() {
        super();
    }

    public TrainingTeam(IDepartment department, String name, ISport sport) {
        super(name, sport);
        this.department = department;
    }

    @Override
    public IDepartment getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(IDepartment department) {
        this.department = department;
    }

    @Override
    public List<ISportsmanTrainingTeam> getSportsmen() {
        return sportsmen;
    }

    @Override
    public void setSportsmen(List<ISportsmanTrainingTeam> sportsmen) {
        this.sportsmen = sportsmen;
    }

    @Override
    public List<ICoach> getCoaches() {
        return coaches;
    }

    @Override
    public void setCoaches(List<ICoach> coaches) {
        this.coaches = coaches;
    }
    
    @Override
    public void addSportsman(ISportsmanTrainingTeam sportsman) {
        this.sportsmen.add(sportsman);
    }
    
    @Override
    public void removeSportsman(ISportsmanTrainingTeam sportsman) {
        this.sportsmen.remove(sportsman);
    }
    
    @Override
    public void addCoach(ICoach coach) {
        this.coaches.add(coach);
    }
    
    @Override
    public void removeCoach(ICoach coach) {
        this.coaches.remove(coach);
    }
    
}
