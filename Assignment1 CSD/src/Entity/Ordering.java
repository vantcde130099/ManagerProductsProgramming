
package Entity;

public class Ordering implements Comparable<Ordering>{
    private String pcode;
    private String ccode;
    private int quantity;

    public Ordering() {
    }

    public Ordering(String pcode, String ccode, int quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public String getCcode() {
        return ccode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ordering{" + "pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + '}';
    }

    
    
    
    // override compareTo
    // return positive number is higher, negative number if is lower, 0 if equal
    @Override
    public int compareTo(Ordering t) {
        if (t.getPcode().compareTo(pcode) != 0){
            return t.getPcode().compareTo(pcode);
        }else{
            return t.getCcode().compareTo(ccode);
        }
    }
    
}
