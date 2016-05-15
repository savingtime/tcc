package com.savingtime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.savingtime.conexao.AcessoBD;
import com.savingtime.model.Mesa;

public class DaoMesa {
	
	
	public void cadastrarMesa(Mesa mesa, int quantidade) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "insert into mesas (capacidade, status_mesa) values (?,?);";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
				for(int i=0; i < quantidade; i++){
					stm.setInt(1, mesa.getCapacidade());
					stm.setString(2, mesa.getStatus());
					stm.executeUpdate();
				}
			stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void alterarMesa(Mesa mesa) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "update Mesas set capacidade=?, status_mesa=? where num_desc_mesa=?;";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);	
				stm.setInt(1, mesa.getCapacidade());
				stm.setString(2, mesa.getStatus());
				stm.setInt(3, mesa.getCodigo());
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public List<Mesa> consultarTodasMesas() throws SQLException {
			AcessoBD bd = new AcessoBD();	
			Connection conn = bd.obtemConexao();
	         
	        String sqlSelect = "select status_mesa, capacidade, num_desc_mesa from Mesas";
	        ResultSet rs = null;
	        List<Mesa> listmesa = new ArrayList<Mesa>();
	        
	        
	        try{
	        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
	            rs = stm.executeQuery();
	         
	            // ENCONTRAR UMA SOLUÇÃO SE A LISTA FOR VAZIA.
	            
	            	while(rs.next()){
	            	Mesa mesa = new Mesa();
		            	mesa.setStatus(rs.getString(1));
		                mesa.setCapacidade(rs.getInt(2));
		                mesa.setCodigo(rs.getInt(3));
		                listmesa.add(mesa);
		                System.out.print("passei aquiii");            
	            	}    
	            
		}catch (Exception e){			
			System.out.println("erro");
			e.printStackTrace();
		}
		
	    return listmesa;  
	}
	
	
	public List<Mesa> consultarMesasCapacidade(int capacidade) throws SQLException {
		AcessoBD bd = new AcessoBD();	
		Connection conn = bd.obtemConexao();
         
        String sqlSelect = "select status_mesa, capacidade, num_desc_mesa from Mesas where capacidade=?";
        ResultSet rs = null;
        List<Mesa> listmesa = new ArrayList<Mesa>();
        
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
        	stm.setInt(1, capacidade);
        	rs = stm.executeQuery();
         
            // ENCONTRAR UMA SOLUÇÃO SE A LISTA FOR VAZIA.
            	while(rs.next()){
                    Mesa teste = new Mesa();

	            	teste.setStatus(rs.getString(1));
	                teste.setCapacidade(rs.getInt(2));
	                teste.setCodigo(rs.getInt(3));
	                listmesa.add(teste);
	                
	                
            	}    
            
		}catch (Exception e){			
			System.out.println("erro");
			e.printStackTrace();
		}
		
	    return listmesa;  
	}

	
	public List<Mesa> consultarMesaStatus(String status) throws SQLException {
		AcessoBD bd = new AcessoBD();	
		Connection conn = bd.obtemConexao();
         
        String sqlSelect = "select status_mesa, capacidade, cod_tipo_mesa from Mesas where status_mesa=?";
        ResultSet rs = null;
        List<Mesa> listmesa = new ArrayList<Mesa>();
        
        
        try{
        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
        	stm.setString(1, status);
        	rs = stm.executeQuery();
         
            // ENCONTRAR UMA SOLUÇÃO SE A LISTA FOR VAZIA.
            
            	while(rs.next()){
            		Mesa mesa = new Mesa();
	            	mesa.setStatus(rs.getString(1));
	                mesa.setCapacidade(rs.getInt(2));
	                mesa.setCodigo(rs.getInt(3));
	                listmesa.add(mesa);            
            	}    
            
		}catch (Exception e){			
			System.out.println("erro");
			e.printStackTrace();
		}
		
	    return listmesa;  
	}

	
	
	

}
