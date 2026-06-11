package view;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {

    private JTextField txtEmail;
    private JPasswordField txtSenha;

    public LoginView() {

        setTitle("Mini Uber - Login");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 1));

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField();

        JButton btnEntrar = new JButton("Entrar");
        JButton btnCadastrar = new JButton("Cadastrar");


        add(lblEmail);
        add(txtEmail);
        add(lblSenha);
        add(txtSenha);
        add(btnEntrar);
        add(btnCadastrar);

        btnEntrar.addActionListener(e -> fazerLogin());
        btnCadastrar.addActionListener(e -> {
            new CadastroView();
        });

        setVisible(true);
    }

    private void fazerLogin() {

        String email = txtEmail.getText();

        String senha =
                new String(txtSenha.getPassword());

        UsuarioDAO dao = new UsuarioDAO();

        Usuario usuario =
                dao.login(email, senha);

        if (usuario != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Bem-vinda, " +
                            usuario.getNome()
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Email ou senha inválidos!"
            );
        }
    }
}