package manager;

import dp.DBConnectionProvider;
import model.Category;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private Connection connection = DBConnectionProvider.getInstance().getConnection();


    public Category getById(int id) {
        String sql = "SELECT *FROM category WHERE id = " + id;
        try {
            Statement statment = connection.createStatement();
            ResultSet resultSet = statment.executeQuery(sql);

            if (resultSet.next()) {

                return getCategoryFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Category getCategoryFromResultSet(ResultSet resultSet) {
        try {
            return Category.builder()
                    .id(resultSet.getInt(1))
                    .name(resultSet.getString(2))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Category> getAllCategories() {
        String sql = "select * from category";
        List<Category> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category=new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));

                result.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
