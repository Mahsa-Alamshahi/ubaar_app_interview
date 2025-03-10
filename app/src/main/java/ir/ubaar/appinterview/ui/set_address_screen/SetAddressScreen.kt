package ir.ubaar.appinterview.ui.set_address_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.ubaar.appinterview.R
import ir.ubaar.appinterview.data.data_source.remote.dto.Detail
import ir.ubaar.appinterview.ui.component.Loading
import ir.ubaar.appinterview.ui.component.TopAppBarComponent
import ir.ubaar.appinterview.ui.theme.FormTitleTextColor
import ir.ubaar.appinterview.utils.createRequest
import kotlin.reflect.KFunction1


@Composable
fun SetAddressScreenRoute(onBackClick: () -> Unit, onSecondPage: () -> Unit) {

    val viewModel: SetAddressViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    SetAddressScreen(
        onNextClick = viewModel::setAddress,
        onSecondPage = onSecondPage,
        onBackClick= onBackClick,
        setAddressResponseState = uiState
    )

}


@Composable
fun SetAddressScreen(
    onNextClick: KFunction1<Detail, Unit>,
    onSecondPage: () -> Unit,
    onBackClick: () -> Unit,
    setAddressResponseState: SetAddressState
) {


    val scrollState = rememberScrollState()
    val context = LocalContext.current


    var firstNameTextState by remember { mutableStateOf("") }
    var lastNameTextState by remember { mutableStateOf("") }
    var mobilePhoneNumberTextState by remember { mutableStateOf("") }
    var phoneNumberTextState by remember { mutableStateOf("") }
    var addressTextState by remember { mutableStateOf("") }
    var genderTextState by remember { mutableStateOf("خانم") }


    var rowBorderColor by remember { mutableStateOf(Color.LightGray) }
    var apiCalled by remember { mutableStateOf(false)    }



    CompositionLocalProvider(LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl) {

        TopAppBarComponent(
            topAppBarTitle = stringResource(R.string.register),
            onBackClick = onBackClick
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .verticalScroll(scrollState)
                    .consumeWindowInsets(innerPadding)
                    .imePadding()
                    .background(MaterialTheme.colorScheme.primary)
            ) {

                Text(
                    stringResource(R.string.enter_your_data),
                    modifier = Modifier
                        .fillMaxWidth()
//                        .background(Color(0xFFF2F2F2))
                        .padding(start = 12.dp, top = 12.dp, bottom = 12.dp),
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {

                    InputFieldRow(
                        label = stringResource(R.string.name),
                        minChar = 3,
                        onValueChange = {
                            firstNameTextState = it
                        })

                    InputFieldRow(label = stringResource(R.string.last_name),
                        minChar = 3,
                        onValueChange = {
                            lastNameTextState = it
                        })

                    InputFieldRow(label = stringResource(R.string.mobile_phone),
                        minChar = 11,
                        keyboardType = KeyboardType.Number,
                        onValueChange = {
                            mobilePhoneNumberTextState = it
                        })

                    InputFieldRow(label = stringResource(R.string.phone_number),
                        minChar = 11,
                        keyboardType = KeyboardType.Number,
                        onValueChange = {
                            phoneNumberTextState = it
                        })
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {

                    Text(
                        stringResource(R.string.address),
                        color = FormTitleTextColor,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )

                    TextField(
                        value = addressTextState, onValueChange = {
                            addressTextState = it
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(
                                width = .5.dp, color = rowBorderColor
                            )
                            .onFocusChanged {
                                rowBorderColor = if (it.isFocused) {
                                    Color.Black
                                } else {
                                    Color.LightGray
                                }
                            }, colors = TextFieldDefaults.colors().copy(
                            focusedContainerColor = Color.White,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Gray,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
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
                            stringResource(R.string.gender),
                            modifier = Modifier
                                .weight(.5f)
                                .padding(start = 8.dp, top = 8.dp),
                            color = FormTitleTextColor,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Row(modifier = Modifier.weight(.5f)) {
                            GenderSwitch(items = listOf("خانم", "آقا")) {
                                genderTextState = it
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(8.dp)
                ) {
                    if (apiCalled) {
                        onNextClick(
                            createRequest(
                                mapOf(
                                    "firstName" to firstNameTextState,
                                    "lastName" to lastNameTextState,
                                    "address" to addressTextState,
                                    "coordinatePhoneNumber" to phoneNumberTextState,
                                    "coordinateMobile" to mobilePhoneNumberTextState,
                                    "gender" to genderTextState
                                )
                            )
                        )
                        if (setAddressResponseState.isLoading) {
                            Loading(modifier = Modifier.fillMaxWidth())
                        } else if (setAddressResponseState.error.isNotBlank()) {
                            Toast.makeText(
                                context, setAddressResponseState.error, Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                stringResource(R.string.address_added_successfully), Toast.LENGTH_SHORT
                            ).show()
                            onSecondPage()
                        }
                    }
                }

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18D999)),
                    shape = RoundedCornerShape(8.dp),
                    onClick = {
                        apiCalled = true
                    }) {

                    Text(
                        text = stringResource(R.string.next),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
