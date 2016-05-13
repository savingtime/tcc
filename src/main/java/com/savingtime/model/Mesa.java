package com.savingtime.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mesa {

	
	@XmlElement private int capacidade, quantidade,codigo;
	@XmlElement private String status;	
	
	
	public Mesa(){
		
	}
	
	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Mesa [capacidade=" + capacidade + ", quantidade=" + quantidade + ", codigo=" + codigo + ", status="
				+ status + "]";
	}
	
}
