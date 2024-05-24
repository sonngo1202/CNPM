package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.User;
import model.WeekdayTicketStat;
import dao.WeekdayTicketStatDAO;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class WeekdayTicketStatFrm extends JFrame implements ActionListener{
    private List<WeekdayTicketStat> weekdayTicketStats;
	private JPanel contentPane;
	private JTextField txtStarttime;
	private JTextField txtEndtime;
	private JButton btnStat;
	private JTable tblStat;
	private User user;
	private WeekdayTicketStatFrm mainFrm;


	/**
	 * Create the frame.
	 */
	public WeekdayTicketStatFrm(User user) {
		super("Weekday Ticket Stat");
		this.user = user;
		mainFrm = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 1000));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Weekday Ticket Stat");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(32767, 2500));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Start time");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1);
		
		txtStarttime = new JTextField();
		txtStarttime.setToolTipText("YYYY-MM-DD");
		txtStarttime.setActionCommand("");
		txtStarttime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(txtStarttime);
		txtStarttime.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		panel_2.setMaximumSize(new Dimension(32767, 2500));
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("End time");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_2.add(lblNewLabel_2);
		
		txtEndtime = new JTextField();
		txtEndtime.setToolTipText("YYYY-MM-DD");
		txtEndtime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(txtEndtime);
		txtEndtime.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 100));
		panel_3.setMaximumSize(new Dimension(32767, 2500));
		contentPane.add(panel_3);
		
		btnStat = new JButton("Stat");
		btnStat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnStat.addActionListener(this);
		panel_3.add(btnStat);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		
		tblStat = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblStat);
		panel_4.add(scrollPane);
		tblStat.setFillsViewportHeight(false);
		tblStat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tblStat.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = tblStat.getColumnModel().getColumnIndexAtX(e.getX());
				int row = e.getY()/tblStat.getRowHeight();
				if(row < tblStat.getRowCount()&& row >= 0 && column < tblStat.getColumnCount()&&column >=0) {
					int totalTicket = Integer.parseInt(tblStat.getValueAt(row, 2).toString());
					float revenue = Float.parseFloat(tblStat.getValueAt(row, 3).toString());
					if(totalTicket == 0&& revenue == 0 && weekdayTicketStats.get(row).getnShowtime()==0) {
						JOptionPane.showMessageDialog(mainFrm, "Khong co suat chieu nao trong ngay nay");
					}else {
						(new WeekdayDetailFrm(user, Date.valueOf(txtStarttime.getText().trim()), Date.valueOf(txtEndtime.getText().trim()), tblStat.getValueAt(row, 1).toString())).setVisible(true);
						mainFrm.dispose();
					}
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		JButton btnClicked = (JButton)e.getSource();
		if(btnClicked.equals(btnStat)) {
			if((txtStarttime.getText()==null)||(txtStarttime.getText().length()==0)||(txtEndtime.getText()==null)||(txtEndtime.getText().length()==0)) return;
			String starttime = txtStarttime.getText().trim();
			String endtime = txtEndtime.getText().trim();
			try {
				Date st = Date.valueOf(starttime);
				Date et = Date.valueOf(endtime);
				if(st.compareTo(et)<=0) {
					WeekdayTicketStatDAO weekdayTicketStatDAO = new WeekdayTicketStatDAO();
					weekdayTicketStats = weekdayTicketStatDAO.getWeekdayTicketStat(st, et);
					String [] columnNames = {"STT", "Dayname", "TotalTicket", "Revenue"};
					String [][] value = new String[weekdayTicketStats.size()][4];
					for(int i=0; i<weekdayTicketStats.size(); i++) {
						value[i][0] = weekdayTicketStats.get(i).getId()+"";
						value[i][1] = weekdayTicketStats.get(i).getDayname()+"";
						value[i][2] = weekdayTicketStats.get(i).getTotalTicket()+"";
						value[i][3] = String.format("%.0f", weekdayTicketStats.get(i).getRevenue());
					}
					DefaultTableModel tableModel = new DefaultTableModel(value, columnNames) {
						public boolean isCellEditable(int row, int column) {
						       return false;
						}
					};
					tblStat.setModel(tableModel);
					
				}else{
					JOptionPane.showMessageDialog(this, "Start khong the lon hon Endtime");
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "Dinh dang ngay nhap vao khong dung");
				ex.printStackTrace();
			}
		}
	}
}
