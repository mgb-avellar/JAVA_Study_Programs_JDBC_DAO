package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    /*
    Esta classe será responsável por instanciar meus DAOs
     */

    public static SellerDAO createSellerDAO () {

        return new SellerDaoJDBC();

        /*
        O que acontece é que o método retorna um objeto interface SellerDAO,
        mas internamente instancia uma implementação.
        Assim, não precisamos expor a implementação, apenas a interface.
         */
    }
}
