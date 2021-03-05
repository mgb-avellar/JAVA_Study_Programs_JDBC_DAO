import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        Posso instanciar o SellerDao agora, mas note que sem o 'new SellerDAO (...)'
        Agora, meu método não precisa saber da implementação.
         */

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println();
        System.out.println("=== TEST 1: seller findById =====");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment =====");
        Department department = new Department(2, null );
        List<Seller> sellerList = sellerDAO.findByDepartment(department);
        for (Seller s : sellerList) {

            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== TEST 3: seller findAll =====");
        List<Seller> allSellersList = sellerDAO.findAll();
        for (Seller s : allSellersList) {

            System.out.println(s);
        }

        System.out.println();
        System.out.println("=== TEST 4: seller insert =====");
        Seller newSeller = new Seller(null, "Bombs", "bombs@gmail.com", new Date(), 9875.54,department);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getSellerID());



    }
}
