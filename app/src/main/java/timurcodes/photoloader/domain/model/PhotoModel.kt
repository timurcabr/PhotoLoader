package timurcodes.photoloader.domain.model

data class PhotoModel(
    val urls: PhotoItem?
) {

    data class PhotoItem(
        val raw: String?,
        val full: String?,
        val regular: String?
    )

}