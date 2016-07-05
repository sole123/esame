/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.presentation;


import it.tss.buniness.boundary.UsersCache;
import it.tss.buniness.boundary.UtenteSrv;
import it.tss.buniness.entity.Utente;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author tss
 */
@Stateless
public class Security {
    @Inject
    Utente utente;
    @Inject
    private UtenteSrv utenteSrv;
    @Inject
    SessionData sessionData;
    @Inject
    UsersCache usersCache;


    public boolean login(String usr, String pwd) {
        try {
            Utente u = utenteSrv.findByUsrPwd(usr, pwd);
            usersCache.addUser(u);
           
            return true;
        } catch (EJBException ex) {
            return false;
        }

    }
   
    public void logout() {
        logout(
            utenteSrv.findByNick(sessionData.getLoggedUser()));
    }

    public void logout(Utente u) {
        usersCache.removeUser(u);
    }


}
