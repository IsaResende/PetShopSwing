package janelas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

public class CadastrarPet extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCliente;
    private JTextField textFieldNome;
    private JTextField textFieldEspecie;
    private JTextField textFieldRaca;
    private JTextField textFieldIdade;
    private JTextField textFieldPeso;
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastrarPet frame = new CadastrarPet();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CadastrarPet() {
        setTitle("Cadastro de Pet");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 250));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[] { 100, 300 };
        gbl.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 50, 40, 40 };
        contentPane.setLayout(gbl);

        Font fonte = new Font("Segoe UI", Font.PLAIN, 16);

        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(fonte);
        GridBagConstraints gbcCliente = new GridBagConstraints();
        gbcCliente.insets = new Insets(5, 5, 5, 5);
        gbcCliente.anchor = GridBagConstraints.EAST;
        gbcCliente.gridx = 0;
        gbcCliente.gridy = 0;
        contentPane.add(lblCliente, gbcCliente);

        textFieldCliente = new JTextField();
        textFieldCliente.setFont(fonte);
        GridBagConstraints gbcClienteField = new GridBagConstraints();
        gbcClienteField.insets = new Insets(5, 5, 5, 5);
        gbcClienteField.fill = GridBagConstraints.HORIZONTAL;
        gbcClienteField.gridx = 1;
        gbcClienteField.gridy = 0;
        contentPane.add(textFieldCliente, gbcClienteField);

        JLabel lblNome = new JLabel("Nome Pet:");
        lblNome.setFont(fonte);
        GridBagConstraints gbcNome = new GridBagConstraints();
        gbcNome.insets = new Insets(5, 5, 5, 5);
        gbcNome.anchor = GridBagConstraints.EAST;
        gbcNome.gridx = 0;
        gbcNome.gridy = 1;
        contentPane.add(lblNome, gbcNome);

        textFieldNome = new JTextField();
        textFieldNome.setFont(fonte);
        GridBagConstraints gbcNomeField = new GridBagConstraints();
        gbcNomeField.insets = new Insets(5, 5, 5, 5);
        gbcNomeField.fill = GridBagConstraints.HORIZONTAL;
        gbcNomeField.gridx = 1;
        gbcNomeField.gridy = 1;
        contentPane.add(textFieldNome, gbcNomeField);

        JLabel lblEspecie = new JLabel("Espécie:");
        lblEspecie.setFont(fonte);
        GridBagConstraints gbcEspecie = new GridBagConstraints();
        gbcEspecie.insets = new Insets(5, 5, 5, 5);
        gbcEspecie.anchor = GridBagConstraints.EAST;
        gbcEspecie.gridx = 0;
        gbcEspecie.gridy = 2;
        contentPane.add(lblEspecie, gbcEspecie);

        textFieldEspecie = new JTextField();
        textFieldEspecie.setFont(fonte);
        GridBagConstraints gbcEspecieField = new GridBagConstraints();
        gbcEspecieField.insets = new Insets(5, 5, 5, 5);
        gbcEspecieField.fill = GridBagConstraints.HORIZONTAL;
        gbcEspecieField.gridx = 1;
        gbcEspecieField.gridy = 2;
        contentPane.add(textFieldEspecie, gbcEspecieField);

        JLabel lblRaca = new JLabel("Raça:");
        lblRaca.setFont(fonte);
        GridBagConstraints gbcRaca = new GridBagConstraints();
        gbcRaca.insets = new Insets(5, 5, 5, 5);
        gbcRaca.anchor = GridBagConstraints.EAST;
        gbcRaca.gridx = 0;
        gbcRaca.gridy = 3;
        contentPane.add(lblRaca, gbcRaca);

        textFieldRaca = new JTextField();
        textFieldRaca.setFont(fonte);
        GridBagConstraints gbcRacaField = new GridBagConstraints();
        gbcRacaField.insets = new Insets(5, 5, 5, 5);
        gbcRacaField.fill = GridBagConstraints.HORIZONTAL;
        gbcRacaField.gridx = 1;
        gbcRacaField.gridy = 3;
        contentPane.add(textFieldRaca, gbcRacaField);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(fonte);
        GridBagConstraints gbcIdade = new GridBagConstraints();
        gbcIdade.insets = new Insets(5, 5, 5, 5);
        gbcIdade.anchor = GridBagConstraints.EAST;
        gbcIdade.gridx = 0;
        gbcIdade.gridy = 4;
        contentPane.add(lblIdade, gbcIdade);

        textFieldIdade = new JTextField();
        textFieldIdade.setFont(fonte);
        GridBagConstraints gbcIdadeField = new GridBagConstraints();
        gbcIdadeField.insets = new Insets(5, 5, 5, 5);
        gbcIdadeField.fill = GridBagConstraints.HORIZONTAL;
        gbcIdadeField.gridx = 1;
        gbcIdadeField.gridy = 4;
        contentPane.add(textFieldIdade, gbcIdadeField);

        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setFont(fonte);
        GridBagConstraints gbcPeso = new GridBagConstraints();
        gbcPeso.insets = new Insets(5, 5, 5, 5);
        gbcPeso.anchor = GridBagConstraints.EAST;
        gbcPeso.gridx = 0;
        gbcPeso.gridy = 5;
        contentPane.add(lblPeso, gbcPeso);

        textFieldPeso = new JTextField();
        textFieldPeso.setFont(fonte);
        GridBagConstraints gbcPesoField = new GridBagConstraints();
        gbcPesoField.insets = new Insets(5, 5, 5, 5);
        gbcPesoField.fill = GridBagConstraints.HORIZONTAL;
        gbcPesoField.gridx = 1;
        gbcPesoField.gridy = 5;
        contentPane.add(textFieldPeso, gbcPesoField);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBackground(new Color(100, 149, 237));
        btnSalvar.setForeground(Color.WHITE);
        btnSalvar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnSalvar.setFocusPainted(false);
        btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(e -> {
            String nomeCliente = textFieldCliente.getText();
            String nome = textFieldNome.getText();
            String especie = textFieldEspecie.getText();
            String raca = textFieldRaca.getText();
            String idadeStr = textFieldIdade.getText();
            String pesoStr = textFieldPeso.getText();

            int idade;
            double peso;
            try {
                idade = Integer.parseInt(idadeStr);
                peso = Double.parseDouble(pesoStr);
                if (idade <= 0 || idade > 50 || peso <= 0 || peso > 200) {
                    JOptionPane.showMessageDialog(this, "Idade deve estar entre 1 e 50 anos e peso maior que 0 e até 200 kg.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade e peso devem ser valores numéricos válidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente cliente = clientes.stream().filter(c -> c.nome.equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);
            if (cliente == null) {
                cliente = new Cliente(nomeCliente);
                clientes.add(cliente);
            }
            cliente.pets.add(new Pet(nome, especie, raca, idade + " anos", peso + " kg"));

            JOptionPane.showMessageDialog(this, "Pet cadastrado para o cliente " + nomeCliente + " com sucesso!", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        });

        GridBagConstraints gbcBotao = new GridBagConstraints();
        gbcBotao.insets = new Insets(15, 5, 5, 5);
        gbcBotao.gridx = 1;
        gbcBotao.gridy = 6;
        gbcBotao.anchor = GridBagConstraints.EAST;
        contentPane.add(btnSalvar, gbcBotao);

        JButton btnListar = new JButton("Listar Clientes e Pets");
        btnListar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Cliente c : clientes) {
                sb.append("Cliente: ").append(c.nome).append("\n");
                for (Pet p : c.pets) {
                    sb.append(" - ").append(p).append("\n");
                }
                sb.append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Nenhum cliente cadastrado.", "Clientes e Pets", JOptionPane.INFORMATION_MESSAGE);
        });
        gbcBotao.gridy = 7;
        contentPane.add(btnListar, gbcBotao);

        JButton btnExcluirPet = new JButton("Excluir Pet");
        btnExcluirPet.addActionListener(e -> {
            String nomeCliente = JOptionPane.showInputDialog(this, "Nome do Cliente:");
            String nomePet = JOptionPane.showInputDialog(this, "Nome do Pet a excluir:");

            Cliente cliente = clientes.stream().filter(c -> c.nome.equalsIgnoreCase(nomeCliente)).findFirst().orElse(null);
            if (cliente != null) {
                boolean removed = cliente.pets.removeIf(p -> p.nome.equalsIgnoreCase(nomePet));
                if (removed) {
                    JOptionPane.showMessageDialog(this, "Pet removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Pet não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        gbcBotao.gridy = 8;
        contentPane.add(btnExcluirPet, gbcBotao);
    }

    static class Cliente {
        String nome;
        ArrayList<Pet> pets = new ArrayList<>();
        Cliente(String nome) {
            this.nome = nome;
        }
    }

    static class Pet {
        String nome, especie, raca, idade, peso;
        Pet(String nome, String especie, String raca, String idade, String peso) {
            this.nome = nome;
            this.especie = especie;
            this.raca = raca;
            this.idade = idade;
            this.peso = peso;
        }
        public String toString() {
            return "Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca + ", Idade: " + idade + ", Peso: " + peso;
        }
    }
}