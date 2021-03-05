import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Department dept = new Department(1,"books");

        Seller seller = new Seller(1,"Bombs","bombs@gmail.com",new Date(),5000.00, dept);

        System.out.println(seller);
    }
}
