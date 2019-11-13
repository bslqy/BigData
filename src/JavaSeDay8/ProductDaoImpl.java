package JavaSeDay8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void addProduct(Product p) {
        ProductDatabase.pMap.put(p.getpID(),p);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> pList = new ArrayList<>();
        Set<Map.Entry<String, Product>> entries = ProductDatabase.pMap.entrySet();
        for (Map.Entry<String,Product> e : entries){
            pList.add(e.getValue());
        }

        return pList;
    }

    @Override
    public Product getProductById(String pId) {
        return ProductDatabase.pMap.get(pId);
    }

    @Override
    public Product getProductByName(String pName) {
        Collection<Product> values = ProductDatabase.pMap.values();
        for (Product p:values){
            if (p.getpName().equals(pName)) return p;

        }
        return null;
    }

    @Override
    public ArrayList<Product> getProductByPirceRange(float min, float max) {
        Collection<Product> values = ProductDatabase.pMap.values();
        ArrayList<Product> pList = new ArrayList<>();
        for (Product p : values){
            if (p.getPrice() >= min && p.getPrice() <= max){pList.add(p);}
        }

        return pList;
    }

    @Override
    public void removeProductById(String pId) {
        ProductDatabase.pMap.remove(pId);
    }

    @Override
    public void updateProduct(Product p) {
    ProductDatabase.pMap.put(p.getpID(),p);
    }
}
