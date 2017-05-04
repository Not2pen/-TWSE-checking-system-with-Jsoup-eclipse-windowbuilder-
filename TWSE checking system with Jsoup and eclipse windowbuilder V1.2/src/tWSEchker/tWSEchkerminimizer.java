package tWSEchker;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

final class tWSEchkerminimizer {
	public static TrayIcon minimizeicon =null;
	public static void traysupportjudge() {
		IniFrame.frmv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(SystemTray.isSupported()) {
			Image trayimage=Toolkit.getDefaultToolkit().getImage("/workspace/TWSE checking system with Jsoup and eclipse windowbuilder V1.2/src/tWSEchker/observation.png");
			ActionListener show= new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					IniFrame.frmv.setState(JFrame.NORMAL);
					IniFrame.frmv.setVisible(true);
					}

		
			};
			ActionListener exit =  new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
				
			};
			PopupMenu minimizermenu = new PopupMenu() ;
			MenuItem showupitem= new MenuItem() ;
			MenuItem exititem= new MenuItem() ;
			showupitem.addActionListener(show);
			showupitem.setLabel("show");
			minimizermenu.add(showupitem);
			exititem.addActionListener(exit);
			exititem.setLabel("exit");
			minimizermenu.add(exititem);
			minimizeicon = new TrayIcon(trayimage,"台股查詢系統",minimizermenu) ;
			minimizeicon.addActionListener(show);
			 try {
				 SystemTray.getSystemTray().remove(minimizeicon);
				 SystemTray.getSystemTray().add(minimizeicon);
	         } catch (AWTException e) {
	             System.err.println(e);
	         }
			
			
		}
		else {
			JOptionPane.showInternalMessageDialog(null, "minimize is not support!!");
		}
		} 
	 {
		
	}

}
