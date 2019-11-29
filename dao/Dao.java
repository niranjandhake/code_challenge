package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class Dao implements Closeable
{
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement selectStatement;
	private PreparedStatement issueStatement;
	public Dao()throws Exception
	{
		this.connection = DBUtils.getConnection();
		this.insertStatement = connection.prepareStatement("INSERT INTO books VALUES(?,?,?,?,?)");
		this.updateStatement = connection.prepareStatement("UPDATE books SET price=? WHERE bookid=?");
		this.deleteStatement = connection.prepareStatement("DELETE FROM books WHERE bookid=?");
		this.selectStatement = connection.prepareStatement("SELECT * FROM books");
		this.issueStatement = connection.prepareStatement("SELECT * FROM copies where bookid=?");
	}
	public int insert(Book book)throws Exception
	{
		this.insertStatement.setInt(1, book.getBookId());
		this.insertStatement.setString(2, book.getSubjectName());
		this.insertStatement.setString(3, book.getBookName());
		this.insertStatement.setString(4, book.getAuthorName());
		this.insertStatement.setString(5, book.getIsbn());
		this.insertStatement.setFloat(6, book.getPrice());
		return this.insertStatement.executeUpdate();
	}
	public int update(int bookId, float price)throws Exception
	{
		this.updateStatement.setFloat(1, price);
		this.updateStatement.setInt(2, bookId);
		return this.updateStatement.executeUpdate();
	}
	public int delete(int bookId) throws Exception
	{
		this.deleteStatement.setInt(1, bookId);
		return this.deleteStatement.executeUpdate();
	}
	public List<Book> getBooks()throws Exception
	{
		List<Book> bookList = new ArrayList<Book>();
		try( ResultSet rs = this.selectStatement.executeQuery())
		{
			while( rs.next())
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
				bookList.add(book);
			}
		}
		return bookList;
	}
	@Override
	public void close() throws IOException 
	{
		try
		{
			this.insertStatement.close();
			this.updateStatement.close();
			this.deleteStatement.close();
			this.selectStatement.close();
			this.connection.close();
		}
		catch( SQLException cause )
		{
			throw new IOException(cause);
		}
	}
	public List<Book> findRecord(String bookName) throws SQLException 
	{
		List<Book> list = new ArrayList<>();
		Book book = new Book();
		book.setBookName(bookName);
		this.selectStatement.execute();
		ResultSet rs=this.selectStatement.getResultSet();
		while(rs.next())
		{
			for (Book book2 : list)
			{
				book2.setBookId(rs.getInt(1));
				book2.setSubjectName(rs.getString(2));
				book2.setBookName(rs.getString(3));
				book2.setAuthorName(rs.getString(4));
				book2.setIsbn(rs.getString(5));
				book2.setPrice(rs.getFloat(6));
				list.add(book2);
			}		
		}
//		if(this.list.contains(bookName))
//		{
//			int index = this.list.indexOf(bookName);
//			return this.list.get(index);
//		}
				
		return null;
	}
	public void issueCopy(int memberId, int bookId) throws Exception 
	{
		ResultSet rs=this.issueStatement.executeQuery();
		while(rs.next())
		{
			System.out.printf("%-5d%-10ds%-20s%-10d%\n",rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
		}
		System.out.println();
	}
	
	
	
	
	
}
