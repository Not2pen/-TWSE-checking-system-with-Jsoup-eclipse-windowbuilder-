import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.lang.String;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JTextField;

public class Frame1 {

	public JFrame frame;
	public JLabel lblNewLabelFor;
	public Document doc = null;
	public JTextField textField;
	public JLabel lblNewLabel;
	public JLabel label;
	public JLabel lblNewLabel_1;
	public JLabel label_1;
	public JLabel lblNewLabel_2;
	public JLabel label_2;
	public JLabel label_3;
	public JLabel label_4;
	public JLabel label_5;
	public JLabel label_6;
	public JTextField textField_1;
	public JTextField textField_2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("台股基本資料查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
			try {
				doc = Jsoup.connect("http://www.tse.com.tw/ch/stock_search/stock_search.php?STK_NO=" + textField.getText()).userAgent("Mozilla").get();
				String title=doc.title();
				lblNewLabelFor.setText(title);
				lblNewLabel_2.setText(doc.select("td > div.til_2").text());
				label_2.setText(doc.select("td.basic2").eq(0).text());
				label_3.setText(doc.select("td.basic2").eq(1).text());
				label_4.setText(doc.select("td.basic2").eq(2).text());
				label_6.setText(doc.select("td.basic2").eq(5).text());
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(10, 145, 182, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabelFor = new JLabel("請輸入欲查詢的個股編號");
		lblNewLabelFor.setBounds(10, 10, 172, 15);
		frame.getContentPane().add(lblNewLabelFor);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("本日漲停");
		lblNewLabel.setBounds(10, 71, 78, 15);
		frame.getContentPane().add(lblNewLabel);
		
		label = new JLabel("開盤競價基準");
		label.setBounds(10, 89, 78, 15);
		frame.getContentPane().add(label);
		
		lblNewLabel_1 = new JLabel("本日跌停");
		lblNewLabel_1.setBounds(10, 108, 78, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		label_1 = new JLabel("查詢個股名稱");
		label_1.setBounds(10, 54, 103, 15);
		frame.getContentPane().add(label_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(120, 54, 304, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		label_2 = new JLabel("");
		label_2.setBounds(120, 71, 150, 15);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(120, 89, 182, 15);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("");
		label_4.setBounds(120, 108, 182, 15);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("最近一次除權息交易日");
		label_5.setBounds(10, 125, 137, 15);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(157, 125, 220, 15);
		frame.getContentPane().add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(46, 178, 67, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 178, 78, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("個股日收盤價及月平均價查詢");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				
			}
		});
		btnNewButton_1.setBounds(10, 209, 210, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("西元年");
		lblNewLabel_3.setBounds(10, 178, 46, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("月份");
		lblNewLabel_4.setBounds(116, 181, 29, 15);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
