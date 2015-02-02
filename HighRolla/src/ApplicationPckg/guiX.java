//By Jami Makkonen 2015

package ApplicationPckg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class guiX {

	private JFrame frmHighrollaV;
	private JTextField textField;
	private JTextField textField_1;
	Random rand = new Random();
	private JButton btnNewButton;
	private JSeparator separator;
	String myString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiX window = new guiX();
					window.frmHighrollaV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHighrollaV = new JFrame();
		frmHighrollaV.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmHighrollaV.setTitle("HighRolla- Random Number Generator");
		frmHighrollaV.setBounds(100, 100, 474, 329);
		frmHighrollaV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHighrollaV.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(87, 140, 134, 28);
		frmHighrollaV.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(233, 140, 134, 28);
		frmHighrollaV.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JTextArea rollAns = new JTextArea();

		JButton btnRoll = new JButton("ROLL");
		btnRoll.setToolTipText("Start Rolling");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num1, num2;
				rollAns.setText("");

				try {
					num1 = Integer.parseInt(textField.getText());
					num2 = Integer.parseInt(textField_1.getText());

					for (int i = 0; i < num1; i++) {
						int dice = 1 + rand.nextInt(num2);
						rollAns.append(dice + ",");
						if((i%20)==1){
							rollAns.append("\n");
						}


					}

					JOptionPane.showMessageDialog(null, rollAns,"Random Numbers",JOptionPane.ERROR_MESSAGE);

				} catch (Exception excep) {
					JOptionPane.showMessageDialog(null,
							"Please enter valid number", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRoll.setBounds(169, 223, 142, 44);
		frmHighrollaV.getContentPane().add(btnRoll);

		JLabel lblHowManyTimes = new JLabel("How Many Times?");
		lblHowManyTimes
				.setToolTipText("Set how many times you want to generate a random number.");
		lblHowManyTimes.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblHowManyTimes.setBounds(98, 125, 115, 16);
		frmHighrollaV.getContentPane().add(lblHowManyTimes);

		JLabel lblRollFrom = new JLabel("Roll from 1 to:");
		lblRollFrom.setToolTipText("Roll from 1 to number you set here.");
		lblRollFrom.setBounds(250, 125, 104, 16);
		frmHighrollaV.getContentPane().add(lblRollFrom);

		btnNewButton = new JButton("Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "V.1.1.1 "
						+ "Made By Jami Makkonen (c)2015", "Info",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton.setBounds(6, 6, 66, 16);
		frmHighrollaV.getContentPane().add(btnNewButton);

		separator = new JSeparator();
		separator.setBounds(0, 20, 454, 28);
		frmHighrollaV.getContentPane().add(separator);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource(
				"/highRollalogo.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(109, 34, 218, 82);
		frmHighrollaV.getContentPane().add(lblNewLabel);

		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				rollAns.setText("");
			}
		});
		clearBtn.setBounds(379, 141, 74, 29);
		frmHighrollaV.getContentPane().add(clearBtn);

	}
}
