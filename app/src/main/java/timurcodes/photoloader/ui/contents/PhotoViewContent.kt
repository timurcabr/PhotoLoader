package timurcodes.photoloader.ui.contents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import timurcodes.photoloader.domain.model.PhotoModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhotoViewContent(
    list: List<PhotoModel>?, isRefreshing: Boolean, refresh: () -> Unit, onClick: (String) -> Unit
) {

    val pullRefreshState = rememberPullRefreshState(isRefreshing, { refresh() })

    Box(
        Modifier
            .pullRefresh(pullRefreshState)
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            list?.let { photoList ->
                items(photoList.size) { index ->
                    CardContent(item = photoList[index]) {
                        onClick(it)
                    }
                }
            }
        }

        PullRefreshIndicator(
            refreshing = isRefreshing, state = pullRefreshState, Modifier.align(Alignment.TopCenter)
        )
    }

}

@Composable
fun CardContent(
    item: PhotoModel,
    onClick: (String) -> Unit
) {
    AsyncImage(
        model = item.urls?.regular,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(128.dp)
            .clickable { onClick(item.urls?.regular ?: "") }
    )
}