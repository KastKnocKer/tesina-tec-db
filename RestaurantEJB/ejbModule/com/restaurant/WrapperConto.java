package com.restaurant;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.orb.Conto;
import com.orb.StatoContoEnum;

public class WrapperConto {
	
	private int idConto;
	private BigDecimal prezzo;
	private Timestamp timestampApertura;
	private Timestamp timestampChiusura;
	private StatoContoEnum stato;
	
	public WrapperConto(Conto conto) {
	
		this.idConto = conto.getIdConto();
		this.prezzo = conto.getPrezzo();
		this.timestampApertura = conto.getTimeStampApertura();
		this.timestampChiusura = conto.getTimeStampChiusura();
		this.setStato(conto.getStato());
	}
	
	public int getIdConto() {
		return idConto;
	}
	public void setIdConto(int idConto) {
		this.idConto = idConto;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public Timestamp getTimestampApertura() {
		return timestampApertura;
	}

	public void setTimestampApertura(Timestamp timestampApertura) {
		this.timestampApertura = timestampApertura;
	}

	public Timestamp getTimestampChiusura() {
		return timestampChiusura;
	}

	public void setTimestampChiusura(Timestamp timestampChiusura) {
		this.timestampChiusura = timestampChiusura;
	}

	public StatoContoEnum getStato() {
		return stato;
	}

	public void setStato(StatoContoEnum stato) {
		this.stato = stato;
	}
	
		
}
