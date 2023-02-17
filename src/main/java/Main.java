import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "countries.csv";

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        Map<String, Country> countries = readCountries(FILE_NAME);
        printCountryByKey(countries, scanner);
    }

    private Map<String, Country> readCountries(String filename) {
        Map<String, Country> countries = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(filename))
        ) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                String key = split[0];
                String abbreviation = key;
                String name = split[1];
                BigDecimal population = BigDecimal.valueOf(Long.parseLong(split[2]));
                Country country = new Country(name, abbreviation, population);
                countries.put(key, country);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku " + filename);
        }
        return countries;
    }

    private void printCountryByKey(Map<String, Country> map, Scanner scanner) {
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String key = scanner.nextLine().toUpperCase();
        Country country = map.get(key);
        if (country != null) {
            System.out.println(country.getName() + " (" + country.getAbbreviation() + ")"
                    + " ma " + country.getPopulation() + " ludności.");
        } else {
            System.out.println("Kod kraju " + key + " nie został znaleziony.");
        }
        scanner.close();
    }

}
