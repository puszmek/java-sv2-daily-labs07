package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> soldProducts = new ArrayList<>();

    public void addProduct(Product p) {
        if (p.getSellDate().isAfter(LocalDate.now())) {
            throw new IllegalStateException("Invalid sell date!");
        }
        soldProducts.add(p);
    }

    public Path writeToFileByMonth(Month month, Path testPath) {
        List<String> result = createStringListByMonth(month);
        try {
            StringBuilder sb = new StringBuilder().append("soldProducts_").append(month.name()).append(".csv");
            Path path = Paths.get(sb.toString());
            Files.write(testPath, result);
            return path;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can't write file!", ioe);
        }
    }

    private List<String> createStringListByMonth(Month month) {
        List<String> result = new ArrayList<>();
        for (Product actual : soldProducts) {
            if (actual.getSellDate().getMonth() == month) {
                result.add(actual.toString());
            }
        }
        return result;
    }

    public List<Product> getSoldProducts() {
        return soldProducts;
    }
}
