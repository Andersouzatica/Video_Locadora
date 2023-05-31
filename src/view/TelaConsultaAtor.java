package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TelaConsultaAtor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTable tbPesquisaAtor;
	private TelaCadastroAtor telaCadastroAtor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaAtor frame = new TelaConsultaAtor();
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

	public TelaConsultaAtor(TelaCadastroAtor telaCadastroAtor) {
		this.telaCadastroAtor = telaCadastroAtor;
//		setContentPane(contentPane);
	}

	public TelaConsultaAtor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Consulta Ator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Anderson\\Pictures\\App-clean-icon.png"));

		JLabel lblNewLabel_1 = new JLabel("Nome do Filme:");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		JButton btnPesquisa = new JButton("");
		btnPesquisa.setIcon(new ImageIcon("C:\\Users\\Anderson\\Downloads\\lupa.png"));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(150).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnPesquisa, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(panel,
								GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(28, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addContainerGap().addComponent(lblNewLabel).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addContainerGap(68, Short.MAX_VALUE)
										.addComponent(btnPesquisa).addPreferredGap(ComponentPlacement.RELATED)))
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(23, Short.MAX_VALUE)));
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 446, 281);
		panel.add(scrollPane);

		tbPesquisaAtor = new JTable();
		tbPesquisaAtor.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Nacionalidade" }));
		tbPesquisaAtor.getColumnModel().getColumn(0).setPreferredWidth(56);
		tbPesquisaAtor.getColumnModel().getColumn(1).setPreferredWidth(249);
		tbPesquisaAtor.getColumnModel().getColumn(2).setPreferredWidth(153);
		scrollPane.setViewportView(tbPesquisaAtor);
		contentPane.setLayout(gl_contentPane);
	}
}
