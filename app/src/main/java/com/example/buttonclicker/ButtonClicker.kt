package com.example.buttonclicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ButtonClickerLayout(
    modifier: Modifier = Modifier,
    buttonModel: ButtonViewModel = viewModel(),
){
    val buttonUiState by buttonModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = modifier.size(200.dp),
            shape = RoundedCornerShape(70.dp),
            onClick = { buttonModel.increment()}
        ) {
            Text(
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                text = "Click"
            )
        }
        Spacer(
            modifier.padding(top = 10.dp)
        )
        Text("You have clicked this ${buttonUiState.clicks} times")
    }
}
