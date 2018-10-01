package Minance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(0, "Sunday");
        hashMap.put(1, "Monday");
        hashMap.put(2, "Tuesday");
        hashMap.put(3, "Wednesday");
        hashMap.put(4, "Thursday");
        hashMap.put(5, "Friday");
        hashMap.put(6, "Saturday");

        while(t-->0){

            int year = s.nextInt();
            Boolean flag = false;
            int closestYear = year;
            int answer =-1;
            int answer1 =-1;

            if(year%4==0)
                answer = printDayOfWeek(29,2,year);
            else if(year%4==1){
                answer = printDayOfWeek(29,2,year-1);
                flag = true;
                closestYear = year-1;
            }
            else if(year%4==3){
                answer = printDayOfWeek(29,2,year+1);
                flag = true;
                closestYear = year+1;
            }
            else{
                flag = true;
                answer = printDayOfWeek(29,2,year-2);
                answer1 = printDayOfWeek(29,2,year+2);
                closestYear = year;

            }



            if(flag && (year%4==1 || year%4==3)){
                System.out.println("This is not a leap year");
                System.out.println("Closest leap year: " + closestYear);
                System.out.println(hashMap.get(answer));
            }else if(flag && year%4==2){
                System.out.println("This is not a leap year");
                System.out.println("Closest leap year: " + (closestYear-2));
                System.out.println(hashMap.get(answer));
                System.out.println("Closest leap year: " + (closestYear+2));
                System.out.println(hashMap.get(answer1));
            }else{
                System.out.println(hashMap.get(answer));
            }
        }
    }

    private static int printDayOfWeek(int day, int month, int year ) {
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        year -= (month < 3) ? 1 : 0;
        return (year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
    }
}
