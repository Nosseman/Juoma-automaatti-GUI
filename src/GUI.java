import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnYllapito;
	private JMenu mnTietoja;
	private JMenuItem mntmAsetaKahvi;
	private JMenuItem mntmAsetaTee;
	private JMenuItem mntmAsetaKaakao;
	private JMenuItem mntmTallenna;
	private JMenuItem mntmLataa;
	private JMenuItem mntmSulje;
	private JMenuItem mntmVersio;
	private JMenuItem mntmOhje;
	private JButton btnKahvi;
	private JButton btnTee;
	private JButton btnKaakao;
	private JLabel lblTeeTxt;
	private JLabel lblKaakaoTxt;
	private JLabel lblKahviTxt;
	private JLabel lblKahviMaara;
	private JLabel lblTeeMaara;
	private JLabel lblKaakaoMaara;
	
	Versiotiedot versio = new Versiotiedot();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					automaatti ja = new automaatti();
					GUI frame = new GUI(ja);
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
	public GUI(automaatti ja) {
		setTitle("Juoma-automaatti GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnYllapito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllapito);
		
		mntmAsetaKahvi = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mnYllapito.add(mntmAsetaKahvi);
		
		mntmAsetaTee = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mnYllapito.add(mntmAsetaTee);
		
		mntmAsetaKaakao = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mnYllapito.add(mntmAsetaKaakao);
		
		mntmTallenna = new JMenuItem("Tallenna automaatin tila");
		mnYllapito.add(mntmTallenna);
		
		mntmLataa = new JMenuItem("Lataa automaatti");
		mnYllapito.add(mntmLataa);
		
		mntmSulje = new JMenuItem("Sulje");
		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllapito.add(mntmSulje);
		
		mnTietoja = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietoja);
		
		mntmVersio = new JMenuItem("Versiotiedot");
		mntmVersio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				versio.setVisible(true);
			}
		});
		mnTietoja.add(mntmVersio);
		
		mntmOhje = new JMenuItem("Ohje");
		mnTietoja.add(mntmOhje);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{108, 0, 26, 59, 51, 67, 0};
		gbl_contentPane.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		Image coffee = new ImageIcon(this.getClass().getResource("kahvi.png")).getImage();
		
		btnKahvi = new JButton("");
		btnKahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKahvi();
				// vaihdetaan n�ytett�v� raaka-aineen m��r�
				//lblKahviMaara.setText("Kahvi: " + ja.getKahvi());
				// jos raaka-aine alhainen vaihdetaan v�ri
				if (ja.getKahvi() <= 20) {
					lblKahviMaara.setForeground(Color.RED);
				}
			}
		});
		
		lblKahviTxt = new JLabel("Kahvi");
		lblKahviTxt.setFont(new Font("Ravie", Font.PLAIN, 10));
		GridBagConstraints gbc_lblKahviTxt = new GridBagConstraints();
		gbc_lblKahviTxt.insets = new Insets(0, 0, 5, 5);
		gbc_lblKahviTxt.gridx = 1;
		gbc_lblKahviTxt.gridy = 2;
		contentPane.add(lblKahviTxt, gbc_lblKahviTxt);
		
		lblTeeTxt = new JLabel("Tee");
		lblTeeTxt.setFont(new Font("Ravie", Font.PLAIN, 10));
		GridBagConstraints gbc_lblTeeTxt = new GridBagConstraints();
		gbc_lblTeeTxt.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeeTxt.gridx = 2;
		gbc_lblTeeTxt.gridy = 2;
		contentPane.add(lblTeeTxt, gbc_lblTeeTxt);
		
		lblKaakaoTxt = new JLabel("Kaakao");
		lblKaakaoTxt.setFont(new Font("Ravie", Font.PLAIN, 10));
		GridBagConstraints gbc_lblKaakaoTxt = new GridBagConstraints();
		gbc_lblKaakaoTxt.insets = new Insets(0, 0, 5, 5);
		gbc_lblKaakaoTxt.gridx = 3;
		gbc_lblKaakaoTxt.gridy = 2;
		contentPane.add(lblKaakaoTxt, gbc_lblKaakaoTxt);
		GridBagConstraints gbc_btnKahvi = new GridBagConstraints();
		gbc_btnKahvi.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnKahvi.insets = new Insets(0, 0, 5, 5);
		gbc_btnKahvi.gridx = 1;
		gbc_btnKahvi.gridy = 3;
		contentPane.add(btnKahvi, gbc_btnKahvi);
		btnKahvi.setIcon(new ImageIcon(coffee));
		Image tea = new ImageIcon(this.getClass().getResource("tee.png")).getImage();
		
		btnTee = new JButton("");
		btnTee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaTee();
				// p�ivitet��n raaka-aineen m��r�
				lblTeeMaara.setText("Tee :" + ja.getTee());
				// jos raaka-aine alhainen vaihdetaan v�ri
				if (ja.getTee() <= 20) {
					lblTeeMaara.setForeground(Color.RED);
				}
			}
		});
		GridBagConstraints gbc_btnTee = new GridBagConstraints();
		gbc_btnTee.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnTee.insets = new Insets(0, 0, 5, 5);
		gbc_btnTee.gridx = 2;
		gbc_btnTee.gridy = 3;
		contentPane.add(btnTee, gbc_btnTee);
		btnTee.setIcon(new ImageIcon(tea));
		Image choco = new ImageIcon(this.getClass().getResource("kaakao.png")).getImage();
		
		btnKaakao = new JButton("");
		btnKaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();
				// p�ivitet��n raaka-aineen m��r�
				lblKaakaoMaara.setText("Kaakao :" + ja.getKaakao());
				// vaihdetaan v�ri jos raaka-aineen m��r� alhainen
				if (ja.getKaakao() <= 20) {
					lblKaakaoMaara.setForeground(Color.RED);
				}
			}
		});
		GridBagConstraints gbc_btnKaakao = new GridBagConstraints();
		gbc_btnKaakao.insets = new Insets(0, 0, 5, 5);
		gbc_btnKaakao.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnKaakao.gridx = 3;
		gbc_btnKaakao.gridy = 3;
		contentPane.add(btnKaakao, gbc_btnKaakao);
		btnKaakao.setIcon(new ImageIcon(choco));
		
		lblKahviMaara = new JLabel("Kahvi: " + ja.getKahvi());
		lblKahviMaara.setFont(new Font("Ravie", Font.PLAIN, 12));
		GridBagConstraints gbc_lblKahviMaara = new GridBagConstraints();
		gbc_lblKahviMaara.insets = new Insets(0, 0, 5, 5);
		gbc_lblKahviMaara.gridx = 1;
		gbc_lblKahviMaara.gridy = 5;
		contentPane.add(lblKahviMaara, gbc_lblKahviMaara);
		//lis�t��n if lause t�h�nkin jos alkuarvo on liian alhainen, vaihdetaan v�ri
		if (ja.getKahvi() <= 20) {
			lblTeeMaara.setForeground(Color.RED);
		}
		
		lblTeeMaara = new JLabel("Tee: " + ja.getTee());
		lblTeeMaara.setFont(new Font("Ravie", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTeeMaara = new GridBagConstraints();
		gbc_lblTeeMaara.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeeMaara.gridx = 2;
		gbc_lblTeeMaara.gridy = 5;
		contentPane.add(lblTeeMaara, gbc_lblTeeMaara);
		//lis�t��n if lause t�h�nkin jos alkuarvo on liian alhainen, vaihdetaan v�ri
		if (ja.getTee() <= 20) {
			lblTeeMaara.setForeground(Color.RED);
		}
		
		lblKaakaoMaara = new JLabel("Kaakao: " + ja.getKaakao());
		lblKaakaoMaara.setFont(new Font("Ravie", Font.PLAIN, 12));
		GridBagConstraints gbc_lblKaakaoMaara = new GridBagConstraints();
		gbc_lblKaakaoMaara.insets = new Insets(0, 0, 5, 5);
		gbc_lblKaakaoMaara.gridx = 3;
		gbc_lblKaakaoMaara.gridy = 5;
		contentPane.add(lblKaakaoMaara, gbc_lblKaakaoMaara);
		lblKaakaoMaara.setText("Kaakao :" + ja.getKaakao());
		//lis�t��n if lause t�h�nkin jos alkuarvo on liian alhainen, vaihdetaan v�ri
		if (ja.getKaakao() <= 20) {
			lblKaakaoMaara.setForeground(Color.RED);
		}
	}
}
