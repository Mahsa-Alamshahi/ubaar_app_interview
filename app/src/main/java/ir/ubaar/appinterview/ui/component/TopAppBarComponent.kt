package ir.ubaar.appinterview.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    topAppBarTitle: String,
    onBackClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
){


    Scaffold(topBar = {
        TopAppBar(
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                titleContentColor = MaterialTheme.colorScheme.secondary,
            ),
            title = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        topAppBarTitle,
                        modifier = Modifier,
                        textAlign = TextAlign.Right,
                        color = Color.Black
                    )
                    Box(modifier = Modifier.weight(1f))
                    Icon(Icons.Default.ArrowBack, tint = Color.Gray, contentDescription = null,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp).clickable {
                            onBackClick()
                        })
                }
            },
        )
    }
    ) { innerPadding ->
        content(innerPadding)
    }
}