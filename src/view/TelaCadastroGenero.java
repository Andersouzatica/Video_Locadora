package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import model.entities.Genero;
import model.entities.Impl.GeneroDaoJDBC;
import model.entities.dao.ConexaoDB;

public class TelaCadastroGenero extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTable tbGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroGenero frame = new TelaCadastroGenero();
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
	public TelaCadastroGenero() {
		setTitle("Cadastro de Genero");
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 459, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Genero");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(112, 11, 210, 51);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(20, 83, 59, 14);
		contentPane.add(lblNewLabel_1);

		txtId = new JTextField();
		txtId.setBounds(89, 80, 59, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 111, 72, 14);
		contentPane.add(lblNewLabel_1_1);

		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(89, 108, 326, 20);
		contentPane.add(txtDescricao);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 190, 395, 198);
		contentPane.add(scrollPane);

		tbGenero = new JTable();
		tbGenero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarLinha();
			}
		});
		tbGenero.addAncestorListener(new AncestorListener() {
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
		scrollPane.setViewportView(tbGenero);
		tbGenero.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Descri\u00E7\u00E3o" }));

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparTela();
			}
		});
		btnNovo.setBounds(20, 151, 89, 23);
		contentPane.add(btnNovo);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EditarGenero();
					listarGenero();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(218, 151, 89, 23);
		contentPane.add(btnEditar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadastrarGenero();
					listarGenero();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(119, 151, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluirGenero();
					listarGenero();
					LimparTela();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(326, 151, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnConsultar = new JButton("...");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarGenero();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(158, 80, 22, 20);
		contentPane.add(btnConsultar);
		tbGenero.getColumnModel().getColumn(0).setPreferredWidth(45);
		tbGenero.getColumnModel().getColumn(1).setPreferredWidth(276);
	}

	protected void buscarGenero() throws NumberFormatException, SQLException {
		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		Genero genero = generoDaoJDBC.findById(Integer.parseInt(txtId.getText()));

		if (genero == null) {
			JOptionPane.showMessageDialog(this, "Filme nao encontrado");
		} else {
			txtDescricao.setText(genero.getDescricao());
		}
	}

	protected void excluirGenero() throws NumberFormatException, SQLException {
		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		Genero genero = generoDaoJDBC.findById(Integer.parseInt(txtId.getText()));
		generoDaoJDBC.deleteById(genero);

		if (generoDaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Excluido");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void EditarGenero() throws NumberFormatException, SQLException {
		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		Genero genero = generoDaoJDBC.findById(Integer.parseInt(txtId.getText()));
		genero.setDescricao(txtDescricao.getText());
		generoDaoJDBC.update(genero);

		if (generoDaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Atualizado");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void CadastrarGenero() throws SQLException {
		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		Genero genero = new Genero();
		genero.setDescricao(txtDescricao.getText());
		generoDaoJDBC.inserir(genero);

		if (generoDaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Sucesso");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void LimparTela() {
		txtId.setText("");
		txtDescricao.setText("");
	}

	protected void selecionarLinha() {
		txtId.setText(tbGenero.getValueAt(tbGenero.getSelectedRow(), 0).toString());
		txtDescricao.setText(tbGenero.getValueAt(tbGenero.getSelectedRow(), 1).toString());
	}

	protected void listarGenero() throws SQLException {

		GeneroDaoJDBC generoDaoJDBC = new GeneroDaoJDBC(ConexaoDB.getConexao());
		List<Genero> generos = generoDaoJDBC.listagenero();
		DefaultTableModel model = (DefaultTableModel) tbGenero.getModel();
		model.setNumRows(0);

		for (Genero genero : generos) {
			model.addRow(new Object[] { genero.getCodGenero(), genero.getDescricao()

			});
		}

	}
}
