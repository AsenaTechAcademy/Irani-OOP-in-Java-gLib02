package gLib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Common.Book;
import Managers.BooksManager;

public class frmBook extends JFrame
{
	private JLabel lblBNO;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblPages;
	private JLabel lblSubject;
	
	private JTextField txtBNO;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPages;
	private JTextField txtSubject;
	
	private JTextArea list;
	
	private JButton btnInsertBook;
	
	private JPanel insertpanel;
	
	public frmBook()
	{
		super("Book");
		this.setBounds(200, 100, 1000, 700);
		this.setLayout(new FlowLayout());
		
		lblBNO = new JLabel("شماره کتاب :");
		lblTitle = new JLabel("عنوان کتاب :");
		lblAuthor = new JLabel("نویسنده کتاب :");
		lblPages = new JLabel("تعداد صفحات :");
		lblSubject = new JLabel("موضوع کتاب :");
		
		txtBNO = new JTextField();
		txtBNO.setPreferredSize(new Dimension(130, 20));
		txtTitle = new JTextField();
		txtTitle.setPreferredSize(new Dimension(130, 20));
		txtAuthor = new JTextField();
		txtAuthor.setPreferredSize(new Dimension(130, 20));
		txtPages = new JTextField();
		txtPages.setPreferredSize(new Dimension(130, 20));
		txtSubject = new JTextField();
		txtSubject.setPreferredSize(new Dimension(130, 20));
		
		//////////////////////////// insertpanel
		insertpanel = new JPanel();
		insertpanel.setPreferredSize(new Dimension(300, 200));
		insertpanel.setBackground(Color.green);
		
		insertpanel.add(txtBNO);
		insertpanel.add(lblBNO);
		insertpanel.add(txtTitle);
		insertpanel.add(lblTitle);
		insertpanel.add(txtAuthor);
		insertpanel.add(lblAuthor);
		insertpanel.add(txtPages);
		insertpanel.add(lblPages);
		insertpanel.add(txtSubject);
		insertpanel.add(lblSubject);
		
		btnInsertBook = new JButton("ثبت کتاب");
		btnInsertBook.setPreferredSize(new Dimension(200, 30));
		
		
		btnInsertBook.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Book b = new Book();
				b.setBNO(txtBNO.getText());
				b.setTitle(txtTitle.getText());
				b.setAuthor(txtAuthor.getText());
				b.setPages(Integer.parseInt(txtPages.getText()));
				b.setSubject(txtSubject.getText());
				
				BooksManager bm = new BooksManager();
				bm.Insert(b);
				
				Book[] books = bm.SelectAll();
				String S = "";
				for (int i = 0; i < books.length; i++)
					S = S + books[i].toString() + "\n";
				list.setText(S);
				
				JOptionPane.showMessageDialog(null, "اطلاعات کتاب ثبت گردید",
						"مدیریت کتابخانه: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		
		insertpanel.add(btnInsertBook);
		
		this.add(insertpanel);
		
		list = new JTextArea(20, 80);
		list.setEditable(false);
		this.add(list);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new frmBook();
	}
}
