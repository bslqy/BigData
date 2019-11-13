package JavaSeDay8;

import java.util.ArrayList;

public interface ProductService {
    // Add product
    public void addProduct(Product p);

    public ArrayList<Product> getAllProduct();

    public Product getProductById(String id);

    public Product getProductByName(String name);

    public ArrayList<Product> getProductByPriceRange(float min , float max);

    public void removeProductById(String pId);

    public void updateName(String pId, String newName);

    public void updatePrice(String pID,float newPrice);

    public void updateStockNum(String pId, int newStockNumber);


}
