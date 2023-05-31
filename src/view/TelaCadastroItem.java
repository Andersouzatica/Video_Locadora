package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastroItem extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroItem frame = new TelaCadastroItem();
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
	public TelaCadastroItem() {
		setTitle("Cadastro de Item");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 428, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setBounds(10, 79, 37, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(57, 76, 338, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 107, 37, 14);
		contentPane.add(lblTipo);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 135, 37, 14);
		contentPane.add(lblPreo);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(57, 132, 86, 20);
		contentPane.add(textField_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(57, 103, 86, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(10, 160, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(108, 160, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(207, 160, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(306, 160, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Item");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(108, 11, 180, 37);
		contentPane.add(lblNewLabel_1);
	}

}
