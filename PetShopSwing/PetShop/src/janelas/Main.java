package janelas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Importações das janelas adicionais
import janelas.CadastrarCliente;
import janelas.CadastrarPet;
import janelas.ContratarServico;
import janelas.Excluir;
import janelas.ListarServicos;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panelConteudo;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) { }

        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        setTitle("Sistema de Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 480);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(700, 450));

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(33, 150, 243));
        panelMenu.setPreferredSize(new Dimension(200, getHeight()));
        panelMenu.setLayout(new GridBagLayout());
        panelMenu.setBorder(new EmptyBorder(20, 10, 20, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weightx = 1;

        Font fonteTitulo = new Font("Segoe UI", Font.BOLD, 16);
        Font fonteItem = new Font("Segoe UI", Font.PLAIN, 14);

        // Título
        JLabel lblTitulo = new JLabel("Menu Principal");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(fonteTitulo);
        gbc.gridy = 0;
        panelMenu.add(lblTitulo, gbc);

        // --- Menu: Cadastrar
        JLabel lblCadastrar = criarTituloSeccao("Cadastrar");
        gbc.gridy++;
        panelMenu.add(lblCadastrar, gbc);

        JButton btnCadastrarCliente = criarBotaoMenu("Cliente");
        btnCadastrarCliente.addActionListener(e -> abrirJanela(new CadastrarCliente()));
        gbc.gridy++;
        panelMenu.add(btnCadastrarCliente, gbc);

        JButton btnCadastrarPet = criarBotaoMenu("Pet");
        btnCadastrarPet.addActionListener(e -> abrirJanela(new CadastrarPet()));
        gbc.gridy++;
        panelMenu.add(btnCadastrarPet, gbc);

        // --- Menu: Listar
        JLabel lblListar = criarTituloSeccao("Listar");
        gbc.gridy++;
        panelMenu.add(lblListar, gbc);

        JButton btnListarServicos = criarBotaoMenu("Listar Serviços");
        btnListarServicos.addActionListener(e -> abrirJanela(new ListarServicos()));
        gbc.gridy++;
        panelMenu.add(btnListarServicos, gbc);

        // --- Menu: Serviços
        JLabel lblServicos = criarTituloSeccao("Serviços");
        gbc.gridy++;
        panelMenu.add(lblServicos, gbc);

        JButton btnContratar = criarBotaoMenu("Contratar Serviço");
        btnContratar.addActionListener(e -> abrirJanela(new ContratarServico()));
        gbc.gridy++;
        panelMenu.add(btnContratar, gbc);

        // --- Menu: Outros
        JLabel lblOutros = criarTituloSeccao("Outros");
        gbc.gridy++;
        panelMenu.add(lblOutros, gbc);

        JButton btnExcluir = criarBotaoMenu("Excluir");
        btnExcluir.setForeground(new Color(244, 67, 54));
        btnExcluir.addActionListener(e -> abrirJanela(new Excluir()));
        gbc.gridy++;
        panelMenu.add(btnExcluir, gbc);

        contentPane.add(panelMenu, BorderLayout.WEST);

        // Painel principal
        panelConteudo = new JPanel();
        panelConteudo.setBackground(Color.WHITE);
        panelConteudo.setLayout(new BorderLayout());
        panelConteudo.setBorder(new EmptyBorder(40, 40, 40, 40));

        JLabel lblBoasVindas = new JLabel("Bem-vindo ao Sistema Administrador");
        lblBoasVindas.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblBoasVindas.setForeground(new Color(33, 150, 243));
        lblBoasVindas.setHorizontalAlignment(SwingConstants.CENTER);
        panelConteudo.add(lblBoasVindas, BorderLayout.NORTH);

        ImageIcon imagem = new ImageIcon("C:\\Users\\Isadora\\Documents\\ProjetoJava\\SistemaParaPetShop-Java\\src\\janelas\\pets123.jpg");
        Image img = imagem.getImage().getScaledInstance(800, 550, Image.SCALE_SMOOTH);
        JLabel lblImagem = new JLabel(new ImageIcon(img));
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        panelConteudo.add(lblImagem, BorderLayout.CENTER);

        contentPane.add(panelConteudo, BorderLayout.CENTER);
    }

    private JButton criarBotaoMenu(String texto) {
        JButton botao = new JButton(texto);
        botao.setFocusPainted(false);
        botao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(33, 150, 243));
        botao.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 10));
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setHorizontalAlignment(SwingConstants.LEFT);
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(30, 136, 229));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                botao.setBackground(new Color(33, 150, 243));
            }
        });
        return botao;
    }

    private JLabel criarTituloSeccao(String texto) {
        JLabel label = new JLabel(texto.toUpperCase());
        label.setForeground(new Color(200, 230, 255));
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setBorder(new EmptyBorder(5, 5, 5, 5));
        return label;
    }

    private void abrirJanela(JFrame janela) {
        janela.setLocationRelativeTo(this);
        janela.setVisible(true);
    }
}