package BO;

public class Asset_Type {
	
		private int Asset_Type_Id;
		private String Asset_Type_Name;
		public Asset_Type() {
			super();
		}
		public Asset_Type(int asset_type_id)
		{
			Asset_Type_Id=asset_type_id;
		}
		public Asset_Type(int asset_Type_Id, String asset_Type_Name) {
			super();
			Asset_Type_Id = asset_Type_Id;
			Asset_Type_Name = asset_Type_Name;
		}
		public int getAsset_Type_Id() {
			return Asset_Type_Id;
		}
		public void setAsset_Type_Id(int asset_Type_Id) {
			Asset_Type_Id = asset_Type_Id;
		}
		public String getAsset_Type_Name() {
			return Asset_Type_Name;
		}
		public void setAsset_Type_Name(String asset_Type_Name) {
			Asset_Type_Name = asset_Type_Name;
		}
		
		@Override
		public String toString() {
			return "Asset_Type [Asset_Type_Id=" + Asset_Type_Id + ", Asset_Type_Name=" + Asset_Type_Name + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Asset_Type_Id;
			result = prime * result + ((Asset_Type_Name == null) ? 0 : Asset_Type_Name.hashCode());
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
			Asset_Type other = (Asset_Type) obj;
			if (Asset_Type_Id != other.Asset_Type_Id)
				return false;
			if (Asset_Type_Name == null) {
				if (other.Asset_Type_Name != null)
					return false;
			} else if (!Asset_Type_Name.equals(other.Asset_Type_Name))
				return false;
			return true;
		}

		}


