package gr.kokkoentry.dao;

import gr.kokkoentry.model.BeanPerOre;

public class Constants {

	public static final int NR_OF_KOSKINA = 5;
	
	public enum ORIKTA_ENUM{
		quartzo("quartzo",0,"quartzo"),
		astrio("astrio",1, "astrio"),
		byotype("byotype",2, "byotype"),
		pyrox("pyrox",2, "pyrox"),
		
		quartzo1("quartzo1",0,"quartzo1"),
		quartzo2("quartzo2",0,"quartzo2"),
		quartzo3("quartzo3",0,"quartzo3"),
		quartzo4("quartzo4",0,"quartzo4"),
		quartzo5("quartzo5",0,"quartzo5"),
		quartzo6("quartzo6",0,"quartzo6"),
		quartzo7("quartzo7",0,"quartzo7"),
		quartzo8("quartzo8",0,"quartzo8"),
		quartzo9("quartzo9",0,"quartzo9"),
		quartzo10("quartzo10",0,"quartzo10"),
		
		quartzo11("quartzo11",0,"quartzo1"),
    quartzo12("quartzo12",0,"quartzo2"),
    quartzo13("quartzo13",0,"quartzo3"),
    quartzo14("quartzo14",0,"quartzo4"),
    quartzo15("quartzo15",0,"quartzo5"),
    quartzo16("quartzo16",0,"quartzo6"),
    quartzo17("quartzo17",0,"quartzo7"),
    quartzo18("quartzo18",0,"quartzo8"),
    quartzo19("quartzo19",0,"quartzo9"),
    quartzo20("quartzo20",0,"quartzo10"),
    
    
    quartzo21("quartzo21",0,"quartzo1"),
    quartzo22("quartzo22",0,"quartzo2"),
    quartzo23("quartzo23",0,"quartzo3"),
    quartzo24("quartzo24",0,"quartzo4"),
    quartzo25("quartzo25",0,"quartzo5"),
    quartzo26("quartzo26",0,"quartzo6"),
    quartzo27("quartzo27",0,"quartzo7"),
    quartzo28("quartzo28",0,"quartzo8"),
    quartzo29("quartzo29",0,"quartzo9"),
    quartzo30("quartzo30",0,"quartzo10"),
    
    quartzo31("quartzo31",0,"quartzo1"),
    quartzo32("quartzo32",0,"quartzo2"),
    quartzo33("quartzo33",0,"quartzo3"),
    quartzo34("quartzo34",0,"quartzo4"),
    quartzo35("quartzo35",0,"quartzo5"),
    quartzo36("quartzo36",0,"quartzo6"),
    quartzo37("quartzo37",0,"quartzo7"),
    quartzo38("quartzo38",0,"quartzo8"),
    quartzo39("quartzo39",0,"quartzo9"),
    quartzo40("quartzo40",0,"quartzo10")
		
		;
		
		private String uniqueName;
		private int relativePosition;
		private String displayName;
		private ORIKTA_ENUM(String uniqueName, int code ,String displayName) {
			this.uniqueName = uniqueName;
			this.relativePosition = code;
			this.displayName= displayName;
		}
		public String getUniqueName() {
			return uniqueName;
		}
		public void setUniqueName(String uniqueName) {
			this.uniqueName = uniqueName;
		}
		public int getRelativePosition() {
			return relativePosition;
		}
		public void setRelativePosition(int relativePosition) {
			this.relativePosition = relativePosition;
		}
		public String getDisplayName() {
      return displayName;
    }
    public void setDisplayName(String displayName) {
      this.displayName = displayName;
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
				result[a .ordinal()]=a.getUniqueName(); 
			}
			return result;
		}
		
		public static BeanPerOre [] getSieveBeanPerOre(){
			BeanPerOre [] result = new BeanPerOre [values().length];
			for(ORIKTA_ENUM orikto :values()){
				BeanPerOre beanPerOre = new BeanPerOre();
				beanPerOre.setOreName(orikto.getUniqueName());
				beanPerOre.setRelativePosition(orikto.getRelativePosition());
				result[orikto .ordinal()]= beanPerOre; 
			}
			return result;
		}
		
	}

}
