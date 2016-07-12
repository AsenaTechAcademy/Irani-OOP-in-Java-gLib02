package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txtFileManager
{
	private String FileName;
	private int Rows;
	
	
	public txtFileManager(String FileName)
	{
		this.FileName = "myFiles/" + FileName;
		Rows = 0;
	}
	
	
	///////////////////////////////////////////////////////////////////////   DeleteRow
	public void DeleteRow(int Row)
	{
		if (Row <= 0 || Row > Rows)
			return;
		
		String S[] = getArrayFromFile();
		String newS = "";
		for (int i = 0; i < S.length; i++)
			if (i != Row - 1)
				newS = newS + S[i];
		
		setIntoFile(newS);
	}
	
	
	///////////////////////////////////////////////////////////////////////   SelectCount
	public int SelectCount()
	{
		return Rows;
	}
	
	///////////////////////////////////////////////////////////////////////   SelectCount
	private void _UpdateRows()
	{
		int c = 0;
		try
		{
			Scanner input = new Scanner(new File(FileName));
			while (input.hasNextLine())
			{
				input.nextLine();
				c++;
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		Rows = c;
	}
	
	///////////////////////////////////////////////////////////////////////   Append
	public void AppendRow(String NewRow)
	{
		String S = getFromFile();
		if (S.length() == 0)
			S = NewRow;
		else
			S = S + "\n" + NewRow;
		setIntoFile(S);
	}
	
	
	///////////////////////////////////////////////////////////////////////   setIntoFile
	private void setIntoFile(String S)
	{
		try
		{
			PrintWriter out = new PrintWriter(this.FileName);
			out.print(S);
			out.close();
			_UpdateRows();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////   getArrayFromFile	
	public String[] getArrayFromFile()
	{
		File file = new File(this.FileName);
		String S[] = new String[Rows];
		int cS = 0;
		try
		{
			Scanner input = new Scanner(file);
			while (input.hasNextLine())
			{
				S[cS++] = input.nextLine() + "\n";
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return S;
	}
	
	
	///////////////////////////////////////////////////////////////////////   getFromFile	
	private String getFromFile()
	{
		File file = new File(this.FileName);
		String S = "";
		try
		{
			Scanner input = new Scanner(file);
			while (input.hasNextLine())
			{
				if (S == "")
					S = input.nextLine();
				else
					S = S + "\n" + input.nextLine();
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return S;
	}
	
	///////////////////////////////////////////////////////////////////////   CreateFile
	public void CreateFile()
	{
		setIntoFile("");
		Rows = 0;
	}
	
	///////////////////////////////////////////////////////////////////////   Clear
	public void Clear()
	{
		CreateFile();
		Rows = 0;
	}
	
}
