import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Admin_Portal extends JFrame {

    private JPanel contentPane;
    private manageBookRecords manageBookRecords;
    private manageTransactionRecords manageTransactionRecords;
    private manageStudentRecords manageStudentRecords;
    private JPanel MENU;
    private JPanel bookRecMenu;
    private JPanel transactionRecMenu;
    private JPanel studentRecMenu;
    private JLabel lblmanageBook;
    private JLabel lblmanageTransac;
    private JLabel lblManageStudentRecords;
    private JButton btnNewButton;
    private JPanel panelMainDisplay;
    
    private JLabel ADMINlbl;
    
    private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book

    public static void main(String[] args) {
    	
    	//--------MAIN MAGRE-RETRIEVE NG LIST---------------//
    	book.retrieveBook();
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin_Portal frame = new Admin_Portal();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Admin_Portal() {
    	
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1125, 670);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon refreshIcon = new ImageIcon(this.getClass().getResource("/assets/reload.png")); // load the image to a imageIcon
		Image refresh = refreshIcon.getImage(); // transform it 
		Image newrefresh = refresh.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		refreshIcon = new ImageIcon(newrefresh);
		getContentPane().setLayout(null);
		
		ImageIcon logOutIcon = new ImageIcon(this.getClass().getResource("/assets/logout.png")); // load the image to a imageIcon
		Image logOut = logOutIcon.getImage(); // transform it 
		Image newlogOut = logOut.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
		logOutIcon = new ImageIcon(newlogOut);
		getContentPane().setLayout(null);

        manageBookRecords = new manageBookRecords();
        manageBookRecords.setBackground(new Color(255, 245, 238));
        manageTransactionRecords = new manageTransactionRecords();
        manageTransactionRecords.setBackground(new Color(255, 245, 238));
        manageStudentRecords = new manageStudentRecords();
        manageStudentRecords.setBackground(new Color(255, 245, 238));

        panelMainDisplay = new JPanel();
        panelMainDisplay.setBounds(53, 105, 1005, 480);
        contentPane.add(panelMainDisplay);
        panelMainDisplay.setLayout(null);
        panelMainDisplay.add(manageBookRecords);
        panelMainDisplay.add(manageTransactionRecords);
        panelMainDisplay.add(manageStudentRecords);

        menuClicked(manageBookRecords);

        MENU = new JPanel();
        MENU.setBounds(53, 66, 1005, 40);
        contentPane.add(MENU);
        MENU.setLayout(null);

        bookRecMenu = new JPanel();
        bookRecMenu.addMouseListener(new PanelButtonMouseAdapter(bookRecMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(manageBookRecords);
            }
        });
        bookRecMenu.setBackground(new Color(70, 130, 180));
        bookRecMenu.setBounds(0, 0, 335, 45);
        MENU.add(bookRecMenu);
        bookRecMenu.setLayout(null);

        lblmanageBook = new JLabel("Manage Book Records");
        lblmanageBook.setForeground(new Color(255, 245, 238));
        lblmanageBook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        lblmanageBook.setHorizontalAlignment(SwingConstants.CENTER);
        lblmanageBook.setBounds(80, 11, 185, 23);
        bookRecMenu.add(lblmanageBook);

        transactionRecMenu = new JPanel();
        transactionRecMenu.addMouseListener(new PanelButtonMouseAdapter(transactionRecMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(manageTransactionRecords);
            }
        });
        transactionRecMenu.setBackground(new Color(70, 130, 180));
        transactionRecMenu.setBounds(335, 0, 335, 45);
        MENU.add(transactionRecMenu);
        transactionRecMenu.setLayout(null);

        lblmanageTransac = new JLabel("Manage Transaction Records");
        lblmanageTransac.setForeground(new Color(255, 245, 238));
        lblmanageTransac.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        lblmanageTransac.setHorizontalAlignment(SwingConstants.CENTER);
        lblmanageTransac.setBounds(45, 11, 239, 23);
        transactionRecMenu.add(lblmanageTransac);

        studentRecMenu = new JPanel();
        studentRecMenu.addMouseListener(new PanelButtonMouseAdapter(studentRecMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(manageStudentRecords);
            }
        });
        studentRecMenu.setBackground(new Color(70, 130, 180));
        studentRecMenu.setBounds(670, 0, 335, 45);
        MENU.add(studentRecMenu);
        studentRecMenu.setLayout(null);

        lblManageStudentRecords = new JLabel("Manage Student Records");
        lblManageStudentRecords.setForeground(new Color(255, 245, 238));
        lblManageStudentRecords.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        lblManageStudentRecords.setHorizontalAlignment(SwingConstants.CENTER);
        lblManageStudentRecords.setBounds(43, 11, 218, 23);
        studentRecMenu.add(lblManageStudentRecords);
        
        JLabel logoutImg = new JLabel();
		logoutImg.setBounds(1033, 30, 25, 34);
		logoutImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//logout or exit
				LoginFrame login = new LoginFrame();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		
		contentPane.setLayout(null);
		logoutImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		getContentPane().add(logoutImg);
		logoutImg.setIconTextGap(0);
		logoutImg.setIcon(logOutIcon);
		
		ADMINlbl = new JLabel("ADMIN");
		ADMINlbl.setFont(new Font("Segoe UI", Font.BOLD, 30));
		ADMINlbl.setBounds(53, 21, 106, 34);
		contentPane.add(ADMINlbl);
    }

    public void menuClicked(JPanel panel) {
        manageBookRecords.setVisible(false);
        manageTransactionRecords.setVisible(false);
        manageStudentRecords.setVisible(false);

        panel.setVisible(true);
    }

    private class PanelButtonMouseAdapter extends MouseAdapter {
        JPanel panel;

        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }

        public void mouseEntered(MouseEvent e) {
        	panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.setBackground(new Color(0, 0, 139));
        }

        public void mouseExited(MouseEvent e) {
        	panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.setBackground(new Color(70, 130, 180));
        }

        public void mousePressed(MouseEvent e) {
        	panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.setBackground(new Color(70, 130, 180));
        }

        public void mouseReleased(MouseEvent e) {
        	panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.setBackground(new Color(70, 130, 180));
        }
    }
}
