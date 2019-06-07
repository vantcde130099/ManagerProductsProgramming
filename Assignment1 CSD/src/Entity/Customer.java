
package Entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Comparable<Customer>, Serializable{
    private String ccode;
    private String cus_name;
    private String phone;

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getCcode() {
        return ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", cus_name=" + cus_name + ", phone=" + phone + '}';
    }

    // override equal 
    // return true if 2 ccode of 2 Customer equal

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ccode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.ccode, other.ccode)) {
            return false;
        }
        return true;
    }
    

    @Override
    public int compareTo(Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
