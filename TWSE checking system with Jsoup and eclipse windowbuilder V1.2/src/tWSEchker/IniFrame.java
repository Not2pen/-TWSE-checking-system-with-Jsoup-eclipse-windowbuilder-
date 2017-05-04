package tWSEchker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.lang.String;
import java.io.IOException;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.JRadioButton;


public class IniFrame  {

	public static JFrame frmv;
	private JTextField getstocknumber;
	private JLabel showstockname;
	private JLabel showlimitdown;
	private JLabel showexdividenddate;
	private JLabel showlimitup;
	private JLabel showopeningprice;
	private Document doc = null;
	private JTextField getqueyear;
	private JTextField getquemonth;
	
	
	private JLabel averagepanelinfolabel;
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
	Connection connection = null;
	private JPanel reminderpanel;
	/**
	 * @wbp.nonvisual location=38,-31
	 */
	private final JTextField textField = new JTextField();
	private JTable thesqltable;
	private JTextField remindergetstocknumber;
	private JLabel remindersettarget;
	private JTextField remindertagetprice;
	private JLabel lblNewLabel;
	public IniFrame() {
		initialize();
		connection = Thesqlconnector.dbconnector();
		JOptionPane.showMessageDialog(null, "本程式之圖式來自http://www.flaticon.com/　作者：freepik");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		textField.setColumns(10);
		frmv = new JFrame();
		frmv.setTitle("台股基本資料查詢系統V1.0.1");
		frmv.setBounds(100, 100, 338, 344);
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
		 
		
		final JTable table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		 DefaultTableModel model = new DefaultTableModel(0, 0);
		 final String header[] = new String[] {"日期","成交股數","成交金額","開盤價","最高價","最低價","收盤價","漲跌價差","成交筆數"} ;
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
		
		final JTable averagetable = new JTable();
		averagetable.setSurrendersFocusOnKeystroke(true);
		averagetable.setFillsViewportHeight(true);
		averagetable.setColumnSelectionAllowed(true);
		averagetable.setCellSelectionEnabled(true);
		scrollPane_1.setViewportView(averagetable);
		averagetablepanel.setVisible(false);
		DefaultTableModel averagetablemodel = new DefaultTableModel(0, 0);
		final String averageheader[] = new String[] {"日期", "收盤價"} ;
		averagetablemodel.setColumnIdentifiers(averageheader);
		averagetable.setModel(averagetablemodel);
		
		averagepanelinfolabel = new JLabel("");
		averagepanelinfolabel.setBounds(10, 21, 775, 24);
		averagetablepanel.add(averagepanelinfolabel);
		
		final JButton button = new JButton("回基本查詢");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmv.setSize(330, 340);
				inipanel.setVisible(true);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(false);
				
				averagetablemodel.setRowCount(0);
				getstocknumber.setEditable(true);
				getqueyear.setEditable(true);
				getquemonth.setEditable(true);
				System.gc();
			}
		});
		button.setBounds(10, 402, 121, 23);
		averagetablepanel.add(button);
		final JButton inicheckerbtn = new JButton("回基本查詢");
		inicheckerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmv.setSize(330, 340);
				inipanel.setVisible(true);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(false);
				model.setRowCount(0);
				System.gc();
				getstocknumber.setEditable(true);
				getqueyear.setEditable(true);
				getquemonth.setEditable(true);
				
			}
		});
		inicheckerbtn.setBounds(10, 392, 121, 23);
		tablepanel.add(inicheckerbtn);
		tablepanel.setVisible(false);
		
		final JLabel noticeLabel = new JLabel("歡迎使用本系統，請於下方輸入欲查詢之個股編號");
		noticeLabel.setBounds(10, 0, 358, 15);
		inipanel.add(noticeLabel);
		
		getstocknumber = new JTextField();
		getstocknumber.setBounds(10, 21, 125, 21);
		inipanel.add(getstocknumber);
		getstocknumber.setColumns(10);
		
		final JButton generalchkbtn = new JButton("點我查詢");
		generalchkbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					doc = Jsoup.connect("http://www.tse.com.tw/ch/stock_search/stock_search.php?STK_NO=" + getstocknumber.getText()).get();
					
					
					showstockname.setText(doc.select("td > div.til_2").text());
					showstockname.setToolTipText(doc.select("td > div.til_2").text());
					showlimitup.setText(doc.select("td.basic2").eq(0).text());
					showopeningprice.setText(doc.select("td.basic2").eq(1).text());
					showlimitdown.setText(doc.select("td.basic2").eq(2).text());
					showexdividenddate.setText(doc.select("td.basic2").eq(5).text());
					
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
				System.gc();
			}
		});
		generalchkbtn.setBounds(150, 20, 125, 23);
		inipanel.add(generalchkbtn);
		
		final JLabel stockname = new JLabel("個股名稱");
		stockname.setBounds(20, 52, 96, 15);
		inipanel.add(stockname);
		
		final JLabel limitup = new JLabel("本日漲停價");
		limitup.setBounds(10, 76, 96, 15);
		inipanel.add(limitup);
		
		final JLabel openingprice = new JLabel("本日開盤價");
		openingprice.setBounds(10, 101, 96, 15);
		inipanel.add(openingprice);
		
		final JLabel limitdown = new JLabel("本日跌停價");
		limitdown.setBounds(10, 126, 96, 15);
		inipanel.add(limitdown);
		
		final JLabel exdividenddate = new JLabel("上次除權息日");
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
		
		final JLabel year = new JLabel("西元年");
		year.setBounds(10, 176, 46, 15);
		inipanel.add(year);
		
		getqueyear = new JTextField();
		getqueyear.setBounds(66, 173, 96, 21);
		inipanel.add(getqueyear);
		getqueyear.setColumns(10);
		
		final JLabel month = new JLabel("月份");
		month.setBounds(176, 176, 46, 15);
		inipanel.add(month);
		
		getquemonth = new JTextField();
		getquemonth.setBounds(208, 173, 96, 21);
		inipanel.add(getquemonth);
		getquemonth.setColumns(10);
		
		final JButton histrodatachker = new JButton("個股日成交資訊查詢");
		histrodatachker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inipanel.setVisible(false);
				tablepanel.setVisible(true);
				averagetablepanel.setVisible(false);
				try {
					frmv.setSize(810, 500);
					doc = Jsoup.connect("http://www.twse.com.tw/ch/trading/exchange/STOCK_DAY/STOCK_DAYMAIN.php")
							.data("query_year",getqueyear.getText())
							.data("query_month",getquemonth.getText())
							.data("CO_ID",getstocknumber.getText())
							.post();
					tableinfolabel.setText("你所查詢的個股日成交資訊為 "+doc.select("thead td:eq(0)").text());
					
					
					Elements thestockinforow = doc.select("table  tr:gt(0)");
					int colnum = thestockinforow.size()-1;
					//iterate each row of table
					for(int i = 0; i<=colnum ;i++ ) {
						
						model.addRow(new Object[]{ 
								doc.select("tbody  td:eq(0)").get(i).text(), 
								doc.select("tbody  td:eq(1)").get(i).text(), 
								doc.select("tbody  td:eq(2)").get(i).text(),
								doc.select("tbody  td:eq(3)").get(i).text(),
								doc.select("tbody  td:eq(4)").get(i).text(),
								doc.select("tbody  td:eq(5)").get(i).text(),
								doc.select("tbody  td:eq(6)").get(i).text(),
								doc.select("tbody  td:eq(7)").get(i).text(), 
								doc.select("tbody  td:eq(8)").get(i).text()});
						getstocknumber.setEditable(false);
						getqueyear.setEditable(false);
						getquemonth.setEditable(false);
						
					}
					
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
				System.gc();
			}
		});
		histrodatachker.setBounds(10, 201, 294, 23);
		inipanel.add(histrodatachker);
		
		final JButton averagechker = new JButton("個股日收盤價及月平均價查詢");
		averagechker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				inipanel.setVisible(false);
				tablepanel.setVisible(false);
				averagetablepanel.setVisible(true);
				try {
					frmv.setSize(810, 500);
					doc = Jsoup.connect("http://www.twse.com.tw/ch/trading/exchange/STOCK_DAY_AVG/STOCK_DAY_AVGMAIN.php")
							.data("query_year",getqueyear.getText())
							.data("query_month",getquemonth.getText())
							.data("CO_ID",getstocknumber.getText())
							.post();
					averagepanelinfolabel.setText("你所查詢的個股日收盤價及月平均價查詢交資訊為 "+doc.select("thead td:eq(0)").text());
					
					
					
					
					Elements theavainforow = doc.select("table  tr:gt(0)");
					int avacolnum = theavainforow.size()-1;
					//iterate each row of table
					for(int i = 0; i<=avacolnum ;i++ ) {
						averagetablemodel.addRow(new Object[]{ doc.select("tbody  td:eq(0)").get(i).text(), doc.select("tbody  td:eq(1)").get(i).text()});
						
					}
					getstocknumber.setEditable(false);
					getqueyear.setEditable(false);
					getquemonth.setEditable(false);
					
				}
				catch (IOException e) {
					
					e.printStackTrace();
				}
				System.gc();
				
			}
		});
		averagechker.setBounds(10, 234, 294, 23);
		inipanel.add(averagechker);
		
		final JButton Minimizebutton = new JButton("最小化到系統列");
		Minimizebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmv.dispose();
				tWSEchkerminimizer.traysupportjudge();
				getstocknumber.setEditable(false);
				getqueyear.setEditable(false);
				getquemonth.setEditable(false);
				
				System.gc();
			}
		});
		Minimizebutton.setBounds(10, 267, 294, 23);
		inipanel.add(Minimizebutton);
		
		reminderpanel = new JPanel();
		frmv.getContentPane().add(reminderpanel, "name_723687017625532");
		reminderpanel.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(779, 316, -761, -281);
		reminderpanel.add(scrollPane_2);
		
		thesqltable = new JTable();
		scrollPane_2.setViewportView(thesqltable);
		
		JLabel reminderinfostocknumber = new JLabel("請選擇你所要追蹤的股票編號");
		reminderinfostocknumber.setBounds(10, 357, 162, 15);
		reminderpanel.add(reminderinfostocknumber);
		
		remindergetstocknumber = new JTextField();
		remindergetstocknumber.setBounds(182, 354, 96, 21);
		reminderpanel.add(remindergetstocknumber);
		remindergetstocknumber.setColumns(10);
		
		remindersettarget = new JLabel("當成交價");
		remindersettarget.setBounds(288, 357, 59, 15);
		reminderpanel.add(remindersettarget);
		
		JRadioButton remindercondictiongreaterthan = new JRadioButton("高於");
		remindercondictiongreaterthan.setBounds(342, 353, 49, 23);
		reminderpanel.add(remindercondictiongreaterthan);
		
		JRadioButton remindercondictionlowerthan = new JRadioButton("低於");
		remindercondictionlowerthan.setBounds(393, 353, 49, 23);
		reminderpanel.add(remindercondictionlowerthan);
		
		remindertagetprice = new JTextField();
		remindertagetprice.setBounds(448, 354, 96, 21);
		reminderpanel.add(remindertagetprice);
		remindertagetprice.setColumns(10);
		
		lblNewLabel = new JLabel("元時，通知我");
		lblNewLabel.setBounds(554, 357, 78, 15);
		reminderpanel.add(lblNewLabel);
		
		JButton savereminderintotable = new JButton("存檔");
		savereminderintotable.setBounds(642, 353, 87, 23);
		reminderpanel.add(savereminderintotable);
		
		

		System.gc();
		
	}
}

