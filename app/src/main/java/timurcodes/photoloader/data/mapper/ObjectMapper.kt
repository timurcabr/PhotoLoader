package timurcodes.photoloader.data.mapper

import timurcodes.photoloader.data.network.model.response.ListPhotosResponse
import timurcodes.photoloader.domain.model.PhotoModel

interface ObjectMapper {
    fun toPhotoModel(
        item: ListPhotosResponse
    ): PhotoModel
}