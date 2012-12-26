package gr.kokkoentry.dao;

import gr.kokkoentry.model.BeanPerOre;

public class Constants {

	public static final int NR_OF_KOSKINA = 5;
	
	public enum ORIKTA_ENUM{
		
		ore1("quartzo1",0,"quarzo1"),
		ore2("quartzo2",0,"quarzo2"),
		ore3("quartzo3",0,"quarzo3"),
		ore4("quartzo4",0,"quarzo4"),
		ore5("quartzo5",0,"quarzo5"),
		ore6("quartzo6",0,"quarzo6"),
		ore7("quartzo7",0,"quarzo7"),
		ore8("quartzo8",0,"quarzo8"),
		ore9("quartzo9",0,"quarzo9"),
		ore10("quartzo10",0,"quarzo10"),
		
		ore11("quartzo11",0,"quarzo11"),
    ore12("quartzo12",0,"quarzo12"),
    ore13("quartzo13",0,"quarzo13"),
    ore14("quartzo14",0,"quarzo14"),
    ore15("quartzo15",0,"quarzo15"),
    ore16("quartzo16",0,"quarzo16"),
    ore17("quartzo17",0,"quarzo17"),
    ore18("quartzo18",0,"quarzo18"),
    ore19("quartzo19",0,"quarzo19"),
    ore20("quartzo20",0,"quarzo20"),
    
    
    ore21("quartzo21",0,"quarzo21"),
    ore22("quartzo22",0,"quarzo22"),
    ore23("quartzo23",0,"quarzo23"),
    ore24("quartzo24",0,"quarzo24"),
    ore25("quartzo25",0,"quarzo25"),
    ore26("quartzo26",0,"quarzo26"),
    ore27("quartzo27",0,"quarzo27"),
    ore28("quartzo28",0,"quarzo28"),
    ore29("quartzo29",0,"quarzo29"),
    ore30("quartzo30",0,"quarzo30"),
    
    ore31("quartzo31",0,"quarzo31"),
    ore32("quartzo32",0,"quarzo32"),
    ore33("quartzo33",0,"quarzo33"),
    ore34("quartzo34",0,"quarzo34"),
    ore35("quartzo35",0,"quarzo35"),
    ore36("quartzo36",0,"quarzo36"),
    ore37("quartzo37",0,"quarzo37"),
    ore38("quartzo38",0,"quarzo38"),
    ore39("quartzo39",0,"quarzo39"),
    ore40("quartzo40",0,"quarzo40"),
    
    ore41("quartzo41",0,"quarzo41"),
    ore42("quartzo42",0,"quarzo42"),
    ore43("quartzo43",0,"quarzo43"),
    ore44("quartzo44",0,"quarzo44"),
    ore45("quartzo45",0,"quarzo45"),
    ore46("quartzo46",0,"quarzo46"),
    ore47("quartzo47",0,"quarzo47"),
    ore48("quartzo48",0,"quarzo48"),
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
    public static ORIKTA_ENUM getEnumFromUniqueName(String oreName) {
      ORIKTA_ENUM resut = null;
      for(ORIKTA_ENUM a :values()){
        if(a.getUniqueName().equals(oreName)){
          resut=a;
        }
      }
      return resut;
    }
		
	}

}
