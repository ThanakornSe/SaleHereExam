package com.salehere.salehereexam.ui.home.compose

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
import com.salehere.salehereexam.core.theme.progressBackground
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space24Dp
import com.salehere.salehereexam.core.theme.space4Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.core.ui.homeTopBarGradientBackground
import com.salehere.salehereexam.ui.home.model.HomeUiState

@Composable
fun HomeMainScreen(
    navHostController: NavHostController,
    //viewModel: HomeViewModel = koinViewModel(),
) {

    HomeScreen(uiState = HomeUiState())
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
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
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(horizontal = space16Dp)
                ) {
                    items(10) { index ->
                        HomeTopCatalogue(
                            isGood = true,
                            isEven = index % 2 != 0
                        )
                    }
                }
                Spacer(modifier = Modifier.height(space16Dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = space16Dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "3 Goals",
                        color = white,
                        style = Typography.titleMedium,
                    )
                    Text(
                        text = "All Saving 37,500 THB",
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
                onClick = { /*TODO*/ }) {
                Text(
                    text = "+ New Goal",
                    style = MaterialTheme.typography.bodyMedium,
                    color = white,
                    fontWeight = FontWeight.Bold
                )

            }
        }

    }

}

@Preview
@Composable
private fun DefaultHomeScreenPreview() {
    AppTheme {
        HomeScreen(uiState = HomeUiState())
    }
}