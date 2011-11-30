package com.restaurant;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.orb.Area;
import com.orb.Prenotazione;

public class TreeNodeTavolo {
	
	private int idTavolo;
	private String nome;
	private String descrizione;
	private boolean enabled;
	private String stato;
	private int idTenant;
		
	public TreeNodeTavolo(	int idTavolo, 
							String nome, 
							String descrizione,
							boolean enabled, 
							String stato, 
							int idTenant) {
		super();
		this.idTavolo = idTavolo;
		this.nome = nome;
		this.descrizione = descrizione;
		this.enabled = enabled;
		this.stato = stato;
		this.idTenant = idTenant;
	}
	
	public int getIdTavolo() {
		return idTavolo;
	}
	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public int getIdTenant() {
		return idTenant;
	}
	public void setIdTenant(int idTenant) {
		this.idTenant = idTenant;
	}
	
	
	
}
