package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.dangnhapbean;
import bo.dangnhapbo;
import dao.dangnhapdao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmdangnhap extends JFrame {
	static frmdangnhap frame;
	private JPanel contentPane;
	private JTextField txtdangnhap;
	private JPasswordField password;
	dangnhapbo dnbo = new dangnhapbo();
	dangnhapdao dndao = new dangnhapdao();
	ArrayList<dangnhapbo> ds;
	public static String un="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new frmdangnhap();
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
	public frmdangnhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ten Dang Nhap");
		lblNewLabel.setBounds(20, 36, 88, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblMatKhau = new JLabel("Mat Khau");
		lblMatKhau.setBounds(20, 79, 88, 32);
		contentPane.add(lblMatKhau);
		
		txtdangnhap = new JTextField();
		txtdangnhap.setBounds(118, 42, 194, 20);
		contentPane.add(txtdangnhap);
		txtdangnhap.setColumns(10);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {
					String pass = new String(password.getPassword());
					try {
						dangnhapbean dn = dnbo.ktdn(txtdangnhap.getText(), pass);
						if(dn!=null){
							JOptionPane.showMessageDialog(null,"Ketnoi thanh cong");
							un = dn.getTenDangNhap();
							new frmBanSach().setVisible(true);
							frmketnoi.f.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null,"Sai TK Mk");
						}
					}
					catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		password.setBounds(119, 85, 193, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Dang Nhap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(password.getPassword());
				try {
					dangnhapbean dn = dnbo.ktdn(txtdangnhap.getText(), pass);
					if(dn!=null){
						JOptionPane.showMessageDialog(null,"Ketnoi thanh cong");
						un = dn.getTenDangNhap();
						new frmBanSach().setVisible(true);
//						frame.setVisible(false);
						frmketnoi.f.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,"Sai TK Mk");
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(134, 142, 105, 32);
		contentPane.add(btnNewButton);
	}
}
