package timurcodes.photoloader.ui.contents

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import timurcodes.photoloader.domain.model.ScreenType
import timurcodes.photoloader.ext.compose.BackButton
import timurcodes.photoloader.ext.compose.DialogLoadingContent
import timurcodes.photoloader.ext.compose.RowDivider
import timurcodes.photoloader.ext.compose.TopAppBarContent
import timurcodes.photoloader.ui.MainViewModel
import timurcodes.photoloader.ui.model.MainActions

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainViewContent(
    viewModel: MainViewModel
) {

    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        DialogLoadingContent()
    }

    Scaffold(backgroundColor = Color.White, modifier = Modifier.fillMaxSize(), topBar = {
        if (state.screenType == ScreenType.DETAILED_PHOTO) {
            Column {
                TopAppBarContent(
                    title = "Detailed photo view",
                    navigationItem = {
                        BackButton {
                            viewModel.setInputActions(MainActions.ClickGoBack)
                        }
                    },
                )
                RowDivider()
            }
        }
    }

    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            when (state.screenType) {
                ScreenType.PHOTO_LIST -> {
                    PhotoViewContent(list = state.photoList,
                        isRefreshing = state.isRefreshing,
                        onClick = {
                            viewModel.setInputActions(MainActions.SelectPhoto(it))
                        },
                        refresh = {
                            viewModel.setInputActions(MainActions.ClickRefresh)
                        })
                }

                ScreenType.DETAILED_PHOTO -> {
                    DetailedViewContent(
                        selectedPhoto = state.selectedPhoto
                    )
                }
            }
        }
    }
}