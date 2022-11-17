package com.example.composeapp.ui.screens.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.data.Person
import com.example.composeapp.data.PersonSaver
import com.example.composeapp.ui.screens.Destinations
import com.example.composeapp.MainViewModel
import com.example.composeapp.data.AppPreferences
import kotlinx.coroutines.launch

@Composable
fun AccountScreen(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    viewModel.setCurrentScreen(Destinations.DrawerDestinations.Account)
    LoginSCreen()
}


@Composable
fun LoginSCreen() {
    //context
    val context = LocalContext.current
    // a coroutine scope
    val scope = rememberCoroutineScope()
    // we instantiate the saveEmail class
    val dataStore = AppPreferences(context)


    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var email by rememberSaveable { mutableStateOf("") }
        //
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "EMAIL",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType
                = KeyboardType.Email
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    dataStore.saveEmail(email)
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                text = "Save Email",

                )
        }
        Spacer(modifier = Modifier.height(32.dp))

        val userEmail = dataStore.getEmail.collectAsState(initial = "")

        Text(text = userEmail.value!!)
        PersonDetail()




    }
}

@Composable
fun PersonDetail(){
    var savedPerson = rememberSaveable(stateSaver = PersonSaver) {
        mutableStateOf(Person("Ram", 20))
    }
    Text(text = "Name is ${savedPerson.value.name} and age is ${savedPerson.value.age}")
}
