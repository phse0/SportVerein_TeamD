/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ISportsmanDTO;
import data.interfaces.models.ISportsman;

/**
 *
 * @author uubu
 */
public class SportsmanDTO extends AbstractRoleDTO<ISportsman> implements ISportsmanDTO {

    public SportsmanDTO(ISportsman model) {
        if(model == null) {
            return;
        }
        extract(model);
    }

    @Override
    public void extract(ISportsman model) {
        extractRole(model);
    }

    @Override
    public String toString() {
        return person.getLastname() + " " + person.getFirstname();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ISportsmanDTO)) return false;
        if (((ISportsmanDTO) obj).getId() == this.id) {
            return true;
        }
        return false;
    }
}
