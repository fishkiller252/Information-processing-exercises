package membercard;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class Card {
	private String name;
	private String gender;
	private int age;
	
	public Card(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}
