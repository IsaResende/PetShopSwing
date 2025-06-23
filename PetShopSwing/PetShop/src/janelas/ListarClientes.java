package janelas;

import javax.swing.*;
import java.awt.*;

public class ListarClientes extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarClientes() {
        setTitle("Lista de Clientes");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] colunas = { "ID", "Nome", "Telefone" };
        Object[][] dados = {
            { 1, "João da Silva", "(11) 99999-1111" },
            { 2, "Maria Souza", "(21) 98888-2222" }
        };

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);
    }
}
