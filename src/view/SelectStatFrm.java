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

public class SelectStatFrm extends JFrame implements ActionListener{

	private JPanel contentPane;
    private JButton btnWeekdayTicketStat, btnCancel;
    private User user;
	/**
	 * Create the frame.
	 */
	public SelectStatFrm(User user) {
		super("Select Stat");
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Select Stat");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnWeekdayTicketStat = new JButton("Weekday Ticket Stat");
		btnWeekdayTicketStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnWeekdayTicketStat.addActionListener(this);
		panel_1.add(btnWeekdayTicketStat);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.addActionListener(this);
		panel_2.add(btnCancel);
	}
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnWeekdayTicketStat))) {
			(new WeekdayTicketStatFrm(user)).setVisible(true);
			this.dispose();
		}else {
			(new ManagerHomeFrm(user)).setVisible(true);
			this.dispose();
		}
	}

}
