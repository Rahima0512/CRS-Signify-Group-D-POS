/**
 * 
 */
package com.signify.bean;

/**
 * @author ALRAHIMA
 *
 */
public class Payment {
	//Payment Variables
	private int studentId;
	private String referenceId;
	private float amount;
	private boolean status;
	
	//Net banking Variables
	private String modeOfTransfer;
	private int accountNumber;
    private String IFSCcode;
	
    //cheque Variables
    private String paymentMethod;
	private String bankName;
    private int chequeNumber;
    
    //payment notification variable
	private int notificationId;
	private String notificationMessage;
	
	//payment card notification
	 private int cardNumber;
     private String cardType;
    
	
    //getter setter of payment
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	//getter setter of netbanking
    public String getModeOfTransfer() {
		return modeOfTransfer;
	}
	public void setModeOfTransfer(String modeOfTransfer) {
		this.modeOfTransfer = modeOfTransfer;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	
	
	//cheque getter setter
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	
	
	//getter setter payment notification
	public int getStudentId() {
		return studentId;
	}
	
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	//getter setter card
	public int getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
    

}
