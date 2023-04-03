package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmBanSach extends JFrame {

	private JPanel contentPane;
	private JTextField txtten;
	private JTextField txttg;
	private JTextField txtgia;
	private JTextField txtsl;
	private JTextField txtslmua;
	private JTextField txttt;
	private JTable table;
	JComboBox cbbma = new JComboBox();
	JList listloai = new JList();
	loaibo lbo = new loaibo();
	/**
	 * Launch the application.
	 */
	loaibo lBo = new loaibo();
	sachbo sBo = new sachbo();
	ArrayList<sachbean> ds;
	void napbang(ArrayList<sachbean> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		mh.addColumn("Ma Sach");
		mh.addColumn("Ten Sach");
		mh.addColumn("So Luong");
		mh.addColumn("Gia");
		mh.addColumn("Ma Loai");
		mh.addColumn("So Tap");
		mh.addColumn("Anh");
		mh.addColumn("Ngay Nhap");
		mh.addColumn("Tac Gia");
		for (sachbean sach : ds) {
			Object[] t = new Object[9];
			t[0] = sach.getMasach();
			t[1] = sach.getTensach();
			t[2] = sach.getSoluong();
			t[3] = sach.getGia();
			t[4] = sach.getMaloai();
			t[5] = sach.getSotap();
			t[6] = sach.getAnh();
			SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
			t[7] = d.format(sach.getNgayNhap());
			t[8] = sach.getTacgia();
			mh.addRow(t);
		}
		table.setModel(mh);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBanSach frame = new frmBanSach();
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
	public frmBanSach() {
		this.setTitle("Xin chào " + frmdangnhap.un);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					DefaultListModel<loaibean> mh = new DefaultListModel<loaibean>();
					for (loaibean l : lbo.getloai()) {
						mh.addElement(l);
					}
				listloai.setModel(mh);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				try {
					ds = sBo.getsach();
					napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				for (sachbean sach : ds) {
						cbbma.addItem(sach.getMasach());
				}
			}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chon loai");
		lblNewLabel.setBounds(10, 11, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ma sach");
		lblNewLabel_1.setBounds(206, 11, 79, 14);
		contentPane.add(lblNewLabel_1);
		cbbma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String masach = (String) cbbma.getSelectedItem();
				for (sachbean sach : ds) {
					if (sach.getMasach().equals(masach)) {
						txtten.setText(sach.getTensach());
						txttg.setText(sach.getTacgia());
						String sl = Long.toString(sach.getSoluong());
						txtsl.setText(sl);
						String gia = Long.toString(sach.getGia());
						txtgia.setText(gia);
					}
				}
			}
		});

		cbbma.setBounds(295, 6, 162, 22);
		contentPane.add(cbbma);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ten sach");
		lblNewLabel_1_1.setBounds(206, 47, 79, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tac gia");
		lblNewLabel_1_2.setBounds(206, 82, 79, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Gia");
		lblNewLabel_1_3.setBounds(206, 119, 79, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("So luong");
		lblNewLabel_1_4.setBounds(206, 156, 79, 14);
		contentPane.add(lblNewLabel_1_4);
		
		txtten = new JTextField();
		txtten.setBounds(295, 43, 162, 20);
		contentPane.add(txtten);
		txtten.setColumns(10);
		
		txttg = new JTextField();
		txttg.setColumns(10);
		txttg.setBounds(295, 78, 162, 20);
		contentPane.add(txttg);
		
		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(295, 115, 162, 20);
		contentPane.add(txtgia);
		
		txtsl = new JTextField();
		txtsl.setColumns(10);
		txtsl.setBounds(295, 152, 162, 20);
		contentPane.add(txtsl);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("So luong mua");
		lblNewLabel_1_4_1.setBounds(206, 198, 79, 14);
		contentPane.add(lblNewLabel_1_4_1);
		
		txtslmua = new JTextField();
		txtslmua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {
					int soluongmua= Integer.valueOf(txtslmua.getText());
					Long soluong = Long.parseLong(txtsl.getText());
					long gia= Long.parseLong(txtgia.getText());
					if (soluongmua <= 0|| soluongmua > soluong) {
						JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Long tt=gia*soluongmua;
						txttt.setText(tt.toString());
						JOptionPane.showMessageDialog(null, "Số tiền bạn cần thanh toán là " +tt+" VNĐ");
					}
					}
			}
		});
		txtslmua.setColumns(10);
		txtslmua.setBounds(295, 194, 162, 20);
		contentPane.add(txtslmua);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Thanh tien");
		lblNewLabel_1_4_2.setBounds(206, 243, 79, 14);
		contentPane.add(lblNewLabel_1_4_2);
		
		txttt = new JTextField();
		txttt.setColumns(10);
		txttt.setBounds(295, 239, 162, 20);
		contentPane.add(txttt);
		
		JButton btnNewButton = new JButton("Tim Ma Sach");
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getStyle() | Font.BOLD | Font.ITALIC, btnNewButton.getFont().getSize() + 2f));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 204, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String th = JOptionPane.showInputDialog("Nhap ma sach can tim kiem");
				ArrayList<sachbean> tam = new ArrayList<sachbean>();
				try {
					tam = sBo.Tim(th);
					napbang(tam);
					}
				 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(486, 103, 123, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBan = new JButton("BAN");
		btnBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chon = JOptionPane.showConfirmDialog(null,"Bạn có muốn bán loại sách này không","Thông báo", JOptionPane.YES_NO_OPTION);
				int slmua = Integer.valueOf(txtslmua.getText());
				String masach = (String) cbbma.getSelectedItem();
				Long soluong = Long.parseLong(txtsl.getText());
				
				try {
					if (slmua <= 0|| slmua > soluong) {
						JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ vui lòng nhập lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
					else if (chon == JOptionPane.YES_OPTION) {
						String tru = Long.toString(soluong-slmua);
						ds = sBo.Ban(slmua, masach);
						txtsl.setText(tru);
						napbang(ds);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBan.setForeground(Color.BLACK);
		btnBan.setBackground(new Color(0, 204, 51));
		btnBan.setFont(btnBan.getFont().deriveFont(btnBan.getFont().getStyle() | Font.BOLD | Font.ITALIC, btnBan.getFont().getSize() + 2f));
		btnBan.setBounds(486, 185, 123, 38);
		contentPane.add(btnBan);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 303, 599, 168);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Thong tin sach", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 31, 162, 226);
		contentPane.add(scrollPane_1);
		
		
		listloai.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				loaibean loai = (loaibean)listloai.getSelectedValue();
				System.out.println(loai.getMaloai());
				try {
					ds = sBo.LietKeMaSach(loai);
					napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				cbbma.removeAllItems();
				for (sachbean sach : ds) {
					cbbma.addItem(sach.getMasach());
			}
			}
		});
		scrollPane_1.setViewportView(listloai);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EA5n Enter \u0111\u1EC3 t\u00EDnh s\u1ED1 ti\u1EC1n");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(lblNewLabel_2.getFont().deriveFont(lblNewLabel_2.getFont().getStyle() | Font.BOLD | Font.ITALIC, lblNewLabel_2.getFont().getSize() + 3f));
		lblNewLabel_2.setBounds(260, 285, 210, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ds = sBo.getsach();
					napbang(ds);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnMenu.setForeground(Color.BLACK);
		btnMenu.setFont(btnMenu.getFont().deriveFont(btnMenu.getFont().getStyle() | Font.BOLD | Font.ITALIC, btnMenu.getFont().getSize() + 2f));
		btnMenu.setBackground(new Color(0, 204, 51));
		btnMenu.setBounds(486, 31, 123, 38);
		contentPane.add(btnMenu);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
