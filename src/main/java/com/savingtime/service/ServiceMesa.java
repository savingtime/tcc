package com.savingtime.service;

import java.sql.SQLException;
import java.util.List;

import com.savingtime.dao.DaoMesa;
import com.savingtime.model.Mesa;


public class ServiceMesa {
	
	public void cadastrarMesas(Mesa mesa, int quantidade) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		daomesa.cadastrarMesa(mesa, quantidade);
		
	}
	public List<Mesa> consultarTodasMesas() throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		return daomesa.consultarTodasMesas();
		
	}
	
	public List<Mesa> consultarMesasCapacidade(int capacidade) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		return daomesa.consultarMesasCapacidade(capacidade);
		
	}
	
	public List<Mesa> consultarMesaStatus(String status) throws SQLException{
		
		DaoMesa daomesa = new DaoMesa();
		return daomesa.consultarMesaStatus(status);
		
	}
	
	public void alterarMesa(Mesa mesa) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		daomesa.alterarMesa(mesa);
		
	}
}