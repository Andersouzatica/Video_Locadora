package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import model.entities.Ator;
import model.entities.Pais;
import model.entities.Impl.AtorDaoJDBC;
import model.entities.dao.ConexaoDB;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TelaCadastroAtor extends JInternalFrame implements KeyListener {

	private JPanel contentPane;
	private JTextField txtNome;
	private JComboBox cbxPais;
	private TelaCadastroAtor telaCadastroAtor;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAtor frame = new TelaCadastroAtor();
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
	
	public TelaCadastroAtor(TelaCadastroAtor telaCadastroAtor) {
		this.telaCadastroAtor = telaCadastroAtor;
//		setContentPane(contentPane);
	}
	
	public TelaCadastroAtor() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Cadastro de Ator");
		setResizable(false);
		setBounds(100, 100, 434, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Ator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(114, 28, 183, 48);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 123, 78, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.addKeyListener(this);
		txtNome.setBounds(98, 120, 298, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Nacionalidade:");
		lblNewLabel_1_1.setBounds(10, 151, 89, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InserirAtor();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(10, 179, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnLimpar.setBounds(109, 179, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(208, 179, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbrirConsulta();
			}
		});
		btnConsultar.setBounds(307, 179, 89, 23);
		contentPane.add(btnConsultar);

		cbxPais = new JComboBox();
		cbxPais.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));
		cbxPais.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					ListarPais();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbxPais.setBounds(96, 147, 163, 22);
		contentPane.add(cbxPais);
	}

	protected void AbrirConsulta() {
		TelaConsultaAtor telaConsultaAtor = new TelaConsultaAtor(this);
		telaConsultaAtor.setVisible(true);
		this.setVisible(false);

		
		
	}

	protected void LimparTela() {

		txtNome.setText("");
		cbxPais.setSelectedItem("Selecione");
	}

	protected void InserirAtor() throws SQLException {
		AtorDaoJDBC atorDaoJDBC = new AtorDaoJDBC(ConexaoDB.getConexao());
		Pais pais = new Pais();
		Ator ator = new Ator();
		ator.setName(txtNome.getText());
		pais = (Pais) cbxPais.getSelectedItem();
		ator.setPais(pais);

		atorDaoJDBC.insert(ator);
		;
		if (atorDaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Sucesso");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void ListarPais() throws SQLException {
		AtorDaoJDBC atorDaoJDBC = new AtorDaoJDBC(ConexaoDB.getConexao());
		Pais pais = new Pais();
		List<Pais> list = atorDaoJDBC.findPais();
		cbxPais.removeAll();
		for (Pais pais2 : list) {
			cbxPais.addItem(pais2);
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNome) {
			keyTypedTxtNomeJTextField(e);
		}
	}
	protected void keyTypedTxtNomeJTextField(KeyEvent e) {
	}
}
