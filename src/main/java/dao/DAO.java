package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private int noOfRecords;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from accounts";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("uID"),
                        rs.getString("users"),
                        rs.getString("pass"),
                        rs.getInt("isSell"),
                        rs.getInt("isAdmin")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }



    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateID = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getAccountByCID(String cid) {
        List<Account> listAcc = new ArrayList<>();
        String query = "select  from Accounts where cateID = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                listAcc.add(new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return listAcc;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where namee like ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }


    public Product getProductByID(String id) {
        String query = "select * from product where id = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getLast() {
        String query = "SELECT *FROM product WHERE id = (SELECT MAX(id) FROM product);";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account login(String user, String pass) {
        String query = "select * from accounts where users= ? and pass = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from accounts where users = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String query = "insert into accounts(users,pass,isSell,isAdmin) values(?,?,0,0)";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from product where id = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteAccount(String aid) {
        String query = "delete from accounts where id = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertProduct(String name, String image, String price, String title, String description, String category, int sid) {
        String query = "INSERT into product ( namee, image, price, title, descriptions, cateID,sell_ID) VALUES (?,?,?,?,?,?,?)";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setInt(7, sid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


    public void insertAccount(String users, String pass, int isSell, int isAdmin, int aid) {
        String query = "INSERT into Accounts ( users,pass,0,0) VALUES (?,?,?)";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, users);
            ps.setString(2, pass);
            ps.setInt(3, isSell);
            ps.setInt(4, isAdmin);
            ps.setInt(3, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String image, String price, String title, String description, String category, String pid) {
        String query = "update product set namee = ?, image = ? , price =?, title = ?, descriptions =? , cateID =?  where id = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setString(6, category);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editAccount(String users, String pass, int isSell, int isAdmin, String aid) {
        String query = "update product set users = ?, pass = ? , isSell =?, isAdmin = ?  where id = ?";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, users);
            ps.setString(2, pass);
            ps.setInt(3, isSell);
            ps.setInt(4, isAdmin);
            ps.setString(5, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public int getTotalProduct(){
        String query = "select count(*) from product";
        try {
            new DBContext();
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Product> pagingProduct(int index){
        List<Product> list =new ArrayList<>();
        String query= " select * from product \n"
                +" order by id \n"
                +"offset ? rows fetch next 3 rows only";
        System.out.println(query);
                try {
                    try {
                        conn= DBContext.getConnection();
                        ps=conn.prepareStatement(query);
                        rs= ps.executeQuery();
                        while (rs.next()) {
                            list.add(new Product(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getDouble(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getInt(7),
                                    rs.getInt(8)));
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }catch (Exception e){
                }
        return list;
    }


    public static void main(String[] args) {
        DAO dao =new DAO();
     List<Product>list =dao.pagingProduct(1);
            for (Product o: list
                 ) {
                System.out.println(o);
            }
        }
    }
