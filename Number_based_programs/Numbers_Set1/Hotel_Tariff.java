/* 
    Write a program to calculate the hotel tariff. The room rent is 20% high during peak seasons [April-June, November-December].
    Note: Use the switch construct. Input format: The first input containing an integer which denotes the number of the month.
    The second input containing the integer number which denotes the room rent per day. The third input containing an integer which 
    denotes the number of days stayed in the hotel.
    Output format: Print the hotel tariff to be paid in floating point with 2 decimal places

    Sample Input 0:
    3
    1500
    2
    Sample Output 0:
    3000.00

    Sample Input 1:
    4
    1500
    3
    Sample Output 1:
    5400.00
*/

import java.io.*;
import java.util.*;

public class Hotel_Tariff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int monthNo = sc.nextInt();
        int rentPerDay = sc.nextInt();
        int noOfDays = sc.nextInt();

        double finalRentPerDay = rentPerDay;

        switch (monthNo) {
            case 4:
            case 5:
            case 6:
            case 11:
            case 12:
                // Room rent is 20% higher during peak seasons
                finalRentPerDay = rentPerDay + (rentPerDay * 0.2);
                break;
            default:
                break;
        }

        double hotelTariff = noOfDays * finalRentPerDay;
        System.out.printf("%.2f", hotelTariff);
    }
}