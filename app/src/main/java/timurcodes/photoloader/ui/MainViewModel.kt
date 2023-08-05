package timurcodes.photoloader.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timurcodes.photoloader.data.network.model.response.ApiResponse
import timurcodes.photoloader.data.repository.ListPhotosRepository
import timurcodes.photoloader.domain.model.ScreenType
import timurcodes.photoloader.ui.model.MainActions
import timurcodes.photoloader.ui.model.MainState

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        getPhotosList()
    }

    fun setInputActions(action: MainActions) {
        when (action) {
            MainActions.ClickGoBack -> _state.update { it.copy(screenType = ScreenType.PHOTO_LIST) }
            MainActions.ClickRefresh -> refreshList()
            is MainActions.SelectPhoto -> _state.update {
                it.copy(
                    selectedPhoto = action.url, screenType = ScreenType.DETAILED_PHOTO
                )
            }
        }
    }

    private fun getPhotosList() {
        _state.update { it.copy(isLoading = true, isError = false, errorText = "") }
        viewModelScope.launch(Dispatchers.IO) {
            val response =
                ListPhotosRepository.getListPhotos(page = 1, perPage = 100, orderBy = null)
            if (response is ApiResponse.Success) {
                _state.update {
                    it.copy(
                        isLoading = false, photoList = response.data
                    )
                }
            }
            if (response is ApiResponse.Error) {
                _state.update {
                    it.copy(
                        isLoading = false, isError = true, errorText = response.exception.toString()
                    )
                }
            }
        }
    }

    private fun refreshList() {
        getPhotosList()
    }

}