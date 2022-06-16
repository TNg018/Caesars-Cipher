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
        String encrypted_word = cipher.encrypt(user_input, shift);

        System.out.println("Encrypted code -->     " + cipher.encrypt(user_input, shift));
        System.out.println("Decrypted code -->     " + cipher.decrypt(encrypted_word, shift));
        
        System.out.println("Brute force: ");
        cipher.brute_force(encrypted_word);
        

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
    public String decrypt(String input, int s) {
        int current, rank;
        StringBuffer decoded = new StringBuffer();
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
                rank = (current + (26 - s)) % 26;
                //letter with rank R2 in alphabet
                c = upper_case_alphabet.charAt(rank);
                decoded.append(c);
            //else if lowercase, use lowercase alphabet
            } else if (Character.isLowerCase(c)) {
                // c = nth char of text input
                // calculate r = rank of c in alphabet
                current = lower_case_alphabet.indexOf(input.charAt(i));
                // shift and get position within alphabet
                rank = (current + (26 - s)) % 26;
                //letter with rank R2 in alphabet
                c = lower_case_alphabet.charAt(rank);
                decoded.append(c);
            //else , if not upper or lowercase, leave as is 
            } else {
                decoded.append(c);
            }

        }
        return decoded.toString();
    }

    public String brute_force(String input) {
        //letter shift index
        int x = 0;
        //number shift index
        int lx = 0;
        int current, rank;
        StringBuffer attempt = new StringBuffer();
        char c;
        while (x < 26) {
            x++;
            lx++;
            for (int i=0; i<input.length(); i++) {
                c = input.charAt(i);
                // if uppercase, use uppercase alphabet
                if (Character.isUpperCase(c)) {
                    // c = nth char of text input
                    // calculate r = rank of c in alphabet
                    current = upper_case_alphabet.indexOf(input.charAt(i));
                    // shift and get position within alphabet
                    rank = (current + x) % 26;
                    //letter with rank R2 in alphabet
                    c = upper_case_alphabet.charAt(rank);
                    attempt.append(c);
                //else if lowercase, use lowercase alphabet
                } else if (Character.isLowerCase(c)) {
                    // c = nth char of text input
                    // calculate r = rank of c in alphabet
                    current = lower_case_alphabet.indexOf(input.charAt(i));
                    // shift and get position within alphabet
                    rank = (current + x) % 26;
                    //letter with rank R2 in alphabet
                    c = lower_case_alphabet.charAt(rank);
                    attempt.append(c);                
                //else , if not upper or lowercase, leave as is 
                } else {
                    attempt.append(c);
                }     
            }
            attempt.append("\n");
        }
        System.out.print(attempt);
        return attempt.toString();

    }

}
