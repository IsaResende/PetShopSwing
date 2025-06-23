package janelas;

import javax.swing.*;
import java.awt.*;

public class BuscarPet extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscarPet() {
        setTitle("Buscar Pet");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JTextField campoBusca = new JTextField();
        JButton botaoBuscar = new JButton("Buscar");

        botaoBuscar.addActionListener(e -> {
            String nome = campoBusca.getText();
            // Aqui você colocaria a lógica real de busca
            JOptionPane.showMessageDialog(this, "Pet buscado: " + nome);
        });

        panel.add(new JLabel("Digite o nome do pet:"), BorderLayout.NORTH);
        panel.add(campoBusca, BorderLayout.CENTER);
        panel.add(botaoBuscar, BorderLayout.SOUTH);
        add(panel);
    }
}
