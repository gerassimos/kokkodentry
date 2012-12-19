package gr.kokkoentry.model;

import gr.kokkoentry.dao.Constants.ORIKTA_ENUM;

public class OresPerSieve {
	private BeanPerOre[] beanPerOreArray;

	public OresPerSieve() {
		super();
		beanPerOreArray = ORIKTA_ENUM.getSieveBeanPerOre();
	}

  public BeanPerOre[] getBeanPerOreArray() {
    return beanPerOreArray;
  }

  public void setBeanPerOreArray(BeanPerOre[] beanPerOreArray) {
    this.beanPerOreArray = beanPerOreArray;
  }
	
	
	
}
