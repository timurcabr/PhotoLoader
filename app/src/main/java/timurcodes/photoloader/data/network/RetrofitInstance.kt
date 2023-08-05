package timurcodes.photoloader.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timurcodes.photoloader.data.network.service.PhotoService

object RetrofitInstance {

    private const val BASE_URL = "https://api.unsplash.com"
    const val API_KEY = "LFVKhmVTdQyghC52YgE2uJohzAGQy-WvRBM-WMVCxl4"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient()
                    .newBuilder()
                    .addInterceptor { chain ->
                        chain.proceed(chain
                            .request()
                            .newBuilder()
                            .build()
                        )
                    }
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getPhotosList() = retrofit.create(PhotoService::class.java)

}