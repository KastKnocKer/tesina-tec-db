package com.restaurant.android.cameriere.notifiche;

import java.util.Date;

public class Notifica {
	
	private TipoNotifica tipoNotifica;
	private int idComanda;
	private String nomeTavolo;
	private int idVoceMenu;
	private String voceMenu;
	
	private String data;
	
	public TipoNotifica getTipoNotifica() {
		return tipoNotifica;
	}
	public void setTipoNotifica(TipoNotifica tipoNotifica) {
		this.tipoNotifica = tipoNotifica;
	}
	public String getNomeTavolo() {
		return nomeTavolo;
	}
	public void setNomeTavolo(String nomeTavolo) {
		this.nomeTavolo = nomeTavolo;
	}
	public String getVoceMenu() {
		return voceMenu;
	}
	public void setVoceMenu(String voceMenu) {
		this.voceMenu = voceMenu;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getIdVoceMenu() {
		return idVoceMenu;
	}
	public void setIdVoceMenu(int idVoceMenu) {
		this.idVoceMenu = idVoceMenu;
	}
	public int getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	
	
}