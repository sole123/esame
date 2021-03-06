/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.buniness.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author tss
 */
@Entity
public class Offerta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private String Utente;
    @ManyToOne
    private String Oggetto;
    private Float importoOfferta;
    private Date dataOfferta;

    public Offerta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtente() {
        return Utente;
    }

    public void setUtente(String Utente) {
        this.Utente = Utente;
    }

    public String getOggetto() {
        return Oggetto;
    }

    public void setOggetto(String Oggetto) {
        this.Oggetto = Oggetto;
    }

    public Float getImportoOfferta() {
        return importoOfferta;
    }

    public void setImportoOfferta(Float importoOfferta) {
        this.importoOfferta = importoOfferta;
    }

    public Date getDataOfferta() {
        return dataOfferta;
    }

    public void setDataOfferta(Date dataOfferta) {
        this.dataOfferta = dataOfferta;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offerta other = (Offerta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Offerta{" + "Utente=" + Utente + ", Oggetto=" + Oggetto + ", importoOfferta=" + importoOfferta + ", dataOfferta=" + dataOfferta + '}';
    }
    
    
    
}
