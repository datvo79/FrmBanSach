package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.KetNoiBo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmketnoi extends JFrame {

	private JPanel contentPane;
	private JTextField txtserver;
	private JTextField txtdata;
	private JTextField txtuser;
	private JPasswordField password;
	static frmketnoi frame ;
	public static frmdangnhap f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new frmketnoi();
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
	public frmketnoi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sever Name");
		lblNewLabel.setBounds(10, 26, 99, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setBounds(10, 72, 99, 24);
		contentPane.add(lblDatabase);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(10, 121, 99, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 173, 99, 24);
		contentPane.add(lblPassword);
		
		txtserver = new JTextField();
		txtserver.setText("DESKTOP-VPF0AQ3\\MSSQLSERVER1");
		txtserver.setBounds(92, 28, 194, 20);
		contentPane.add(txtserver);
		txtserver.setColumns(10);
		
		txtdata = new JTextField();
		txtdata.setText("QlSach");
		txtdata.setColumns(10);
		txtdata.setBounds(92, 74, 194, 20);
		contentPane.add(txtdata);
		
		txtuser = new JTextField();
		txtuser.setText("sa");
		txtuser.setColumns(10);
		txtuser.setBounds(92, 123, 194, 20);
		contentPane.add(txtuser);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==10) {
					try {
						KetNoiBo kn = new KetNoiBo();
						String pass = new String(password.getPassword());
						kn.ketnoi(txtserver.getText(), txtdata.getText(), txtuser.getText(),pass);
						f = new frmdangnhap();
						f.setVisible(true);
						frame.setVisible(false);
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		password.setBounds(92, 175, 194, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					KetNoiBo kn = new KetNoiBo();
					String pass = new String(password.getPassword());
					kn.ketnoi(txtserver.getText(), txtdata.getText(), txtuser.getText(),pass);
					f = new frmdangnhap();
					f.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(151, 221, 106, 37);
		contentPane.add(btnNewButton);
	}
}
