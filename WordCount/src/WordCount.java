import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class WordCount {

    public static void main(String[] args){


        BufferedReader reader = null;

        int charCount = 0;

        int wordCount = 0;

        int lineCount = 0;

        try {

            reader = new BufferedReader(new FileReader("aStory"));

            String currentLine = reader.readLine();

            while (currentLine != null) {

                lineCount++;

                String[] words = currentLine.split(" ");

                wordCount = wordCount + words.length;

                for (String word : words) {

                    charCount = charCount + word.length();
                }

                currentLine = reader.readLine();
            }

            System.out.println("Number Of Chars In A Story File : "+charCount);

            System.out.println("Number Of Words In A Story File : "+wordCount);

            System.out.println("Number Of Lines In A Story File : "+lineCount);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>(50, 10);
        //Not sure what the (50,10) is for

        try {
            File input = new File("input.txt");
            Scanner read = new Scanner(new FileInputStream("aStory"));
            ArrayList<String> list = new ArrayList<>();

            while (read.hasNext()) {
                list.add(read.next());
            }

            for(String w : list)
                map.put(w, map.getOrDefault(w, 0) + 1);

            System.out.println(" ");
            System.out.println(" the number of times each word occurs in the file ");
            System.out.println(map.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }


        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Please enter a word: ");
        String wordname = scan.nextLine();

        int count = 0;
        try (LineNumberReader r = new LineNumberReader(new FileReader("aStory"))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String element : line.split(" ")) {
                    if (element.equalsIgnoreCase(wordname)) {
                        count++;
                        System.out.println("Word found at line " + r.getLineNumber());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The word " + wordname + " appears " + count + " times.");

    }
}