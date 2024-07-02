import java.util.Random;
import java.util.Scanner;

public class TypingSpeedTest {
    // Array of different sentences
    private static final String[] sentences={
        "Java’s robust libraries and frameworks accelerate software development",
        "Java’s garbage collection ensures efficient memory management.",
        "Developed by Sun Microsystems in 1995, Java is a highly popular, object-oriented programming language.",
        "Classes in Java are the blueprint for creating objects and defining their properties and behaviors.",
        "Interfaces in Java are abstract types that define a set of methods that a class must implement. ",
    };

    private static final String[] paragraphs={
        "When compared with C++, Java codes are generally more maintainable because Java does not allow many things which may lead to bad/inefficient programming if used incorrectly.",
        "Java syntax is similar to C/C++. But Java does not provide low-level programming functionalities like pointers. Also, Java codes are always written in the form of classes and objects.",
        "The Java community continues to thrive, with new features and improvements in each release. So, embrace Java and join the global network of developers shaping the future of technology",
        "When you delve into Java, you’ll discover its platform independence. It runs on over 3 billion devices worldwide, making it a crucial language for enterprise applications, Android app development, big data processing, and maintaining legacy software. ",
        "Java is a versatile programming language that has found applications in various domains. From building websites to operating systems, Java’s stability and reliability make it a popular choice. It even plays a role in outer space, powering the Mars rover on its mission."
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Typing Speed Test by ProjectGurukul!");
        System.out.println();

        while(true){
            // Prompt the user to select the text type
            System.out.println("What type of text do you want to type?");
            System.out.println("1. Sentence");
            System.out.println("2. Paragraph");
            System.out.print("Enter your choice (1 or 2): ");
            int textTypeChoice = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt()

            String originalText;

            if(textTypeChoice==1){
                // Randomly select a sentence from the array
                originalText=sentences[random.nextInt(sentences.length)];
            } 
            else if(textTypeChoice==2){
                // Randomly select a paragraph from the array
                originalText=paragraphs[random.nextInt(paragraphs.length)];
            } 
            else{
                System.out.println("Invalid choice. Please try again.");
                continue; // Restart the loop to get a valid choice
            }

            System.out.println("Type the following text:");
            System.out.println(originalText);
            System.out.println();

            // Prompt user to start the test
            System.out.println("Press Enter when you are ready to start the test.");
            sc.nextLine();

            // User types the text
            System.out.println("Type the text:");
            long startTime=System.currentTimeMillis();
            String userInput=sc.nextLine();
            long endTime=System.currentTimeMillis();

            // Calculate elapsed time in seconds
            long elapsedTime=endTime-startTime;
            double seconds=elapsedTime/1000.0;

            int originalTextLength=originalText.length();
            int userInputLength=userInput.length();
            int correctCharacters=0;

            // Compare the user's input with the original text to count correct characters
            for(int i=0;i<Math.min(originalTextLength, userInputLength);i++){
                if(originalText.charAt(i)==userInput.charAt(i)){
                    correctCharacters++;
                }
            }

            // Calculate accuracy as a percentage
            int accuracy=(int)(((double) correctCharacters/originalTextLength)*100);

            // Calculate words per minute
            double wordsPerMinute=(userInputLength/5.0)/(seconds/60);

            // Display test results
            System.out.println();
            System.out.println("Test Result:");
            System.out.println("--------------");
            System.out.println("Time elapsed: " + seconds + " seconds");
            System.out.println("Accuracy: " + accuracy + "%");
            System.out.println("Words per minute: " + wordsPerMinute);

            // Additional functionality - Check for extra or missing characters
            if(userInputLength>originalTextLength){
                int extraCharacters=userInputLength-originalTextLength;
                System.out.println("Extra characters typed: " + extraCharacters);
            } 
            else if(userInputLength<originalTextLength){
                int missingCharacters=originalTextLength-userInputLength;
                System.out.println("Missing characters: " + missingCharacters);
            }

            System.out.println("------------------------------");

            // Prompt the user to try again
            System.out.println("Would you like to try again? (Y/N)");
            String choice=sc.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                break; // Exit the loop if the user doesn't want to try again
            }
        }

        System.out.println("Thank you for using the Typing Speed Test . Goodbye!");
        sc.close(); // Close the scanner after the loop ends
    }
}