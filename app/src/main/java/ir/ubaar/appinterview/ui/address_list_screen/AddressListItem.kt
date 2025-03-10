package ir.ubaar.appinterview.ui.address_list_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ir.ubaar.appinterview.data.data_source.remote.dto.AddressListDtoItem


private val CARD_PADDING = 4.dp
private val CONTENT_PADDING = 4.dp
private val TEXT_PADDING = 8.dp


@Composable
fun AddressListItems(item: AddressListDtoItem) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(CARD_PADDING),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(CONTENT_PADDING),
            verticalArrangement = Arrangement.Center
        ) {

            item.address?.let {
                Text(
                    it,
                    modifier = Modifier.padding(TEXT_PADDING),
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "${item.firstName} ${item.lastName}",
                    modifier = Modifier
                        .padding(TEXT_PADDING)
                        .weight(1f),
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onSurface
                )
                item.coordinateMobile?.let {
                    Text(
                        it,
                        modifier = Modifier
                            .padding(TEXT_PADDING)
                            .weight(1f),
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.outline,
                        textAlign = TextAlign.End,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }

}
