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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import  java.util.Timer;

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
	private JTextField getqueyear;
	private JLabel month;
	private JTextField getquemonth;
	private JTable table;
	private JLabel tableinfolabel;
	private JButton averagechker;
	private JTable averagetable;
	private JLabel averagepanelinfolabel;
	private JButton button;
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
		frmv.setBounds(100, 100, 811, 498);
		frmv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmv.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel inipanel = new JPanel();
		frmv.getContentPane().add(inipanel, "name_892950514140763");
		inipanel.setLayout(null);
		inipanel.setVisible(true);
		
		JPanel tablepanel = new JPanel();
		frmv.getContentPane().add(tablepanel, "name_892961205550540");
		tablepanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 775, 327);
		tablepanel.add(scrollPane);
		tablepanel.setVisible(false);
		 
		
		JTable table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		 DefaultTableModel model = new DefaultTableModel(0, 0);
		 String header[] = new String[] {"日期","成交股數","成交金額","開盤價","最高價","最低價","收盤價","漲跌價差","成交筆數"} ;
		 model.setColumnIdentifiers(header);

		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JLabel tableinfolabel = new JLabel("");
		tableinfolabel.setBounds(23, 26, 762, 31);
		tablepanel.add(tableinfolabel);
		
		
		
		JPanel averagetablepanel = new JPanel();
		frmv.getContentPane().add(averagetablepanel, "name_892979256671928");
		averagetablepanel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 55, 775, 327);
		averagetablepanel.add(scrollPane_1);
		
		JTable averagetable = new JTable();
		averagetable.setSurrendersFocusOnKeystroke(true);
		averagetable.setFillsViewportHeight(true);
		averagetable.setColumnSelectionAllowed(true);
		averagetable.setCellSelectionEnabled(true);
		scrollPane_1.setViewportView(averagetable);
		averagetablepanel.setVisible(false);
		DefaultTableModel averagetablemodel = new DefaultTableModel(0, 0);
		String averageheader[] = new String[] {"日期", "收盤價"} ;
		averagetablemodel.setColumnIdentifiers(averageheader);
		averagetable.setModel(averagetablemodel);
		
		averagepanelinfolabel = new JLabel("");
		averagepanelinfolabel.setBounds(10, 21, 775, 24);
		averagetablepanel.add(averagepanelinfolabel);
		
		button = new JButton("回基本查詢");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inipanel.setVisible(true);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(false);
				model.setRowCount(0);
				averagetablemodel.setRowCount(0);
			}
		});
		button.setBounds(10, 402, 121, 23);
		averagetablepanel.add(button);
		JButton inicheckerbtn = new JButton("回基本查詢");
		inicheckerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inipanel.setVisible(true);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(false);
				model.setRowCount(0);
				averagetablemodel.setRowCount(0);
			}
		});
		inicheckerbtn.setBounds(10, 392, 121, 23);
		tablepanel.add(inicheckerbtn);
		tablepanel.setVisible(false);
		
		JLabel noticeLabel = new JLabel("歡迎使用本系統，請於下方輸入欲查詢之個股編號");
		noticeLabel.setBounds(10, 0, 358, 15);
		inipanel.add(noticeLabel);
		
		getstocknumber = new JTextField();
		getstocknumber.setBounds(10, 21, 125, 21);
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
		generalchkbtn.setBounds(150, 20, 125, 23);
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
		
		JLabel year = new JLabel("西元年");
		year.setBounds(10, 176, 46, 15);
		inipanel.add(year);
		
		getqueyear = new JTextField();
		getqueyear.setBounds(66, 173, 96, 21);
		inipanel.add(getqueyear);
		getqueyear.setColumns(10);
		
		month = new JLabel("月份");
		month.setBounds(176, 176, 46, 15);
		inipanel.add(month);
		
		getquemonth = new JTextField();
		getquemonth.setBounds(208, 173, 96, 21);
		inipanel.add(getquemonth);
		getquemonth.setColumns(10);
		
		JButton histrodatachker = new JButton("個股日成交資訊查詢");
		histrodatachker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inipanel.setVisible(false);
				tablepanel.setVisible(true);
				averagetablepanel.setVisible(false);
				try {
					doc = Jsoup.connect("http://www.twse.com.tw/ch/trading/exchange/STOCK_DAY/STOCK_DAYMAIN.php")
							.data("query_year",getqueyear.getText())
							.data("query_month",getquemonth.getText())
							.data("CO_ID",getstocknumber.getText())
							.post();
					tableinfolabel.setText("你所查詢的個股日成交資訊為 "+doc.select("thead td:eq(0)").text());
					
					Element Column1 = doc.select("tbody  td:eq(0)").first();
					Element Column2 = doc.select("tbody  td:eq(1)").first();
					Element Column3 = doc.select("tbody  td:eq(2)").first();
					Element Column4 = doc.select("tbody  td:eq(3)").first();
					Element Column5 = doc.select("tbody  td:eq(4)").first();
					Element Column6 = doc.select("tbody  td:eq(5)").first();
					Element Column7 = doc.select("tbody  td:eq(6)").first();
					Element Column8 = doc.select("tbody  td:eq(7)").first();
					Element Column9 = doc.select("tbody  td:eq(8)").first();
					Elements thestockinforow = doc.select("table  tr:gt(0)");
					//iterate each row of table
					for(int i = 0; i<=thestockinforow.size();i++ ) {
						Column1 = doc.select("tbody  td:eq(0)").get(i);
						Column2 = doc.select("tbody  td:eq(1)").get(i);
						Column3 = doc.select("tbody  td:eq(2)").get(i);
						Column4 = doc.select("tbody  td:eq(3)").get(i);
						Column5 = doc.select("tbody  td:eq(4)").get(i);
						Column6 = doc.select("tbody  td:eq(5)").get(i);
						Column7 = doc.select("tbody  td:eq(6)").get(i);
						Column8 = doc.select("tbody  td:eq(7)").get(i);
						Column9 = doc.select("tbody  td:eq(8)").get(i);
						model.addRow(new Object[]{ Column1.text(), Column2.text(), Column3.text(),
								Column4.text(), Column5.text(), Column6.text(), Column7.text(), Column8.text(), Column9.text()});
						
					}
					
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		histrodatachker.setBounds(10, 201, 294, 23);
		inipanel.add(histrodatachker);
		
		averagechker = new JButton("個股日收盤價及月平均價查詢");
		averagechker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inipanel.setVisible(false);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(true);
				try {
					doc = Jsoup.connect("http://www.twse.com.tw/ch/trading/exchange/STOCK_DAY_AVG/STOCK_DAY_AVGMAIN.php")
							.data("query_year",getqueyear.getText())
							.data("query_month",getquemonth.getText())
							.data("CO_ID",getstocknumber.getText())
							.post();
					averagepanelinfolabel.setText("你所查詢的個股日收盤價及月平均價查詢交資訊為 "+doc.select("thead td:eq(0)").text());
					
					Element avaColumn1 = doc.select("tbody  td:eq(0)").first();
					Element avaColumn2 = doc.select("tbody  td:eq(1)").first();
					
					Elements theavainforow = doc.select("table  tr:gt(0)");
					//iterate each row of table
					for(int i = 0; i<=theavainforow.size();i++ ) {
						avaColumn1 = doc.select("tbody  td:eq(0)").get(i);
						avaColumn2 = doc.select("tbody  td:eq(1)").get(i);
						
						averagetablemodel.addRow(new Object[]{ avaColumn1.text(), avaColumn2.text()});
						
					}
					
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		averagechker.setBounds(10, 234, 294, 23);
		inipanel.add(averagechker);
		
		
		
	}
}

