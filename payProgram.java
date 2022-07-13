/*Project: Pal Calculator
 *Author: Jason Jacobs
 * Course: CPT307 Data Structures & Algorithms
 * Instructor: Dr. J. Reichard
 * Date: July 11, 2022
 */

import java.text.DecimalFormat;
import java.util.*;

public class payCalc {
    public static void main(String[] args){
        System.out.println("Enter the employee name ");
        Scanner empName = new Scanner(System.in);
        String emp = empName.nextLine();
        System.out.println("Now enter hours worked ");
        Scanner hrsWorked = new Scanner(System.in);
        String hrs = hrsWorked.nextLine();
        double hours = Double.parseDouble(hrs);
        System.out.println("Enter "+emp+"'s rate of pay ");
        Scanner ratPay = new Scanner(System.in);
        String rat = ratPay.nextLine();
        double rate = Double.parseDouble(rat);
        double reg = 0;
        double ovt = 0;
        if (hours > 40) {
            reg = 40;
            ovt = hours - 40;
        }
        if (hours < 40) {
            reg = hours;
        }
        double grosReg = reg * rate;
        double grosOT = ovt * (rate*1.5);
        double grosTotal = grosReg + grosOT;

        //deductions 

        double fedTax = grosTotal * 0.15;
        double stateTax = grosTotal * 0.0307;
        double medCare = grosTotal * 0.0145;
        double socSec = grosTotal * 0.062;
        double unEmp = grosTotal * 0.0007;

        double deduct = fedTax + stateTax + medCare + socSec + unEmp;

        double netPay = grosTotal - deduct;
        DecimalFormat cashForm = new DecimalFormat("0.00");
        System.out.println("---------------Employee Info-------------------");
        System.out.println("Name "+emp);
        System.out.println("Pay rate $"+rat+" per hour");
        System.out.println("Regular hours " + cashForm.format(reg));
        System.out.println("Overtime hours " + cashForm.format(ovt));
        System.out.println("Gross pay $"+cashForm.format(grosTotal));
        System.out.println("---------------Decuctions-------------------");
        System.out.println("Federal Tax $" + cashForm.format(fedTax));
        System.out.println("State Tax $" + cashForm.format(stateTax));
        System.out.println("Medicare $" + cashForm.format(medCare));
        System.out.println("Social Security $" + cashForm.format(socSec));
        System.out.println("Unemployment Insurrance $" + cashForm.format(unEmp));
        System.out.println("Total duductions $" + cashForm.format(deduct));
        System.out.println("---------------Take Home Pay-------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("Net pay $" + cashForm.format(netPay));
    }
}
