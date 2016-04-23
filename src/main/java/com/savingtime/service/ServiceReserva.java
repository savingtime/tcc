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
	
	public Reserva consultarReservaCod(int codReserva) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		Reserva reserva = new Reserva();
		return daoreserv.consultarReservaCodigo(codReserva, reserva );
		
	}
	
	public Reserva consultarReservaCpf(String cpf) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		Reserva reserva = new Reserva();
		return daoreserv.consultarReservaCpf(cpf, reserva);
		
	}
	
	public List<Reserva> consultarReservaData(String dataInicio, String dataFinal) throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		Reserva reserva = new Reserva();
		return daoreserv.consultarReservaData(dataInicio, dataFinal, reserva);
		
	}
	
	public List<Reserva> consultarTodasReservas() throws SQLException{
		DaoReserva daoreserv = new DaoReserva();
		Reserva reserva = new Reserva();
		return daoreserv.consultarReserva(reserva);
		
		
	}
}
