/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque1.repository;

import controleestoque1.model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
/**
 *
 * @author Professor
 */
public class ConexaoMySQL {
    private Conexao conexao = null;
    public static Connection connection = null;
    
    public ConexaoMySQL(Conexao conexao){
        this.conexao = conexao;
    }
    
    public boolean conectar(){
        if(conexao != null){
            try{
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                             ":" + conexao.getPorta() +
                             "/" + conexao.getNomeBanco();
                
                //pegar a classe da Librarie q adicionamos:
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );
                return true;                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar no banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                ); 
                return false;
            } //catch
        }else{
            return false;
        }
    }
    
    
}
