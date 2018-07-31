package BO;

public class Sign_Up {
	
		private int User_Id;
		private String User_Name;
		private String User_Password;
		private String Email;
		private long Phone_Number;
		public Sign_Up() {
			super();
		}
		public Sign_Up(int user_Id, String user_Name, String user_Password, String email, long phone_Number) {
			super();
			User_Id = user_Id;
			User_Name = user_Name;
			User_Password = user_Password;
			Email = email;
			Phone_Number = phone_Number;
		}
		public int getUser_Id() {
			return User_Id;
		}
		public void setUser_Id(int user_Id) {
			User_Id = user_Id;
		}
		public String getUser_Name() {
			return User_Name;
		}
		public void setUser_Name(String user_Name) {
			User_Name = user_Name;
		}
		public String getUser_Password() {
			return User_Password;
		}
		public void setUser_Password(String user_Password) {
			User_Password = user_Password;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public long getPhone_Number() {
			return Phone_Number;
		}
		public void setPhone_Number(long phone_Number) {
			Phone_Number = phone_Number;
		}
		@Override
		public String toString() {
			return "Sign_Up [User_Id=" + User_Id + ", User_Name=" + User_Name + ", User_Password=" + User_Password
					+ ", Email=" + Email + ", Phone_Number=" + Phone_Number + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Email == null) ? 0 : Email.hashCode());
			result = prime * result + (int) (Phone_Number ^ (Phone_Number >>> 32));
			result = prime * result + User_Id;
			result = prime * result + ((User_Name == null) ? 0 : User_Name.hashCode());
			result = prime * result + ((User_Password == null) ? 0 : User_Password.hashCode());
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
			Sign_Up other = (Sign_Up) obj;
			if (Email == null) {
				if (other.Email != null)
					return false;
			} else if (!Email.equals(other.Email))
				return false;
			if (Phone_Number != other.Phone_Number)
				return false;
			if (User_Id != other.User_Id)
				return false;
			if (User_Name == null) {
				if (other.User_Name != null)
					return false;
			} else if (!User_Name.equals(other.User_Name))
				return false;
			if (User_Password == null) {
				if (other.User_Password != null)
					return false;
			} else if (!User_Password.equals(other.User_Password))
				return false;
			return true;
		}
}