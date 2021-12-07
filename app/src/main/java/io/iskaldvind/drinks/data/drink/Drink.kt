package io.iskaldvind.drinks.data.drink

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("drinks")
    val drinks: List<Drink>
)

@Entity(tableName = "drinks")
data class Drink(
    @SerializedName("idDrink")
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: String,
    @SerializedName("strDrink")
    @ColumnInfo(name="name")
    val name: String,
    @SerializedName("strDrinkThumb")
    @ColumnInfo(name="picture")
    val picture: String,
    @SerializedName("strGlass")
    @ColumnInfo(name="glass")
    val glass: String,
    @SerializedName("strInstructions")
    @ColumnInfo(name="instructions")
    val instructions: String,
    @SerializedName("strIngredient1")
    @ColumnInfo(name="ingredient1")
    val ingredient1: String,
    @SerializedName("strIngredient2")
    @ColumnInfo(name="ingredient2")
    val ingredient2: String?,
    @SerializedName("strIngredient3")
    @ColumnInfo(name="ingredient3")
    val ingredient3: String?,
    @SerializedName("strIngredient4")
    @ColumnInfo(name="ingredient4")
    val ingredient4: String?,
    @SerializedName("strIngredient5")
    @ColumnInfo(name="ingredient5")
    val ingredient5: String?,
    @SerializedName("strIngredient6")
    @ColumnInfo(name="ingredient6")
    val ingredient6: String?,
    @SerializedName("strIngredient7")
    @ColumnInfo(name="ingredient7")
    val ingredient7: String?,
    @SerializedName("strIngredient8")
    @ColumnInfo(name="ingredient8")
    val ingredient8: String?,
    @SerializedName("strIngredient9")
    @ColumnInfo(name="ingredient9")
    val ingredient9: String?,
    @SerializedName("strIngredient10")
    @ColumnInfo(name="ingredient10")
    val ingredient10: String?,
    @SerializedName("strIngredient11")
    @ColumnInfo(name="ingredient11")
    val ingredient11: String?,
    @SerializedName("strIngredient12")
    @ColumnInfo(name="ingredient12")
    val ingredient12: String?,
    @SerializedName("strIngredient13")
    @ColumnInfo(name="ingredient13")
    val ingredient13: String?,
    @SerializedName("strIngredient14")
    @ColumnInfo(name="ingredient14")
    val ingredient14: String?,
    @SerializedName("strIngredient15")
    @ColumnInfo(name="ingredient15")
    val ingredient15: String?,
    @SerializedName("strMeasure1")
    @ColumnInfo(name="measure1")
    val measure1: String,
    @SerializedName("strMeasure2")
    @ColumnInfo(name="measure2")
    val measure2: String?,
    @SerializedName("strMeasure3")
    @ColumnInfo(name="measure3")
    val measure3: String?,
    @SerializedName("strMeasure4")
    @ColumnInfo(name="measure4")
    val measure4: String?,
    @SerializedName("strMeasure5")
    @ColumnInfo(name="measure5")
    val measure5: String?,
    @SerializedName("strMeasure6")
    @ColumnInfo(name="measure6")
    val measure6: String?,
    @SerializedName("strMeasure7")
    @ColumnInfo(name="measure7")
    val measure7: String?,
    @SerializedName("strMeasure8")
    @ColumnInfo(name="measure8")
    val measure8: String?,
    @SerializedName("strMeasure9")
    @ColumnInfo(name="measure9")
    val measure9: String?,
    @SerializedName("strMeasure10")
    @ColumnInfo(name="measure10")
    val measure10: String?,
    @SerializedName("strMeasure11")
    @ColumnInfo(name="measure11")
    val measure11: String?,
    @SerializedName("strMeasure12")
    @ColumnInfo(name="measure12")
    val measure12: String?,
    @SerializedName("strMeasure13")
    @ColumnInfo(name="measure13")
    val measure13: String?,
    @SerializedName("strMeasure14")
    @ColumnInfo(name="measure14")
    val measure14: String?,
    @SerializedName("strMeasure15")
    @ColumnInfo(name="measure15")
    val measure15: String?,
)