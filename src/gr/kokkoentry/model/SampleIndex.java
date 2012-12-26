package gr.kokkoentry.model;

public class SampleIndex {
  
  private String area,  aa,  scv, topdist, date,  depth, color;

  public SampleIndex() {
    super();
    // TODO Auto-generated constructor stub
  }

  public SampleIndex(String area, String aa, String scv, String topdist,
      String date, String depth, String color) {
    super();
    this.area = area;
    this.aa = aa;
    this.scv = scv;
    this.topdist = topdist;
    this.date = date;
    this.depth = depth;
    this.color = color;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getAa() {
    return aa;
  }

  public void setAa(String aa) {
    this.aa = aa;
  }

  public String getScv() {
    return scv;
  }

  public void setScv(String scv) {
    this.scv = scv;
  }

  public String getTopdist() {
    return topdist;
  }

  public void setTopdist(String topdist) {
    this.topdist = topdist;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDepth() {
    return depth;
  }

  public void setDepth(String depth) {
    this.depth = depth;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "SampleIndex [area=" + area + ", aa=" + aa + ", scv=" + scv
        + ", topdist=" + topdist + ", date=" + date + ", depth=" + depth
        + ", color=" + color + "]";
  }
  
  
  

}
