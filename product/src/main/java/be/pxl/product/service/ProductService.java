package be.pxl.product.service;

import be.pxl.product.dao.DAOUtil;
import be.pxl.product.domain.Product;
import be.pxl.product.domain.UserAccount;

import java.sql.SQLException;
import java.util.List;

/**
 * ProductService bean.
 */
public class ProductService {

    public UserAccount findUser(String userName, String password) {

        UserAccount gebruiker = null;
        // make use of DAOUtil
        try {
            gebruiker = DAOUtil.findUser(userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gebruiker;
    }

    public UserAccount findUser(String userName) {

        try {
            DAOUtil.findUser(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // make use of DAOUtil

        return null;
    }

    public List<Product> queryProduct() {

        // make use of DAOUtil
        try {
            List<Product> productList = DAOUtil.queryProduct();
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product findProduct(String code) {

        try {
            DAOUtil.findProduct(code);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // make use of DAOUtil

        return null;
    }

    public void updateProduct(Product product) {

        try {
            DAOUtil.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // make use of DAOUtil

    }

    public void insertProduct(Product product) {

        try {
            DAOUtil.insertProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // make use of DAOUtil

    }

    public void deleteProduct(String code) {

        try {
            DAOUtil.deleteProduct(code);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // make use of DAOUtil

    }
}