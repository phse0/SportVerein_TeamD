/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.DAOs;

import data.hibernate.HibernateUtil;
import data.interfaces.DAOs.IDAOs;
import data.interfaces.models.IModel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Michael
 */
public abstract class AbstractDAO<V extends IModel> implements IDAOs<V> {

    private String table;

    public AbstractDAO(String table) {
        this.table = table;
    }

    protected String getTable() {
        return table;
    }

    @Override
    public List<V> getAll() {
        Session s = HibernateUtil.getCurrentSession();
        Query query = s.createQuery("FROM " + getTable() + "");
        return query.list();
    }

    @Override
    public void add(V model) {
        Session s = HibernateUtil.getCurrentSession();
        s.save(model);
    }

    @Override
    public void remove(V model) {
        Session s = HibernateUtil.getCurrentSession();
        s.delete(model);
    }

    @Override
    public void update(V model) {
        Session s = HibernateUtil.getCurrentSession();
        s.update(model);
    }
    
    @Override
    public abstract V create();
}
