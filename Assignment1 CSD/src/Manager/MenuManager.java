/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Customer;
import Entity.Ordering;
import Entity.Product;
import LinkedList.MyList;
import static Manager.Validate.checkInputLimited;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author thinh
 */
public class MenuManager {

    public static void loadFromFileCustomers(MyList<Customer> mc) {
        //Object data = readAnObject();
        File f = new File(Validate.CUSTOMER_URL);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] customer = line.split(":");
                mc.addToTail(new Customer(customer[0], customer[1], customer[2]));
            }
            br.close();
            fr.close();
            System.err.println("Load successful!");
        } catch (IOException i) {
            System.err.println("Load file error!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//------------------------------------------------------------------------------
    public static void loadFromFileProducts(MyList<Product> mlp) {
        File f = new File(Validate.PRODUCT_URL);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] product = line.split(":");
                int q = Integer.parseInt(product[2]);
                int s = Integer.parseInt(product[3]);
                double price = Double.parseDouble(product[4]);
                mlp.addToTail(new Product(product[0], product[1], q, s, price));
            }
            br.close();
            fr.close();
            System.err.println("Load successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------    
    //print info customers

    public static void printCus(MyList<Customer> mc) {
        mc.traverse();
    }
//------------------------------------------------------------------------------  
    //print info product

    public static void printPro(MyList<Product> ml) {
        ml.traverse();
    }
//------------------------------------------------------------------------------  
    //add Customer to the end

    public static void inputCusToTail(MyList<Customer> mc) {
        System.out.print("Enter your code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter your name: ");
        String cName = Validate.checkInputString();
        System.out.print("Enter your number phone: ");
        String cPhone = Validate.checkInputString();

        mc.addToTail(new Customer(cCode, cName, cPhone)); //it worked!

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------ 
    //add Product to the end

    public static void inputProToTail(MyList<Product> mp) {
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter your product name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity of product: ");
        int pQuan = Validate.checkInputInt();
        System.out.print("Enter number product was sale: ");
        int pSale = Validate.checkInputSaled(pQuan);
        System.out.print("Enter price: ");
        double pPrice = Validate.checkInputDouble();

        mp.addToTail(new Product(pCode, pName, pQuan, pSale, pPrice));  //it worked again!

        System.err.println("Add succcessful!");
    }

//------------------------------------------------------------------------------
    //search by customer code
    public static void searchByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer Code: ");
        String cCode = Validate.checkInputString();

        Customer c; //defind a Customer
        if ((c = mc.search(new Customer(cCode, "", ""))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(c.toString());
    }
//------------------------------------------------------------------------------  
    //delete by Customer code

    public static void delectByCCode(MyList<Customer> mc) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();

        mc.delete(new Customer(cCode, "", ""));
    }
//------------------------------------------------------------------------------ 
    //search by Product Code

    public static void searchByPCode(MyList<Product> mp) {
        System.out.print("Enter Product code: ");
        String pCode = Validate.checkInputString();

        Product p;  //Define a Product 
        if ((p = mp.search(new Product(pCode, "", 0, 0, 0))) == null) {
            System.err.println("Not found!");
            return;
        }
        System.out.println(p.toString());
    }
//------------------------------------------------------------------------------
    //delete by Product Code

    public static void deleteByPCode(MyList<Product> mp) {
        System.out.print("Enter Product code: ");
        String pCode = Validate.checkInputString();

        mp.delete(new Product(pCode, "", 0, 0, 0));

    }
//------------------------------------------------------------------------------
    //sort Product list by PCode

    public static void sortByPCode(MyList<Product> mp) {
        mp.sort();
        System.err.println("Sorted");
    }
//------------------------------------------------------------------------------
    //add a Product after   

    public static void addProductAfter(MyList<Product> mp) {
        System.out.print("Enter position k: ");
        int k = Validate.checkInputInt();
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter your product name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity of product: ");
        int pQuantity = Validate.checkInputInt();
        System.out.print("Enter number product was sale: ");
        int pSale = Validate.checkInputSaled(pQuantity);
        System.out.print("Enter price: ");
        double pPice = Validate.checkInputDouble();

        mp.addAfterPosition(k, new Product(pCode, pName, pQuantity, pSale, pPice));     //Jesus!! its working !

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------

    public static void addOrder(MyList<Ordering> mo) {
        System.out.print("Enter Customer code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter Product code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter Quantity of product: ");
        int pQuantity = Validate.checkInputInt();

        mo.addToTail(new Ordering(pCode, cCode, pQuantity));

        System.err.println("Add successful!");
    }
//------------------------------------------------------------------------------

    public static void printOrder(MyList<Ordering> mo) {
        mo.traverse();
    }
//------------------------------------------------------------------------------ 

    public static void sortOrder(MyList<Ordering> mo) {
        mo.sort();
    }
//------------------------------------------------------------------------------

    public static int menu() {
        System.out.printf("%-3s%-10s", "", "===MAIN MENU===\n");
        System.out.println("1. Product list");
        System.out.println("2. Customer list");
        System.out.println("3. Order list");
        System.out.println("0. Exit program");

        int choise = checkInputLimited(0, 3);
        return choise;
    }
//------------------------------------------------------------------------------

    public static void deleteProductAfter(MyList<Product> mp) {
        System.out.print("Enter your code: ");
        String pCode = Validate.checkInputString();

        mp.deleteAfterNode(new Product(pCode, "", 0, 0, 0));
    }
//------------------------------------------------------------------------------

    public static void saveProductsToFile(MyList<Product> mp) {
        File f = new File(Validate.PRODUCT_URL);
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < mp.length(); i++) {
                Product p = mp.getObject(i);
                fw.write(p.getPcode() + ":" + p.getPro_name() + ":" + Integer.toString(p.getQuantity()) + ":" + Integer.toString(p.getSaled()) + ":" + Double.toString(p.getPrice()) + "\n");
            }
            fw.close();
            System.err.println("Save successful!");
        } catch (IOException i) {
            System.err.println("File error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------

    public static void saveCustomersToFile(MyList<Customer> mc) {
        File f = new File(Validate.CUSTOMER_URL);
        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < mc.length(); i++) {
                Customer c = mc.getObject(i);   //get customer from list
                fw.write(c.getCcode() + ":" + c.getCus_name() + ":" + c.getPhone() + "\n");
            }
            fw.close();
            System.err.println("Save successful!");
        } catch (IOException i) {
            System.err.println("File error!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//------------------------------------------------------------------------------

    public static void addOrder(MyList<Ordering> mo, MyList<Customer> mc, MyList<Product> mp) {

        String pCode = checkInputProduct(mp);
        String cCode = checkInputCustomer(mc);
        int sl = excuteOrder(mp, pCode);
        
        mo.addToTail(new Ordering(pCode, cCode, sl));
        
        System.err.println("Input successful!");
    }

    //check pCode
    static String checkInputProduct(MyList<Product> mp) {
        System.out.print("Enter product code: ");
        while (true) {
            try {
                String pCode = Validate.checkInputString();
                for (int i = 0; i < mp.length(); i++) {
                    Product p = mp.getObject(i);
                    if (pCode.equals(p.getPcode())) {   //compare with pcode from list
                        return pCode;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Your product code just enter not exist!");
                System.out.print("Enter again: ");
            }
        }
    }

    //check cCode
    static String checkInputCustomer(MyList<Customer> mc) {
        System.out.print("Enter customer code: ");
        while (true) {
            try {
                String cCode = Validate.checkInputString();
                for (int i = 0; i < mc.length(); i++) {
                    Customer c = mc.getObject(i);
                    if (cCode.equals(c.getCcode())) {   //compare with ccode from list
                        return cCode;
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Your customer code just enter not exist!");
                System.out.print("Enter again: ");
            }
        }
    }
    //insert and update order
    static int excuteOrder(MyList<Product> mp, String pCode) {
        System.out.print("Enter quantity you want to order: ");

        while (true) {
            int sl = Validate.checkInputInt();  //so luong dat hang
            try {
                for (int i = 0; i < mp.length(); i++) {
                    Product p = mp.getObject(i);
                    if (pCode.equals(p.getPcode())) {
                        if (sl > p.getQuantity()) {
                            throw new NumberFormatException();
                        } else {
                            p.setQuantity(p.getQuantity() - sl);    //update quantity in database
                            p.setSaled(p.getSaled() + sl);          //update saled in database
                            return sl;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Not enough products for you order!");
                System.out.print("Please enter again: ");
            }
        }
    }
}
