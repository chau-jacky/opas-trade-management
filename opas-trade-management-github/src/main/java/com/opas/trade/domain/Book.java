package com.opas.trade.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement(name = "book")
@XmlType(propOrder = { "bookId", "bookName", "bookDescription", "bookIndicator", "offshoreRmbIndicator" })
public class Book {

	@Id
//	@SequenceGenerator(name = "book_generator", sequenceName = "book_sequence", initialValue = 23)
//	@GeneratedValue(generator = "book_generator")
	private Long bookId;

	@Column(nullable = false)
	private String bookName;

	@Column(nullable = false)
	private String bookDescription;

	@Column(nullable = false)
	private BookIndicator bookIndicator;

	@Column(nullable = false)
	private boolean offshoreRmbIndicator;

	@XmlAttribute(name = "bookId")
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@XmlElement(name = "bookName")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@XmlElement(name = "bookDescription")
	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	@XmlElement(name = "bookIndicator")
	public BookIndicator getBookIndicator() {
		return bookIndicator;
	}

	public void setBookIndicator(BookIndicator bookIndicator) {
		this.bookIndicator = bookIndicator;
	}

	@XmlElement(name = "offshoreRmbIndicator")
	public boolean isOffshoreRmbIndicator() {
		return offshoreRmbIndicator;
	}

	public void setOffshoreRmbIndicator(boolean offshoreRmbIndicator) {
		this.offshoreRmbIndicator = offshoreRmbIndicator;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookDescription=" + bookDescription
				+ ", bookIndicator=" + bookIndicator + ", offshoreRmbIndicator=" + offshoreRmbIndicator + "]";
	}

}
