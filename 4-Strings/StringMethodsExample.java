public class StringMethodsExample {

    public static void main(String[] args) {
        
        String str = "Hello, World! Welcome to LeetCode.";

        System.out.println("Length of the string: " + str.length());

        System.out.println("Character at index 7: " + str.charAt(7));

        System.out.println("Substring from index 7 to 12: " + str.substring(7, 12));

        System.out.println("Contains 'World': " + str.contains("World"));

        System.out.println("Lowercase: " + str.toLowerCase());

        System.out.println("Uppercase: " + str.toUpperCase());

        String strWithSpaces = "   Hello, World!   ";
        System.out.println("Trimmed: '" + strWithSpaces.trim() + "'");

        System.out.println("Replace 'o' with 'x': " + str.replace('o', 'x'));

        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));

        String[] words = str.split(" ");
        System.out.println("Words in the string:");
        for (String word : words) {
            System.out.println(word);
        }

        char[] charArray = str.toCharArray();
        System.out.println("Characters in the string:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        String emptyStr = "";
        System.out.println("Is the string empty? " + emptyStr.isEmpty());

        String str1 = "LeetCode";
        String str2 = "leetcode";
        System.out.println("str1 equals str2 (case-sensitive)? " + str1.equals(str2));

        System.out.println("str1 equals str2 (case-insensitive)? " + str1.equalsIgnoreCase(str2));

        System.out.println("Index of 'W': " + str.indexOf('W'));
        System.out.println("Index of 'World': " + str.indexOf("World"));

        System.out.println("Last index of 'o': " + str.lastIndexOf('o'));

        String concatStr = str.concat(" Let's solve problems.");
        System.out.println("Concatenated string: " + concatStr);

        String str11 = "Apple";
        String str12 = "Banana";
        String str13 = "Apple";
        
        System.out.println(str11.compareTo(str12)); // Output: negative value (str1 < str2)
        System.out.println(str12.compareTo(str11)); // Output: positive value (str2 > str1)
        System.out.println(str11.compareTo(str13)); // Output: 0 (str1 == str3)

        
    }
}
