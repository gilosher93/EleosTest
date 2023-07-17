package com.gilosher.eleostest.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.gilosher.eleostest.generateRandomColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Random

class HomeViewModel(
    private val random: Random = Random()
): ViewModel() {

    private val _pageState = MutableStateFlow(HomePageState())
    val pageState = _pageState.asStateFlow()

    data class HomePageState(
        val color: Color = generateRandomColor()
    )

    sealed interface HomeEvent {
        object UpdateColor: HomeEvent
    }

    fun onEvent(event: HomeEvent) {
        when(event) {
            HomeEvent.UpdateColor -> updateColor()
        }
    }

    private fun updateColor() {
        _pageState.update {
            it.copy(
                color = generateRandomColor(random)
            )
        }
    }
}