package com.salehere.salehereexam.ui.home.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.salehere.salehereexam.core.theme.space4Dp
import com.salehere.salehereexam.core.theme.space8Dp

@Composable
fun AppProgressbar(
    modifier: Modifier = Modifier,
    primaryProgress: Float,
    secondaryProgress: Float,
    max: Float,
    primaryColor: Color,
    secondaryColor: Color,
    backgroundColor: Color
) {
    var first by remember { mutableStateOf(0f) }
    first = (primaryProgress)/max
    var second by remember {
        mutableStateOf(0f)
    }
    second = (primaryProgress + secondaryProgress)/max

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(space4Dp))
            .background(backgroundColor)
            .height(space8Dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(space4Dp))
                .background(secondaryColor)
                .fillMaxHeight()
                .fillMaxWidth(second)
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(space4Dp))
                .background(primaryColor)
                .fillMaxHeight()
                .fillMaxWidth(first)
        )
    }
}