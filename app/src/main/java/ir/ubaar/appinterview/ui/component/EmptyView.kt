package ir.ubaar.appinterview.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ir.ubaar.appinterview.R
import ir.ubaar.appinterview.ui.theme.FormTitleTextColor


@Composable
fun EmptyView(getAddressList: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("No data found.",
            color = FormTitleTextColor)
        IconButton(onClick = getAddressList) {
            Icon(
                modifier = Modifier,
                imageVector = Icons.Default.Refresh,
                contentDescription = stringResource(R.string.retry),
                tint = FormTitleTextColor
            )
        }
    }
}