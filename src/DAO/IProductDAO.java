package DAO;

import Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> showAll() throws SQLException, ClassNotFoundException;
    void createProduct(Product product) throws SQLException, ClassNotFoundException;
    void editProduct(Product product) throws SQLException, ClassNotFoundException;
    void deleteProduct(Product product) throws SQLException, ClassNotFoundException;
}
