/*2 * Создать массив из слов
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
слово не угадано, компьютер показывает буквы которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно, можно пользоваться:
String str = "apple";
str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово
Используем только маленькие буквы*/

import java.util.Random;
import java.util.Scanner;

public class Number3 {
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
        String symbol = "#";

        OUTERMOST: do{
            if (cnt >= word.length()){
                String word1 = word;
                System.out.println("Введите слово заново, пока длина его не будет больше предыдущего: ");
                word = inp.nextLine();
                while (word.length() <= word1.length()){
                    System.out.println("Введите слово заново, пока длина его не станет больше предыдущего: ");
                    word = inp.nextLine();
                }
            }
            else if (word.equals(random_word)) {
                output = random_word;
                break;
            }
            else if (word.charAt(cnt) == random_word.charAt(cnt) && word.substring(0, cnt).equals(random_word.substring(0, cnt))){
                while (word.charAt(cnt) == random_word.charAt(cnt)){
                    output = output.substring(0, cnt) + random_word.charAt(cnt);
                    cnt += 1;
                    if (output.equals(random_word)){
                        cnt = random_word.length();
                        System.out.println("Внутри вашего слова содержится угадываемое, считайте, что повезло.");
                        break OUTERMOST;
                    }
                    if (cnt >= word.length()) break;
                }
                System.out.println(output + symbol.repeat(15 - cnt));
            }else{
                System.out.println(output + symbol.repeat(15 - cnt));
            }
            System.out.println("Введите слово: ");
            word = inp.nextLine();
        }while (cnt != random_word.length());

        System.out.printf("Вы угадали слово - %s, поздравляю!", output);
    }
}
