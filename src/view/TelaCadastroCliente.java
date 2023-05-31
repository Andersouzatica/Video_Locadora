package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastroCliente extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setTitle("Cadastro de Cliente");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 430, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 108, 108, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(113, 105, 278, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Data de Nascimento:");
		lblNewLabel_1.setBounds(10, 136, 108, 14);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 133, 108, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setBounds(10, 163, 108, 14);
		contentPane.add(lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 160, 135, 20);
		contentPane.add(textField_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1_1.setBounds(10, 191, 108, 14);
		contentPane.add(lblNewLabel_1_1_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 188, 212, 20);
		contentPane.add(textField_3);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Endere\u00E7o:");
		lblNewLabel_1_1_1_1.setBounds(10, 219, 108, 14);
		contentPane.add(lblNewLabel_1_1_1_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 216, 278, 20);
		contentPane.add(textField_4);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(10, 274, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(108, 274, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(207, 274, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(302, 274, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblNewLabel_2 = new JLabel("Cadastro de Cliente");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(113, 22, 201, 44);
		contentPane.add(lblNewLabel_2);
	}

}
