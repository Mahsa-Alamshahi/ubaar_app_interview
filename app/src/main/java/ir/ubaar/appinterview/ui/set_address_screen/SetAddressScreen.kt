package ir.ubaar.appinterview.ui.set_address_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetAddressScreen() {

    val scrollState = rememberScrollState()
    var mText by remember { mutableStateOf("") }

    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {
        Scaffold(topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "ثبت نام",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Right
                    )
                },
                navigationIcon = {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            )
        }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    "لطفا اطلاعات ورود خود را وارد نمایید.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF2F2F2))
                        .padding(start = 12.dp, top = 12.dp, bottom = 12.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {

                    InputFieldRow(label = "نام", value = mText, onValueChange = { mText = it })
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.White)
//                            .border(
//                                width = .5.dp,
//                                color = Color.Black,
//                                shape = RectangleShape
//                            )
//                            .absolutePadding(left = 8.dp, right = 8.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                        Text("نام", modifier = Modifier.weight(.5f))
//
//                        TextField(
//                            value = mText,
//                            onValueChange = { mText = it },
//                            label = {
//                                Text("نام")
//                            },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .weight(3f),
//                            colors = TextFieldDefaults.colors().copy(
//                                focusedContainerColor = Color.White,
//                                focusedTextColor = Color.White,
//                                unfocusedTextColor = Color.White,
//                                unfocusedContainerColor = Color.White,
//                                focusedIndicatorColor = Color.Transparent,
//                                unfocusedIndicatorColor = Color.Transparent,
//                                disabledIndicatorColor = Color.Transparent
//                            )
//                        )
//                    }
                    InputFieldRow(
                        label = "نام خانوادگی",
                        value = mText,
                        onValueChange = { mText = it })
                    InputFieldRow(
                        label = "تلفن همراه",
                        value = mText,
                        onValueChange = { mText = it })
                    InputFieldRow(
                        label = "تلفن ثابت",
                        value = mText,
                        onValueChange = { mText = it })
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .background(Color(0xFFF2F2F2))
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {

                    Text(
                        "آدرس دقیق",
                        color = Color(0xFF2684B4),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )

                    OutlinedTextField(
                        value = mText,
                        onValueChange = { mText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Gray,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Black,
                            unfocusedIndicatorColor = Color.Gray,
                            disabledIndicatorColor = Color.Gray
                        )
                    )


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "جنسیت",
                            modifier = Modifier
                                .weight(.5f)
                                .padding(start = 8.dp, top = 8.dp),
                            color = Color(0xFF2684B4),
                            fontWeight = FontWeight.SemiBold,
                        )

                        Row(modifier = Modifier.weight(.5f)) {
                            GenderSwitch(items = listOf("خانم", "آقا")) { }
                        }
                    }

                }





                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF2F2F2))
                ) {
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18D999)),
                        shape = RoundedCornerShape(8.dp),
                        onClick = {
                        }) {

                        Text(
                            text = "مرحله بعد", color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun SetAddressScreenPreview() {
    SetAddressScreen()
}