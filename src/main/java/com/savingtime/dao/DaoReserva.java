package com.savingtime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.savingtime.model.Reserva;
import com.savingtime.conexao.AcessoBD;

public class DaoReserva {
	
	public void cadastrarReserva(Reserva reserva) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "insert into reserva(data, horario, qt_pessoas, cpf, telefone, tipo_evento) values (?,?,?,?,?,?);";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setString(1, reserva.getDataReserva());
				stm.setString(2, reserva.getHoraReserva());
				stm.setInt(3, reserva.getQtPessoas());
				stm.setString(4, reserva.getCpf());
				stm.setString(5, reserva.getTelefone());
				stm.setString(6, reserva.getTipoEvento());		
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void alterarReserva(Reserva reserva) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "update reserva set data=?, horario=?, qt_pessoas=?, cpf=?, telefone=?, tipo_evento where id=?;";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);	
				stm.setString(1, reserva.getDataReserva());
				stm.setString(2, reserva.getHoraReserva());
				stm.setString(3, reserva.getCpf());
				stm.setString(4, reserva.getTelefone());
				stm.setString(5, reserva.getTipoEvento());

				
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void excluirReserva(int codigoReserva) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "delete from reserva where codreserva =?;";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			 	stm.setInt(1,codigoReserva); 
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Reserva consultarReservaCpf(String cpf,Reserva reserva) throws SQLException {
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();       
        String sqlSelect = "select * from reserva where cpf=?;";
        ResultSet rs = null;
     
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, cpf);
            rs = stm.executeQuery();
         
            if(!rs.next()){
 
              //tratar caso não tenha reserva cadastradas. 
            }else{
            	
	            reserva.setDataReserva(rs.getString(1));
	            reserva.setHoraReserva(rs.getString(2));
	            reserva.setQtPessoas(rs.getInt(3));
	            reserva.setCpf(rs.getString(4));
	            reserva.setTelefone(rs.getString(5));
	            reserva.setCpf(rs.getString(6));
	            reserva.setCodReserva(rs.getInt(7)); 
            }    
            
		}catch (Exception e){			
			System.out.println("erro");
		}
		
        return reserva;  
	}
	
	
	public List<Reserva> consultarReservaData(String dataInicio, String dataFinal, Reserva reserva) throws SQLException {
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();       
        String sqlSelect = "select * from reserva;"; 
        ResultSet rs = null;
        
        List<Reserva> listreserva = new ArrayList<Reserva>();
     
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
            rs = stm.executeQuery();
         
            if(!rs.next()){
 
              //tratar caso não tenha reserva cadastradas. 
            }else{
            	
            	while(rs.next()){
            		
	            	reserva.setDataReserva(rs.getString(1));
		            reserva.setHoraReserva(rs.getString(2));
		            reserva.setQtPessoas(rs.getInt(3));
		            reserva.setCpf(rs.getString(4));
		            reserva.setTelefone(rs.getString(5));
		            reserva.setCpf(rs.getString(6));  
		            reserva.setCodReserva(rs.getInt(7)); 
		            listreserva.add(reserva);
            	}    
            }    
            
            stm.close();
		}catch (Exception e){			
			System.out.println("erro");
		}
		
        return listreserva;  
	}
	
	
	
	public List<Reserva> consultarReserva(Reserva reserva) throws SQLException {
		
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();       
        String sqlSelect = "select * from reserva;";
        ResultSet rs = null;
        
        List<Reserva> listreserva = new ArrayList<Reserva>();
     
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
            rs = stm.executeQuery();
         
            if(!rs.next()){
 
              //tratar caso não tenha reserva cadastradas. 
            }else{
            	
            	while(rs.next()){
            		
	            	reserva.setDataReserva(rs.getString(1));
		            reserva.setHoraReserva(rs.getString(2));
		            reserva.setQtPessoas(rs.getInt(3));
		            reserva.setCpf(rs.getString(4));
		            reserva.setTelefone(rs.getString(5));
		            reserva.setCpf(rs.getString(6));  
		            reserva.setCodReserva(rs.getInt(7)); 
		            listreserva.add(reserva);
            	}    
            }    
            
            stm.close();
		}catch (Exception e){			
			System.out.println("erro");
		}
		
        return listreserva;  
	}
	
	
	public Reserva consultarReservaCodigo(int codReserva,Reserva reserva) throws SQLException {
		
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();       
        String sqlSelect = "select * from reserva where codreserva=?;";
        ResultSet rs = null;
     
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
            stm.setInt(1, codReserva);
            rs = stm.executeQuery();
         
            if(!rs.next()){
 
              //tratar caso não tenha reserva cadastradas. 
            }else{
            	
	            reserva.setDataReserva(rs.getString(1));
	            reserva.setHoraReserva(rs.getString(2));
	            reserva.setQtPessoas(rs.getInt(3));
	            reserva.setCpf(rs.getString(4));
	            reserva.setTelefone(rs.getString(5));
	            reserva.setCpf(rs.getString(6));
	            reserva.setCodReserva(rs.getInt(7)); 
            }    
            
		}catch (Exception e){			
			System.out.println("erro");
		}
		
        return reserva;  
	}
}	
