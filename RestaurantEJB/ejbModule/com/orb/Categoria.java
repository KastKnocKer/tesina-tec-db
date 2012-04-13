package com.orb;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "getCategorieFiglieDi",
				query = "SELECT c FROM Categoria c " +
						"LEFT JOIN c.categoriaPadre cp WHERE "+
						"cp.idCategoria=:idCategoriaPadre AND "+
						"c.idTenant=:idTenant AND " +
						"c.removed = :removed")})
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCategoria")
	private int idCategoria;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="idTenant")
	private int idTenant;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="removed")
	private boolean removed;
	
	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private TipoCategoriaEnum tipo;
		
	/* Essendo l'associazione con la categoria padre molti a uno, il fetch è 
	 * di default eager, ma diventa ricorsivo essendo l'associazione collegata
	 * alla stessa entità */
	@ManyToOne(fetch=FetchType.LAZY)
	
	@JoinColumn(name="idCategoriaPadre", referencedColumnName="idCategoria")
	private Categoria categoriaPadre;
	
	@OneToMany(mappedBy="categoriaPadre")
	private List<Categoria> categorieFiglie;

	@OneToMany(mappedBy="categoriaAppartenenza")
	private List<Variazione> variazioni;
	
	@OneToMany(mappedBy="categoriaAppartenenza")
	private List<VoceMenu> vociMenu;
	
	
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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

	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public List<Categoria> getCategorieFiglie() {
		return categorieFiglie;
	}

	public List<Variazione> getVariazioni() {
		return variazioni;
	}

	public List<VoceMenu> getVociMenu() {
		return vociMenu;
	}

	public int getIdTenant() {
		return idTenant;
	}

	public void setIdTenant(int idTenant) {
		this.idTenant = idTenant;
	}

	public TipoCategoriaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoCategoriaEnum tipo) {
		this.tipo = tipo;
	}

	public boolean getRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	
	
}
