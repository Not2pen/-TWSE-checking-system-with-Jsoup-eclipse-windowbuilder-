package tWSEchker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
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


public class IniFrame {

	private JFrame frmv;
	private JTextField getstocknumber;
	private JLabel stockname;
	private JLabel limitdown;
	private JLabel exdividenddate;
	private JLabel limitup;
	private JLabel openingprice;
	private JLabel showstockname;
	private JLabel showlimitdown;
	private JLabel showexdividenddate;
	private JLabel showlimitup;
	private JLabel showopeningprice;
	private Document doc = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniFrame window = new IniFrame();
					window.frmv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IniFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmv = new JFrame();
		frmv.setTitle("台股基本資料查詢系統V1.0.1");
		frmv.setBounds(100, 100, 450, 300);
		frmv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmv.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel inipanel = new JPanel();
		frmv.getContentPane().add(inipanel, "name_892950514140763");
		inipanel.setLayout(null);
		inipanel.setVisible(true);
		
		
		JLabel noticeLabel = new JLabel("歡迎使用本系統，請於下方輸入欲查詢之個股編號");
		noticeLabel.setBounds(10, 0, 358, 15);
		inipanel.add(noticeLabel);
		
		getstocknumber = new JTextField();
		getstocknumber.setBounds(10, 21, 96, 21);
		inipanel.add(getstocknumber);
		getstocknumber.setColumns(10);
		
		JButton generalchkbtn = new JButton("點我查詢");
		generalchkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					doc = Jsoup.connect("http://www.tse.com.tw/ch/stock_search/stock_search.php?STK_NO=" + getstocknumber.getText())
							.userAgent("Mozilla").get();
					
					
					showstockname.setText(doc.select("td > div.til_2").text());
					showlimitup.setText(doc.select("td.basic2").eq(0).text());
					showopeningprice.setText(doc.select("td.basic2").eq(1).text());
					showlimitdown.setText(doc.select("td.basic2").eq(2).text());
					showexdividenddate.setText(doc.select("td.basic2").eq(5).text());
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		generalchkbtn.setBounds(135, 20, 87, 23);
		inipanel.add(generalchkbtn);
		
		stockname = new JLabel("個股名稱");
		stockname.setBounds(20, 52, 96, 15);
		inipanel.add(stockname);
		
		limitup = new JLabel("本日漲停價");
		limitup.setBounds(10, 76, 96, 15);
		inipanel.add(limitup);
		
		openingprice = new JLabel("本日開盤價");
		openingprice.setBounds(10, 101, 96, 15);
		inipanel.add(openingprice);
		
		limitdown = new JLabel("本日跌停價");
		limitdown.setBounds(10, 126, 96, 15);
		inipanel.add(limitdown);
		
		exdividenddate = new JLabel("上次除權息日");
		exdividenddate.setBounds(10, 151, 96, 15);
		inipanel.add(exdividenddate);
		
		showstockname = new JLabel("");
		showstockname.setBounds(111, 53, 257, 15);
		inipanel.add(showstockname);
		
		showlimitup = new JLabel("");
		showlimitup.setBounds(111, 76, 257, 15);
		inipanel.add(showlimitup);
		
		showopeningprice = new JLabel("");
		showopeningprice.setBounds(111, 101, 257, 15);
		inipanel.add(showopeningprice);
		
		showlimitdown = new JLabel("");
		showlimitdown.setBounds(111, 126, 257, 15);
		inipanel.add(showlimitdown);
		
		showexdividenddate = new JLabel("");
		showexdividenddate.setBounds(111, 151, 257, 15);
		inipanel.add(showexdividenddate);
		
		JPanel tablepanel = new JPanel();
		frmv.getContentPane().add(tablepanel, "name_892961205550540");
		tablepanel.setVisible(false);
		
		JPanel chartpanel = new JPanel();
		frmv.getContentPane().add(chartpanel, "name_892979256671928");
		chartpanel.setVisible(false);
		
	}
}
