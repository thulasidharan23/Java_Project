
import java.util.*;
public class Riddle {
    public static void riddle(Character c,Scanner sc){
        HashMap<String,String> map=new HashMap<>();
        map.put("I speak without a mouth and hear without ears. I have no body, but I come alive with the wind.", "echo");
        map.put("You measure my life in hours and I serve you by expiring. I'm quick when I'm thin and slow when I'm fat. The wind is my enemy.", "candle");
        map.put("I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?", "map");
        map.put("What can travel around the world while staying in a corner?", "stamp");
        map.put("What has keys but can't open locks?", "piano");
        char ch=c;
        do{
            switch (ch) {
                case 'Y':
                case 'y':
                    List<String> keysAsArray = new ArrayList<>(map.keySet());
                    Random random = new Random();
                    String question = keysAsArray.get(random.nextInt(keysAsArray.size()));
                    System.out.println("Your Riddle is :" + question);
                    System.out.println("Guess you answer :");
                    String answer=sc.nextLine();
                    String ans=answer.toLowerCase();
                        if(map.get(question).equals(ans)){
                            System.out.println("Great ! ,You are the Master");
                        }
                        else{
                            System.out.println("Better Luck Next Time!");
                        }
                case 'n':
                case 'N':
                    System.out.println("Thanks for playing Riddle Game!! Come back for more riddles.");
                    break;
                default:
                    System.out.println("Click \"Y\" to continue || \"N\" to close the Game.");
                    ch=sc.next().charAt(0);
                    sc.nextLine();
                    break;
            }
        }while(ch!='y' && ch!='Y' && ch!='n' && ch!='N');
    }
    public static void main(String args[]){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Are you ready to play the Riddle? (Y/N):");
            char c=sc.next().charAt(0);
            sc.nextLine();
            riddle(c,sc);
        }
    }
}
