package by.victorskurchik.birthday.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import by.victorskurchik.birthday.screens.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = ANIMATION_DURATION
        )
    )

    LaunchedEffect(key1 = true, block = {
        startAnimation = true
        delay(LAUNCH_EFFECT_DELAY)
        navController.popBackStack()
        navController.navigate(Screen.MainScreen.route)
    })

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alphaAnim.value),
            text = "Birthday",
            textAlign = TextAlign.Center,
            fontSize = 50.sp
        )
    }
}

private const val ANIMATION_DURATION = 1_500
private const val LAUNCH_EFFECT_DELAY = 2_000L