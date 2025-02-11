/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleestoque1.model;

/**
 *
 * @author thiag
 */
public class Produto {

        private int id;
        private String nome;
        private float quantidade;
        private float preco;
        private String descricao;

        public Produto(int id, String nome, float quantidade, float preco, String descricao) {
            this.id = id;
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
            this.descricao = descricao;
    }

    public Produto() {
        
    }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }

        public float getQuantidade() {
            return quantidade;
        }
        public void setQuantidade(float quantidade) {
            this.quantidade = quantidade;
        }    
 
        public float getPreco() {
            return preco;
        }
        public void setPreco(float preco) {
            this.preco = preco;
        }    

        public String getDescricao() {
            return descricao;
        }
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }  
}
        
        


