package com.posh.Arrays;

import java.util.Base64;
// we use classes of nio package to read bytes data of the JSON file
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class json_to_string_converter {
    public static void main(String[] args) throws Exception {
        // declare fileName, location, and file variable that will store the user entered file name, location, and file data as a string, respectively
        String fileName, file, location;
        // create scanner class object
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file which you want to convert or access as string: ");
        // take input from user and initialize filName variable
        fileName = sc.nextLine();
        System.out.print("Enter the laction of the "+fileName+" file: ");
        // take input from user and initialize location variable
        location = sc.nextLine();
        // close scanner class obj
        sc.close();
        // call convertFileIntoString() method that will return the file data as string. We store the returned data into file variable
        file = convertFileIntoString(location+"\\"+fileName);
        // print the result, i.e., JSON data in form of string
        System.out.println(file);
    }

    public static String convertFileIntoString(String file)throws Exception
    {
        // declare a variable in which we store the JSON data as a string and return it to the main() method
        String result;
        // initialize result variable
        // we use the get() method of Paths to get the file data
        // we use readAllBytes() method of Files to read byted data from the files
        result = new String(Files.readAllBytes(Paths.get(file)));
        String result_updated = "";
        for(int i =0;i<2;i++){
            result_updated = Reverse_a_string_encoding(result);
//            System.out.println(result_updated);
            result = result_updated;
        }
        // return result to the main() method
        return result_updated;
    }


    public static String Reverse_a_string_encoding(String hell){
        String rev_string = "";
        int n = hell.length();
//        System.out.println(hell);
        for (int i =0;i<n;i++){
            rev_string +=hell.charAt(n-i-1);
        }
//        System.out.println(rev_string);
        byte[] encodedBytes = Base64.getEncoder().encode(rev_string.getBytes());
        String encoded = new String(encodedBytes);
//        System.out.println(Decode_a_string_and_reverse(encoded,encodedBytes));
        Decode_a_string_and_reverse(encoded,encodedBytes);
//        System.out.println(encoded);
        return encoded;
    }

    public static void Decode_a_string_and_reverse(String hell,byte[] encodedBytes){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        String decoded = new String(decodedBytes);

        String rev_string = "";
        int n = decoded.length();
        for(int i =0;i<n;i++){
            rev_string += decoded.charAt(n-i-1);
        }
        System.out.println(rev_string);
//        return rev_string;
    }
}
