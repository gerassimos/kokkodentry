package gr.kokkoentry.model;

import gr.kokkoentry.dao.Constants;

//sample 
public class Sample {
	private OresPerSieve [] oresPerSieveArray = new  OresPerSieve[Constants.NR_OF_KOSKINA];

	public Sample() {
		super();
		for(int i=0;i< Constants.NR_OF_KOSKINA; i++){
			oresPerSieveArray [i] = new OresPerSieve();
		}
	}

  public OresPerSieve[] getOresPerSieveArray() {
    return oresPerSieveArray;
  }

  public void setOresPerSieveArray(OresPerSieve[] oresPerSieveArray) {
    this.oresPerSieveArray = oresPerSieveArray;
  }
	
	
}
