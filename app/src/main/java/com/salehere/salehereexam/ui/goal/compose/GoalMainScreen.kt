package com.salehere.salehereexam.ui.goal.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salehere.salehereexam.R
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.Typography
import com.salehere.salehereexam.core.theme.borderRed
import com.salehere.salehereexam.core.theme.homeToolbarOrange
import com.salehere.salehereexam.core.theme.placeholderText
import com.salehere.salehereexam.core.theme.primaryText
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space2Dp
import com.salehere.salehereexam.core.theme.space32Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.core.ui.AppTextField
import java.util.Vector

@Composable
fun GoalMainScreen() {
    GoalScreen()
}

@Composable
fun GoalScreen() {
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(white)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(homeToolbarOrange)
                    .statusBarsPadding()
                    .padding(top = space32Dp, start = space32Dp, end = space32Dp)
            ) {
                Text(
                    text = "What your Goal",
                    color = white,
                    style = Typography.titleMedium
                )
                Spacer(modifier = Modifier.height(space8Dp))

                AppTextField(
                    container = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(white)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(space16Dp))
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
            items(5) {
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
                        Icon(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            painter = painterResource(id = R.drawable.ic_luggage),
                            contentDescription = null,
                            tint = borderRed
                        )

                        Spacer(modifier = Modifier.height(space8Dp))

                        Text(text = "Travel", style = Typography.bodyMedium, fontSize = 12.sp)
                    }
                }
            }

            item(span = { GridItemSpan(3) }) {
                Column {
                    AppTextField(
                        placeHolderText = stringResource(
                            id = R.string.goal_amount_text_field
                        ),
                        trailingIcon = {
                            Text(
                                modifier = Modifier
                                    .padding(end = space16Dp),
                                text = stringResource(
                                    id = R.string.home_currency_thb
                                ),
                                color = borderRed,
                                style = Typography.titleMedium,
                                fontSize = 18.sp
                            )
                        },
                        container = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 1.dp, color = borderRed)
                            )
                        }
                    )

                    AppTextField(
                        enable = false,
                        placeHolderText = stringResource(
                            id = R.string.goal_select_date_text_field
                        ),
                        trailingIcon = {
                            Icon(
                                modifier = Modifier.size(space32Dp),
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = borderRed
                            )
                        },
                        container = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 1.dp, color = borderRed)
                            )
                        }
                    )
                }
            }

            item(span = { GridItemSpan(3) }) {
                Column {
                    Spacer(modifier = Modifier.height(space16Dp))
                    Text(
                        text = "Bank Account",
                        color = primaryText,
                        style = Typography.titleMedium,
                        fontSize = 18.sp
                    )
                    AppTextField(
                        enable = false,
                        placeHolderText = stringResource(
                            id = R.string.goal_select_account_text_field
                        ),
                        trailingIcon = {
                            Icon(
                                modifier = Modifier.size(space32Dp),
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = borderRed
                            )
                        },
                        container = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 1.dp, color = borderRed)
                            )
                        }
                    )
                    AppTextField(
                        placeHolderText = stringResource(
                            id = R.string.goal_amount_text_field
                        ),
                        trailingIcon = {
                            Text(
                                modifier = Modifier
                                    .padding(end = space16Dp),
                                text = stringResource(
                                    id = R.string.goal_currency_trailing_text_field
                                ),
                                color = borderRed,
                                style = Typography.titleMedium,
                                fontSize = 18.sp
                            )
                        },
                        container = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .border(width = 1.dp, color = borderRed)
                            )
                        }
                    )
                }
            }

        }

    }


}

@Preview
@Composable
private fun DefaultGoalScreenPreview() {
    AppTheme {
        GoalScreen()
    }
}