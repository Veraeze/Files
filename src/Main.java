import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        createTextFile("C:\\Users\\USER\\IdeaProjects\\Files\\src\\productList", "product.txt");
        createJsonFile("C:\\Users\\USER\\IdeaProjects\\Files\\src\\productList", "product.json");

        Product product1 = new Product("1", "coke", BigDecimal.valueOf(1000), 2);
        Product product2 = new Product("2", "chocolate", BigDecimal.valueOf(1500), 5);
        Product product3 = new Product("3", "pepsi", BigDecimal.valueOf(200), 1);
        Product product4 = new Product("4", "honey", BigDecimal.valueOf(500), 3);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        writeToTextFile(products);
        writeToJsonFile(products);


    }

    public static void writeToTextFile(List<Product> products) {
        StringBuilder list = new StringBuilder("");
        String location = "C:\\Users\\USER\\IdeaProjects\\Files\\src\\productList\\product.txt";
        for (Product product : products) {
            list.append(product);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(location)) {
            String data = "id      name        price       quantity" + list;
            byte[] bytesFormOFTheData = data.getBytes();
            fileOutputStream.write(bytesFormOFTheData);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void createTextFile(String location, String filename) {
        Path path = Path.of(location, filename);
        try {
            Files.createFile(path);
        } catch (IOException exception) {exception.printStackTrace();        }
    }

    public static void writeToJsonFile(List<Product> products) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileOutputStream writer = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Files\\src\\productList\\product.json")) {
            mapper.writeValue(writer, products);
        } catch (IOException exception) {exception.printStackTrace();}
    }

    public static void createJsonFile(String location, String filename) {
        Path path = Path.of(location, filename);
        try {
            Files.createFile(path);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

