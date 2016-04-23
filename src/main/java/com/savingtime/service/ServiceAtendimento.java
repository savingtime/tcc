package com.savingtime.service;

import java.sql.SQLException;
import java.util.List;

import com.savingtime.dao.DaoAtendimento;
import com.savingtime.model.Atendimento;

public class ServiceAtendimento {
	
	public ServiceAtendimento(){
		
	}
	
	public  void cadastrarAtendimento(Atendimento atend) throws SQLException{
		DaoAtendimento daoatend = new DaoAtendimento();
		daoatend.cadastrarAtendimento(atend);
	}
	
	public List<Atendimento> consultarAtendimento(Atendimento atend) throws SQLException{
		DaoAtendimento daoatend = new DaoAtendimento();
		return daoatend.consultarAtendimento(atend);
		
	}
	
	
	
	
	
	
	
}
