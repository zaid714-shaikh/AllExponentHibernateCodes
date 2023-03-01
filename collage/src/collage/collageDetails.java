package collage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class collageDetails {

	@Id
	private int cid;
	private String cname;
	private String unviersity;
	private String collageLocation;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUnviersity() {
		return unviersity;
	}

	public void setUnviersity(String unviersity) {
		this.unviersity = unviersity;
	}

	public String getCollageLocation() {
		return collageLocation;
	}

	public void setCollageLocation(String collageLocation) {
		this.collageLocation = collageLocation;
	}

	@Override
	public String toString() {
		return "collageDetails [cid=" + cid + ", cname=" + cname + ", unviersity=" + unviersity + ", collageLocation="
				+ collageLocation + "]";
	}

}
