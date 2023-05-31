package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.entities.Filme;
import model.entities.Genero;
import model.entities.Impl.FilmeDaoJDBC;
import model.entities.Impl.GeneroDaoJDBC;
import model.entities.dao.ConexaoDB;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TelaCadastroFilme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JComboBox cbxGenero;
	private JTextArea txtArea;
	private JSpinner jsDuracao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme frame = new TelaCadastroFilme();
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
	public TelaCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 108, 46, 14);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(70, 105, 452, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 136, 46, 14);
		contentPane.add(lblGenero);

		cbxGenero = new JComboBox();
		cbxGenero.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					listarGenero();
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
		cbxGenero.setBounds(70, 132, 143, 22);
		contentPane.add(cbxGenero);

		JLabel lblNewLabel_2 = new JLabel("Sinopse:");
		lblNewLabel_2.setBounds(10, 164, 50, 14);
		contentPane.add(lblNewLabel_2);

		txtArea = new JTextArea();
		txtArea.setBounds(70, 165, 452, 75);
		contentPane.add(txtArea);

		JLabel lblNewLabel_2_1 = new JLabel("Dura\u00E7\u00E3o:");
		lblNewLabel_2_1.setBounds(10, 251, 61, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1 = new JLabel("minutos");
		lblNewLabel_1.setBounds(140, 251, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarFilme();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnSalvar.setBounds(10, 289, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(109, 289, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(208, 289, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(307, 289, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblNewLabel_3 = new JLabel("Cadastro de Filme");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(176, 11, 192, 42);
		contentPane.add(lblNewLabel_3);

		jsDuracao = new JSpinner();
		jsDuracao.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		jsDuracao.setBounds(69, 251, 61, 20);
		contentPane.add(jsDuracao);
	}

	protected void cadastrarFilme() throws SQLException {
		FilmeDaoJDBC filmeDaoJDBC = new FilmeDaoJDBC(ConexaoDB.getConexao());
		Filme filme = new Filme();
		filme.setTitulo(txtNome.getText());
		filme.setGenero(cbxGenero.getSelectedItem().toString());
		filme.setSinopse(txtArea.getText());
		filme.setDuracao(Integer.parseInt(jsDuracao.getValue().toString()));

		Filme obj = filmeDaoJDBC.insert(filme);
		if (obj != null) {
			JOptionPane.showMessageDialog(contentPane, "Sucesso");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	protected void listarGenero() throws SQLException {
		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		Genero genero = new Genero();
		List<Genero> list = generoDaoJDBC.listagenero();
		cbxGenero.removeAll();
		for (Genero genero2 : list) {
			cbxGenero.addItem(genero2);
		}
		
	}
}
