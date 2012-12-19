package gr.kokkoentry.model;

public class BeanPerOre {
	
private String oreName;
private Integer relativePosition;
private Integer nrOfBeans;

public BeanPerOre() {
	super();
}


public String getOreName() {
	return oreName;
}
public void setOreName(String oreName) {
	this.oreName = oreName;
}
public Integer getNrOfBeans() {
	return nrOfBeans;
}
public void setNrOfBeans(Integer nrOfBeans) {
	this.nrOfBeans = nrOfBeans;
}


public Integer getRelativePosition() {
	return relativePosition;
}


public void setRelativePosition(Integer relativePosition) {
	this.relativePosition = relativePosition;
}



}
