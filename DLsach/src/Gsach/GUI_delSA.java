package Gsach;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_delSA extends JFrame {

	private JPanel contentPane;
	
	//tao jtable de cho csdl vào
	//tạo đối tượng
	private JTable jtbSach;
	//tạo kết nối sang file xlsach
	private XLsach XL =new XLsach();
	//lưu trữ dl vào bảng 
	private DefaultTableModel dtm = new DefaultTableModel();
	//tạo vecsto để sử dụng cột với hàng của jtable
	private Vector<String >columns = new Vector<String>() ;
	
	private Vector<Vector<Object>>rows = new Vector<>() ;
	private ArrayList<Sach> lsSachs;
	
	/**
	 * Launch the application.
	 */
	
	//in ds 
	//gọi hàm sang
	private void getallbook() {
		lsSachs = XL.getSA();
		for(int i=0;i<lsSachs.size();i++) {
			Sach s = lsSachs.get(i);
			Vector<Object>tbRow =new Vector<>();//dùng để thêm
			tbRow.add(s.getMaS());
			tbRow.add(s.getTenS());
			tbRow.add(s.getNamXB());
			tbRow.add(s.getGiaB());
			rows.add(tbRow);
		}
		dtm.setDataVector(rows,columns );
		jtbSach.setModel(dtm);
	}
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_delSA frame = new GUI_delSA();
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
	public GUI_delSA() {
		setTitle("GUI_delSA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cb_namxb = new JComboBox();
		cb_namxb.setModel(new DefaultComboBoxModel(new String[] {"2019", "2020", "2021"}));
		cb_namxb.setBounds(38, 21, 226, 21);
		contentPane.add(cb_namxb);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {//chuot phai action
			public void actionPerformed(ActionEvent e) {
				int i = Integer.parseInt(cb_namxb.getSelectedItem()+"");
				deleteSach(i);
			}
		});
		btnXoa.setBounds(294, 21, 85, 21);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 86, 290, 149);
		contentPane.add(scrollPane);
		
		//đẩy dl vào bảng
		jtbSach = new JTable();
		scrollPane.setViewportView(jtbSach);
		columns.add("Mã sách");
		columns.add("Tên sách");
		columns.add("Năm xuất bản");
		columns.add("Giá bán");
		getallbook();
	}
	//xóa
	public void deleteSach(int NamXB) {
		XL.deleteSA(NamXB);
		
	}
	
}
