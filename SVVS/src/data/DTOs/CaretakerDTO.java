/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DTOs;

import data.interfaces.DTOs.ICaretakerDTO;
import data.interfaces.models.ICaretaker;

/**
 *
 * @author uubu
 */
public class CaretakerDTO extends AbstractRoleDTO<ICaretaker> implements ICaretakerDTO{

    public CaretakerDTO(ICaretaker model){
        extract(model);
    }

    @Override
    public void extract(ICaretaker model) {
        extractRole(model);
    }
}
