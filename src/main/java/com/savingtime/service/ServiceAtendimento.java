package com.savingtime.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.savingtime.dao.DaoAtendimento;
import com.savingtime.model.Atendimento;

public class ServiceAtendimento {
	
	private ArrayList<Atendimento> filaEspera = new ArrayList<Atendimento>();
	

	private ArrayList<Atendimento> listaAtendimento = new ArrayList<Atendimento>();
	
	public ServiceAtendimento(){
		
	}
	
	public void efetuarCkeckIn(Atendimento atend) throws SQLException{
		
		filaEspera.add(atend);
		DaoAtendimento daoatend = new DaoAtendimento();
		daoatend.efetuarCheckIn(atend);
	}
	
	public void iniciarAtendimento(int codigo) throws SQLException{
		
		int posicaoAtendimento = buscarFilaEspera(codigo);
		filaEspera.get(posicaoAtendimento).setHoraAtendimento("");
		listaAtendimento.add(filaEspera.get(posicaoAtendimento));
				
		DaoAtendimento daoatend = new DaoAtendimento();
		daoatend.iniciarAtendimento(filaEspera.get(posicaoAtendimento));
		
		filaEspera.remove(posicaoAtendimento);
	}
	
	public void efetuarCheckOut(int codigo) throws SQLException{
		
		int posicaoAtendimento = buscarListaAtendimento(codigo);
		listaAtendimento.get(posicaoAtendimento).setHoraCheckOut("");
				
		DaoAtendimento daoatend = new DaoAtendimento();
		daoatend.efetuarCheckOut(listaAtendimento.get(posicaoAtendimento));
		
		listaAtendimento.remove(posicaoAtendimento);
	}
	
	
	
	
	public List<Atendimento> consultarAtendimento(Atendimento atend) throws SQLException{
		DaoAtendimento daoatend = new DaoAtendimento();
		return daoatend.consultarAtendimento(atend);	
	}
	
	public int buscarFilaEspera(int procurado) throws SQLException{
		int n = filaEspera.size();
		int meio;
		int inicio = 0;
		int fim = n-1;
		while (inicio <= fim) {
			meio = (inicio + fim)/2;
		        if (procurado == filaEspera.get(meio).getCodigoAtendimento()){
		        	return meio;
		        }	
		        	
		        if (procurado < filaEspera.get(meio).getCodigoAtendimento()){
		                 fim = meio - 1;
		        }else{
		                 inicio = meio + 1;
				}
		 }
		//caso não encontre ninguem
		return -1;
	}
	
	public int buscarListaAtendimento(int procurado){
		int posicao = -1;//retornar -1 caso nao encontre na lista
		for(int i=0; i <listaAtendimento.size(); i++){
			if(listaAtendimento.get(i).getCodigoAtendimento() == procurado){
				return i;
			}
		}
		
		return posicao;
	}
	
	
	public ArrayList<Atendimento> getFilaEspera() {
		return filaEspera;
	}
	
	public ArrayList<Atendimento> getEmAtendimento() {
		return listaAtendimento;
	}
	
}