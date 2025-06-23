package janelas;

import javax.swing.*;
import java.awt.*;

public class ListarServicos extends JFrame {

    private static final long serialVersionUID = 1L;

    public ListarServicos() {
        setTitle("Lista de Serviços");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] colunas = { "ID", "Serviço", "Preço" };
        Object[][] dados = {
            { 1, "Banho", "R$ 40,00" },
            { 2, "Tosa", "R$ 50,00" },
            { 3, "Consulta Veterinária", "R$ 100,00" },
            { 4, "Hospedagem", "R$ 70,00 por dia" },
            { 5, "Adestramento", "R$ 120,00 por aula" },
            { 6, "Pacote Banho + Tosa", "R$ 85,00" },
            { 7, "Pacote Completo (Banho, Tosa e Consulta)", "R$ 180,00" }
        };

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);
    }
}
