package com.salehere.salehereexam.ui.achievement.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salehere.salehereexam.R
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.Typography
import com.salehere.salehereexam.core.theme.borderRed
import com.salehere.salehereexam.core.theme.homeToolbarOrange
import com.salehere.salehereexam.core.theme.primaryText
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space2Dp
import com.salehere.salehereexam.core.theme.space32Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.core.ui.AppTextField
import com.salehere.salehereexam.data.achievement.model.AchievementItemResponse
import com.salehere.salehereexam.data.achievement.model.AchievementResponse
import com.salehere.salehereexam.ui.achievement.model.AchievementItem
import com.salehere.salehereexam.ui.achievement.model.AchievementUiState
import com.salehere.salehereexam.ui.achievement.viewmodel.AchievementViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun AchievementMainScreen(viewModel: AchievementViewModel = koinViewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAchievementData()
    }

    AchievementScreen(uiState = uiState)
}

@Composable
fun AchievementScreen(uiState: AchievementUiState) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(white),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(homeToolbarOrange)
                    .statusBarsPadding()
                    .padding(space32Dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(id = R.drawable.ic_medal),
                    contentDescription = null,
                    tint = white
                )
                Spacer(modifier = Modifier.width(space16Dp))
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "Achievement",
                        color = white,
                        style = Typography.titleMedium
                    )
                    Text(
                        text = "Level 2",
                        color = white,
                        style = Typography.titleLarge
                    )
                }
            }

        }
    ) { paddingValue ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(white),
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = space32Dp, vertical = space16Dp),
            horizontalArrangement = Arrangement.spacedBy(space16Dp),
            verticalArrangement = Arrangement.spacedBy(space16Dp)
        ) {
            uiState.item?.let {
                items(it) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(100.dp),
                        shape = RoundedCornerShape(space8Dp),
                        colors = CardDefaults.cardColors(
                            containerColor = white
                        ),
                        border = BorderStroke(width = space2Dp, color = borderRed)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(space8Dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            it.icon?.let { icon ->
                                Icon(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f),
                                    painter = painterResource(id = icon),
                                    contentDescription = null,
                                    tint = borderRed
                                )
                            }

                            Spacer(modifier = Modifier.height(space8Dp))

                            it.name?.let { name ->
                                Text(
                                    text = name,
                                    style = Typography.bodyMedium,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun DefaultAchievementScreenPreview() {
    AppTheme {
        AchievementScreen(uiState = AchievementUiState(
            item = listOf(
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                ),
                AchievementItem(
                    name = "Achievement", icon = R.drawable.ic_achievement
                )
            )
        )
        )
    }
}