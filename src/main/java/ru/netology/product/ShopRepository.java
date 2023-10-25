package ru.netology.product;

public class ShopRepository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        products = addToArray(products, product);
    }

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void saveProduct(Product item) throws Exception {
        if (findById(item.getId()) != null) {
            throw new Exception(
                    "Данный элемент с id: " + item.getId() + " уже добавлен в репозиторий"
            );
        }
    }

    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
    }

    public Product[] findAll() {
        return products;
    }

    public void save(Product product5) {
    }
}