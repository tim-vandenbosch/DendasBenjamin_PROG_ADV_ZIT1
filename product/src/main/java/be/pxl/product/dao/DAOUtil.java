package be.pxl.product.dao;

import be.pxl.product.domain.Product;
import be.pxl.product.domain.UserAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOUtil bean.
 */
public class DAOUtil {

    public static UserAccount findUser(String userName, String password) throws SQLException, ClassNotFoundException {

        Connection conn = MySQLConnUtils.getMySQLConnection();

        // create query, process resultset and return a user account!
        String query = "Select * from user_account where USER_NAME = ? and PASSWORD = ?";
        try
        {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,userName);
            statement.setString(2,password);
            ResultSet set = statement.executeQuery();

            if(set.next())
            {
                UserAccount account = new UserAccount();
                account.setUserName(set.getString("USER_NAME"));
                account.setGender(set.getString("GENDER"));
                account.setPassword(set.getString("PASSWORD"));
                return account;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            if(conn != null)
            {
                conn.close();
            }
        }
    }

    public static UserAccount findUser(String userName) throws SQLException, ClassNotFoundException {


        return null;
    }

    public static List<Product> queryProduct() throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<Product>();
        Connection conn = MySQLConnUtils.getMySQLConnection();

        String query = "Select * from product";
        try
        {
            Statement statement = conn.createStatement();

            ResultSet set = statement.executeQuery(query);
            while(set.next())
            {
                Product productObject = new Product();
                productObject.setName(set.getString("NAME"));
                productObject.setCode(set.getString("CODE"));
                productObject.setPrice(set.getInt("PRICE"));

                productList.add(productObject);
            }

            return productList;

        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            if(conn != null)
            {
                conn.close();
            }
        }
    }

    public static Product findProduct(String code) throws SQLException, ClassNotFoundException {

        Connection conn = MySQLConnUtils.getMySQLConnection();

        String query = "Select * from product where CODE = ?";
        try
        {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,code);
            ResultSet set = statement.executeQuery();

            if(set.next())
            {
                Product productObject = new Product();
                productObject.setPrice(set.getInt("PRICE"));
                productObject.setName(set.getString("NAME"));
                productObject.setCode(set.getString("CODE"));
                return productObject;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        finally
        {
            if(conn != null)
            {
                conn.close();
            }
        }
    }

    public static void updateProduct(Product product) throws SQLException, ClassNotFoundException {


    }

    public static void insertProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection conn = MySQLConnUtils.getMySQLConnection();

        String query = "INSERT INTO product(CODE,NAME,PRICE) VALUES(?,?,?)";
        try
        {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,product.getCode());
            statement.setString(2,product.getName());
            statement.setFloat(3,product.getPrice());
            statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();

        }
        finally
        {
            if(conn != null)
            {
                conn.close();
            }
        }
    }

    public static void deleteProduct(String code) throws SQLException, ClassNotFoundException {

        Connection conn = MySQLConnUtils.getMySQLConnection();

        String query = "Select * from product where CODE = ?";
        try
        {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,code);
            statement.executeUpdate();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(conn != null)
            {
                conn.close();
            }
        }

    }
}
