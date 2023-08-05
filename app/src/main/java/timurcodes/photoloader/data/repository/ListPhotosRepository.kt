package timurcodes.photoloader.data.repository

import retrofit2.HttpException
import timurcodes.photoloader.data.mapper.ObjectMapperImpl
import timurcodes.photoloader.data.network.RetrofitInstance
import timurcodes.photoloader.data.network.model.response.ApiResponse
import timurcodes.photoloader.domain.model.PhotoModel
import java.io.IOException

object ListPhotosRepository {

    suspend fun getListPhotos(
        page: Int?, perPage: Int?, orderBy: String?
    ): ApiResponse<List<PhotoModel>> {
        return try {
            val response = RetrofitInstance.getPhotosList()
            val photoList = response.listPhotos(
                clientId = RetrofitInstance.API_KEY,
                page = page,
                perPage = perPage,
                orderBy = orderBy
            ).map { ObjectMapperImpl.toPhotoModel(item = it) }
            ApiResponse.Success(data = photoList)
        } catch (e: HttpException) {
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            ApiResponse.Error(exception = e)
        }
    }
}