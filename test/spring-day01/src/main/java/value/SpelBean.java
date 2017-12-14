package value;

public class SpelBean {
	private String nameString;
	private String cityString;
	private double score;
	private String pageSize;
	
	public SpelBean() {
		System.out.println("SpelBean()");
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public void setCityString(String cityString) {
		this.cityString = cityString;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "SpelBean [nameString=" + nameString + ", cityString="
				+ cityString + ", score=" + score + ", pageSize=" + pageSize
				+ "]";
	}
	
}
