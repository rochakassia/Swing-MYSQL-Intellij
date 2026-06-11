package view;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class CadastroView extends JFrame {

    private JTextField txtNome;
    private JTextField txtEmail;
    private JPasswordField txtSenha;
    private JTextField txtTelefone;
    private JComboBox<String> cbTipo;

    public CadastroView() {

        setTitle("Cadastro de Usuário");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 2));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        add(txtTelefone);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>();
        cbTipo.addItem("PASSAGEIRO");
        cbTipo.addItem("MOTORISTA");
        add(cbTipo);

        JButton btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        btnSalvar.addActionListener(e -> cadastrar());

        setVisible(true);
    }

    private void cadastrar() {

        String nome = txtNome.getText();
        String email = txtEmail.getText();
        String senha = new String(txtSenha.getPassword());
        String telefone = txtTelefone.getText();
        String tipo = cbTipo.getSelectedItem().toString();

        Usuario usuario = new Usuario(
                nome,
                email,
                senha,
                telefone,
                tipo
        );

        UsuarioDAO dao = new UsuarioDAO();
        dao.salvar(usuario);

        JOptionPane.showMessageDialog(
                this,
                "Usuário cadastrado com sucesso!"
        );

        dispose();
    }
}