package gr.kokkoentry.dao;

import gr.kokkoentry.model.BeanPerOre;

public class Constants {

	public static final int NR_OF_KOSKINA = 5;
	
	public enum ORIKTA_ENUM{
		quartzo("quartzo",1),
		astrio("astrio",2),
		byotype("byotype",3);
		
		private String displayString;
		private int relativePosition;
		private ORIKTA_ENUM(String displayString, int code) {
			this.displayString = displayString;
			this.relativePosition = code;
		}
		public String getDisplayString() {
			return displayString;
		}
		public void setDisplayString(String displayString) {
			this.displayString = displayString;
		}
		public int getRelativePosition() {
			return relativePosition;
		}
		public void setRelativePosition(int relativePosition) {
			this.relativePosition = relativePosition;
		}
		public static ORIKTA_ENUM getEnumFromRelativePosition(int position){
			ORIKTA_ENUM resut = null;
			for(ORIKTA_ENUM a :values()){
				if(a.getRelativePosition()==position){
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
		
		public static BeanPerOre [] getSieveBeanPerOre(){
			BeanPerOre [] result = new BeanPerOre [values().length];
			for(ORIKTA_ENUM orikto :values()){
				BeanPerOre beanPerOre = new BeanPerOre();
				beanPerOre.setOreName(orikto.getDisplayString());
				beanPerOre.setRelativePosition(orikto.getRelativePosition());
				result[orikto .ordinal()]= beanPerOre; 
			}
			return result;
		}
		
	}

}
