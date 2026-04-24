package Quiz;


/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

import Game.Game;

public class Quiz implements Game {
        static Scanner sc = new Scanner(System.in);

        
       @Override
  public String getGameName(){
return ("Weekend Warrior Quiz");
  }
        public void play() {

                

                
                // Create Categories
                Category gogetter = new Category("Go-Getter",
                                "You are disciplined, driven, and focused");
                Category chill = new Category("Chill-Cuddler", "You are very competitive "
                                + "but it's hidden underneath a friendly verneer. You're kinda popular but you deny it.");
                Category socialb = new Category("Social Butterfly",
                                "You are a racket! always want to be surrounded by people. You are the life of the party");
                Category SoloE = new Category("Solo Explorer",
                                "After a long week you like nothing better than to have some low energy time to yourself or with freinds. ");
                // Create Questions
                Question q1 = new Question("It's Friday evening. How are you feeling");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("I want to try something new and exciting\n" + //
                                "", gogetter);
                q1.possibleAnswers[1] = new Answer("I’m up for hanging out with friends and maybe go out\n" + //
                                "",
                                socialb);
                q1.possibleAnswers[2] = new Answer("I just want to chill at home and relax\n" + //
                                "", chill);
                q1.possibleAnswers[3] = new Answer("I feel like some quiet time alone maybe a walk or a book\n" + //
                                "", SoloE);

                Question q2 = new Question("What is your ideal way to start your saturday morning\n" + //
                                "?");
                q2.possibleAnswers[0] = new Answer("Early workout or a jog + coffee\n" + //
                                "", gogetter);
                q2.possibleAnswers[1] = new Answer("Head out solo to a museum, café, or a stroll\n" + //
                                "", SoloE);
                q2.possibleAnswers[2] = new Answer("Sleep in, then enjoy a slow breakfast or brunch\n" + //
                                "", chill);
                q2.possibleAnswers[3] = new Answer("Call a friend/ group and plan something fun\n" + //
                                "",
                                socialb);

                Question q3 = new Question("What do you do to relax?" + //
                                "?");
                q3.possibleAnswers[0] = new Answer("Reading, journaling, walking or quiet creative time" + //
                                "", SoloE);
                q3.possibleAnswers[1] = new Answer("Do something active (sports, dancing, exploring)\n" + //
                                "" + //
                                "", gogetter);
                q3.possibleAnswers[2] = new Answer("Hanging out, chatting, maybe grabbing drinks or food with pals\n" + //
                                "" + //
                                "" + //
                                "", socialb);
                q3.possibleAnswers[3] = new Answer("Couch, cozy blankets, movies or comfort food\n" + //
                                "" + //
                                "",
                                chill);
                Question q4 = new Question("Given a free weekend with no plans. What do you lean toward?" + //
                                "?");
                q4.possibleAnswers[1] = new Answer("Use it to recharge alone reflect explore at your own p-ace\n" + //
                                "" + //
                                "", SoloE);
                q4.possibleAnswers[0] = new Answer("Fill it with events / adventures / new experiences\n" + //
                                "" + //
                                "" + //
                                "", gogetter);
                q4.possibleAnswers[3] = new Answer("Invite a few friends, maybe spontaneous day-out\n" + //
                                "" + //

                                "", socialb);
                q4.possibleAnswers[2] = new Answer("Couch, cozy blankets, movies or comfort food\n" + //
                                "" + //
                                "",
                                chill);

                Question q5 = new Question("How do you usually plan your weekends" + //
                                "?");
                q5.possibleAnswers[0] = new Answer("Use it to recharge alone reflect explore at your own pace" + //
                                "" + //
                                "", SoloE);
                q5.possibleAnswers[1] = new Answer("Fill it with events / adventures / new experiences" + //
                                "" + //
                                "" + //
                                "", gogetter);
                q5.possibleAnswers[3] = new Answer("I plan ahead and schedule everything for max fun" + //
                                "" + //

                                "", socialb);
                q5.possibleAnswers[2] = new Answer("I keep it chill and go with the low" + //
                                "" + //
                                "" + //
                                "",
                                chill);
                Question q6 = new Question("If you could pick a weekend activity, you’d choose" + //
                                "" + //
                                "?");
                q6.possibleAnswers[1] = new Answer(
                                "A walk in nature reading at a café exploring a new neighborhood alone" + //
                                                "" + //
                                                "" + //
                                                "",
                                SoloE);
                q6.possibleAnswers[3] = new Answer("A road-trip, hike concert" + //
                                "" + //
                                "" + //
                                "" + //
                                "", gogetter);
                q6.possibleAnswers[0] = new Answer("A lively brunch, social gathering, party" + //
                                "" + //
                                "n" + //
                                "" + //

                                "", socialb);
                q6.possibleAnswers[2] = new Answer("A cozy movie marathon and junk food at home" + //
                                "" + //
                                "" + //
                                "" + //
                                "", chill);

                Question q7 = new Question("Your energy level after a busy week is" + //
                                "" + //
                                "?");
                q7.possibleAnswers[0] = new Answer("Moderate but your still up for new experiences" + //
                                "" + //
                                "" + //
                                "", SoloE);
                q7.possibleAnswers[1] = new Answer("Still high, you're ready to go" + //
                                "" + //
                                "" + //
                                "" + //
                                "" + //
                                "", gogetter);
                q7.possibleAnswers[2] = new Answer("Moderate, enough to socialize and have fun" + //
                                "" + //
                                "" + //
                                "n" + //
                                "" + //

                                "", socialb);
                q7.possibleAnswers[3] = new Answer("Low, you need downtime and rest" + //
                                "" + //
                                "" + //
                                "" + //
                                "" + //
                                "", chill);

                // ... more questions here

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { gogetter, socialb, chill, SoloE

                };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("You are a1 " + cList[index].label + ". ");
                System.out.println(cList[index].description);

        }
        
        public void gameIntro() {
                // requires 1 to keep going
                System.out.println("What weekend warrior are you?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                if (sc.hasNextInt() == true) {
                        int play = sc.nextInt();
                        if (play != 1) {
                                System.out.println("Unidentifiable input. Please enter '1' to play");
                                gameIntro(); // hasnextint // next
                        }
                } else {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        sc.next();
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
        @Override
        public String getScore() {
        return "n/a";
        }
        public static Scanner getSc() {
                return sc;
        }
        public static void setSc(Scanner sc) {
                Quiz.sc = sc;
        }
}
