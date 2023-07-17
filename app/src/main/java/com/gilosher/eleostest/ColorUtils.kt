package com.gilosher.eleostest

import androidx.compose.ui.graphics.Color
import java.util.Random

fun generateRandomColor(random: Random = Random()) =
    Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))