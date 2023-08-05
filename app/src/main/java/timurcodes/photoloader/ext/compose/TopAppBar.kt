package timurcodes.photoloader.ext.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBarContent(
    title: String,
    titleSize: Int = 20,
    backgroundColor: Color = Color.White,
    navigationItem: @Composable (() -> Unit)
) {

    TopAppBar(
        backgroundColor = backgroundColor,
        elevation = 0.dp,
        title = {
            Text(
                color = Color.Black,
                textAlign = TextAlign.Start,
                text = title,
                fontWeight = FontWeight.W600,
                fontSize = titleSize.sp
            )
        },
        navigationIcon = {
            Row {
                Spacer(modifier = Modifier.width(8.dp))
                navigationItem()
            }
        },
        actions = {}
    )
}
