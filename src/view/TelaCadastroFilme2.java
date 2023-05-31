package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.entities.Filme2;
import model.entities.Genero;
import model.entities.Impl.Filme2DaoJDBC;
import model.entities.Impl.GeneroDaoJDBC;
import model.entities.dao.ConexaoDB;

public class TelaCadastroFilme2 extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextArea txtArea;
	private JSpinner jsDuracao;
	private JTextField txtId;
	private JTable tbFilme;
	private JComboBox cbxGenero;
	private Integer codFilme;
	int hoveredRow = -1;
	int hoveredColumn = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFilme2 frame = new TelaCadastroFilme2();
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
	public TelaCadastroFilme2() {
		setMaximizable(true);
		setClosable(true);
		setTitle("Cine Pipoca");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 108, 46, 14);
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(70, 105, 452, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setBounds(10, 136, 46, 14);
		contentPane.add(lblGenero);

		JLabel lblNewLabel_2 = new JLabel("Sinopse:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 161, 50, 14);
		contentPane.add(lblNewLabel_2);

		txtArea = new JTextArea();
		txtArea.setBounds(70, 165, 452, 75);
		contentPane.add(txtArea);

		JLabel lblNewLabel_2_1 = new JLabel("Dura\u00E7\u00E3o:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(10, 251, 61, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1 = new JLabel("minutos");
		lblNewLabel_1.setBounds(133, 251, 46, 14);
		contentPane.add(lblNewLabel_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarFilme2();
					listarFilme();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});
		btnSalvar.setBounds(122, 282, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					editar();
					listarFilme();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(221, 282, 89, 23);
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					excluir();
					listarFilme();
					txtId.setText("");
					txtArea.setText("");
					txtTitulo.setText("");
					jsDuracao.setValue(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(320, 282, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					consultarDados();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(419, 282, 89, 23);
		contentPane.add(btnConsultar);

		JLabel lblNewLabel_3 = new JLabel("Cadastro de Filme");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(176, 11, 192, 42);
		contentPane.add(lblNewLabel_3);

		jsDuracao = new JSpinner();
		jsDuracao.setModel(new SpinnerNumberModel(0, 0, 200, 1));
		jsDuracao.setBounds(69, 251, 61, 20);
		contentPane.add(jsDuracao);

		JLabel lblId = new JLabel("Id:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(10, 81, 46, 14);
		contentPane.add(lblId);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(70, 78, 50, 20);
		contentPane.add(txtId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 323, 487, 128);
		contentPane.add(scrollPane);

		tbFilme = new JTable();
		tbFilme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarLinha();
			}
		});
		tbFilme.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				try {
					listarFilme();
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
		scrollPane.setViewportView(tbFilme);
		tbFilme.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "T\u00EDtulo", "G\u00EAnero", "Sinopse", "Dura\u00E7\u00E3o" }));

		cbxGenero = new JComboBox();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "Selecione" }));
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
		cbxGenero.setBounds(70, 132, 218, 18);
		contentPane.add(cbxGenero);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtId.setText("");
				txtArea.setText("");
				txtTitulo.setText("");
				jsDuracao.setValue(0);
//				cbxGenero.setSelectedItem("0");

			}
		});
		btnNovo.setBounds(20, 282, 89, 23);
		contentPane.add(btnNovo);
		tbFilme.getColumnModel().getColumn(0).setPreferredWidth(42);
		tbFilme.getColumnModel().getColumn(1).setPreferredWidth(154);
		tbFilme.getColumnModel().getColumn(2).setPreferredWidth(118);
		tbFilme.getColumnModel().getColumn(3).setPreferredWidth(105);
		tbFilme.getColumnModel().getColumn(4).setPreferredWidth(60);
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		tbFilme.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tbFilme.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		
		tbFilme.setRowSelectionAllowed(true);
		tbFilme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tbFilme.getTableHeader().setReorderingAllowed(false);
		
		tbFilme.setDefaultEditor(Object.class, null);

		
	}

	protected void consultarDados() throws SQLException {
		int idPesquisa = Integer.parseInt(txtId.getText());

		Filme2DaoJDBC filme2DaoJDBC = new Filme2DaoJDBC(ConexaoDB.getConexao());
		Filme2 filme2 = filme2DaoJDBC.findById(idPesquisa);
		if (filme2 == null) {
			JOptionPane.showMessageDialog(this, "Filme nao encontrado");
		} else {
			txtTitulo.setText(filme2.getTitulo());
			txtArea.setText(filme2.getSinopse());
			jsDuracao.setValue(filme2.getDuracao());
			cbxGenero.setSelectedIndex(filme2.getGenero().getCodGenero());
		}
	}

	protected void selecionarLinha() {
		txtId.setText(tbFilme.getValueAt(tbFilme.getSelectedRow(), 0).toString());
		txtTitulo.setText(tbFilme.getValueAt(tbFilme.getSelectedRow(), 1).toString());
		cbxGenero.getModel().setSelectedItem(tbFilme.getValueAt(tbFilme.getSelectedRow(), 2));
		txtArea.setText(tbFilme.getValueAt(tbFilme.getSelectedRow(), 3).toString());
		jsDuracao.setValue(tbFilme.getValueAt(tbFilme.getSelectedRow(), 4));
	}

	protected void excluir() throws SQLException {
		Filme2DaoJDBC filme2DaoJDBC = new Filme2DaoJDBC(ConexaoDB.getConexao());
		Filme2 obj = new Filme2();
		obj.setCodFilme(Integer.parseInt(txtId.getText()));

		filme2DaoJDBC.deleteById(obj);
		if (filme2DaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Excluido");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void editar() throws SQLException {
		Filme2DaoJDBC filme2DaoJDBC = new Filme2DaoJDBC(ConexaoDB.getConexao());
		Genero genero = new Genero();
		Filme2 obj = new Filme2();
		obj.setTitulo(txtTitulo.getText());
		genero = (Genero) cbxGenero.getSelectedItem();
		obj.setGenero(genero);
		obj.setSinopse(txtArea.getText());
		obj.setDuracao(Integer.parseInt(jsDuracao.getValue().toString()));
		obj.setCodFilme(Integer.parseInt(txtId.getText()));

		filme2DaoJDBC.update(obj);
		if (filme2DaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Atualizado");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void listarFilme() throws SQLException {
		// TODO Auto-generated method stub
		Filme2DaoJDBC filme2DaoJDBC = new Filme2DaoJDBC(ConexaoDB.getConexao());
		List<Filme2> list = filme2DaoJDBC.findAll();
		DefaultTableModel model = (DefaultTableModel) tbFilme.getModel();
		model.setNumRows(0);

		for (Filme2 filme2 : list) {
			model.addRow(new Object[] { filme2.getCodFilme(), filme2.getTitulo(), filme2.getGenero().getDescricao(),
					filme2.getSinopse(), filme2.getDuracao() });

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

	protected void cadastrarFilme2() throws SQLException {
		Filme2DaoJDBC filme2DaoJDBC = new Filme2DaoJDBC(ConexaoDB.getConexao());
		Genero genero = new Genero();
		Filme2 filme = new Filme2();
		filme.setTitulo(txtTitulo.getText());
		genero = (Genero) cbxGenero.getSelectedItem();
		filme.setGenero(genero);
		filme.setSinopse(txtArea.getText());
		filme.setDuracao(Integer.parseInt(jsDuracao.getValue().toString()));

		filme2DaoJDBC.inserir(filme);
		if (filme2DaoJDBC != null) {
			JOptionPane.showMessageDialog(contentPane, "Sucesso");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Dados Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
