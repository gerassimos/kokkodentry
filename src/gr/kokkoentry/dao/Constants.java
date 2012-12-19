package gr.kokkoentry.dao;

public class Constants {

	public static final int NR_OF_KOSKINA = 5;
	
	enum ORIKTA_ENUM{
		quartzo("quartzo",1),
		astrio("astrio",2),
		byotype("byotype",3);
		
		private String displayString;
		private int code;
		private ORIKTA_ENUM(String displayString, int code) {
			this.displayString = displayString;
			this.code = code;
		}
		public String getDisplayString() {
			return displayString;
		}
		public void setDisplayString(String displayString) {
			this.displayString = displayString;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		
		public static ORIKTA_ENUM getEnumFromCode(int code){
			ORIKTA_ENUM resut = null;
			for(ORIKTA_ENUM a :values()){
				if(a.getCode()==code){
					resut=a;
				}
			}
			return resut;
		}
		
		public static String [] getDisplayNames(){
			String [] result = new String [values().length];
			for(ORIKTA_ENUM a :values()){
				result[a .ordinal()]=a.getDisplayString(); 
			}
			return result;
		}
		
	}

}
