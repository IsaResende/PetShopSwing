package janelas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class CadastrarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private static ArrayList<Cliente> clientes = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CadastrarCliente frame = new CadastrarCliente();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public CadastrarCliente() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 250));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 100, 300 };
		gbl.rowHeights = new int[] { 40, 40, 40, 50, 40, 40, 40 };
		contentPane.setLayout(gbl);

		Font fonte = new Font("Segoe UI", Font.PLAIN, 16);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(fonte);
		GridBagConstraints gbcNome = new GridBagConstraints();
		gbcNome.insets = new Insets(5, 5, 5, 5);
		gbcNome.anchor = GridBagConstraints.EAST;
		gbcNome.gridx = 0;
		gbcNome.gridy = 0;
		contentPane.add(lblNome, gbcNome);

		textFieldNome = new JTextField();
		textFieldNome.setFont(fonte);
		GridBagConstraints gbcNomeField = new GridBagConstraints();
		gbcNomeField.insets = new Insets(5, 5, 5, 5);
		gbcNomeField.fill = GridBagConstraints.HORIZONTAL;
		gbcNomeField.gridx = 1;
		gbcNomeField.gridy = 0;
		contentPane.add(textFieldNome, gbcNomeField);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(fonte);
		GridBagConstraints gbcTelefone = new GridBagConstraints();
		gbcTelefone.insets = new Insets(5, 5, 5, 5);
		gbcTelefone.anchor = GridBagConstraints.EAST;
		gbcTelefone.gridx = 0;
		gbcTelefone.gridy = 1;
		contentPane.add(lblTelefone, gbcTelefone);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(fonte);
		GridBagConstraints gbcTelefoneField = new GridBagConstraints();
		gbcTelefoneField.insets = new Insets(5, 5, 5, 5);
		gbcTelefoneField.fill = GridBagConstraints.HORIZONTAL;
		gbcTelefoneField.gridx = 1;
		gbcTelefoneField.gridy = 1;
		contentPane.add(textFieldTelefone, gbcTelefoneField);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(fonte);
		GridBagConstraints gbcEmail = new GridBagConstraints();
		gbcEmail.insets = new Insets(5, 5, 5, 5);
		gbcEmail.anchor = GridBagConstraints.EAST;
		gbcEmail.gridx = 0;
		gbcEmail.gridy = 2;
		contentPane.add(lblEmail, gbcEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(fonte);
		GridBagConstraints gbcEmailField = new GridBagConstraints();
		gbcEmailField.insets = new Insets(5, 5, 5, 5);
		gbcEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbcEmailField.gridx = 1;
		gbcEmailField.gridy = 2;
		contentPane.add(textFieldEmail, gbcEmailField);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(100, 149, 237));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.addActionListener(e -> {
			String nome = textFieldNome.getText();
			String telefone = textFieldTelefone.getText();
			String email = textFieldEmail.getText();
			clientes.add(new Cliente(nome, telefone, email));
			JOptionPane.showMessageDialog(this,
				"Cliente cadastrado com sucesso!\n\nNome: " + nome +
				"\nTelefone: " + telefone +
				"\nEmail: " + email,
				"Confirmação",
				JOptionPane.INFORMATION_MESSAGE);
		});
		GridBagConstraints gbcBotao = new GridBagConstraints();
		gbcBotao.insets = new Insets(15, 5, 5, 5);
		gbcBotao.gridx = 1;
		gbcBotao.gridy = 3;
		gbcBotao.anchor = GridBagConstraints.EAST;
		contentPane.add(btnSalvar, gbcBotao);

		JButton btnListar = new JButton("Listar Clientes");
		btnListar.addActionListener(e -> {
			StringBuilder sb = new StringBuilder();
			for (Cliente c : clientes) {
				sb.append("Nome: ").append(c.nome)
				  .append(", Telefone: ").append(c.telefone)
				  .append(", Email: ").append(c.email).append("\n");
			}
			JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Nenhum cliente cadastrado.", "Clientes", JOptionPane.INFORMATION_MESSAGE);
		});
		gbcBotao.gridy = 4;
		contentPane.add(btnListar, gbcBotao);

		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.addActionListener(e -> {
			String nome = JOptionPane.showInputDialog(this, "Nome do Cliente a excluir:");
			boolean removed = clientes.removeIf(c -> c.nome.equalsIgnoreCase(nome));
			if (removed) {
				JOptionPane.showMessageDialog(this, "Cliente removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		gbcBotao.gridy = 5;
		contentPane.add(btnExcluir, gbcBotao);

		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(e -> {
			String nome = JOptionPane.showInputDialog(this, "Nome do Cliente a buscar:");
			Cliente cliente = clientes.stream().filter(c -> c.nome.equalsIgnoreCase(nome)).findFirst().orElse(null);
			if (cliente != null) {
				JOptionPane.showMessageDialog(this,
					"Cliente encontrado:\n\nNome: " + cliente.nome +
					"\nTelefone: " + cliente.telefone +
					"\nEmail: " + cliente.email,
					"Resultado da Busca",
					JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		gbcBotao.gridy = 6;
		contentPane.add(btnBuscar, gbcBotao);
	}

	static class Cliente {
		String nome, telefone, email;
		Cliente(String nome, String telefone, String email) {
			this.nome = nome;
			this.telefone = telefone;
			this.email = email;
		}
	}
}
