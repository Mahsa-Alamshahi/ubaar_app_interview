package ir.ubaar.appinterview.ui.set_address_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ubaar.appinterview.ui.theme.FormTitleTextColor


@Composable
fun InputFieldRow(
    label: String,
    minChar: Int,
   keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {


    var rowBorderColor by remember { mutableStateOf(Color.LightGray) }
    var inputTextState by remember { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }


    fun validate(text: CharSequence) {
        isError = text.length > minChar
    }

    LaunchedEffect(Unit) {
        snapshotFlow { inputTextState }.collect { validate(it) }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White)
            .border(
                width = .5.dp, color = rowBorderColor, shape = RectangleShape
            ), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            color = FormTitleTextColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        TextField(
            value = inputTextState,
            onValueChange = {
                inputTextState = it
                rowBorderColor = Color.Black
                if (inputTextState.length >= minChar) onValueChange(inputTextState)
            },
            singleLine = true,
            trailingIcon = {
                Icon(
                    Icons.Filled.CheckCircle,
                    "error",
                    modifier = Modifier.size(20.dp),
                    tint = if (inputTextState.length <= minChar) Color.LightGray else Color(0xFF18D999)
                )
            },
            keyboardActions = KeyboardActions { validate(inputTextState) },
            keyboardOptions =  KeyboardOptions(
                keyboardType = keyboardType
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .onFocusChanged {
                    rowBorderColor = if (it.isFocused) {
                        Color.Black
                    } else {
                        Color.LightGray
                    }
                },
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
