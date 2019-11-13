package JavaSeDay8;

import org.junit.Test;

public class ProductServiceImpTest {

    @Test
    public void testadd(){
        ProductServiceImp service = new ProductServiceImp();
        Product p  = new Product("p1","Necklace",199.9f,10000);
        service.addProduct(p);

        Product productID = service.getProductById("p1");
        System.out.println(productID);

    }
    @Test
    public void testGetByName(){
        ProductServiceImp service = new ProductServiceImp();
        Product p = new Product("p1","Necklace",199.9f,10000);
        service.addProduct(p);

        Product product = service.getProductByName("Necklace");
        System.out.println(product);

    }

    @Test
    public void testUpdatProducts(){
        ProductServiceImp service = new ProductServiceImp();
        Product p = new Product("p1","Necklace",199.9f,10000);
        service.addProduct(p);

        service.updateStockNum("p1",5000);
        Product product = service.getProductById("p1");
        System.out.println(product.getStockNum());
    }

}
