package test;

import java.util.List;
import java.util.Scanner;

import dao.Dao;
import pojo.Book;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(Book book) 
	{
		System.out.print("Book id	:	");
		book.setBookId(sc.nextInt());
		System.out.print("Subject Name	:	");
		sc.nextLine();
		book.setSubjectName(sc.nextLine());
		System.out.print("Book Name	:	");
		book.setBookName(sc.nextLine());
		System.out.print("Author Name	:	");
		book.setAuthorName(sc.nextLine());
		System.out.print("Price	:	");
		book.setPrice(sc.nextFloat());
	}
	
	private static void acceptRecord(String[] name)
	{
		System.out.println("Enter the name of the book");
		sc.nextLine();
		name[0]=sc.nextLine();
	}
	private static void printRecord(List<Book> books)
	{
		if( books != null )
		{
			for (Book book : books) 
				System.out.println(book.toString());
		}
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Insert Book");
		System.out.println("2.Update Book");
		System.out.println("3.Delete Book");
		System.out.println("4.Display All Books");
		System.out.println("5.Find Book");
		System.out.println("6.Issue Book");
		System.out.println("7.Change Rack");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		try( Dao dao = new Dao())
		{
			int choice, bookId,memberId;
			float price;
			String[] name=new String[1];
			while( ( choice = Program.menuList( ) ) != 0 )
			{
				switch( choice )
				{
				case 1:
					Book book = new Book();
					Program.acceptRecord( book );
					dao.insert( book );
					break;
				case 2:
					System.out.print("Enter book id	:	");
					bookId = sc.nextInt();
					System.out.print("Enter price	:	");
					price = sc.nextFloat();
					dao.update( bookId, price );
					break;
				case 3:
					System.out.print("Enter book id	:	");
					dao.delete( sc.nextInt() );
					break;
				case 4:
					List<Book> books = dao.getBooks();
					Program.printRecord( books );
					break;
					
				case 5:
					Program.acceptRecord(name);
					List<Book> list=dao.findRecord(name[0]);
					break;
				case 6:
					System.out.print("Enter member id	:	");
					memberId = sc.nextInt();
					System.out.print("Enter book id	:	");
					bookId = sc.nextInt();
					dao.issueCopy(memberId,bookId);
					break;
					
				case 7:
					
					break;
				}
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
