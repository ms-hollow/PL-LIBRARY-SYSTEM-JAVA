import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Student_Portal extends JFrame {

	private studentDisplayBooks studentDisplayBooks;
	private studentSearchBorrow studentSearchBorrow;
	private studentChangePass studentChangePass;
	private JPanel contentPane;
	private JPanel panelMainDisplayStudent;
	private JPanel MENU;
	
	private JPanel displayBookMenu;
	private JPanel searchBorrowMenu;
	private JPanel changePassMenu;
	
	private JLabel displayBooklbl;
	private JLabel studentSearchBorrowlbl;
	private JLabel studentChangePasslbl;
	
	private static CBook book = new CBook("","","","","","","",0,0,0);    //creates an instance of an object book para matawag mga methods na nasa class Book
	private static CBorrower borrower = new CBorrower("","","","","","");  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		book.retrieveBook();
		borrower.retrieveBorrower();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Portal frame = new Student_Portal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_Portal() {
		
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
		
		studentDisplayBooks = new studentDisplayBooks();
        studentDisplayBooks.setBackground(new Color(255, 245, 238));
        studentSearchBorrow = new studentSearchBorrow();
        studentSearchBorrow.setBackground(new Color(255, 245, 238));
        studentChangePass = new studentChangePass();
        studentChangePass.setBackground(new Color(255, 245, 238));
        
		panelMainDisplayStudent = new JPanel();
	    panelMainDisplayStudent.setBounds(53, 105, 1005, 480);
	    contentPane.add(panelMainDisplayStudent);
	    panelMainDisplayStudent.setLayout(null);
	    panelMainDisplayStudent.add(studentDisplayBooks);
	    panelMainDisplayStudent.add(studentSearchBorrow);
	    panelMainDisplayStudent.add(studentChangePass);
	    
	    menuClicked(studentDisplayBooks);
	    
	    MENU = new JPanel();
        MENU.setBounds(53, 66, 1005, 40);
        contentPane.add(MENU);
        MENU.setLayout(null);
        
        displayBookMenu = new JPanel();
        displayBookMenu.addMouseListener(new PanelButtonMouseAdapter(displayBookMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(studentDisplayBooks);
            }
        });
        displayBookMenu.setBackground(new Color(70, 130, 180));
        displayBookMenu.setBounds(0, 0, 335, 45);
        MENU.add(displayBookMenu);
        displayBookMenu.setLayout(null);
        
        displayBooklbl = new JLabel("Display Books");
        displayBooklbl.setForeground(new Color(255, 245, 238));
        displayBooklbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        displayBooklbl.setHorizontalAlignment(SwingConstants.CENTER);
        displayBooklbl.setBounds(80, 11, 185, 23);
        displayBookMenu.add(displayBooklbl);
        
        searchBorrowMenu = new JPanel();
        searchBorrowMenu.addMouseListener(new PanelButtonMouseAdapter(searchBorrowMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(studentSearchBorrow);
            }
        });
        searchBorrowMenu.setBackground(new Color(70, 130, 180));
        searchBorrowMenu.setBounds(335, 0, 335, 45);
        MENU.add(searchBorrowMenu);
        searchBorrowMenu.setLayout(null);

        studentSearchBorrowlbl = new JLabel("Search and Borrow Book");
        studentSearchBorrowlbl.setForeground(new Color(255, 245, 238));
        studentSearchBorrowlbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        studentSearchBorrowlbl.setHorizontalAlignment(SwingConstants.CENTER);
        studentSearchBorrowlbl.setBounds(45, 11, 239, 23);
        searchBorrowMenu.add(studentSearchBorrowlbl);
        
        changePassMenu = new JPanel();
        changePassMenu.addMouseListener(new PanelButtonMouseAdapter(changePassMenu) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuClicked(studentChangePass);
            }
        });
        changePassMenu.setBackground(new Color(70, 130, 180));
        changePassMenu.setBounds(670, 0, 335, 45);
        MENU.add(changePassMenu);
        changePassMenu.setLayout(null);
        
        studentChangePasslbl = new JLabel("Change password");
        studentChangePasslbl.setForeground(new Color(255, 245, 238));
        studentChangePasslbl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        studentChangePasslbl.setHorizontalAlignment(SwingConstants.CENTER);
        studentChangePasslbl.setBounds(43, 11, 218, 23);
        changePassMenu.add(studentChangePasslbl);
		
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
	}
	
	public void menuClicked(JPanel panel) {
		studentDisplayBooks.setVisible(false);
		studentSearchBorrow.setVisible(false);
		studentChangePass.setVisible(false);

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
