import java.util.Iterator;

public class TestDynamicArray {
    public static void main(String[] args) {
        DataCollection<String> arr1 = new DynamicArray<String>();
        arr1.put("Seoul");
        arr1.put("Busan");
        arr1.put("Gwangju");
        arr1.put("Daejeon");
        arr1.put("Cheonan");
        arr1.put("Ulsan");
        arr1.put("Daegu");
        arr1.put("Incheon");



        System.out.println("\n변경 전:  DynamicArray를 이용");
        System.out.println("--------------------------------");
        System.out.println("index");
        for (int i = 0; i < arr1.length(); i++) {
            String s = (String) arr1.elemAt(i);
            System.out.println(s);
        }


        System.out.println("--------------------------------");
        System.out.println("iterator");
        for (Iterator iter = arr1.createIterator(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println(s);
        }


        DataCollection<String> arr2 = new DataCollectionAdapter<String>();
        arr2.put("Seoul");
        arr2.put("Busan");
        arr2.put("Gwangju");
        arr2.put("Daejeon");
        arr2.put("Cheonan");
        arr2.put("Ulsan");
        arr2.put("Daegu");
        arr2.put("Incheon");



        System.out.println("\n변경 후:  DataCollectionAdapter를 이용");
        System.out.println("--------------------------------");
        System.out.println("index");
        for (int i = 0; i < arr2.length(); i++) {
            String s = (String) arr2.elemAt(i);
            System.out.println(s);
        }

        System.out.println("--------------------------------");
        System.out.println("iterator");
        for (Iterator iter = arr2.createIterator(); iter.hasNext(); ) {
            String s = (String) iter.next();
            System.out.println(s);
        }
    }
}