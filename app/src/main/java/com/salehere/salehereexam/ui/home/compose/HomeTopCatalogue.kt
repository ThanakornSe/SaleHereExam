package com.salehere.salehereexam.ui.home.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salehere.salehereexam.R
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.Typography
import com.salehere.salehereexam.core.theme.goodColor
import com.salehere.salehereexam.core.theme.black
import com.salehere.salehereexam.core.theme.borderBottomNavTint
import com.salehere.salehereexam.core.theme.borderGreen
import com.salehere.salehereexam.core.theme.borderRed
import com.salehere.salehereexam.core.theme.unHappyColor
import com.salehere.salehereexam.core.theme.progressBackground
import com.salehere.salehereexam.core.theme.space150Dp
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space24Dp
import com.salehere.salehereexam.core.theme.space2Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white
import com.salehere.salehereexam.data.home.model.GoalResponse
import com.salehere.salehereexam.ui.home.model.Goal

@Composable
fun HomeTopCatalogue(
    homeGoal: Goal,
    isEven: Boolean = false,
) {
    Column(
        modifier = Modifier
            .size(space150Dp)
            .border(
                border = BorderStroke(
                    space2Dp,
                    if (isEven) borderRed else borderGreen
                ),
                shape = RoundedCornerShape(
                    space16Dp
                )
            )
            .clip(RoundedCornerShape(space16Dp))
            .background(color = white)
            .padding(horizontal = space8Dp, vertical = space16Dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            homeGoal.icon?.let {
                Icon(
                    modifier = Modifier.size(space24Dp),
                    painter = painterResource(id = it),
                    tint = borderRed,
                    contentDescription = null
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = homeGoal.saving ?: "",
                    color = borderRed,
                    style = Typography.bodyMedium,
                )
                Text(
                    text = homeGoal.goalSaving ?: "",
                    color = black,
                    style = Typography.bodySmall,
                )
            }
        }

        Spacer(modifier = Modifier.height(space8Dp))

        AppProgressbar(
            primaryProgress = homeGoal.saving?.replace(",", "")?.toFloat() ?: 0f,
            secondaryProgress = homeGoal.goalSaving?.replace(",", "")?.toFloat() ?: 0f,
            max = homeGoal.goalSaving?.replace(",", "")?.toFloat() ?: 100f,
            primaryColor = borderBottomNavTint,
            secondaryColor = progressBackground,
            backgroundColor = progressBackground
        )

        Spacer(modifier = Modifier.height(space16Dp))

        Text(
            text = homeGoal.name ?: "",
            color = black,
            style = Typography.bodyMedium,
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = homeGoal.status ?: "",
                color = if (homeGoal.status == "Good") goodColor else unHappyColor,
                style = Typography.bodyMedium,
                fontSize = 10.sp
            )
            Text(
                text = stringResource(R.string.goal_days_left, homeGoal.expired ?: ""),
                color = black,
                style = Typography.bodyMedium,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
@Preview
private fun DefaultHomeTopCataloguePreview() {
    AppTheme {
        HomeTopCatalogue(
            homeGoal = Goal(
                saving = "16,500",
                goalSaving = "20,000",
                icon = R.drawable.ic_luggage,
                name = "ไปเที่ยวญี่ปุ่น",
                status = "Good",
                expired = "45"
            )
        )
    }
}