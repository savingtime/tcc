package com.savingtime.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Reserva {

	@XmlElement private String dataReserva, horaReserva, cpf, tipoEvento, telefone, statusReserva;
	@XmlElement private int codReserva, qtPessoas;
	
	public Reserva(){
		
		
	}

	
	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public int getQtPessoas() {
		return qtPessoas;
	}

	public void setQtPessoas(int qtPessoas) {
		this.qtPessoas = qtPessoas;
	}

	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getHoraReserva() {
		return horaReserva;
	}

	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getStatusReserva() {
		return statusReserva;
	}


	public void setStatusReserva(String statusReserva) {
		this.statusReserva = statusReserva;
	}
	
	
}
