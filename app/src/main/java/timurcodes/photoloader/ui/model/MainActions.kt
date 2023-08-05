package timurcodes.photoloader.ui.model

sealed class MainActions {
    object ClickGoBack : MainActions()
    object ClickRefresh : MainActions()

    data class SelectPhoto(val url: String): MainActions()
}