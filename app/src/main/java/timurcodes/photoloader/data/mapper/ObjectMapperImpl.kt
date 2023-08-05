package timurcodes.photoloader.data.mapper

import timurcodes.photoloader.data.network.model.response.ListPhotosResponse
import timurcodes.photoloader.domain.model.PhotoModel

object ObjectMapperImpl : ObjectMapper {
    override fun toPhotoModel(item: ListPhotosResponse): PhotoModel {
        return PhotoModel(
            urls = PhotoModel.PhotoItem(
                raw = item.urls.raw,
                full = item.urls.full,
                regular = item.urls.regular
            )
        )
    }
}