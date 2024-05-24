package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPasswordField;

import model.User;
import dao.UserDAO;

public class LoginFrm extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginFrm myFrame = new LoginFrm();
		myFrame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginFrm() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		FlowLayout fl_panel_1 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_1.setLayout(fl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(txtUsername);
		txtUsername.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('*');
		txtPassword.setColumns(20);
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(txtPassword);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		contentPane.add(panel_3);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.addActionListener(this);
		panel_3.add(btnLogin);
	}
	
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnLogin))) {
			User user = new User();
			user.setUsername(txtUsername.getText());
			user.setPassword(txtPassword.getText());
			
			UserDAO uDAO = new UserDAO();
			if(uDAO.checkLogin(user)) {
				if(user.getPosition().equalsIgnoreCase("manager")) {
					(new ManagerHomeFrm(user)).setVisible(true);
					this.dispose();
				}else if(user.getPosition().equalsIgnoreCase("seller")) {
					JOptionPane.showMessageDialog(this, "Day la Seller: "+user.getFullname());;
				}
				else {
					JOptionPane.showMessageDialog(this, "Day la Administrator: "+user.getFullname());
				}
			}else {
				JOptionPane.showMessageDialog(this, "Thong tin tai khoan/mat khau khong chinh xac");
			}
		}
	}

}
