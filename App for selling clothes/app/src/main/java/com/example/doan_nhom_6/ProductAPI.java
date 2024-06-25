package com.example.doan_nhom_6;

import com.example.doan_nhom_6.Model.Category;
import com.example.doan_nhom_6.Model.Product;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductAPI {

    RetrofitService retrofitService = new RetrofitService();
    ProductAPI productApi = retrofitService.getRetrofit().create(ProductAPI.class);
    @GET("/newproduct")
    Call<List<Product>> getNewProduct();

    @GET("bestsellers")
    Call<List<Product>> getBestSellers();
//    @FormUrlEncoded
    @GET("/search")
    Call<List<Product>> search(@Query("searchContent") String searchContent);


    @GET("/product")
    Call<List<Product>> GetAllProduct();
    @Multipart
    @POST("/addproduct")
    Call<Product> AddProduct(@Part("product_name") RequestBody productName,
                             @Part("product_price") RequestBody productPrice,
                             @Part("product_quantity") RequestBody productQuantity,
                             @Part("product_decription") RequestBody productDecription,
                             @Part("product_category") RequestBody productCategory,
                             @Part List<MultipartBody.Part> product_images,
                             @Part("product_sold") RequestBody productSold,
                             @Part("product_is_selling") RequestBody productIsSelling,
                             @Part("product_is_active") RequestBody productIsActive);
    @DELETE("/deleteproduct/{id}")
    Call<Product> DeleteProduct(@Path("id") int id);
    @Multipart
    @PUT("/updateproduct")
    Call<Product> UpdateProduct(@Part("id") RequestBody productID,
                                @Part("product_name") RequestBody productName,
                                @Part("product_price") RequestBody productPrice,
                                @Part("product_quantity") RequestBody productQuantity,
                                @Part("product_decription") RequestBody productDecription,
                                @Part("product_category") RequestBody productCategory,
                                @Part List<MultipartBody.Part> product_images,
                                @Part("product_sold") RequestBody productSold,
                                @Part("product_is_selling") RequestBody productIsSelling,
                                @Part("product_is_active") RequestBody productIsActive);

}
