package ir.ubaar.appinterview.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.ubaar.appinterview.ui.theme.FormTitleTextColor

@Composable
fun Loading(modifier: Modifier = Modifier.fillMaxSize()) {
    Row(
        modifier= modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Loading", color = FormTitleTextColor)
        CircularProgressIndicator(color = FormTitleTextColor, modifier = Modifier.padding(8.dp))
    }
}
