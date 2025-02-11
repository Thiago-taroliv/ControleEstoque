/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque1.repository;

import java.sql.ResultSet;
import controleestoque1.model.Produto;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thiag
 */
public class ProdutoRepository {
    
    public boolean inserir(Connection connection, Produto produto) {
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO produtos(nome, quantidade, preco, descricao) " +
                             "VALUES(?, ?, ?, ?)"; 
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getQuantidade());
            stmt.setFloat(3, produto.getPreco());
            stmt.setString(4, produto.getDescricao());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir produto: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        //return false;
    }
    
    public boolean atualizar(Connection connection, Produto produto) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE produtos SET " +
                             "nome = ?, quantidade = ?, preco = ?, descricao = ? " +
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getQuantidade());
            stmt.setFloat(3, produto.getPreco());
            stmt.setString(4, produto.getDescricao());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar pessoa: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    public boolean deletar(Connection connection, Produto produto) {
            
        PreparedStatement stmt = null;
        
        try{
            String comando = "DELETE FROM produtos " + 
                             "WHERE id = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, produto.getId());

            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir produto: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        
       
    }
        
    public Produto selecionar(Connection connection, String operador, int id) {
        try{
            Produto produto = new Produto();
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM produtos WHERE id " +
                             operador + "? ";
            if(operador.equals("<"))
                comando += " ORDER BY id DESC";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res != null){
                while(res.next()){
                    produto.setId(Integer.parseInt(res.getString("id")));
                    produto.setNome(res.getString("nome"));
                    produto.setDescricao(res.getString("descricao"));
                    produto.setPreco(Float.parseFloat(res.getString("preco")));
                    produto.setQuantidade(Float.parseFloat(res.getString("quantidade")));
                    break;

                }
            }
            return produto;
        }catch(Exception ex){
            return null;
        }
    }
    
    public List<Produto> selecionarTodos(Connection connection, int id){
        
        try{
            List<Produto> produtos = new ArrayList<>();
            PreparedStatement stmt = null;

            String comando = "SELECT * FROM produtos";

            stmt = connection.prepareStatement(comando);
            ResultSet res = stmt.executeQuery();

            while(res.next()){
                Produto produto = new Produto();
                produto.setId(res.getInt("id"));
                produto.setId(Integer.parseInt(res.getString("id")));
                produto.setNome(res.getString("nome"));
                produto.setDescricao(res.getString("descricao"));
                produto.setPreco(res.getFloat("preco"));
                produto.setQuantidade(res.getFloat("quantidade"));

                produtos.add(produto);
            }
            return produtos;

        }catch(Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }
}

