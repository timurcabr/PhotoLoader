package timurcodes.photoloader.data.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import timurcodes.photoloader.data.network.Endpoint
import timurcodes.photoloader.data.network.Queries
import timurcodes.photoloader.data.network.model.response.ListPhotosResponse

interface PhotoService {

    @GET(Endpoint.Photos.LIST_PHOTOS)
    suspend fun listPhotos(
        @Query(Queries.ListPhotos.CLIENT_ID) clientId: String,
        @Query(Queries.ListPhotos.PAGE) page: Int?,
        @Query(Queries.ListPhotos.PER_PAGE) perPage: Int?,
        @Query(Queries.ListPhotos.ORDER_BY) orderBy: String?
    ): List<ListPhotosResponse>

}