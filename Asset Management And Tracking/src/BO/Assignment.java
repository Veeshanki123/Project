package BO;

import java.sql.Date;

public class Assignment {
private int Assignment_Id;
private Date Assignment_Date;
private int Dept_Id;
private int Location_Id;
private String Model_No;
public int getAssignment_Id() {
	return Assignment_Id;
}
public void setAssignment_Id(int assignment_Id) {
	Assignment_Id = assignment_Id;
}
public Date getAssignment_Date() {
	return Assignment_Date;
}
public void setAssignment_Date(Date assignment_Date) {
	Assignment_Date = assignment_Date;
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
public String getModel_No() {
	return Model_No;
}
public void setModel_No(String model_No) {
	Model_No = model_No;
}
public Assignment(int assignment_Id, Date assignment_Date, int dept_Id, int location_Id, String mod) {
	super();
	Assignment_Id = assignment_Id;
	Assignment_Date = assignment_Date;
	Dept_Id = dept_Id;
	Location_Id = location_Id;
	Model_No = mod;
}
public Assignment() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Assignment_Date == null) ? 0 : Assignment_Date.hashCode());
	result = prime * result + Assignment_Id;
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
	Assignment other = (Assignment) obj;
	if (Assignment_Date == null) {
		if (other.Assignment_Date != null)
			return false;
	} else if (!Assignment_Date.equals(other.Assignment_Date))
		return false;
	if (Assignment_Id != other.Assignment_Id)
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
@Override
public String toString() {
	return "Assignment [Assignment_Id=" + Assignment_Id + ", Assignment_Date=" + Assignment_Date + ", Dept_Id="
			+ Dept_Id + ", Location_Id=" + Location_Id + ", Model_No=" + Model_No + "]";
}


}
