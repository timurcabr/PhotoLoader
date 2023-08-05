package timurcodes.photoloader.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import timurcodes.photoloader.ext.PhotoLoaderTheme
import timurcodes.photoloader.ui.contents.MainViewContent

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoLoaderTheme {
                MainViewContent(
                    viewModel = viewModel
                )
            }
        }
    }
}