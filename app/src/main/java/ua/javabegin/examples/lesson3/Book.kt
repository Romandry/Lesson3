package ua.javabegin.examples.lesson3

import com.google.gson.annotations.SerializedName

data class Book (
    @SerializedName("response") val firstObject : FirstObject
)
data class FirstObject (
    @SerializedName("0") val responseItem : List<ResponseItem>
)
data class ResponseItem (
    @SerializedName("name") val name: String,
    @SerializedName("startTimestamp") val date: String,
    @SerializedName("cityName") val cityName: String,
    @SerializedName("userName") val userName: String,
    @SerializedName("userImg") val userImg: String,
    @SerializedName("img") val img: String,
    @SerializedName("text") val text: String,
    @SerializedName("eventId") val eventId: Int
)


//data class Book(
//    var id: Int?,
//    var title: String?,
//    var author: String?,
//    var description: String?,
//    var published: Int?
//)

//
//data class Book (
//    @SerializedName("0") val foo : MainParams
//)