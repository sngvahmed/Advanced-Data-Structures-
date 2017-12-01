package homework3;

import java.io.*;
import java.util.*;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {
        if (filename == null) return new ArrayList<Sentence>();

        List<Sentence> result = new LinkedList<Sentence>();
        String[] ranges = {"-2", "-1", "0", "1", "2"};

        ClassLoader classLoader = new Analyzer().getClass().getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(filename).getFile());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("File not found ");
            return new ArrayList<Sentence>();
        }

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length <= 1 || !isFound(ranges, words[0])) {
                    continue;
                }

                result.add(new Sentence(Integer.parseInt(words[0]), line.substring(words[0].length() + 1, line.length())));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    private static boolean isFound(String[] ranges, String word) {
        for (String rng : ranges) {
            if (word.equals(rng)) return true;
        }
        return false;
    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

        if (sentences == null) return new HashSet<Word>();

        Map<String, Integer> wordScore = new HashMap<String, Integer>();
        Map<String, Integer> wordCount = new HashMap<String, Integer>();

        for (Sentence sentence : sentences) {
            if (sentence == null) continue;
            StringTokenizer words = new StringTokenizer(sentence.text);
            Integer score = sentence.score;

            while (words.hasMoreTokens()) {
                String wordTxt = words.nextToken();

                if (valid(wordTxt) == false) continue;
                if (wordCount.get(wordTxt) == null) {
                    wordCount.put(wordTxt, 0);
                    wordScore.put(wordTxt, 0);
                }
                wordCount.put(wordTxt, wordCount.get(wordTxt) + 1);
                wordScore.put(wordTxt, wordScore.get(wordTxt) + score);
            }
        }

        Set<Word> res = new HashSet<Word>();

        for (Map.Entry<String, Integer> entry : wordScore.entrySet()) {
            Word word = new Word(entry.getKey());
            word.count = wordCount.get(entry.getKey());
            word.total = entry.getValue();
            res.add(word);
        }

        return res;
    }

    private static boolean valid(String word) {
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') continue;
            return false;
        }
        return true;
    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {
        if (words == null) return new HashMap<String, Double>();
        Map<String, Double> res = new HashMap<String, Double>();

        for (Word word : words) {
            if (word == null) continue;

            res.put(word.text, word.calculateScore());
        }

        return res;

    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
        if (sentence == null || wordScores == null
                || wordScores.isEmpty() || sentence.isEmpty()) return 0.0D;

        double numberOfWord = 0;
        double totalScore = 0;

        for (String word : sentence.toLowerCase().split(" ")) {
            if(valid(word) == false) continue;
            numberOfWord += 1.0D;
            if (wordScores.get(word) != null) {
                totalScore += wordScores.get(word);
            }
        }
        return (numberOfWord != 0.0D) ? totalScore / numberOfWord : 0.0D;

    }

    /*
     * This method is here to help you run your program. Y
     * You may modify it as needed.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify the name of the input file");
            System.exit(0);
        }
        String filename = args[0];
        System.out.print("Please enter a sentence: ");
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        in.close();
        List<Sentence> sentences = Analyzer.readFile(filename);
        Set<Word> words = Analyzer.allWords(sentences);
        Map<String, Double> wordScores = Analyzer.calculateScores(words);
        double score = Analyzer.calculateSentenceScore(wordScores, sentence);
        System.out.println("The sentiment score is " + score);
    }
}
