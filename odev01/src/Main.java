import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> students = new HashMap<>();

        List<String> classA = new ArrayList<>();
        classA.add("Can Bartu");
        classA.add("Ahmet Akay");
        classA.add("Ferhan Sevinchan");

        List<String> classB = new ArrayList<>();
        classB.add("Mevlüt Bartu");
        classB.add("Ayhan Akay");
        classB.add("Mustafa Sevinchan");

        List<String> classC = new ArrayList<>();
        classC.add("Kemal Bartu");
        classC.add("Nurlan Akay");
        classC.add("Ozcan Sevinchan");

        students.put("12-B",classA);
        students.put("12-A",classB);
        students.put("12-C",classC);


        for (Map.Entry<String, List<String>> entry : students.entrySet()) {

            for(String name : entry.getValue()){
                String[] arrOfStr = name.split(" ");

                if (arrOfStr[0].endsWith("an")) {
                    System.out.println(entry.getKey() + " " + name);
                }

            }
            System.out.println();
        }
    }
}