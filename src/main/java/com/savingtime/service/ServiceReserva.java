package com.savingtime.service;

import java.sql.SQLException;
import java.util.List;

import com.savingtime.dao.DaoReserva;
import com.savingtime.model.Reserva;

public class ServiceReserva {

	public void efetuarReserva(Reserva reserva) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		daoreserv.cadastrarReserva(reserva);
		
	}
	
	public void excluirReserva(int codReserva) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		daoreserv.excluirReserva(codReserva);
		
	}
	
	public void alterarReserva(Reserva reserva) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		daoreserv.alterarReserva(reserva);
		
	}
	
	
	public Reserva consultarReservaCpf(String cpf) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		return daoreserv.consultarReservaCpf(cpf);
		
	}
	
	public Reserva consultarReservaCodigo(int codigo) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		return daoreserv.consultarReservaCodigo(codigo);
		
	}

	
	public List<Reserva> consultarReservaData(String dataInicio, String dataFinal) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		return daoreserv.consultarReservaData(dataInicio, dataFinal);
		
	}
	
	public List<Reserva> consultarTodasReservas() throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		return daoreserv.consultarTodasReservas();	
		
	}
}