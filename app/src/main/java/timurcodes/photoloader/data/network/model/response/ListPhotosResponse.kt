package timurcodes.photoloader.data.network.model.response

import com.google.gson.annotations.SerializedName

class ListPhotosResponse(
    @SerializedName("urls") val urls: PhotoItemResponse
) {

    class PhotoItemResponse(
        @SerializedName("raw") val raw: String?,
        @SerializedName("full") val full: String?,
        @SerializedName("regular") val regular: String?
    )

}