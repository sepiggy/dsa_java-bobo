import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("Set/res/pride-and-prejudice.txt", words1);
//        FileOperation.readFile("Set/res/a-tale-of-two-cities.txt", words1);
        System.out.println("Total words: " + words1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word : words1) {
            set1.add(word);
        }
        System.out.println("Total different words: " + set1.getSize());
    }
}
