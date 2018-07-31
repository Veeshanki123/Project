package BO;

public class Location {
private int Location_Id;
private String Location_Name;
public int getLocation_Id() {
	return Location_Id;
}
public void setLocation_Id(int location_Id) {
	Location_Id = location_Id;
}
public String getLocation_Name() {
	return Location_Name;
}
public void setLocation_Name(String location_Name) {
	Location_Name = location_Name;
}
@Override
public String toString() {
	return "Location [Location_Id=" + Location_Id + ", Location_Name=" + Location_Name + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Location_Id;
	result = prime * result + ((Location_Name == null) ? 0 : Location_Name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Location other = (Location) obj;
	if (Location_Id != other.Location_Id)
		return false;
	if (Location_Name == null) {
		if (other.Location_Name != null)
			return false;
	} else if (!Location_Name.equals(other.Location_Name))
		return false;
	return true;
}
public Location() {
	super();
	// TODO Auto-generated constructor stub
}
public Location(int location_Id, String location_Name) {
	super();
	Location_Id = location_Id;
	Location_Name = location_Name;
}

}
