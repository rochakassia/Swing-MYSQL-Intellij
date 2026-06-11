package uberapp;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        Connection con = ConexaoBD.conectar();

        if(con != null){

            System.out.println("Conectado com sucesso!");

        } else {

            System.out.println("Erro na conexão!");

        }
    }
}