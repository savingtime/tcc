package com.savingtime.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.savingtime.model.Mesa;
import com.savingtime.model.Reserva;
import com.savingtime.service.ServiceMesa;
import com.savingtime.service.ServiceReserva;


@Path("/svtime")
public class ApiRest {

//************** CHAMADAS REST SOMENTE PARA MESAS******************************		
	
	@POST
	@Path("/consultar/mesas")
	@Produces(MediaType.APPLICATION_JSON)
	public Mesa consultarMesas() {
		// Chamar a service para a consulta das mesas
		
		Mesa mesa = new Mesa();
		return mesa;
	}
	
	
	@GET
	@Path("/alterar/mesa")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarMesas() {
		// Chamar a service para a alteração das mesas
		
		ServiceMesa mesa = new ServiceMesa();
		
	}
	
	
	@GET
	@Path("/cadastrar/mesas")
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastrarMesas() {
		// Chamar a service para a cadastro das mesas
		
		ServiceMesa mesas = new ServiceMesa();
		
	}

//************** CHAMADAS REST SOMENTE PARA Reservas******************************	

	@POST
	@Path("/cadastrar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastrarReservas() {
		// Chamar a service para a cadastro de reservas
		
		ServiceReserva reserva = new ServiceReserva();
	
	}
	
	
	@GET
	@Path("/excluir/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirReservas() {
		// Chamar a service para a cadastro de reservas
		
		ServiceReserva reserva = new ServiceReserva();

	}
	
	
	@GET
	@Path("/alterar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarReservas() {
		// Chamar a service para a alteração de reservas
		
		ServiceReserva reserva = new ServiceReserva();
	}
	
	
	/*@GET
	@Path("/consultar/reserva/data")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> consultarReservasData() {
		// Chamar a service para a alteração de reservas por intervalo de data
		
		ServiceReserva reserva = new ServiceReserva();
		return reserva.alterarReservaDatas();
	}
	
	
	@GET
	@Path("/consultar/reserva/cpf")
	@Produces(MediaType.APPLICATION_JSON)
	public Reserva consultarReservasCpf() {
		// Chamar a service para a conulsta de reserva por cpf
		
		ServiceReserva reserva = new ServiceReserva();
		return reserva.consultarReservaCpf();
	}
	
	@GET
	@Path("/consultar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> consultarReservas() {
		// Chamar a service para consulta de todas reservas
		
		ServiceReserva reserva = new ServiceReserva();
		return reserva.consultarReserva();
	}
*/
}
