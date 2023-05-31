package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Filme extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filme frame = new Filme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Filme() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Cadastro de Filme");
		setBounds(100, 100, 800, 600);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_1_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JButton btnNewButton = new JButton("Novo");
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));

		JButton btnNewButton_1 = new JButton("Aterar");

		JButton btnNewButton_1_1 = new JButton("Salvar");

		JButton btnExcluir = new JButton("Excluir");

		JButton btnNewButton_1_1_1 = new JButton("Fechar");

		JButton btnNewButton_2_1 = new JButton("Cancelar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(54)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(164)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_2_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_1_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(32))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1_1_1)
						.addComponent(btnNewButton_2_1)
						.addComponent(btnNewButton_1_1)
						.addComponent(btnExcluir)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(13))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
