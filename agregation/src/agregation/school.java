package agregation;

public class school {

	private int schoolID;

	private String schoolName;

	private student std;

	public int getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public student getStd() {
		return std;
	}

	public void setStd(student std) {
		this.std = std;
	}

	@Override
	public String toString() {
		return "school [schoolID=" + schoolID + ", schoolName=" + schoolName + ", std=" + std + "]";
	}

}
