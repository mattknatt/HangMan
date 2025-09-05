package org.example;

import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void hangMan() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //Skapar en String-array för möjliga ord
        String[] wordPool = {"ITERATION", "PIRAYA", "KANTARELL", "MALLORCA", "KONSTNÄRLIG", "TRUNKERAD", "AVSLUTNING",
                "REPARATÖR", "AVDANKAD", "KOLIBRI"};
        String correctAnswer;
        String guess;
        boolean playAgain;
        System.out.println("Välkommen till Hänga Gubbe!");
        playAgain = true;
        //Artwork
        String[] artwork = {
                """
                          +---+
                          |   |
                              |
                              |
                              |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                              |
                              |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                          |   |
                              |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                         /|   |
                              |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                              |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         /    |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """,
                """
                          +---+
                          |   |
                          O   |
                         /|\\  |
                         / \\  |
                              |
                          /‾‾‾‾‾‾‾\\
                         /         \\
                        /           \\
                        ‾‾‾‾‾‾‾‾‾‾‾‾‾
    """
        };
        //While-loop för att köra om spelet så länge användaren vill
        while (playAgain) {
            int triesLeft = 7;
            //String för gissade bokstäver.
            String guessedLetters = "";
            // Skapar en random-funktion för att slumpa ett ord per spelomgång.
            int index = random.nextInt(wordPool.length);
            correctAnswer = wordPool[index];
            System.out.println("Ordet du söker har " + correctAnswer.length() + " bokstäver.");
            System.out.println("Börja med att gissa på valfri bokstav. ");

            //Spelet körs så länge antal gissningar kvar >0
            while (triesLeft > 0) {
                System.out.println("Du har " + triesLeft + " felgissningar kvar;");
                //Ta emot input, göra till stor bokstav och ta bort eventuella mellanslag
                guess = sc.nextLine().toUpperCase().trim();
                if (guess.isEmpty()) {
                    System.out.println("Du måste skriva en bokstav!");
                    continue;
                }

                String allowed = guess;
                //Skapar en String där alla bokstäver utom de korrekt gissade skrivs ut som _
                String currentWord = correctAnswer.replaceAll("[^" + allowed + guessedLetters + "]", "_");

                if (currentWord.equals(correctAnswer)) {
                    System.out.println("Grattis, du löste det!");
                    System.out.println(currentWord);
                    triesLeft = 0;
                } else if (correctAnswer.contains(guess)) {
                    System.out.println("Bra jobbat, bokstaven fanns i ordet!");
                    System.out.println(currentWord);
                } else {
                    System.out.println("Tyvärr fanns inte den bokstaven med.");
                    triesLeft--;
                    //Switch-sats för att visa olika artwork baserat på hur många felgissningar du gjort
                    switch (triesLeft) {
                        case 6 -> System.out.println(artwork[0]);
                        case 5 -> System.out.println(artwork[1]);
                        case 4 -> System.out.println(artwork[2]);
                        case 3 -> System.out.println(artwork[3]);
                        case 2 -> System.out.println(artwork[4]);
                        case 1 -> System.out.println(artwork[5]);
                        case 0 -> System.out.println(artwork[6]);
                    }
                    System.out.println(currentWord);


                }
                //Lägger till senast gissade bokstav/bokstäver till tidigare gissade
                guessedLetters = guessedLetters + guess;


            }
            //Avslutad loop - slutmeddelande och fråga om att spela igen
            System.out.println("Ordet var " + correctAnswer);
            //Fråga om att spela igen
            System.out.println("Vill du spela igen? ja/nej");
            String playAgainAnswer = sc.nextLine().toLowerCase();
            if (playAgainAnswer.equals("nej")) {
                playAgain = false;
            }

        }
        System.out.println("Tack för att du spelade!");


    }
}
