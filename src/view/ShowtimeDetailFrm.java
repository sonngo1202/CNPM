package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.BillDAO;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import model.Bill;
import model.ShowtimeStat;
import model.User;
import model.WeekdayTicketStat;

public class ShowtimeDetailFrm extends JFrame implements ActionListener{
    private List<Bill> bills;
	private JPanel contentPane;
	private JTable tblBill;
	JButton btnBack;
	private ShowtimeStat showtimeStat;
	private User user;
	private WeekdayTicketStat weekdayTicketStat;
	private Date st, et;
	private ShowtimeDetailFrm mainFrm;

	public ShowtimeDetailFrm(User user, Date st, Date et, String dayname, int idS) {
		super("Showtime Detail");
		this.user = user;
		this.st = st;
		this.et = et;
		this.weekdayTicketStat = new WeekdayTicketStat();
		weekdayTicketStat.setDayname(dayname);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Showtime Detail");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		tblBill = new JTable();
		tblBill.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tblBill);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.addActionListener(this);
		panel_2.add(btnBack);
		
		//Đưa kết quả lên bảng
		BillDAO billDAO = new BillDAO();
        bills = billDAO.getBillofShowtime(st, et, dayname, idS);
        String [] colunmNames = {"STT", "Customer", "TotalTicket", "TotalAmount", "PaymentDate"};
        String [][] value = new String[bills.size()][8];
        for(int i = 0; i < bills.size(); i++) {
        	value[i][0] = (i+1)+"";
        	value[i][1] = bills.get(i).getClient().getName();
        	value[i][2] = bills.get(i).getTotalTicket()+"";
        	value[i][3] = String.format("%.0f", bills.get(i).getTotalAmount());
        	value[i][4] = bills.get(i).getPaymentDate()+"";
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(value, colunmNames){
			public boolean isCellEditable(int row, int column) {
			       return false;
			}
		};
		tblBill.setModel(defaultTableModel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
    	JButton btnClick = (JButton) e.getSource();
    	if(btnClick.equals(btnBack)) {
    		(new WeekdayDetailFrm(user, st, et, weekdayTicketStat.getDayname())).setVisible(true);
    		this.dispose();
    	}
    }
}
