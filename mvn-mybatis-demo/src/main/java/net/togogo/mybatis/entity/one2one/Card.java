package net.togogo.mybatis.entity.one2one;

public class Card {
	private int cardId;
	private int cardNo;
	private Person person;
	
	public Card() {
		super();
	}
	
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardNo=" + cardNo + ", person=" + person + "]";
	}
	
	
	
}
