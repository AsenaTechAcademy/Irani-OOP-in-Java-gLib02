package Managers;

import Common.Book;
import Common.Commons;
import FileManager.txtFileManager;

public class BooksManager
{
	private txtFileManager fm;
	
	public BooksManager()
	{
		fm = new txtFileManager("Books.txt");
		//fm.CreateFile();
	}
	
	
	public void Insert(Book b)
	{
		String S = b.getBNO() + Commons.SPILITTER + b.getTitle()
				+ Commons.SPILITTER + b.getAuthor() + Commons.SPILITTER
				+ b.getPages() + Commons.SPILITTER + b.getSubject();
		
		
		fm.AppendRow(S);
	}
	
	private Book Str2Book(String S)
	{
		String A[] = S.split(Commons.SPILITTER);
		Book b = new Book();
		
		b.setBNO(A[0]);
		b.setTitle(A[1]);
		b.setAuthor(A[2]);
		b.setPages(Integer.parseInt(A[3]));
		b.setSubject(A[4]);
		
		return b;
	}
	
	public Book[] SelectAll()
	{
		String S[] = fm.getArrayFromFile();
		
		Book b[] = new Book[S.length];
		for (int i = 0; i < S.length; i++)
			b[i] = Str2Book(S[i]);
		
		
		return b;
	}
	
	
}
