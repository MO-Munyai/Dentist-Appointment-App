/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;

import jakarta.persistence.EntityManager;
import java.util.*;


public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        return getEntityManager()
            .createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
            .getResultList();
    }

    public int count() {
        return ((Number) getEntityManager()
            .createQuery("SELECT COUNT(e) FROM " + entityClass.getSimpleName() + " e")
            .getSingleResult()).intValue();
    }
}
