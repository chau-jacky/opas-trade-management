package com.opas.trade.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlRootElement(name = "trade")
@XmlType(propOrder = { "tradeId", "sourceSystemReferenceId", "sourceSystemName", "transactionReference", "valueDate",
		"captureDate", "status", "counterparty", "book", "channel", "borkerId", "dealerId" })
public class Trade implements Serializable {

	private static final long serialVersionUID = 2046451316297333458L;

	@Id
//	@SequenceGenerator(name = "trade_generator", sequenceName = "trade_sequence", initialValue = 23)
//	@GeneratedValue(generator = "trade_generator")
	private Long tradeId;

	@Column(nullable = false)
	private String sourceSystemReferenceId;

	@Column(nullable = false)
	private String sourceSystemName;

	@Column(nullable = false)
	private String transactionReference;

	@Column(nullable = false)
	private Date valueDate;

	@Column(nullable = false)
	private Date captureDate;

	@Column(nullable = false)
	private String status;

	@Column(nullable = false)
	private String counterparty;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@Column(nullable = false)
	private String channel;

	@Column(nullable = false)
	private Long borkerId;

	@Column(nullable = false)
	private Long dealerId;

	@XmlElement(name = "tradeId")
	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	@XmlElement(name = "sourceSystemReferenceId")
	public String getSourceSystemReferenceId() {
		return sourceSystemReferenceId;
	}

	public void setSourceSystemReferenceId(String sourceSystemReferenceId) {
		this.sourceSystemReferenceId = sourceSystemReferenceId;
	}

	@XmlElement(name = "sourceSystemName")
	public String getSourceSystemName() {
		return sourceSystemName;
	}

	public void setSourceSystemName(String sourceSystemName) {
		this.sourceSystemName = sourceSystemName;
	}

	@XmlElement(name = "transactionReference")
	public String getTransactionReference() {
		return transactionReference;
	}

	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}

	@XmlElement(name = "valueDate")
	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	@XmlElement(name = "captureDate")
	public Date getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	@XmlElement(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement(name = "counterparty")
	public String getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(String counterparty) {
		this.counterparty = counterparty;
	}

	@XmlElement(name = "book")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@XmlElement(name = "channel")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@XmlElement(name = "borkerId")
	public Long getBorkerId() {
		return borkerId;
	}

	public void setBorkerId(Long borkerId) {
		this.borkerId = borkerId;
	}

	@XmlElement(name = "dealerId")
	public Long getDealerId() {
		return dealerId;
	}

	public void setDealerId(Long dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return super.toString() + "Trade [tradeId=" + tradeId + ", sourceSystemReferenceId=" + sourceSystemReferenceId
				+ ", sourceSystemName=" + sourceSystemName + ", transactionReference=" + transactionReference
				+ ", valueDate=" + valueDate + ", captureDate=" + captureDate + ", status=" + status + ", counterparty="
				+ counterparty + ", book=" + book + ", channel=" + channel + ", borkerId=" + borkerId + ", dealerId="
				+ dealerId + "]";
	}

}
