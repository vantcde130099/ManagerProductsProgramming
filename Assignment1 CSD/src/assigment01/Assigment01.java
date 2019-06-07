package assigment01;

import Entity.*;
import LinkedList.MyList;
import Manager.ChildsMenu.MenuChilds;
import Manager.MenuManager;

public class Assigment01 {

    public static void main(String[] args) {
        //demoCustomer();
        //demoProduct();
        MyList<Customer> lc = new MyList<>();
        MyList<Ordering> lo = new MyList<Ordering>();
        MyList<Product> lp = new MyList<Product>();
        MenuManager m = new MenuManager();

        runMenu(lc, lo, lp, m);

    }

    public static void runMenu(MyList<Customer> lc, MyList<Ordering> lo, MyList<Product> lp, Manager.MenuManager m) {
        while (true) {
            int choise = m.menu();

            if (choise == 0) {
                System.out.println("THANK YOU SO MUCH!!! WE NEED SOME TEN(1O)-<3");
                break;
            }
            switch (choise) {
                //Product-------------------------------------------------------
                case 1:
                    while (true) {
                        int choiseP = MenuChilds.menuP();

                        if (choiseP == 0) {
                            break;
                        }
                        switch (choiseP) {
                            case 1:
                                m.loadFromFileProducts(lp);
                                break;
                            case 2:
                                m.inputProToTail(lp);   
                                break;
                            case 3:
                                m.printPro(lp);
                                break;
                            case 4:
                                m.saveProductsToFile(lp);
                                break;
                            case 6:
                                m.deleteByPCode(lp);
                                break;
                            case 5:
                                m.searchByPCode(lp);    
                                break;
                            case 7:
                                m.sortByPCode(lp);
                                break;
                            case 8:
                                m.addProductAfter(lp);
                                break;
                            case 9:
                                m.deleteProductAfter(lp);
                                break;
                        }
                    }
                    break;
                //Customer------------------------------------------------------    
                case 2:
                    while (true) {
                        int choiseC = MenuChilds.menuC();

                        if (choiseC == 0) {
                            break;
                        }
                        switch (choiseC) {
                            case 1:
                                m.loadFromFileCustomers(lc);
                                break;
                            case 2:
                                m.inputCusToTail(lc);
                                break;
                            case 3:
                                m.printCus(lc);
                                break;
                            case 4:
                                m.saveCustomersToFile(lc);
                                break;
                            case 5:
                                m.searchByCCode(lc);
                                break;
                            case 6:
                                m.delectByCCode(lc);    
                                break;
                        }
                    }
                    break;
                //Order---------------------------------------------------------
                case 3:
                    while (true) {
                        int choiseO = MenuChilds.menuO();

                        if (choiseO == 0) {
                            break;
                        }
                        switch (choiseO) {
                            case 1:
                                m.addOrder(lo, lc , lp);
                                break;
                            case 2:
                                m.printOrder(lo);
                                break;
                            case 3:
                                m.sortOrder(lo);
                                break;
                        }
                    }
                    break;
            }
        }
    }

    public static void demoCustomer() {
        MyList<Customer> listCustomer = new MyList<>();
        listCustomer.addToHead(new Customer("01", "Minh", "0905901"));
        listCustomer.addToTail(new Customer("02", "Nam", "901"));
        listCustomer.addToHead(new Customer("03", "Van", "090"));
        Customer result = listCustomer.search(new Customer("04", "", ""));
        System.out.println(result);
    }

    public static void demoProduct() {
//        MyList<Product> listProduct = new MyList<>();
//        listProduct.addToHead(new Product("01", "Minh", 23, 6.2));
//        listProduct.addToHead(new Product("05", "Nam", 23, 6.5));
//        listProduct.addToHead(new Product("02", "Thinh", 30, 6.2));
//        listProduct.addToHead(new Product("03", "Loc", 50, 10.2));
//        listProduct.addToHead(new Product("06", "Thanh", 63, 69.2));
//        listProduct.traverse();
        //listProduct.sort();
        //listProduct.traverse();
        //listProduct.addAfterPosition(1, new Product("09", "Ni", 2, 9));
        //listProduct.traverse();
        //System.out.println(listProduct.search(new Product("05", "", 0, 0)));
        //listProduct.traverse();
        //  listProduct.deleteAfterNode(new Product("05", "", 0, 0));

    }
}
