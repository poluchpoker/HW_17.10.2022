import java.util.Random;
import java.util.Scanner;

public class Number2 {
    static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int index = random.nextInt(words.length);
        String random_word = words[index];

        guess_the_word(random_word);
    }

    public static void guess_the_word(String random_word) {
        int cnt = 0;
        String word = inp.nextLine();
        String output = "";

        do{
            if (word.charAt(cnt) == random_word.charAt(cnt)){
                output += word.charAt(cnt);
                cnt += 1;
            }else{
                String symbol = "#";
                System.out.println(output + symbol.repeat(15 - cnt));
                cnt = 0;
                word = inp.nextLine();
            }
        }while (cnt != random_word.length());
        System.out.println("Вы угадали слово: " + output);
    }
}
