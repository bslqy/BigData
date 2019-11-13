package JavaSeDay8;

import java.util.ArrayList;

public interface ProductDao   {

    public void addProduct(Product p);

    public ArrayList<Product> getAllProduct();

    public Product getProductById(String pId);

    public Product getProductByName(String pName);

    public ArrayList<Product> getProductByPirceRange(float min ,float max);

    public void removeProductById(String pId);

    public void updateProduct(Product p);
}
