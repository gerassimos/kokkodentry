package gr.kokkoentry.model;

import java.util.Arrays;

import gr.kokkoentry.dao.Constants;

//sample 
public class Sample {
	private OresPerSieve [] oresPerSieveArray = new  OresPerSieve[Constants.NR_OF_KOSKINA];
	
	private SampleIndex sampleIndex;

	public Sample() {
		super();
		for(int i=0;i< Constants.NR_OF_KOSKINA; i++){
			oresPerSieveArray [i] = new OresPerSieve();
		}
		sampleIndex = new SampleIndex();
	}

  public OresPerSieve[] getOresPerSieveArray() {
    return oresPerSieveArray;
  }

  public void setOresPerSieveArray(OresPerSieve[] oresPerSieveArray) {
    this.oresPerSieveArray = oresPerSieveArray;
  }

  public SampleIndex getSampleIndex() {
    return sampleIndex;
  }

  public void setSampleIndex(SampleIndex sampleIndex) {
    this.sampleIndex = sampleIndex;
  }

  @Override
  public String toString() {
    return "Sample [oresPerSieveArray=" + Arrays.toString(oresPerSieveArray)
        + ", sampleIndex=" + sampleIndex + "]";
  }
  
  
  
  
	
}
