package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDAO {

    void insert(Seller seller);
    void update(Seller seller);
    void deleteById(Integer id);
    Seller findById(Integer id);  // Encontro o vendedor por sua id
    List<Seller> findAll();       // Encontro todos os vendedores e jogo numa lista de vendedores
}
