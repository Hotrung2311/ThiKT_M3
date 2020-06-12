package DAO;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/products?useSSL=false";
        String user = "root";
        String password = "1234";
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    @Override
    public List<Product> showAll() throws SQLException, ClassNotFoundException {
        String selectAll = "select * from product;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(selectAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> productList = new ArrayList<>();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            String category = resultSet.getString("category");
            productList.add(new Product(id, name, price, amount, color, description, category));
        }
        return productList;
    }

    @Override
    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        String create = "insert into product(name, price, amount, color, description, category) values (?,?,?,?,?,?);";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(create);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getPrice());
        preparedStatement.setInt(3, product.getAmount());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setString(6, product.getCategory());
        preparedStatement.executeUpdate();

    }

    @Override
    public void editProduct(Product product) throws SQLException, ClassNotFoundException {
//        String create = "insert into product(name, price, amount, color, description, category) values (?,?,?,?,?,?);";
        String update = "update product set name=?, price=?, amount=?, color=?, description=?, category=? where id=?;";
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getPrice());
        preparedStatement.setInt(3, product.getAmount());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setString(6, product.getCategory());
        preparedStatement.setInt(7, product.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteProduct(int id) throws SQLException, ClassNotFoundException {
        String delete = "delete from product where id=?;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }

    @Override
    public Product findById(int id) throws SQLException, ClassNotFoundException {
        String delete = "select * from product where id=?;";
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);

        Product product = null;

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int _id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            int amount = resultSet.getInt("amount");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            String category = resultSet.getString("category");
            product = new Product(_id, name, price, amount, color, description, category);
        }
        return product;
    }


}
