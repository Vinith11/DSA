

public class CharTemp {
    
    public static void main(String[] args) {
        char a = 'a';
        System.out.println("Check if its Character: " + Character.isAlphabetic(a));

        char digit = '1';
        System.out.println("Check if its Digit: " + Character.isDigit(digit));

        System.out.println("Check if its Upper case: " + Character.isUpperCase(a));

        System.out.println("Check if its Lower case: " + Character.isLowerCase(a));

        char space = ' ';
        System.out.println("Check if it has space: " + Character.isWhitespace(space));
        System.out.println("Check if it has space: " + Character.isWhitespace(a));

        System.out.println("Check if it is a Letter or Digit : " + Character.isLetterOrDigit(a));
        System.out.println("Check if it is a Letter or Digit : " + Character.isLetterOrDigit(digit));

    }
}
