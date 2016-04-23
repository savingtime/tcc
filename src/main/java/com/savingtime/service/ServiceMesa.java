package com.savingtime.service;

import java.sql.SQLException;
import java.util.List;

import com.savingtime.dao.DaoMesa;
import com.savingtime.model.Mesa;


public class ServiceMesa {
	
	public void cadastrarMesas(Mesa mesa) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		daomesa.cadastrarMesa(mesa);
		
	}
	public List<Mesa> consultarMesas(Mesa mesa) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		return daomesa.consultarMesa(mesa);
		
	}
	
	public void alterarMesas(Mesa mesa) throws SQLException{
		DaoMesa daomesa = new DaoMesa();
		daomesa.alterarMesa(mesa);
		
	}
}
