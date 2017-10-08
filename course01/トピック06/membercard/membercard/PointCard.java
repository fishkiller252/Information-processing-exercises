package membercard;

/**
 * 
 * @author 学籍番号 氏名
 *
 */
public class PointCard extends Card {
	private int point;
	private boolean isFirstFemale;
	
	public PointCard(String name, String gender, int age) {
		super(name, gender, age);
		if (gender.equalsIgnoreCase("female")) {
			this.point = 10;
			this.isFirstFemale = false;
		} else {
			this.point = 0;
			this.isFirstFemale = true;
		}
	}

	public void addPoint(int point) {
		this.point += (getAge() >= 55) ? point * 2 : point;
	}
	
	public int getPoint() {
		return point;
	}
	
	@Override
	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("female")) {
			if (isFirstFemale) {
				point += 10;
				isFirstFemale = false;
			}
		}
		super.setGender(gender);
	}
}
