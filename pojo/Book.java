package pojo;

public class Book implements Comparable<Book>
{
		private int bookId;
		private String subjectName, bookName, authorName,isbn;
		private float price;
		
		public Book()
		{}

		public Book(int bookId, String subjectName, String bookName, String authorName, String isbn, float price) {
			this.bookId = bookId;
			this.subjectName = subjectName;
			this.bookName = bookName;
			this.authorName = authorName;
			this.isbn = isbn;
			this.price = price;
		}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getSubjectName() {
			return subjectName;
		}

		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthorName() {
			return authorName;
		}

		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}
		
		@Override
		public String toString() 
		{
			return String.format("%-5d%-20s%-60s%-30s%-15s%-10.2f\n", this.bookId, this.subjectName, this.bookName, this.authorName,this.isbn, this.price);
		}

		@Override
		public int compareTo(Book other) {
			// TODO Auto-generated method stub
			return this.bookId - other.bookId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bookId;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (bookId != other.bookId)
				return false;
			return true;
		}
		
		
}
