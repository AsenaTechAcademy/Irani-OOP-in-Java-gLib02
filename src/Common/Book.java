package Common;

public class Book
{
	private String BNO;
	private String Title;
	private String Author;
	private int Pages;
	private String Subject;
	
	@Override
	public String toString()
	{
		return BNO + "   " + Title + "    " + Author + "   " + Pages + "   "
				+ Subject;
	}
	
	public String getBNO()
	{
		return BNO;
	}
	
	public void setBNO(String bNO)
	{
		if (bNO.length() >= 3 && bNO.length() <= 10)
			BNO = bNO;
	}
	
	public String getTitle()
	{
		return Title;
	}
	
	public void setTitle(String title)
	{
		Title = title;
	}
	
	public String getAuthor()
	{
		return Author;
	}
	
	public void setAuthor(String author)
	{
		Author = author;
	}
	
	public int getPages()
	{
		return Pages;
	}
	
	public void setPages(int pages)
	{
		if (pages >= 10 && pages <= 1000000)
			Pages = pages;
	}
	
	public String getSubject()
	{
		return Subject;
	}
	
	public void setSubject(String subject)
	{
		Subject = subject;
	}
	
	
}
