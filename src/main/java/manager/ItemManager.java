package manager;

import dp.DBConnectionProvider;
import model.Item;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemManager {
    Connection connection = DBConnectionProvider.getInstance().getConnection();
    private UserManager userManager = new UserManager();
    private CategoryManager categoryManager = new CategoryManager();

    public void add(Item item) {
        String sql = "INSERT INTO item(title,price,category_id,pic_url,user_id) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getTitle());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getCategoryID());
            statement.setString(4, item.getPictureUrl());
            statement.setInt(5, item.getUserId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Item getById(int id) {
        String sql = "SELECT *FROM item WHERE id = " + id;
        try {
            Statement statment = connection.createStatement();
            ResultSet resultSet = statment.executeQuery(sql);

            if (resultSet.next()) {

                return getItemFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(int id) {
        String sql = "DELETE FROM item WHERE id= " + id;
        try {
            Statement statment = connection.createStatement();
            statment.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Item getItemFromResultSet(ResultSet resultSet) {
        try {
            return Item.builder()
                    .id(resultSet.getInt(1))
                    .title(resultSet.getString(2))
                    .price(resultSet.getInt(3))
                    .category(categoryManager.getById(resultSet.getInt(4)))
                    .pictureUrl(resultSet.getString(5))
                    .user(userManager.getById(resultSet.getInt(6)))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }}

        public List<Item> getAllItemsByUser ( int userID){
            List<Item> result = new ArrayList<>();
            String sql = "SELECT *FROM item WHERE user_id =  " + userID;
            try {
                PreparedStatement statment = connection.prepareStatement(sql);
                ResultSet resultSet = statment.executeQuery();
                while (resultSet.next()) {
                    result.add(getItemFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        public List<Item> getAllItems () {
            String sql = "select * from item";
            List<Item> result = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt(1));
                    item.setTitle(resultSet.getString(2));
                    item.setPrice(resultSet.getInt(3));
                    item.setCategoryID(resultSet.getInt(4));
                    item.setCategory(categoryManager.getById(item.getCategoryID()));
                    item.setPictureUrl(resultSet.getString(5));
                    item.setUserId(resultSet.getInt(6));
                    item.setUser(userManager.getById(item.getUserId()));
                    result.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;

        }
        public List<Item> get20Items () {
            String sql = "select * from item order by id DESC LIMIT 20";
            List<Item> result = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt(1));
                    item.setTitle(resultSet.getString(2));
                    item.setPrice(resultSet.getInt(3));
                    item.setCategoryID(resultSet.getInt(4));
                    item.setCategory(categoryManager.getById(item.getCategoryID()));
                    item.setPictureUrl(resultSet.getString(5));
                    item.setUserId(resultSet.getInt(6));
                    item.setUser(userManager.getById(item.getUserId()));
                    result.add(item);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;

        }
    }



