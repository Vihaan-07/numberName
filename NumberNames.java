import java.util.*; 
public class NumberNames {
    int num;              // member variables
    int c;
    int num1;
    int z;
    String s;

    public NumberNames(int n) {
        num1 = n;
        s = "";
    }

    void rev() { // reverse method
        int cpy = num1;
        while(cpy>0) {
            cpy/=10;
            c++; // number of digits
        }
        num = 0; 
        cpy = num1;
        while(cpy>0) {
            num = (num*10 ) + (cpy%10) ; // reversing the given number and storing it in num to make calculations easier
            cpy/=10; 
        }
    }

    public String print() {
        if( num1>= 1 && num1<=999999) { // if the number is greater than 1 and less than 999999 (if number is in limits)
            while( c>0 ) {
                if( c==2 || c == 5) {  //special cases where we use words like thirty and forty
                    if( num%10 != 0) { // if the 2nd or 5th digit is not a 0
                        prntTensOrThou(); //invoke a print function
                        prntPlace();  // print the word thousand
                        c-=2; 
                        num/=100;  // eliminating the last 2 digits from the reversed number 
                    }
                    else if( (num/10)%10 !=0) {  // if the 2nd or 5th digit is a 0 but the 1st or 4th digit is not a 0 
                        z=(num/10)%10; // store the 1st or 4th digit
                        prntDigit(z);  // invoke a print function
                        prntPlace();   // print the word thousand
                        c-=2;
                        num/=100;  // eliminate the last 2 digits
                    }
                    else {  // if either the 1st and 2nd or 4th and 5th digit of the original number is 0 
                        prntPlace();// print the term thousand
                        c-=2;
                        num/=100;
                    }
                }
                else { 
                    z = num%10;//extract last digit from the reversed number
                    if(z!=0) { // if the last digit from the reversed number is not a 0
                        prntDigit(z); // print the word form of the digit stored in z
                        prntPlace();  // invoke function to print either the word hundred or thousand depending on which one is required
                        c--;
                        num/=10;  // eliminate last digit of reversed number
                    }

                    else { // if the last digit of reversed number is 0
                        c--;
                        num/=10;  // eliminate last digit of reversed number
                    }
                }
            }
        }
        else
            s = s + "Invalid Input"; // if the number is out of limits( 1-999999)
        return s;
    }

    public void prntDigit(int n) {
        String ones[] = {"" ,"One " , "Two " , "Three " , "Four ", "Five " , "Six " , "Seven " , "Eight " , "Nine "};
        s = s + ones[n] ; //print the digit in the ones place
    }

    public void prntPlace() {
        if( c == 6 ||c== 3) { 
            s = s + "Hundred ";
        }
        else if( c==5|| c == 4) {
            s = s + "Thousand ";
        }
    }

    public void prntTensOrThou() {
        int num = (this.num)%100; //storing 2 digits in variable
        if( num%10 == 1) //if the number is from the range of 10-19(special numbers)
            prntTen(); // invoke function

        else {
            String tens_1[] = {"" ,"" , "Twenty " , "Thirty " , "Forty ", "Fifty " , "Sixty " , "Seventy " , "Eighty " , "Ninety "};
            s = s+ tens_1[num%10] ; // print word for the 2nd or 5th digit as long as it is not a one
            num/=10; //eliminate last digit
            prntDigit(num); // print the 1st or 4th digit
        }
    }

    public void prntTen() { //if 2 digits are in the range of 10-19
        int num = (this.num)%100; // store those 2 digits in a variable from a reversed number
        int rev = 0;
        while( num> 0 )  {
            rev = (rev * 10) + (num%10); //reverse the reversed digits
            num/=10;
        }
        switch( rev) {  
            case 1 : // if the number is a 10
            s = s + "Ten ";
            break;
            case 11: // if the number is a 11
            s = s + "Eleven ";
            break;
            case 12: // if the number is a 12
            s = s  + "Twelve ";
            break;
            case 13: // if the number is a 13
            s = s + "Thirteen ";
            break;
            case 14: // if the number is a 14
            s = s + "Fourteen ";
            break;
            case 15: // if the number is a 15
            s = s + "Fifteen ";
            break;
            case 16: // if the number is a 16
            s = s + "Sixteen ";
            break;
            case 17: // if the number is a 17
            s = s + "Seventeen ";
            break;
            case 18: // if the number is a 18
            s = s + "Eighteen ";
            break;
            case 19: // if the number is a 19
            s = s + "Ninteen ";
        }
    }
}            
