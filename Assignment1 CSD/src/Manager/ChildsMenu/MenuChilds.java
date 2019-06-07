/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager.ChildsMenu;

import Manager.Validate;
import static Manager.Validate.checkInputLimited;

/**
 *
 * @author vannn
 */
public class MenuChilds {

    public static int menuP() {
        System.out.println("    ---Product menu---");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the end\n"
                + "3. Display data\n"
                + "4. Save product list to file\n"
                + "5. Search by pcode\n"
                + "6. Delete by pcode\n"
                + "7. Sort by pcode\n"
                + "8. Add after position  k\n"
                + "9. Delete the node after the node having code = xCode\n"
                + "0. Exit to main menu\n");

        int choise = Validate.checkInputLimited(0, 9);
        return choise;
    }

    public static int menuO() {
        System.out.println("    ---Order menu---");
        System.out.println("1. Input data\n"
                + "2. Display data with total value\n"
                + "3. Sort  by pcode + ccode\n"
                + "0. Exit to main menu\n");

        int choise = Validate.checkInputLimited(0, 3);
        return choise;
    }

    public static int menuC() {
        System.out.println("    ---Customer menu---");
        System.out.println("1. Load data from file\n"
                + "2. Input & add to the end\n"
                + "3. Display data\n"
                + "4. Save customer list to file\n"
                + "5. Search by ccode\n"
                + "6. Delete by ccode\n"
                + "0. Exit to main menu\n");
        
        int choise = checkInputLimited(0, 6);
        return choise;
    }

}
