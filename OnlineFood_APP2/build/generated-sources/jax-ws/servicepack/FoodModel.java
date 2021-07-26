
package servicepack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foodModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foodModel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="foodName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="foodPicPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="foodPrice" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="food_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="isAvailable" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foodModel", propOrder = {
    "foodName",
    "foodPicPath",
    "foodPrice",
    "foodId",
    "isAvailable",
    "type"
})
public class FoodModel {

    protected String foodName;
    protected String foodPicPath;
    protected double foodPrice;
    @XmlElement(name = "food_id")
    protected int foodId;
    protected int isAvailable;
    protected String type;

    /**
     * Gets the value of the foodName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the value of the foodName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoodName(String value) {
        this.foodName = value;
    }

    /**
     * Gets the value of the foodPicPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoodPicPath() {
        return foodPicPath;
    }

    /**
     * Sets the value of the foodPicPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoodPicPath(String value) {
        this.foodPicPath = value;
    }

    /**
     * Gets the value of the foodPrice property.
     * 
     */
    public double getFoodPrice() {
        return foodPrice;
    }

    /**
     * Sets the value of the foodPrice property.
     * 
     */
    public void setFoodPrice(double value) {
        this.foodPrice = value;
    }

    /**
     * Gets the value of the foodId property.
     * 
     */
    public int getFoodId() {
        return foodId;
    }

    /**
     * Sets the value of the foodId property.
     * 
     */
    public void setFoodId(int value) {
        this.foodId = value;
    }

    /**
     * Gets the value of the isAvailable property.
     * 
     */
    public int getIsAvailable() {
        return isAvailable;
    }

    /**
     * Sets the value of the isAvailable property.
     * 
     */
    public void setIsAvailable(int value) {
        this.isAvailable = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
