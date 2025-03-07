package ir.ubaar.appinterview.ui.set_address_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun InputFieldRow(label: String, value: String, onValueChange: (String) -> Unit) {

    var color by remember { mutableStateOf(Color.Gray) }
    var mText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .border(
                width = .4.dp,
                color = color,
                shape = RectangleShape
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label, modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            color = Color(0xFF2684B4),
            fontWeight = FontWeight.SemiBold
        )
        TextField(
            value = mText,
            onValueChange = {
                mText = it
                color = Color.Black
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview
@Composable
fun PreviewInputFieldRow() {
    InputFieldRow("نام", "وحید") { }
}