package timurcodes.photoloader.ext.compose

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import timurcodes.photoloader.R

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    tint: Color = Color.Black,
    navigationAction: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = navigationAction
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_navigation),
            contentDescription = null,
            tint = tint
        )
    }
}

@Composable
fun RowDivider() {
    Divider(
        color = Color.LightGray,
        modifier = Modifier
    )
}
