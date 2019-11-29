package pojo;

import java.util.Date;

public class IssueDetails
{
	private int bookId;
	private String bookName;
	private float fineAmount;
	private Date issueDate,dueDate,returnDate;
	
	public IssueDetails()
	{
		
	}

	public IssueDetails(int bookId, String bookName, float fineAmount, Date issueDate, Date dueDate, Date returnDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.fineAmount = fineAmount;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	
}
