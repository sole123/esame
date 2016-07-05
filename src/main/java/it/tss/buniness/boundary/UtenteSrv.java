/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.buniness.boundary;


import it.tss.buniness.entity.Utente;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Named(value = "userService")
@Stateless
public class UtenteSrv {
    
    @PersistenceContext
    private EntityManager em;
    
   
    
    public Utente save(Utente u){
       
        Utente saved = em.merge(u);
        return saved;
    }
    
    public void delete(Utente u){
        em.remove(u);
    }
   
    
    public Utente findByUsrPwd(String usr, String pwd){
        return em.createNamedQuery("Utente.findByUsrPwd", Utente.class)
                .setParameter("email",usr )
                .setParameter("password", pwd)
                .getSingleResult();
    }

    public Utente findByNick(String nick) {
        return em.createNamedQuery("Utente.findByNick", Utente.class)
                .setParameter("email",nick )
                .getSingleResult();
    }

}
