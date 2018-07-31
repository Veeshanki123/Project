package BO;

public class Asset {
private String Model_No;
private int Asset_Type_Id;
private int Dept_Id;
private int Location_Id;

public Asset() {
	super();
}
public Asset(String model_no)
{
	Model_No=model_no;
}
public Asset(String model_No, int asset_Type_Id, int dept_Id, int location_Id) {
	super();
	Model_No = model_No;
	Asset_Type_Id = asset_Type_Id;
	Dept_Id = dept_Id;
	Location_Id = location_Id;
	
}
public String getModel_No() {
	return Model_No;
}
public void setModel_No(String model_No) {
	Model_No = model_No;
}
public int getAsset_Type_Id() {
	return Asset_Type_Id;
}
public void setAsset_Type_Id(int asset_Type_Id) {
	Asset_Type_Id = asset_Type_Id;
}
public int getDept_Id() {
	return Dept_Id;
}
public void setDept_Id(int dept_Id) {
	Dept_Id = dept_Id;
}
public int getLocation_Id() {
	return Location_Id;
}
public void setLocation_Id(int location_Id) {
	Location_Id = location_Id;
}

@Override
public String toString() {
	return "Asset [Model_No=" + Model_No + ", Asset_Type_Id=" + Asset_Type_Id + ", Dept_Id=" + Dept_Id
			+ ", Location_Id=" + Location_Id + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Asset_Type_Id;
	
	result = prime * result + Dept_Id;
	result = prime * result + Location_Id;
	result = prime * result + ((Model_No == null) ? 0 : Model_No.hashCode());
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
	Asset other = (Asset) obj;
	if (Asset_Type_Id != other.Asset_Type_Id)
		return false;
	
	if (Dept_Id != other.Dept_Id)
		return false;
	if (Location_Id != other.Location_Id)
		return false;
	if (Model_No == null) {
		if (other.Model_No != null)
			return false;
	} else if (!Model_No.equals(other.Model_No))
		return false;
	return true;
}

}
