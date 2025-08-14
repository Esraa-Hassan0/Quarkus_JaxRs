package DAO;

import model.product;
import java.util.*;

public class productDAO {
    private static final List<product> products = new ArrayList<>();
    private static int counter = 1;

    public List<product> listAll() {
        return new ArrayList<>(products);
    }

    public void add(product product) {
        products.add(new product(counter++, product.getName(), product.getPrice()));
    }

    public product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void update(int id, String name, double price) {
        product p = getById(id);
        if (p != null) {
            p.setName(name);
            p.setPrice(price);
        }
    }

    public product delete(int id) {
        product del = getById(id);
      products.removeIf(p -> p.getId() == id);
      return del;
    }
}
