package com.myproject.java.String;

public class StringPreDefinedMethods {

    public static void main(String[] args) {
        String str = "I love india";
        String str2 = new String(" I love tamil nadu ");
        System.out.println(str.length());
        System.out.println(str.charAt(6));
        System.out.println(str.substring(6));
        System.out.println(str.substring(6, 10));
        System.out.println(str.concat(str2));
        System.out.println(str.indexOf("e"));
        System.out.println(str.concat(str2).lastIndexOf("e"));
        System.out.println("love".equals("love"));
        System.out.println("love".equalsIgnoreCase("Love"));
        System.out.println("Love".compareTo("Love"));
        System.out.println("love".compareToIgnoreCase("lOve"));
        System.out.println("Love".toLowerCase());
        System.out.println("Love".toUpperCase());
        System.out.println(str.trim());
        System.out.println(str.replace("india", "tamil nadu"));
        System.out.println(str.replace('i', 't'));
        //System.out.println(str.strip());
        System.out.println(str.codePointAt(1));
        System.out.println(str.codePointBefore(1));
        System.out.println(str.codePointCount(4,7));
        System.out.println(str.contains("L"));
        System.out.println(str.endsWith("a"));
        System.out.println(str.startsWith("I"));
        char[] chArr=new char[20];
        str.getChars(2,7,chArr,0);
        System.out.println(chArr);
        System.out.println(str.toCharArray());
        System.out.println(str.isEmpty());
        String strFormat=String.format("I love %s too",str);
        String strFormat1=String.format("I love %.8f too",47.3689);
        String strFormat2=String.format("I love %15.8f too",47.3689);
        System.out.println(strFormat);
        System.out.println(strFormat1);
        System.out.println(strFormat2);
        System.out.println(str.matches("(.*)love(.*)"));
        String[] str3;
        str3="hello@hai@are@you".split("@");
        System.out.println(str3.toString());
        System.out.println(String.join(" > ","hello","hai","jio","sjh"));
        String str4="hello@hai@are@you";
        System.out.println(str4.replaceAll("@"," "));
        System.out.println(str4.replaceFirst("@"," "));
        System.out.println(str4.replace("@"," "));
        System.out.println(String.valueOf(190));

       /* String s = "GeeksforGeeks";
        // or String s= new String ("GeeksforGeeks");

        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = " + s.charAt(3));

        // Return the substring from the ith  index character
        // to end of string
        System.out.println("Substring " + s.substring(3));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring  = " + s.substring(2, 5));

        // Concatenates string2 to the end of string1.
        String s1 = "Geeks";
        String s2 = "forGeeks";
        System.out.println("Concatenated string  = " + s1.concat(s2));

        // Returns the index within the string
        // of the first occurrence of the specified string.
        String s4 = "Learn Share Learn";
        System.out.println("Index of Share " + s4.indexOf("Share"));

        // Returns the index within the string of the
        // first occurrence of the specified string,
        // starting at the specified index.
        System.out.println("Index of a  = " + s4.indexOf('a', 3));

        // Checking equality of Strings
        Boolean out = "Geeks".equals("geeks");
        System.out.println("Checking Equality  " + out);
        out = "Geeks".equals("Geeks");
        System.out.println("Checking Equality  " + out);

        out = "Geeks".equalsIgnoreCase("gEeks ");
        System.out.println("Checking Equality " + out);

        //If ASCII difference is zero then the two strings are similar
        int out1 = s1.compareTo(s2);
        System.out.println("the difference between ASCII value is=" + out1);
        // Converting cases
        String word1 = "GeeKyMe";
        System.out.println("Changing to lower Case " + word1.toLowerCase());

        // Converting cases
        String word2 = "GeekyME";
        System.out.println("Changing to UPPER Case " + word2.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Replacing characters
        String str1 = "feeksforfeeks";
        System.out.println("Original String " + str1);
        String str3 = "feeksforfeeks".replace('f', 'g');
        System.out.println("Replaced f with g -> " + str3);*/
    }


}
