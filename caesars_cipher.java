import java.util.Scanner;

public class Caesars_cipher {
    final String lower_case_alphabet = "abcdefghijklmnopqrstuvwxyz";
    final String upper_case_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String digits = "1234567890";

    public static void main(String[] args) {
        //user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input word or phrase to be encrypted: ");
        String user_input = scanner.nextLine();

        //get shift amount
        System.out.print("Enter shift amount: ");
        int shift = scanner.nextInt();

         //can be updated to account for input numbers 
        System.out.println("User input -->      " + user_input);
        Caesars_cipher cipher = new Caesars_cipher();

        System.out.println("Encrypted code -->     " + cipher.encrypt(user_input, shift));
    }
    public String encrypt(String input, int s) {
        int current, rank;
        StringBuffer encoded = new StringBuffer();
        char c;

        //iterate through input to encrypt
        for (int i=0; i<input.length(); i++) {
            c = input.charAt(i);
            // if uppercase, use uppercase alphabet
            if (Character.isUpperCase(c)) {
                // c = nth char of text input
                // calculate r = rank of c in alphabet
                current = upper_case_alphabet.indexOf(input.charAt(i));
                // shift and get position within alphabet
                rank = (current + s) % 26;
                //letter with rank R2 in alphabet
                c = upper_case_alphabet.charAt(rank);
                encoded.append(c);
            //else if lowercase, use lowercase alphabet
            } else if (Character.isLowerCase(c)) {
                // c = nth char of text input
                // calculate r = rank of c in alphabet
                current = lower_case_alphabet.indexOf(input.charAt(i));
                // shift and get position within alphabet
                rank = (current + s) % 26;
                //letter with rank R2 in alphabet
                c = lower_case_alphabet.charAt(rank);
                encoded.append(c);
            //else if a digit, iterate over 10 numbers 0 - 9
            //} else if (Character.isDigit(input.charAt(c))) {
                // c = nth char of text input
                // calculate r = rank of c in alphabet
                //current = digits.indexOf(input.charAt(i));
                // shift and get position within alphabet
                //rank = (current + s) % 10;
                //letter with rank R2 in alphabet
                //c = digits.charAt(rank);
                //encoded.append(c);
            //else , if not upper or lowercase, leave as is 
            } else {
                encoded.append(c);
            }

        }
        return encoded.toString();
    }
}
