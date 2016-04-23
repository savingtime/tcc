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
	
	
	public void cadastrarMesa(Mesa mesa) throws SQLException {	
		AcessoBD bd = new AcessoBD();
		Connection conn = bd.obtemConexao();	
		String sqlSelect = "insert into mesas(capacidade, status) values (?,?);";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
				for(int i=0; i < mesa.getQuantidade(); i++){
					stm.setInt(1, mesa.getCapacidade());
					stm.setInt(2, mesa.getStatus());
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
		String sqlSelect = "update mesas set capacidade=?, status=? where id=?);";

		try{
			PreparedStatement stm = conn.prepareStatement(sqlSelect);	
				stm.setInt(1, mesa.getCapacidade());
				stm.setInt(2, mesa.getStatus());
				stm.setInt(3, mesa.getCodigo());
				stm.executeUpdate();
				stm.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public List<Mesa> consultarMesa(Mesa mesa) throws SQLException {
			AcessoBD bd = new AcessoBD();	
			Connection conn = bd.obtemConexao();
	         
	        String sqlSelect = "select * from mesas";
	        ResultSet rs = null;
	        List<Mesa> listmesa = new ArrayList<Mesa>();
	        try{
	        	PreparedStatement stm = conn.prepareStatement(sqlSelect);
	            rs = stm.executeQuery();
	         
	            if(!rs.next()){
	 
	              //tratar caso não tenha mesas cadastradas. 
	            }else{
	            	while(rs.next()){
	            	
		            	mesa.setStatus(rs.getInt(1));
		                mesa.setCapacidade(rs.getInt(2));
		                mesa.setCodigo(rs.getInt(3));
		                listmesa.add(mesa);
		                
	            	}    
	            }
		}catch (Exception e){			
			System.out.println("erro");
		}
		
	    return listmesa;  
	}
	
	
	
	
	
	

}
