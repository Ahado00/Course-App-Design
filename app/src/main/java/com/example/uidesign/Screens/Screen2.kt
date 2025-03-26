package com.example.uidesign.Screens


import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uidesign.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Screen2(navController: NavHostController) {

    var progress by remember { mutableFloatStateOf(0.66f) } // 66% progress

    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = androidx.compose.animation.core.tween(durationMillis = 800, easing = FastOutSlowInEasing) // 2-second animation
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F1F0D)),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End

        ) {
            Text(
                text = stringResource(R.string.Skip),
                textAlign = TextAlign.End,
                color = Color(0xFFF5EAFF),
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .padding(40.dp)
                    .clickable(onClick = { navController.navigate("Screen3") })
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = "Second screen illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(260.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.S2h1),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                lineHeight = 35.sp,
                color = Color(0xFFF0E0FC),
                fontSize = 25.sp,
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = stringResource(R.string.S2h2),
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFFF5EAFF),
                fontSize = 15.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center

            )


            Spacer(modifier = Modifier.height(72.dp))

            //progress bar
            LinearProgressIndicator(
                progress = animatedProgress,
                modifier = Modifier.width(200.dp),
                color = Color(0xFF166E05)
            )
        }
    }
}
