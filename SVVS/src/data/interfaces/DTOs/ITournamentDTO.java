/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.interfaces.DTOs;

import data.interfaces.models.ITournament;

/**
 *
 * @author uubu
 */
public interface ITournamentDTO extends IDTO<ITournament> {

    String getDate();

    double getFee();

    String getLocation();

    String getName();

    void setDate(String date);

    void setFee(double fee);

    void setLocation(String location);

    void setName(String name);

    
}
