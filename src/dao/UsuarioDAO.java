package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Usuario;
import connection.ConnectionFactory;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {

        String sql =
                "INSERT INTO usuarios " +
                        "(nome,email,senha,telefone,tipo) " +
                        "VALUES (?,?,?,?,?)";

        try (
                Connection conn =
                        ConnectionFactory.getConnection();

                PreparedStatement stmt =
                        conn.prepareStatement(sql)
        ) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getTipo());

            stmt.execute();

            System.out.println("Usuário salvo!");

        } catch (Exception e) {

            System.out.println(
                    "Erro ao salvar: " + e.getMessage()
            );
        }
    }

    public Usuario login(String email, String senha) {

        String sql =
                "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setTipo(rs.getString("tipo"));

                return usuario;
            }

        } catch (Exception e) {

            System.out.println("Erro no login: " + e.getMessage());
        }

        return null;
    }
}