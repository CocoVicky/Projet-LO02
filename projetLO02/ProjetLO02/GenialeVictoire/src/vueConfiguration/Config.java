package vueConfiguration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Config {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Config window = new Config();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Config() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 700, 784);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de joueurs : ");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 68, 159, 27);
		panel.add(lblNewLabel_1);
		
		JRadioButton radioButton3Joueurs = new JRadioButton("3 Joueurs\r\n");
		radioButton3Joueurs.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		radioButton3Joueurs.setBounds(205, 68, 109, 27);
		panel.add(radioButton3Joueurs);
		
		JRadioButton radioButton4Joueurs = new JRadioButton("4 Joueurs\r\n");
		radioButton4Joueurs.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		radioButton4Joueurs.setBounds(353, 68, 109, 26);
		panel.add(radioButton4Joueurs);
		
		JLabel labelJoueur1 = new JLabel("Joueur 1");
		labelJoueur1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelJoueur1.setBounds(50, 106, 66, 17);
		panel.add(labelJoueur1);
		
		JLabel labelNom1 = new JLabel("Nom : \r\n");
		labelNom1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		labelNom1.setBounds(70, 134, 46, 14);
		panel.add(labelNom1);
		
		textField1 = new JTextField();
		textField1.setBounds(126, 132, 86, 20);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JLabel labelJoueur2 = new JLabel("Joueur 2");
		labelJoueur2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelJoueur2.setBounds(50, 179, 66, 27);
		panel.add(labelJoueur2);
		
		JLabel labelNom2 = new JLabel("Nom : ");
		labelNom2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		labelNom2.setBounds(70, 217, 46, 27);
		panel.add(labelNom2);
		
		textField2 = new JTextField();
		textField2.setBounds(126, 221, 86, 20);
		panel.add(textField2);
		textField2.setColumns(10);
		
		JLabel labelJoueur3 = new JLabel("Joueur 3");
		labelJoueur3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelJoueur3.setBounds(50, 284, 66, 27);
		panel.add(labelJoueur3);
		
		JLabel labelNom3 = new JLabel("Nom : ");
		labelNom3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		labelNom3.setBounds(70, 327, 46, 27);
		panel.add(labelNom3);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(126, 331, 86, 20);
		panel.add(textField3);
		
		JLabel labelJoueur4 = new JLabel("Joueur 4  (optionnel)");
		labelJoueur4.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		labelJoueur4.setBounds(47, 400, 165, 27);
		panel.add(labelJoueur4);
		
		JLabel labelNom4 = new JLabel("Nom : ");
		labelNom4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		labelNom4.setBounds(70, 445, 46, 27);
		panel.add(labelNom4);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(126, 449, 86, 20);
		panel.add(textField4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(205, 11, 296, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFIGURER");
		lblNewLabel.setBounds(71, 0, 158, 27);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(51, 153, 51));
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		
		JComboBox comboBoxType_1 = new JComboBox();
		comboBoxType_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBoxType_1.setModel(new DefaultComboBoxModel(new String[] {"Type", "R\u00E9el", "VirtuelFacile", "VirtuelMoyen"}));
		comboBoxType_1.setBounds(343, 131, 119, 20);
		panel.add(comboBoxType_1);
		
		JComboBox comboBoxType_2 = new JComboBox();
		comboBoxType_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBoxType_2.setModel(new DefaultComboBoxModel(new String[] {"Type", "R\u00E9el", "VirtuelFacile", "VirtuelMoyen"}));
		comboBoxType_2.setBounds(343, 221, 119, 20);
		panel.add(comboBoxType_2);
		
		JComboBox comboBoxType_3 = new JComboBox();
		comboBoxType_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBoxType_3.setModel(new DefaultComboBoxModel(new String[] {"Type", "R\u00E9el", "VirtuelFacile", "VirtuelMoyen"}));
		comboBoxType_3.setBounds(343, 331, 119, 20);
		panel.add(comboBoxType_3);
		
		JComboBox comboBoxType_4 = new JComboBox();
		comboBoxType_4.setModel(new DefaultComboBoxModel(new String[] {"Type", "R\u00E9el", "VirtuelFacile", "VirtuelMoyen"}));
		comboBoxType_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBoxType_4.setBounds(343, 445, 119, 20);
		panel.add(comboBoxType_4);
		
		JButton boutonValider = new JButton("Valider");
		boutonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom1 = labelNom1.getText();
				String nom2 = labelNom1.getText();
				String nom3 = labelNom1.getText();
				String nom4 = labelNom1.getText();
				
			}
		});
		boutonValider.setForeground(new Color(51, 153, 51));
		boutonValider.setBackground(UIManager.getColor("Button.background"));
		boutonValider.setFont(new Font("Cooper Black", Font.ITALIC, 16));
		boutonValider.setBounds(370, 536, 170, 23);
		panel.add(boutonValider);
		
		JButton boutonReset = new JButton("Reset");
		boutonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText(null); 
				textField2.setText(null); 
				textField3.setText(null); 
				textField4.setText(null); 
				radioButton3Joueurs.setSelected(false);
				radioButton4Joueurs.setSelected(false);
				comboBoxType_1.setSelectedItem("Type");
				comboBoxType_2.setSelectedItem("Type");
				comboBoxType_3.setSelectedItem("Type");
				comboBoxType_4.setSelectedItem("Type");
				
				
			}
		});
		boutonReset.setForeground(new Color(51, 153, 51));
		boutonReset.setFont(new Font("Cooper Black", Font.ITALIC, 16));
		boutonReset.setBounds(70, 536, 142, 23);
		panel.add(boutonReset);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(194, 618, 6, 20);
		panel.add(textPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(112, 604, 4, 22);
		panel.add(textArea);
	}
}
