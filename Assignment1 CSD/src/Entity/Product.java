
package Entity;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Comparable<Product>,Serializable{
    private String pcode;
    private String pro_name;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.saled = saled;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public int getSaled() {
        return saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" + quantity + ", saled=" + saled + ", price=" + price + '}';
    }



    // override equal. Compare 2 Product with pcode
    // return true or false.
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.pcode, other.pcode)) {
            return false;
        }
        return true;
    }

    // don't care about it. Not important now.
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.pcode);
        return hash;
    }

    // Compare 2 product
    // return 0 if equal, positive number if higher, negative number if lower
    @Override
    public int compareTo(Product t) {
        return t.getPcode().compareTo(pcode);
    }
}
