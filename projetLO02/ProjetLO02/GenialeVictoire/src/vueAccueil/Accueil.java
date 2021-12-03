package vueAccueil;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import vueConfiguration.Config;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class Accueil {

	private JFrame frmAccueil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frmAccueil.setUndecorated(true);
					window.frmAccueil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccueil = new JFrame();
		frmAccueil.setFont(new Font("Cooper Black", Font.ITALIC, 16));
		frmAccueil.setTitle("Accueil");
		frmAccueil.setBounds(100, 100, 450, 300);
		frmAccueil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccueil.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setForeground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 450, 300);
		frmAccueil.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel labelBienvenue = new JLabel("BIENVENUE DANS LE JEST");
		labelBienvenue.setForeground(new Color(51, 153, 51));
		labelBienvenue.setFont(new Font("Cooper Black", Font.BOLD | Font.ITALIC, 21));
		labelBienvenue.setBounds(46, 22, 333, 34);
		panel.add(labelBienvenue);
		
		JButton boutonConfig = new JButton("CONFIGURER");
		boutonConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Config param = new Config();
				Config.main(null);
			}
		});
		boutonConfig.setBackground(new Color(51, 153, 51));
		boutonConfig.setFont(new Font("Cooper Black", Font.ITALIC, 11));
		boutonConfig.setBounds(160, 108, 125, 23);
		panel.add(boutonConfig);
	}
}
