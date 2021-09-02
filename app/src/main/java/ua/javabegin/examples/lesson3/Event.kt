package ua.javabegin.examples.lesson3

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Event (
    @SerializedName("response") val firstObject : EventFirstObject
)
data class EventFirstObject (
    @SerializedName("0") val responseItem : EventResponseItem
)

data class EventResponseItem (
    @SerializedName("name") val name: String = "FoooBar",
    @SerializedName("text") val text: String,
    @SerializedName("eventId") val eventId: Int
): Serializable