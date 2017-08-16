package com.jk.entity.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_books")
public class Book {
	@Id
	@Column(name="t_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer bookId;
	
	@Column(name="t_name")
	public String  bookName;
	
	@Column(name="t_price")
	public String  bookPrice;
	
	
	public String bookImg;
	
	@Column(name="book_MD5")
	public String bookMD5;

	public String getBookMD5() {
		return bookMD5;
	}

	public void setBookMD5(String bookMD5) {
		this.bookMD5 = bookMD5;
	}

	

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", bookImg=" + bookImg
				+ ", bookMD5=" + bookMD5 + "]";
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}


	
}
