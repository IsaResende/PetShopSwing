package janelas;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;

public class Excluir extends JFrame {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Excluir frame = new Excluir();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Excluir() {
        setTitle("Sistema de Exclusão e Cancelamento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 350);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuOpcoes = new JMenu("Opções");
        menuBar.add(menuOpcoes);

        JMenuItem excluirClienteItem = new JMenuItem("Excluir Cliente");
        JMenuItem excluirPetItem = new JMenuItem("Excluir Pet");
        JMenuItem cancelarItem = new JMenuItem("Cancelar Serviço");

        menuOpcoes.add(excluirClienteItem);
        menuOpcoes.add(excluirPetItem);
        menuOpcoes.add(cancelarItem);

        excluirClienteItem.addActionListener(e -> abrirDialogExcluirCliente());
        excluirPetItem.addActionListener(e -> abrirDialogExcluirPet());
        cancelarItem.addActionListener(e -> abrirDialogCancelarServico());
    }

    private void abrirDialogExcluirCliente() {
        JDialog dialog = criarDialog("Excluir Cliente", 400, 220);

        JLabel lblCliente = new JLabel("Nome do Cliente:");
        JTextField txtCliente = new JTextField(20);

        adicionarComponente(dialog, lblCliente, 0, 0);
        adicionarComponente(dialog, txtCliente, 1, 0);

        JButton btnExcluir = new JButton("Excluir");
        JButton btnCancelar = new JButton("Cancelar");

        adicionarComponente(dialog, btnExcluir, 0, 1);
        adicionarComponente(dialog, btnCancelar, 1, 1);

        btnExcluir.addActionListener(ev -> {
            String cliente = txtCliente.getText().trim();

            if (cliente.isEmpty()) {
                mostrarErro(dialog, "O nome do cliente é obrigatório.");
                return;
            }

            if (confirmar(dialog, "Confirma exclusão do cliente: " + cliente + "?")) {
                JOptionPane.showMessageDialog(dialog, "Cliente '" + cliente + "' excluído com sucesso!");
                dialog.dispose();
            }
        });

        btnCancelar.addActionListener(ev -> dialog.dispose());
        dialog.setVisible(true);
    }

    private void abrirDialogExcluirPet() {
        JDialog dialog = criarDialog("Excluir Pet", 400, 260);

        JLabel lblCliente = new JLabel("Nome do Cliente:");
        JTextField txtCliente = new JTextField(20);
        JLabel lblPet = new JLabel("Nome do Pet:");
        JTextField txtPet = new JTextField(20);

        adicionarComponente(dialog, lblCliente, 0, 0);
        adicionarComponente(dialog, txtCliente, 1, 0);
        adicionarComponente(dialog, lblPet, 0, 1);
        adicionarComponente(dialog, txtPet, 1, 1);

        JButton btnExcluir = new JButton("Excluir");
        JButton btnCancelar = new JButton("Cancelar");

        adicionarComponente(dialog, btnExcluir, 0, 2);
        adicionarComponente(dialog, btnCancelar, 1, 2);

        btnExcluir.addActionListener(ev -> {
            String cliente = txtCliente.getText().trim();
            String pet = txtPet.getText().trim();

            if (cliente.isEmpty() || pet.isEmpty()) {
                mostrarErro(dialog, "Preencha o nome do cliente e do pet.");
                return;
            }

            if (confirmar(dialog, "Confirma exclusão do pet: " + pet + "\nCliente: " + cliente + "?")) {
                JOptionPane.showMessageDialog(dialog,
                        "Pet '" + pet + "' do cliente '" + cliente + "' excluído com sucesso!");
                dialog.dispose();
            }
        });

        btnCancelar.addActionListener(ev -> dialog.dispose());
        dialog.setVisible(true);
    }

    private void abrirDialogCancelarServico() {
        JDialog dialog = criarDialog("Cancelar Serviço", 450, 280);

        JLabel lblCliente = new JLabel("Nome do Cliente:");
        JTextField txtCliente = new JTextField(20);

        JLabel lblPet = new JLabel("Nome do Pet:");
        JTextField txtPet = new JTextField(20);

        JLabel lblServico = new JLabel("Selecione o Serviço:");
        JComboBox<String> comboServico = new JComboBox<>(new String[]{
                "Banho e Tosa",
                "Consulta Veterinária",
                "Hospedagem",
                "Adestramento"
        });
        comboServico.setSelectedIndex(-1);

        adicionarComponente(dialog, lblCliente, 0, 0);
        adicionarComponente(dialog, txtCliente, 1, 0);
        adicionarComponente(dialog, lblPet, 0, 1);
        adicionarComponente(dialog, txtPet, 1, 1);
        adicionarComponente(dialog, lblServico, 0, 2);
        adicionarComponente(dialog, comboServico, 1, 2);

        JButton btnCancelarServico = new JButton("Cancelar Serviço");
        JButton btnFechar = new JButton("Fechar");

        adicionarComponente(dialog, btnCancelarServico, 0, 3);
        adicionarComponente(dialog, btnFechar, 1, 3);

        btnCancelarServico.addActionListener(ev -> {
            String cliente = txtCliente.getText().trim();
            String pet = txtPet.getText().trim();
            String servico = (String) comboServico.getSelectedItem();

            if (cliente.isEmpty() || pet.isEmpty() || servico == null) {
                mostrarErro(dialog, "Preencha o nome do cliente, do pet e selecione um serviço.");
                return;
            }

            if (confirmar(dialog, "Cancelar serviço: " + servico +
                    "\nCliente: " + cliente + "\nPet: " + pet + "?")) {
                JOptionPane.showMessageDialog(dialog,
                        "Serviço '" + servico + "' cancelado com sucesso para " + pet + " de " + cliente + "!");
                dialog.dispose();
            }
        });

        btnFechar.addActionListener(ev -> dialog.dispose());
        dialog.setVisible(true);
    }

    // 🔧 Utilitários para reutilização
    private JDialog criarDialog(String titulo, int largura, int altura) {
        JDialog dialog = new JDialog(this, titulo, true);
        dialog.setSize(largura, altura);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridBagLayout());
        return dialog;
    }

    private void adicionarComponente(JDialog dialog, Component comp, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dialog.add(comp, gbc);
    }

    private boolean confirmar(Component parent, String mensagem) {
        int confirm = JOptionPane.showConfirmDialog(parent, mensagem, "Confirmar", JOptionPane.YES_NO_OPTION);
        return confirm == JOptionPane.YES_OPTION;
    }

    private void mostrarErro(Component parent, String mensagem) {
        JOptionPane.showMessageDialog(parent, mensagem, "Erro", JOptionPane.WARNING_MESSAGE);
    }

    // Validação de telefone
    private boolean validarTelefone(String telefone) {
        return telefone.matches("\\d{10,11}");
    }

    // Validação de e-mail
    private boolean validarEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w-.]+@[\\w-]+(\\.[\\w-]+)+$");
        return pattern.matcher(email).matches();
    }
}
