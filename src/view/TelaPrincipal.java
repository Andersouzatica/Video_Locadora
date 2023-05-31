package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	JDesktopPane jDesktop;
	private TelaCadastroAtor telaCadastroAtor = new TelaCadastroAtor();
	private TelaCadastroFilme2 telaCadastroFilme2 = new TelaCadastroFilme2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int valor = JOptionPane.showConfirmDialog(jDesktop, "Deseja Sair?", "Mensagem ao Usuário",
						JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setTitle("Video Locadora Hora da Pipoca");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 800, 600);

		JMenuBar menuBarTelaPrincipal = new JMenuBar();
		setJMenuBar(menuBarTelaPrincipal);

		JMenu jMenuLocacao = new JMenu("Loca\u00E7\u00E3o");
		menuBarTelaPrincipal.add(jMenuLocacao);

		JMenuItem jMenuItemAlugar = new JMenuItem("Alugar");
		jMenuItemAlugar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		jMenuLocacao.add(jMenuItemAlugar);

		JMenuItem jMenuConsultar = new JMenuItem("Consultar");
		jMenuLocacao.add(jMenuConsultar);

		JMenu jMenuCadastro = new JMenu("Cadastro");
		jMenuCadastro.setMnemonic('M');
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		jMenuCadastro.setIcon(new ImageIcon(img));
		menuBarTelaPrincipal.add(jMenuCadastro);

		JMenuItem jMenuAtor = new JMenuItem("Ator");
		jMenuAtor.setMnemonic('C');
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		jMenuAtor.setIcon(new ImageIcon(img));
		jMenuAtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAtor exibir = new TelaCadastroAtor();
				janelaNoCentro(exibir);
				jDesktop.add(exibir);
				exibir.setVisible(true);
			}
		});
		jMenuCadastro.add(jMenuAtor);

		JMenuItem jMenuCliente = new JMenuItem("Cliente");
		jMenuCliente.setMnemonic('D');
		jMenuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente exibir = new TelaCadastroCliente();
				janelaNoCentro(exibir);
				jDesktop.add(exibir);
				exibir.setVisible(true);
			}
		});
		jMenuCadastro.add(jMenuCliente);

		JMenuItem jMenuFilme = new JMenuItem("Filme");
		jMenuFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroFilme2 exibir = new TelaCadastroFilme2();
				janelaNoCentro(exibir);
				jDesktop.add(exibir);
				exibir.setVisible(true);

			}
		});
		jMenuCadastro.add(jMenuFilme);

		JMenuItem jMenuItem = new JMenuItem("Item");
		jMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroItem exibir = new TelaCadastroItem();
				janelaNoCentro(exibir);
				jDesktop.add(exibir);
				exibir.setVisible(true);
			}
		});
		jMenuCadastro.add(jMenuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("G\u00EAnero");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroGenero exibir = new TelaCadastroGenero();
				janelaNoCentro(exibir);
				jDesktop.add(exibir);
				exibir.setVisible(true);
			}
		});
		jMenuCadastro.add(mntmNewMenuItem);

		JMenu jMenuSair = new JMenu("Sair");
		jMenuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int valor = JOptionPane.showConfirmDialog(jDesktop, "Deseja Sair?", "Mensagem ao Usuário",
						JOptionPane.YES_NO_OPTION);
				if (valor == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		menuBarTelaPrincipal.add(jMenuSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		jDesktop = new JDesktopPane();
		jDesktop.setBackground(SystemColor.activeCaption);
		contentPane.add(jDesktop, BorderLayout.CENTER);
	}

	public void janelaNoCentro(JInternalFrame frm) {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension formulario = frm.getSize();

		int posX = (int) (pantalla.getWidth() - formulario.getWidth()) / 2;
		int posY = (int) (pantalla.getHeight() - formulario.getHeight()) / 2;
		frm.setLocation(posX - 300, posY - 130);
	}
}
