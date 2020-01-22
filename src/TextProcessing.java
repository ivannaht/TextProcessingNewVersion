import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessing {
        public static void main(String[] args) throws FileNotFoundException {
            //читання файлу
            File file = new File("Energy in Ukraine.txt");
            Scanner in = new Scanner(file);
            String s = "";
            while (in.hasNext())
                s += in.nextLine() + "\r\n";

            // поділити текст на слова
            String[] a = s.split("\\s");

            //Порахувати скільки слів є в тесті
            Arrays.asList(a);
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            System.out.println("*********");
            System.out.println("Number of words " + a.length);
            System.out.println("*********");

            //поділити текст на речення
            String[] sentences = s.split("[\\.\\!\\?]");
            for(int j= 0;j<(sentences.length-1);j++)
                System.out.println((j+1)+ ")" + sentences [j] + " ");
            System.out.println("*********");

            //Порахувати скільки речень є в тесті
            int numSentence = 1;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i].endsWith(".") | a[i].endsWith("?") | a[i].endsWith("!")) {
                    numSentence++;
                }
            }
            System.out.println("Number of sentences " + numSentence);
            System.out.println("*********");


            // Кожне друге речення перевести до верхнього регістру
            for (int j = 1; j < (sentences.length-1); j=j+2) {
                System.out.println((j+1)+")" +sentences[j].toUpperCase());}
            System.out.println("*********");

            //Останні три речення об'єднати в одне використовуючи коми
            String threeSent = null;
            for(int j= 0;j<numSentence;j++){
                threeSent  =  sentences [numSentence-3] + ","
                        + sentences [numSentence-2]+ ","+ sentences [numSentence-1];
            }
            System.out.println(threeSent + " ");

            System.out.println("*********");

            // Порахувати скільки в тексті є слів з довжиною 3, 5, 7 символів
            Arrays.sort(a);
            int numwordOfthee = 0;
            int numwordOffive = 0;
            int numwordOfseven = 0;

            for (int i = 0; i < a.length; i++){
                if (a[i].length() == 3) {
                    numwordOfthee++;
                    System.out.println(a[i]);
                }}
            System.out.println("Number of words with three letters" + " "  + numwordOfthee);
            System.out.println("*********");

            for (int i = 0; i < a.length; i++){
                if (a[i].length() == 5) {
                    numwordOffive++;
                    System.out.println(a[i]);
                }}
            System.out.println("Number of words with five letters" + " " + numwordOffive);
            System.out.println("*********");
            for (int i = 0; i < a.length; i++){
                if (a[i].length() == 7) {
                    numwordOfseven++;
                    System.out.println(a[i]);
                }}
            System.out.println("Number of words with seven letters" + " "  + numwordOfseven);
            System.out.println("*********");


            //пошук всіх чисел
            System.out.print("All numbers in text:" + " " );
            for (int i = 0; i < a.length; i++){
                Pattern allNumbers=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                Matcher matcher1=allNumbers.matcher( a[i]);
                while (matcher1.find()) {
                    System.out.print( " " +  matcher1.group());
                }}


            //пошук чотиризначних дат XX-XXI століття
            System.out.println("*********");
            System.out.print("All dates in text:" + " " );
            for (int i = 0; i < a.length; i++){
                Pattern allYears=Pattern.compile("[2][0-9]{3,}");
                Matcher matcher2=allYears.matcher( a[i]);
                while (matcher2.find()) {
                    System.out.print( " " +  matcher2.group());
                }}


            in.close();
        }}


