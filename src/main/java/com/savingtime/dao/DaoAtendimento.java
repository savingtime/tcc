package com.savingtime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.savingtime.conexao.AcessoBD;
import com.savingtime.model.Atendimento;

public class DaoAtendimento {
	
	public void efetuarCheckIn(Atendimento atend) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "insert into atendimento (nome, qtpessoas, telefone, tipoevento, data, hora_checkin) values (?,?,?,?,?,?);";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setString(1, atend.getNomeResponsavel());
				stm.setInt(2, atend.getQtPessoas());
				stm.setString(3, atend.getTelefone());
				stm.setString(4, atend.getTipoEvento());
				stm.setString(5, atend.getData());
				stm.setString(6, atend.getHoraCheckIn());
				stm.executeUpdate();	
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void iniciarAtendimento(Atendimento atend) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "update atendimento set hora_atendimento where cod_atendimento=?;";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);	
				stm.setString(1, atend.getHoraAtendimento());
				stm.setInt(2, atend.getCodigoAtendimento());
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void efetuarCheckOut(Atendimento atend) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "update atendimento set hora_checkout where cod_atendimento=?;";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);	
				stm.setString(1, atend.getHoraCheckOut());
				stm.setInt(2, atend.getCodigoAtendimento());
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}


	
	public List<Atendimento> consultarAtendimento(Atendimento atend) throws SQLException {	
		
		List<Atendimento> listatend = new ArrayList<Atendimento>();
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "select * from atendimento";
		try{
		
			ResultSet rs = null;
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
	        rs = stm.executeQuery();
	     
	        if(!rs.next()){
	
	          //tratar caso não tenha reserva cadastradas. 
	        }else{
	        	while(rs.next()){
					atend.setNomeResponsavel(rs.getString(1));
					atend.setQtPessoas(rs.getInt(2));
					atend.setTelefone(rs.getString(3));
					atend.setTipoEvento(rs.getString(4));
					atend.setHoraCheckIn(rs.getString(5));
					atend.setData(rs.getString(6));
					atend.setHoraAtendimento(rs.getString(7));
					atend.setHoraCheckOut(rs.getString(8));
					atend.setCodigoAtendimento(rs.getInt(9));
					listatend.add(atend);
	        	}
	        	
	        	stm.close();
	        }	
	        	
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return listatend;
	}
}