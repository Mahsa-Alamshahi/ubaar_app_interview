package ir.ubaar.appinterview.ui.set_address_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ubaar.appinterview.ui.theme.FormTitleTextColor


@Composable
fun GenderSwitch(
    items: List<String>,
    onGenderSelected: (String) -> Unit
) {

    var selectedGender by remember { mutableStateOf(items[0]) }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp))
            .background(Color.White)
            .border(
                width = .4.dp,
                color = FormTitleTextColor,
                shape = RectangleShape
            )
    ) {
        items.forEach { gender ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(0.dp))
                    .background(if (selectedGender == gender) FormTitleTextColor else Color.White)
                    .clickable {
                        selectedGender = gender
                        onGenderSelected(gender)
                    }
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = gender,
                    color = if (selectedGender == gender) Color.White else FormTitleTextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewGenderSwitch() {
    GenderSwitch(listOf("male", "female")) { }
}