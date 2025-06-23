package janelas;

import javax.swing.*;
import java.awt.*;

public class ListarPets extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarPets() {
        setTitle("Lista de Pets");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] colunas = { "ID", "Nome", "Espécie", "Dono" };
        Object[][] dados = {
            { 1, "Rex", "Cachorro", "João da Silva" },
            { 2, "Mimi", "Gato", "Maria Souza" }
        };

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);
    }
}
