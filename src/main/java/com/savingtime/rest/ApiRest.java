package com.savingtime.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import com.savingtime.model.Atendimento;
import com.savingtime.model.Mesa;
import com.savingtime.model.Reserva;
import com.savingtime.service.ServiceAtendimento;
import com.savingtime.service.ServiceMesa;
import com.savingtime.service.ServiceReserva;


@Path("/svtime")
public class ApiRest {

//************** CHAMADAS REST SOMENTE PARA MESAS******************************		
	
	
	@PUT
	@Path("/alterar/mesa")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarMesas(Mesa mesa, int codigo) throws SQLException {
		// Chamar a service para a alteração das mesas
		ServiceMesa serviceMesa = new ServiceMesa();
		serviceMesa.alterarMesa(mesa);		
	}
	
	
	@POST
	@Path("/cadastrar/mesas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void cadastrarMesas(Mesa mesa, int quantidade) throws JSONException {
		// Chamar a service para a cadastro das mesas
		
		ServiceMesa servicemesas = new ServiceMesa();
		try {
			servicemesas.cadastrarMesas(mesa, quantidade);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@GET
	@Path("/consultar/mesas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mesa> consultarTodasMesas() throws SQLException {
		// Chamar a service para a consulta das mesas
		
		ServiceMesa servicemesa = new ServiceMesa();
		
		return servicemesa.consultarTodasMesas();
	}
	
	
	@GET
	@Path("/consultar/mesas/capacidade/{capacidade}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Mesa> consultarMesas(@PathParam("capacidade")int capacidade) throws SQLException {
		
		System.out.println(capacidade);
		ServiceMesa serviceMesa = new ServiceMesa();
		return serviceMesa.consultarMesasCapacidade(capacidade);
	}
	
	
	@GET
	@Path("/consultar/mesas/status/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Mesa> consultarMesas(@PathParam("status")String status) throws SQLException {
		
		ServiceMesa serviceMesa = new ServiceMesa();
		
		return serviceMesa.consultarMesaStatus(status);
	}

	
	
	
//************** CHAMADAS REST SOMENTE PARA Reservas******************************	

	@POST
	@Path("/cadastrar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarReservas(Reserva reserva) {
		// Chamar a service para a cadastro de reservas
		
		ServiceReserva servicereserva = new ServiceReserva();
		try {
			servicereserva.efetuarReserva(reserva);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
//Somente muda o status para cancelado
	@PUT
	@Path("/excluir/reserva")
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluirReserva(int codReserva) {
		
		ServiceReserva serviceReserva = new ServiceReserva();
		
		try {
			serviceReserva.excluirReserva(codReserva);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	
	// Alteração de reservas
	@PUT
	@Path("/alterar/reserva")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alterarReserva(Reserva reserva) {
			
		ServiceReserva serviceReserva = new ServiceReserva();
		try {
			serviceReserva.alterarReserva(reserva);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}	
		
	
	 //Consulta de reservas por intervalo de data
	@GET
	@Path("/consultar/reserva/data/{datainicio}/{datafim}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Reserva> consultarReservasData(@PathParam("datainicio")String dataInicio, @PathParam("datafim")String dataFim) throws SQLException {
		
		ServiceReserva serviceReserva = new ServiceReserva();
		
			return serviceReserva.consultarReservaData(dataInicio, dataFim);
		
	}

	//Consulta de reserva por cpf
	@POST
	@Path("/consultar/reserva/cpf")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reserva consultarReservasCpf(String cpf) throws SQLException {

		ServiceReserva serviceReserva = new ServiceReserva();
		return serviceReserva.consultarReservaCpf(cpf);
	}
	
	// Consultar reserva por codigo
	@GET
	@Path("/consultar/reserva/codigo/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reserva consultarReservaCodigo(@PathParam("codigo") int codigo) throws SQLException
	 {
		ServiceReserva serviceReserva = new ServiceReserva();
		return serviceReserva.consultarReservaCodigo(codigo);
	}


	@GET
	@Path("/consultar/reserva")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> consultarTodasReservas() throws SQLException {
		// Chamar a service para consulta de todas reservas
		
		ServiceReserva serviceReserva = new ServiceReserva();
		return serviceReserva.consultarTodasReservas();
	}

	
//************** CHAMADAS REST SOMENTE PARA ATENDIMENTO******************************	

	@POST
	@Path("/efetuar/checkin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void efetuarCheckIn(Atendimento atendimento) {
		// Chamar a service para a cadastro de reservas
		
		ServiceAtendimento serviceAtendimento = new ServiceAtendimento();
		try {
			serviceAtendimento.efetuarCkeckIn(atendimento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	@POST
	@Path("/iniciar/atendimento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void iniciarAtendimento(int codigo) {
		// Chamar a service para a cadastro de reservas
		
		ServiceAtendimento serviceAtendimento = new ServiceAtendimento();
		try {
			serviceAtendimento.iniciarAtendimento(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
		
}
