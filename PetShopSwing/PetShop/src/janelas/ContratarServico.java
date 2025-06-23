package janelas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ContratarServico extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboTipoServico;
    private JComboBox<String> comboServico1;
    private JComboBox<String> comboServico2;
    private JTextField txtCliente;
    private JTextField txtPet;
    private JTextField txtData;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ContratarServico frame = new ContratarServico();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ContratarServico() {
        setTitle("Contratar Serviço");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 250));
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[] {150, 300};
        gbl.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 60};
        contentPane.setLayout(gbl);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 16);

        JLabel lblTitulo = new JLabel("Selecionar Tipo de Serviço");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbcTitulo = new GridBagConstraints();
        gbcTitulo.insets = new Insets(5, 5, 15, 5);
        gbcTitulo.gridx = 0;
        gbcTitulo.gridy = 0;
        gbcTitulo.gridwidth = 2;
        gbcTitulo.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(lblTitulo, gbcTitulo);

        JLabel lblTipo = new JLabel("Tipo de Serviço:");
        lblTipo.setFont(labelFont);
        GridBagConstraints gbcLblTipo = new GridBagConstraints();
        gbcLblTipo.insets = new Insets(5, 5, 5, 5);
        gbcLblTipo.anchor = GridBagConstraints.EAST;
        gbcLblTipo.gridx = 0;
        gbcLblTipo.gridy = 1;
        contentPane.add(lblTipo, gbcLblTipo);

        comboTipoServico = new JComboBox<>(new String[] {"Serviço Avulso", "Pacote de Serviços"});
        comboTipoServico.setFont(labelFont);
        GridBagConstraints gbcComboTipo = new GridBagConstraints();
        gbcComboTipo.insets = new Insets(5, 5, 5, 5);
        gbcComboTipo.fill = GridBagConstraints.HORIZONTAL;
        gbcComboTipo.gridx = 1;
        gbcComboTipo.gridy = 1;
        contentPane.add(comboTipoServico, gbcComboTipo);

        JLabel lblServico1 = new JLabel("Serviço 1:");
        lblServico1.setFont(labelFont);
        GridBagConstraints gbcLblServ1 = new GridBagConstraints();
        gbcLblServ1.insets = new Insets(5, 5, 5, 5);
        gbcLblServ1.anchor = GridBagConstraints.EAST;
        gbcLblServ1.gridx = 0;
        gbcLblServ1.gridy = 2;
        contentPane.add(lblServico1, gbcLblServ1);

        comboServico1 = new JComboBox<>(new String[] {
            "Banho e Tosa", "Consulta Veterinária", "Hospedagem", "Adestramento"
        });
        comboServico1.setFont(labelFont);
        GridBagConstraints gbcComboServ1 = new GridBagConstraints();
        gbcComboServ1.insets = new Insets(5, 5, 5, 5);
        gbcComboServ1.fill = GridBagConstraints.HORIZONTAL;
        gbcComboServ1.gridx = 1;
        gbcComboServ1.gridy = 2;
        contentPane.add(comboServico1, gbcComboServ1);

        JLabel lblServico2 = new JLabel("Serviço 2:");
        lblServico2.setFont(labelFont);
        GridBagConstraints gbcLblServ2 = new GridBagConstraints();
        gbcLblServ2.insets = new Insets(5, 5, 5, 5);
        gbcLblServ2.anchor = GridBagConstraints.EAST;
        gbcLblServ2.gridx = 0;
        gbcLblServ2.gridy = 3;
        contentPane.add(lblServico2, gbcLblServ2);

        comboServico2 = new JComboBox<>(new String[] {
            "Banho e Tosa", "Consulta Veterinária", "Hospedagem", "Adestramento"
        });
        comboServico2.setFont(labelFont);
        GridBagConstraints gbcComboServ2 = new GridBagConstraints();
        gbcComboServ2.insets = new Insets(5, 5, 5, 5);
        gbcComboServ2.fill = GridBagConstraints.HORIZONTAL;
        gbcComboServ2.gridx = 1;
        gbcComboServ2.gridy = 3;
        contentPane.add(comboServico2, gbcComboServ2);
        comboServico2.setVisible(false);

        JLabel lblCliente = new JLabel("Nome do Cliente:");
        lblCliente.setFont(labelFont);
        GridBagConstraints gbcLblCliente = new GridBagConstraints();
        gbcLblCliente.insets = new Insets(5, 5, 5, 5);
        gbcLblCliente.anchor = GridBagConstraints.EAST;
        gbcLblCliente.gridx = 0;
        gbcLblCliente.gridy = 4;
        contentPane.add(lblCliente, gbcLblCliente);

        txtCliente = new JTextField();
        txtCliente.setFont(labelFont);
        GridBagConstraints gbcTxtCliente = new GridBagConstraints();
        gbcTxtCliente.insets = new Insets(5, 5, 5, 5);
        gbcTxtCliente.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtCliente.gridx = 1;
        gbcTxtCliente.gridy = 4;
        contentPane.add(txtCliente, gbcTxtCliente);

        JLabel lblPet = new JLabel("Nome do Pet:");
        lblPet.setFont(labelFont);
        GridBagConstraints gbcLblPet = new GridBagConstraints();
        gbcLblPet.insets = new Insets(5, 5, 5, 5);
        gbcLblPet.anchor = GridBagConstraints.EAST;
        gbcLblPet.gridx = 0;
        gbcLblPet.gridy = 5;
        contentPane.add(lblPet, gbcLblPet);

        txtPet = new JTextField();
        txtPet.setFont(labelFont);
        GridBagConstraints gbcTxtPet = new GridBagConstraints();
        gbcTxtPet.insets = new Insets(5, 5, 5, 5);
        gbcTxtPet.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtPet.gridx = 1;
        gbcTxtPet.gridy = 5;
        contentPane.add(txtPet, gbcTxtPet);

        // Novo campo: Data do Serviço
        JLabel lblData = new JLabel("Data do Serviço (dd/MM/yyyy):");
        lblData.setFont(labelFont);
        GridBagConstraints gbcLblData = new GridBagConstraints();
        gbcLblData.insets = new Insets(5, 5, 5, 5);
        gbcLblData.anchor = GridBagConstraints.EAST;
        gbcLblData.gridx = 0;
        gbcLblData.gridy = 6;
        contentPane.add(lblData, gbcLblData);

        txtData = new JTextField();
        txtData.setFont(labelFont);
        GridBagConstraints gbcTxtData = new GridBagConstraints();
        gbcTxtData.insets = new Insets(5, 5, 5, 5);
        gbcTxtData.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtData.gridx = 1;
        gbcTxtData.gridy = 6;
        contentPane.add(txtData, gbcTxtData);

        JButton btnConfirmar = new JButton("Confirmar Serviço");
        btnConfirmar.setBackground(new Color(100, 149, 237));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(buttonFont);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirmar.addActionListener(this::confirmarServico);

        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(15, 5, 5, 5);
        gbcBtn.gridx = 1;
        gbcBtn.gridy = 7;
        gbcBtn.anchor = GridBagConstraints.EAST;
        contentPane.add(btnConfirmar, gbcBtn);

        comboTipoServico.addActionListener(e -> {
            String tipo = (String) comboTipoServico.getSelectedItem();
            boolean isPacote = "Pacote de Serviços".equals(tipo);
            comboServico2.setVisible(isPacote);
            contentPane.revalidate();
            contentPane.repaint();
        });
    }

    private void confirmarServico(ActionEvent e) {
        String tipo = (String) comboTipoServico.getSelectedItem();
        String servico1 = (String) comboServico1.getSelectedItem();
        String servico2 = comboServico2.isVisible() ? (String) comboServico2.getSelectedItem() : "";
        String cliente = txtCliente.getText().trim();
        String pet = txtPet.getText().trim();
        String dataStr = txtData.getText().trim();

        if (cliente.isEmpty() || pet.isEmpty() || dataStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date data = sdf.parse(dataStr);
            Date hoje = new Date();
            if (!data.after(hoje)) {
                JOptionPane.showMessageDialog(this, "A data deve ser futura.",
                        "Data Inválida", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/MM/yyyy.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String mensagem = String.format(
            "Tipo: %s\nServiço 1: %s%s\nCliente: %s\nPet: %s\nData: %s",
            tipo, servico1,
            !servico2.isEmpty() ? "\nServiço 2: " + servico2 : "",
            cliente, pet, dataStr
        );

        JOptionPane.showMessageDialog(this, mensagem, "Serviço Contratado", JOptionPane.INFORMATION_MESSAGE);
    }
}