package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerHomeFrm extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnViewStat, btnCancel;
    private User user;

	/**
	 * Create the frame.
	 */
	public ManagerHomeFrm(User user) {
		super("Manager Home");
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Manager Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnViewStat = new JButton("View Stat");
		btnViewStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnViewStat.addActionListener(this);
		panel_1.add(btnViewStat);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		btnCancel =  new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.addActionListener(this);
		panel_2.add(btnCancel);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnViewStat))) {
			(new SelectStatFrm(user)).setVisible(true);
			this.dispose();
		}else {
			this.dispose();
		}
	}
	

}
