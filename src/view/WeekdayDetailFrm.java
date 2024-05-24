package view;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import dao.ShowtimeStatDAO;
import model.User;
import model.WeekdayTicketStat;
import model.ShowtimeStat;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;


public class WeekdayDetailFrm extends JFrame implements ActionListener{
    private List<ShowtimeStat> showtimeStats;
	private User user;
	private WeekdayTicketStat weekdayTicketStat;
	private Date st, et;
	private JPanel contentPane;
	private JTable tblShowtime;
	private JButton btnBack;
	private WeekdayDetailFrm mainFrm;
    
	public WeekdayDetailFrm(User user, Date st, Date et, String dayname) {
		super("Weekday Detail");
		this.user = user;
		this.st = st;
		this.et = et;
		this.mainFrm = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Weekday Detail");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		
		tblShowtime = new JTable();
		TableColumnModel columnModel = tblShowtime.getColumnModel();
		tblShowtime.setFillsViewportHeight(true);
		tblShowtime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane(tblShowtime);
		tblShowtime.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = tblShowtime.getColumnModel().getColumnIndexAtX(e.getX());
				int row = e.getY()/tblShowtime.getRowHeight();
				if(row < tblShowtime.getRowCount()&& row >= 0 && column < tblShowtime.getColumnCount()&&column >=0) {
					int totalTicket = Integer.parseInt(tblShowtime.getValueAt(row, 6).toString());
					float revenue = Float.parseFloat(tblShowtime.getValueAt(row, 7).toString());
					if(totalTicket == 0&& revenue == 0) {
						JOptionPane.showMessageDialog(mainFrm, "Khong co hoa don nao thuoc suat chieu");
					}else {
						(new ShowtimeDetailFrm(user, st, et, dayname, showtimeStats.get(row).getId())).setVisible(true);
						mainFrm.dispose();
					}
				}
			}
		});
		
		panel_1.add(scrollPane);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.addActionListener(this);
		panel_2.add(btnBack);
		
		//Đưa kết quả lên bảng
		ShowtimeStatDAO showtimeStatDAO = new ShowtimeStatDAO();
        showtimeStats = showtimeStatDAO.getShowtimeofWeekday(dayname, st, et);
        String [] colunmNames = {"STT", "Start", "Day", "Movie", "Room", "Cinema", "TotalTicket", "Revenue"};
        String [][] value = new String[showtimeStats.size()][8];
        for(int i = 0; i < showtimeStats.size(); i++) {
        	value[i][0] = (i+1)+"";
        	value[i][1] = showtimeStats.get(i).getStarttime();
        	value[i][2] = showtimeStats.get(i).getDay()+"";
        	value[i][3] = showtimeStats.get(i).getMovie().getName();
        	value[i][4] = showtimeStats.get(i).getRoom().getName();
        	value[i][5] = showtimeStats.get(i).getRoom().getCinema().getName();
        	value[i][6] = showtimeStats.get(i).getTotalTicket()+"";
        	value[i][7] = String.format("%.0f", showtimeStats.get(i).getRevenue());
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(value, colunmNames){
			public boolean isCellEditable(int row, int column) {
			       return false;
			}
		};
		tblShowtime.setModel(defaultTableModel);
	}
	
    public void actionPerformed(ActionEvent e) {
    	JButton btnClick = (JButton) e.getSource();
    	if(btnClick.equals(btnBack)) {
    		(new ManagerHomeFrm(user)).setVisible(true);
    		this.dispose();
    	}
    }
}
