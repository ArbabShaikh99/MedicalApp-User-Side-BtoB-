package com.example.medicalstoreuser.Data_Layer

import com.example.medicalstoreuser.Data_Layer.Response.GetAlluserResponseStatus
import com.example.medicalstoreuser.Data_Layer.Response.Order.MedicalOrderResponseItem
import com.example.medicalstoreuser.Data_Layer.Response.ResponseStatus
import com.example.medicalstoreuser.Data_Layer.Response.product.getAllProductResponseItem
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Part
import java.util.Date


interface ApiService{

@FormUrlEncoded
@POST("/signUp")
suspend fun singUpUser(

    @Field("name") name:String,
    @Field("password") password:String,
    @Field("email") email:String,
    @Field("phone") phoneNumber:String,
    @Field("address") address:String,
    @Field("pinCode") pinCode:String

):Response<ResponseStatus>

@FormUrlEncoded
@POST("/Login")
suspend fun LoginUser(
    @Field("email") email : String,
    @Field("password") password: String
):Response<ResponseStatus>

@FormUrlEncoded
@POST("/getSpecificUser")
    suspend fun getSpecificUserApi(
        @Field("userID") userId: String
    ): Response<ArrayList<GetAlluserResponseStatus>>


    @Multipart
    @PATCH("/updateUser")
    suspend fun updateUserData(
        @Part("userId") userId: RequestBody,
        @Part("name") name: RequestBody,
        @Part("password") password: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone_number") phone_number: RequestBody,
        @Part("pinCode") pinCode: RequestBody,
        @Part("address") address: RequestBody,
        @Part pic: MultipartBody.Part?,
    ) : Response<ResponseStatus>


    @GET("/getProduct")
    suspend fun getAllProducService() : Response<ArrayList<getAllProductResponseItem>>

    @FormUrlEncoded
    @POST("/getSpecificProduct")
    suspend fun getSpecificProduct(
        @Field("ProductID") productId : String
    ) : Response<ArrayList<getAllProductResponseItem>>


    @FormUrlEncoded
    @POST("/order")
    suspend fun createOrder(
        @Field("user_id") userId : String,
        @Field("product_id") productId : String,
        @Field("product_name") productName : String,
        @Field("product_category") productCategory : String,
        @Field("product_image_id") productImageId : String,
        @Field("user_name") userName : String,
        @Field("isApproved") isApproved : Int,
        @Field("product_quantity") productQuantity : Int,
        @Field("product_price") productPrice : Float,
        @Field("subtotal_price") subTotalPrice : Float,
        @Field("delivery_charge") deliveryCharge : Float,
        @Field("tax_charge") taxCharge : Float,
        @Field("total_price") totalPrice : Float,
        @Field("order_date") orderDate : Date,
        @Field("user_address") userAddress : String,
        @Field("user_pincode") userPinCode : String,
        @Field("user_mobile") userMobile : String,
        @Field("user_email") userEmail : String,
        @Field("order_status") orderStatus : String,
        @Field("order_cancel_status") orderCancelStatus : String,
        @Field("user_street") userStreet : String,
        @Field("user_city") userCity : String,
        @Field("user_state") userState : String,
        @Field("discount_price") discountPrice : String,
        @Field("shipped_date") shippedDate : String,
        @Field("out_of_delivery_date") outOfDeliveryDate : String,
        @Field("delivered_date") deliveredDate : String,
    ) : Response<ResponseStatus>

    @FormUrlEncoded
    @POST("/getAllOrderThroughUser")
    suspend fun getAllOrders(
        @Field("user_id") userId : String,
    ) : Response<ArrayList<MedicalOrderResponseItem>>


}