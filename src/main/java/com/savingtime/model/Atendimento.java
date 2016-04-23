package com.savingtime.model;

public class Atendimento {

	private String status, nomeResponsavel,tipoEvento, data,horaCheckIn, horaCheckOut, horaAtendimento, telefone;
	private int qtPessoas, codigoAtendimento;
	
	public Atendimento(){
			
	}
	
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getHoraCheckIn() {
		return horaCheckIn;
	}
	public void setHoraCheckIn(String horaCheckIn) {
		this.horaCheckIn = horaCheckIn;
	}
	public String getHoraCheckOut() {
		return horaCheckOut;
	}
	public void setHoraCheckOut(String horaCheckOut) {
		this.horaCheckOut = horaCheckOut;
	}
	public String getHoraAtendimento() {
		return horaAtendimento;
	}
	public void setHoraAtendimento(String horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}
	public int getQtPessoas() {
		return qtPessoas;
	}
	public void setQtPessoas(int qtPessoas) {
		this.qtPessoas = qtPessoas;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsanvel) {
		this.nomeResponsavel = nomeResponsanvel;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCodigoAtendimento() {
		return codigoAtendimento;
	}

	public void setCodigoAtendimento(int codigoAtendimento) {
		this.codigoAtendimento = codigoAtendimento;
	}
	
}
