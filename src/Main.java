import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Department dept = new Department(1,"books");

        Seller seller = new Seller(1,"Bombs","bombs@gmail.com",new Date(),5000.00, dept);

        System.out.println(seller);

        /*
        Posso instanciar o SellerDao agora, mas note que sem o 'new SellerDAO (...)'
        Agora, meu método não precisa saber da implementação.
         */

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println(sellerDAO);
    }
}
