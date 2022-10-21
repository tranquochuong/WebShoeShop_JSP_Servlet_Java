
package entity;

public class Product {
    private int id;
    private String name;
    private String image;
    private double price;
    private String title;
    private String description;
    private  int cateId;
    private int sell_ID;

    public Product(int id, String name, String image, double price, String title,
                   String description,int cateId, int sell_ID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.cateId=cateId;
        this.sell_ID = sell_ID;
    }

    public Product() {

    }

    public int getCateId() {
        return cateId;
    }
    public void setCateId(int cateId) {
        this.cateId = cateId;
    }
    public int getSell_ID() {
        return sell_ID;
    }

    public void setSell_ID(int sell_ID) {
        this.sell_ID = sell_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cateId=" + cateId +
                ", sell_ID=" + sell_ID +
                '}';
    }
}
