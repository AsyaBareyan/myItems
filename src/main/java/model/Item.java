package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Item {
    private int id;
    private String title;
    private int price;
    private int categoryID;
    private Category category;
    private String pictureUrl;
    private int userId;
    private User user;

}
