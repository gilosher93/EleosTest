package com.gilosher.eleostest.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    pageState: HomeViewModel.HomePageState,
    onEvent: (HomeViewModel.HomeEvent) -> Unit = {}
) {
    val color by animateColorAsState(
        targetValue = pageState.color,
        label = "background color",
        animationSpec = tween(250)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onEvent(HomeViewModel.HomeEvent.UpdateColor)
            }
        ) {
            Text(text = "Change Color", fontSize = 20.sp)
        }
    }
}