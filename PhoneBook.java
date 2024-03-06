import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        
        // Входная структура данных
        String[][] input = {
            {"Алина", "+375259875654"},
            {"Денис", "+375259454646"},
            {"Алина", "+375254556364"},
            {"Маргарита", "+375255689989"},
            {"Максим", "+375254568523"},
            {"Денис", "+375254563217"},
            {"Алина", "+375254953539"},
            {"Денис", "+375254453646"},
            {"Алина", "+375255675657"},
            {"Максим", "+375254687537"},
            {"Маргарита", "+375254564555"},
            {"Рома", "+375254565445"}
        };
        
        // Заполнение телефонной книги
        for (String[] entry : input) {
            String name = entry[0];
            String phoneNumber = entry[1];
            
            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, new HashSet<>());
            }
            phoneBook.get(name).add(phoneNumber);
        }
        
        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        
        // Вывод результатов
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.print(entry.getKey() + ": ");
            for (String phoneNumber : entry.getValue()) {
                System.out.print(phoneNumber + " ");
            }
            System.out.println();
        }
    }
}