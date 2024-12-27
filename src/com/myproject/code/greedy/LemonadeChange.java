package com.myproject.code.greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.print("Queues of customers: ");
        for (int bill : bills) {
            System.out.print(bill + " ");
        }
        System.out.println();
        boolean ans = lemonadeChange(bills);
        if (ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }

    public static boolean lemonadeChange(int[] bills) {

        // Counter for $5
        int five = 0;
        // Counter for $10
        int ten = 0;
        // Iterate through each customer's bill
        for (int bill : bills) {
            /* If the customer's
               bill is $5 */
            if (bill == 5) {
                // Increment $5
                five++;
            }
            /* If the customer's
               bill is $10 */
            else if (bill == 10) {
                /* Check if there are $5
                   bills available to give change */
                if (five > 0) {
                    // Use one $5
                    five--;
                    // Receive one $10
                    ten++;
                } else {
                    // If no $5 bill available, return false
                    return false;
                }
            }
            /* If the customer's
               bill is $20 */
            else {
                /* Check if there are both
                   $5 and $10 bills
                   available to give change */
                if (five > 0 && ten > 0) {
                    // Use one $5
                    five--;
                    // Use one $10
                    ten--;
                }
                /* If there are not enough $10 bills,
                   check if there are at least
                   three $5 bills available */
                else if (five >= 3) {
                    // Use three $5 bills
                    five -= 3;
                }
                /* If unable to give
                   change, return false */
                else {
                    return false;
                }
            }
        }
        // Return true
        return true;
    }
}
