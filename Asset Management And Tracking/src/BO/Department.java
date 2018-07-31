package BO;

public class Department {
	
	private int Dept_Id;
	private String Dept_Name;
	public Department() {
		super();
	}
	public Department(int dept_id)
	{
		Dept_Id=dept_id;
	}
	public Department(int dept_Id, String dept_Name) {
		super();
		Dept_Id = dept_Id;
		Dept_Name = dept_Name;
	}
	public int getDept_Id() {
		return Dept_Id;
	}
	public void setDept_Id(int dept_Id) {
		Dept_Id = dept_Id;
	}
	public String getDept_Name() {
		return Dept_Name;
	}
	public void setDept_Name(String dept_Name) {
		Dept_Name = dept_Name;
	}
	@Override
	public String toString() {
		return "Department [Dept_Id=" + Dept_Id + ", Dept_Name=" + Dept_Name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Dept_Id;
		result = prime * result + ((Dept_Name == null) ? 0 : Dept_Name.hashCode());
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
		Department other = (Department) obj;
		if (Dept_Id != other.Dept_Id)
			return false;
		if (Dept_Name == null) {
			if (other.Dept_Name != null)
				return false;
		} else if (!Dept_Name.equals(other.Dept_Name))
			return false;
		return true;
	}

	}


