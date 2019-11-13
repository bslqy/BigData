package JavaSeDay8;

import java.util.ArrayList;

public class ProductServiceImp implements ProductService {
    ProductDao productDao = new ProductDaoImpl();


    @Override
    public void addProduct(Product p) {
        productDao.addProduct(p);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    @Override
    public ArrayList<Product> getProductByPriceRange(float min, float max) {
        return productDao.getProductByPirceRange(min,max);
    }

    @Override
    public void removeProductById(String pId) {
        productDao.removeProductById(pId);
    }

    @Override
    public void updateName(String pId, String newName) {
    Product p = productDao.getProductById(pId);
    p.setpName(newName);
    productDao.updateProduct(p);
    }

    @Override
    public void updatePrice(String pId, float newPrice) {
        Product p = productDao.getProductById(pId);
        p.setPrice(newPrice);
        productDao.updateProduct(p);


    }

    @Override
    public void updateStockNum(String pId, int newStockNumber) {
        Product p = productDao.getProductById(pId);
        p.setStockNum(newStockNumber);
        productDao.updateProduct(p);

    }
}
