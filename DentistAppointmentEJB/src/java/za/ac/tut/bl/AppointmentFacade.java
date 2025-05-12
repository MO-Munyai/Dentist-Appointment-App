/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import za.ac.tut.entity.Appointment;

import jakarta.persistence.EntityManager;

@Stateless
public class AppointmentFacade extends AbstractFacade<Appointment> implements AppointmentFacadeLocal {

    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;

    public AppointmentFacade() {
        super(Appointment.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
