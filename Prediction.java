
/*
 Lab 8 for CS111
 //Jawaun Brown
 */
import java.util.*;
import java.util.Scanner;

public class Prediction
{
    static Scanner keyboard = new Scanner(System.in);
    static String[] dictionary={"the", "to", "i", "a", "and", "it", "is", "in", "you", "of", "for", "on", "my", "that", "with", "me", "do", "have", "just", "so", "are", "but", "now", "up", "good", "like", "no", "get", "time", "all", "we", "if", "day", "as", "how", "one", "am", "an", "them", "these"};
    
    //Write a function to read tweets from a user, and compute the number of times each dictionary word appeared in the tweets
    static int[] getWeights(){
        int lines = 0;
        String [] tweetWords = new String [0];
        int [] weight = new int[dictionary.length];
        System.out.println("please enter some words into the tweetbox");
        String tweet = keyboard.nextLine();
        while (!(tweet.equals("exit"))){
            tweetWords = tweet.split(" ");
            for (int i = 0; i<tweetWords.length; i++){
                for (int j = 0; j<dictionary.length; j++){
                    if(tweetWords[i].equals(dictionary[j])){
                        weight[j]++;
                    }
                }
            }
            tweet = keyboard.nextLine();
        }
        return weight;
        
        
    }
    
    //Write a function to find the most common word entered by the user. Remember to check for the case when no words are used more than once.
    static String mostCommonWord(int [] weight){ // this may be wrong; function might need additional parameters
        String mostCommonWord = dictionary[0];
        int largestWeight = weight[0];
        for(int i = 1; i<weight.length; i++){
            if(weight[i] > largestWeight){
                largestWeight = weight[i];
                mostCommonWord = dictionary[i];
            }
            if(largestWeight == 1){
                return ("no word used more than once");
            }
            
        }
        return mostCommonWord;
    }
    
    //Write a function to find the number of the times the common word was used
    static int weightCommonWord(String mostCommonWord, int [] weight){
        int weightCommonWord = 0;
        for(int i=0; i<dictionary.length; i++){
            if(mostCommonWord == dictionary[i]){
                weightCommonWord = weight[i];
            }
        }
        return weightCommonWord;
    }
    
    //Write a function to emulate autocorrect
    static String nextWord(){ //this may be wrong; function might need additional parameters
        String [] thDict = {the, them, these, the, that};
        String [] anDict = {an, and};
        String p1 = ("th");
        String p2 = ("an");
        String tweet = keyboard.nextLine();
        String j = "";
        String [] tweetWords = tweet.split(" ");
        for(int i=0; i<tweetwords.length; i++){
            if (tweetwords[i] == p1){
                j=String.join("," , thDict);
            }
            if (tweetwords[i] == p2){
                j = String.join("," , anDict);
            }
        }
        return String q=("did you mean" + j);
    }
    
    
    public static void main(String[] args)
    {
        
        int[] weights = getWeights();
        String mostCommonWord = mostCommonWord(weights);
        int weightCommonWord = weightCommonWord(mostCommonWord, weights);
        System.out.println("Most commonly used word: "+ mostCommonWord + ", "+ weightCommonWord + " times.");
        System.out.println();
        System.out.println("Type a prefix and press enter to see the autocomplete recommendation.");
        
        String prefix = keyboard.nextLine();
        System.out.println("Autocomplete recommendation: "+ nextWord());
        
    }
}
