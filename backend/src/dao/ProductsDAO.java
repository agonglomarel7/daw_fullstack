package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.PolyBayDatabase;
import models.Product;

public class ProductsDAO {

    private PolyBayDatabase database;

    public ProductsDAO() {
        try {
            this.database = new PolyBayDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }



    public ArrayList<Product> findAll() {

        ArrayList<Product> productsList = new ArrayList<Product>();

        try {
            PreparedStatement mystatement =  this.database.prepareStatement("SELECT id, name, owner, bid FROM product");
            ResultSet resultSet = mystatement.executeQuery();

            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final String owner = resultSet.getString("owner");
                final float bid = resultSet.getFloat("bid");

                Product product = new Product(id, name, owner, bid);

                productsList.add(product);
            }
        
        
        } catch (Exception e) {
            System.err.println(e.getMessage());;
        }

        return productsList;
    }
}
