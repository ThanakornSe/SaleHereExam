package com.salehere.salehereexam.ui.home.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.salehere.salehereexam.R
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.Typography
import com.salehere.salehereexam.core.theme.black
import com.salehere.salehereexam.core.theme.borderBottomNavTint
import com.salehere.salehereexam.core.theme.borderGreen
import com.salehere.salehereexam.core.theme.borderRed
import com.salehere.salehereexam.core.theme.homeToolbarOrange
import com.salehere.salehereexam.core.theme.primaryText
import com.salehere.salehereexam.core.theme.progressBackground
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space24Dp
import com.salehere.salehereexam.core.theme.space4Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.core.ui.homeTopBarGradientBackground
import com.salehere.salehereexam.data.home.model.BestOfferResponse
import com.salehere.salehereexam.data.home.model.GoalResponse
import com.salehere.salehereexam.data.home.model.HomeDataResponse
import com.salehere.salehereexam.data.home.model.SuggestionResponse
import com.salehere.salehereexam.ui.home.model.BestOffer
import com.salehere.salehereexam.ui.home.model.Goal
import com.salehere.salehereexam.ui.home.model.HomeUiState
import com.salehere.salehereexam.ui.home.model.Suggestion
import com.salehere.salehereexam.ui.home.viewmodel.HomeViewModel
import com.salehere.salehereexam.ui.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeMainScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = koinViewModel(),
) {

    LaunchedEffect(Unit) {
        viewModel.getHomeData()
    }

    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(uiState = uiState, onNewGoalClick = {
        navHostController.navigate(Screen.GOAL.name)
    })
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onNewGoalClick: () -> Unit = {},
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .homeTopBarGradientBackground()
                    .statusBarsPadding()
                    .padding(top = space16Dp)
            ) {
                uiState.goals?.let {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = space16Dp)
                    ) {
                        itemsIndexed(it) { index, item ->
                            HomeTopCatalogue(homeGoal = item, isEven = index % 2 != 0)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(space16Dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = space16Dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = stringResource(
                            R.string.home_goal_count,
                            uiState.goals?.size.toString()
                        ),
                        color = white,
                        style = Typography.titleMedium,
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style =
                                SpanStyle(
                                    fontSize = 14.sp,
                                ),
                            ) {
                                append(
                                    stringResource(R.string.home_all_saving_tab),
                                )
                            }
                            withStyle(
                                style =
                                SpanStyle(
                                    fontSize = 24.sp,
                                ),
                            ) {
                                append(
                                    uiState.allSaving ?: "",
                                )
                            }
                            withStyle(
                                style =
                                SpanStyle(
                                    fontSize = 14.sp,
                                ),
                            ) {
                                append(
                                    stringResource(R.string.home_currency_thb),
                                )
                            }
                        },
                        style = Typography.titleMedium,
                        color = white,
                    )
                }
                Spacer(modifier = Modifier.height(space16Dp))
            }

        }
        item {
            Spacer(modifier = Modifier.height(space8Dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space16Dp),
                shape = RoundedCornerShape(
                    space8Dp
                ),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = borderBottomNavTint,
                    contentColor = white
                ),
                onClick = {
                    onNewGoalClick()
                }
            ) {
                Text(
                    text = stringResource(R.string.home_new_goal_button),
                    style = MaterialTheme.typography.titleMedium,
                    color = white,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(space16Dp))
            Text(
                text = stringResource(R.string.home_best_offer_tab),
                style = Typography.titleMedium,
                color = primaryText,
                modifier = Modifier.padding(horizontal = space16Dp)
            )
            uiState.bestOffers?.let {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = space16Dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = space16Dp)
                ) {
                    items(it) {
                        Image(
                            modifier = Modifier
                                .width(170.dp)
                                .height(100.dp),
                            painter = painterResource(id = it.img ?: 0),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

        }

        item {
            Spacer(modifier = Modifier.height(space16Dp))
            Text(
                text = stringResource(R.string.home_suggest_for_you_tab),
                style = Typography.titleMedium,
                color = primaryText,
                modifier = Modifier.padding(horizontal = space16Dp)
            )
            uiState.suggestions?.let {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = space16Dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = space16Dp)
                ) {
                    items(it) {
                        Image(
                            modifier = Modifier
                                .width(170.dp)
                                .height(100.dp),
                            painter = painterResource(id = it.img ?: 0),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

    }

}

@Preview
@Composable
private fun DefaultHomeScreenPreview() {
    AppTheme {
        HomeScreen(
            uiState = HomeUiState(
                goals = listOf(
                    Goal(
                        saving = "16,500",
                        goalSaving = "20,000",
                        icon = R.drawable.ic_luggage,
                        name = "ไปเที่ยวญี่ปุ่น",
                        status = "Good",
                        expired = "45"
                    ),
                    Goal(
                        saving = "500",
                        goalSaving = "6,000",
                        icon = R.drawable.ic_stock,
                        name = "ซื้อกองทุนรวม",
                        status = "Unhappy",
                        expired = "20"
                    ),
                    Goal(
                        saving = "4,000",
                        goalSaving = "5,000",
                        icon = R.drawable.ic_luggage,
                        name = "ไปทะเล",
                        status = "Good",
                        expired = "10"
                    )
                ),
                allSaving = "37,500",
                bestOffers = listOf(
                    BestOffer(
                        img = R.drawable.img_best_offer_1
                    ),
                    BestOffer(
                        img = R.drawable.img_best_offer_2
                    ),
                    BestOffer(
                        img = R.drawable.img_best_offer_3
                    )
                ),
                suggestions = listOf(
                    Suggestion(
                        img = R.drawable.img_suggest_1
                    ),
                    Suggestion(
                        img = R.drawable.img_suggest_2
                    ),
                    Suggestion(
                        img = R.drawable.img_suggest_3
                    )
                )
            )
        )
    }
}