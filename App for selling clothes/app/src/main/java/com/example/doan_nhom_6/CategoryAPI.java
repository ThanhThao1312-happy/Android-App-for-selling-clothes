package com.example.doan_nhom_6;

import com.example.doan_nhom_6.Model.Category;

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

public interface CategoryAPI {
    RetrofitService retrofitService = new RetrofitService();
    CategoryAPI categoryAPI = retrofitService.getRetrofit().create(CategoryAPI.class);
    @GET("/category")
    Call<List<Category>> GetAllCategories();
    @Multipart
    @POST("/newcategory")
    Call<Category> AddCategory(@Part("category_name") RequestBody categoryName, @Part MultipartBody.Part category_image);
    @DELETE("/deletecategory/{id}")
    Call<Category> DeleteCategory(@Path("id") int id);
    @Multipart
    @PUT("/updatecategory")
    Call<Category> UpdateCategory(@Part("id") RequestBody categoryID, @Part("category_name") RequestBody categoryName,
                                  @Part MultipartBody.Part category_image);
}
