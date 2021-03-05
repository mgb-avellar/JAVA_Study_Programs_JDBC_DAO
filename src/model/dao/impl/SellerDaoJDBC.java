package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDAO {

    /*
    Esta é uma implementação JDBC do meu SellerDAO
     */

    private Connection connection;  // Esta conexão agora está disponível para uso em todos os métodos
                                    //   dentro desta classe.

    public SellerDaoJDBC(Connection connection) {

        this.connection = connection;
    }


    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = connection.prepareStatement(
                    "SELECT seller.*, department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            /*
            Caso nosso result set (rs) não encontre nada em nossa consulta, precisamos retornar nulo.
             */

            if (rs.next()) {

                /*
                O ResultSet retorna uma tabela de dados com os resultados de nossa consulta.
                É importante ter em mente que na memória precisaremos "desmembrar" essa tabela
                instanciando dois objetos, um Seller e suas informações e um Department associado
                com suas informações próprias.
                 */

                /*
                Primeiro, instanciaremos um departamento e setamos as informações dele
                 */

                Department dep = instantiateDepartment(rs);

                /*
                Agora precisamos instanciar um vendedor e suas informações, incluindo a associação
                com o departamento que instanciamos acima.
                 */

                Seller seller = instantiateSeller(rs, dep);

                return seller;
            }
            else {
                return null;
            }
        }
        catch (SQLException e) {

            throw new DbException(e.getMessage());
        }
        finally {

            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {

        Seller seller = new Seller();

        seller.setSellerID(rs.getInt("Id"));
        seller.setSellerName(rs.getString("Name"));
        seller.setSellerEmail(rs.getString("Email"));
        seller.setSellerBaseSalary(rs.getDouble("BaseSalary"));
        seller.setSellerBirthDate(rs.getDate("BirthDate"));

        seller.setSellerDepartment(dep);  // Aqui está a associação com o departamento!!

        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {

        Department dep = new Department();

        dep.setDepartmentID(rs.getInt("DepartmentId"));
        dep.setDepartmentName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
