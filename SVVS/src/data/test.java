/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.hibernate.HibernateUtil;
import data.models.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Michael
 */
public class test {
    
    public static void main(String args[]){
        
        Session s = HibernateUtil.getCurrentSession();
        Transaction tx = s.beginTransaction();
        
        
        Country country = new Country();
        country.setCode("666");
        country.setName("Dörkadörkistan");
        
        
        s.save(country);

        tx.commit();
        
    }
    
}
