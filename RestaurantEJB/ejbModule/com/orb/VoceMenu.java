package com.orb;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vocemenu")
public class VoceMenu {
	
	@Id
	@Column(name="idVoceMenu")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVoceMenu;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="prezzo")
	private BigDecimal prezzo;
	
	@Column(name="idTenant")
	private int idTenant;
	
	@OneToMany(mappedBy="voceMenuAssociata")
	private List<Comanda> comande;
	
	@ManyToOne
	@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")
	private Categoria categoriaAppartenenza;

	public int getIdVoceMenu() {
		return idVoceMenu;
	}

	public void setIdVoceMenu(int idVoceMenu) {
		this.idVoceMenu = idVoceMenu;
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

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public int getIdTenant() {
		return idTenant;
	}

	public void setIdTenant(int idTenant) {
		this.idTenant = idTenant;
	}

	public List<Comanda> getComande() {
		return comande;
	}

	public void setComande(List<Comanda> comande) {
		this.comande = comande;
	}

	public Categoria getCategoriaAppartenenza() {
		return categoriaAppartenenza;
	}

	public void setCategoriaAppartenenza(Categoria categoriaAppartenenza) {
		this.categoriaAppartenenza = categoriaAppartenenza;
	}
	
	

	
}