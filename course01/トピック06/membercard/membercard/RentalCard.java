package membercard;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class RentalCard extends Card {
	private String itemName;

	public RentalCard(String name, String gender, int age) {
		super(name, gender, age);
		this.itemName = "";
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemName() {
		return itemName;
	}
}
