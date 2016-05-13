package com.savingtime.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.savingtime.model.Mesa;
import com.savingtime.model.Reserva;
import com.savingtime.service.ServiceMesa;
import com.savingtime.service.ServiceReserva;


@Path("/svtime")
public class ApiRest {

//************** CHAMADAS REST SOMENTE PARA MESAS******************************		
	
	@GET
	@Path("/consultar/mesas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mesa> consultarMesas() throws SQLException {
		// Chamar a service para a consulta das mesas
		
		ServiceMesa servicemesa = new ServiceMesa();
		
		return servicemesa.consultarMesas();
	}
	
	
	@PUT
	@Path("/alterar/mesa")
	@Produces(MediaType.APPLICATION_JSON)
	public void alterarMesas() {
		// Chamar a service para a alteração das mesas
		
		ServiceMesa servicemesa = new ServiceMesa();
		
		//servicemesa.alterarMesas();
		
	}
	
	
	@POST
	@Path("/cadastrar/mesas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastrarMesas(Mesa mesa) throws JSONException {
		// Chamar a service para a cadastro das mesas
		
		ServiceMesa servicemesas = new ServiceMesa();
		try {
			servicemesas.cadastrarMesas(mesa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

//************** CHAMADAS REST SOMENTE PARA Reservas******************************	

	@POST
	@Path("/cadastrar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarReservas(Reserva Reserva) {
		// Chamar a service para a cadastro de reservas
		
		ServiceReserva servicereserva = new ServiceReserva();
		try {
			servicereserva.efetuarReserva();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
/*	
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
