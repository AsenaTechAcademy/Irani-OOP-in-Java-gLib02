package gLib;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class frmMain extends JFrame
{
	public frmMain()
	{
		super("gBook Manager System");
		this.setBounds(200, 100, 1000, 400);
		this.setLayout(new FlowLayout());
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new frmMain();
	}
}
