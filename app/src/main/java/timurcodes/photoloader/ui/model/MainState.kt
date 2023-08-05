package timurcodes.photoloader.ui.model

import timurcodes.photoloader.domain.model.PhotoModel
import timurcodes.photoloader.domain.model.ScreenType

data class MainState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isRefreshing: Boolean = false,
    val errorText: String = "",
    val selectedPhoto: String = "",
    val screenType: ScreenType = ScreenType.PHOTO_LIST,
    val photoList: List<PhotoModel>? = null
)