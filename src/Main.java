import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Main {

    public static void main(String[] args) {

        /*
        Posso instanciar o SellerDao agora, mas note que sem o 'new SellerDAO (...)'
        Agora, meu método não precisa saber da implementação.
         */

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
    }
}
