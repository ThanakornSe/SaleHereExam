package com.salehere.salehereexam.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salehere.salehereexam.core.theme.AppTheme
import com.salehere.salehereexam.core.theme.Typography
import com.salehere.salehereexam.core.theme.borderRed
import com.salehere.salehereexam.core.theme.placeholderText
import com.salehere.salehereexam.core.theme.space16Dp
import com.salehere.salehereexam.core.theme.space8Dp
import com.salehere.salehereexam.core.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    placeHolderText: String? = null,
    enable: Boolean = true,
    trailingIcon: @Composable () -> Unit = {},
    container: @Composable () -> Unit = {},
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = space16Dp),
        singleLine = true,
        enabled = enable
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = text,
            innerTextField = innerTextField,
            singleLine = true,
            enabled = enable,
            interactionSource = remember { MutableInteractionSource() },
            visualTransformation = VisualTransformation.None,
            contentPadding = PaddingValues(space8Dp),
            shape = RectangleShape,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = white,
                unfocusedContainerColor = white,
                disabledContainerColor = white,
                focusedIndicatorColor = white,
                unfocusedIndicatorColor = white,
            ),
            placeholder = {
                placeHolderText?.let {
                    Text(
                        modifier = Modifier
                            .padding(end = space16Dp),
                        text = it,
                        color = placeholderText,
                        style = Typography.titleMedium,
                        fontSize = 18.sp
                    )
                }
            },
            trailingIcon = {
                trailingIcon()
            },
            container = {
                container()
            }
        )
    }
}

@Preview
@Composable
private fun DefaultAppTextFieldPreview() {
    AppTheme {
        AppTextField(
            placeHolderText = "Test",
            enable = false,
            trailingIcon = {

            },
            container = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(white)
                        .border(width = 1.dp, color = borderRed)
                )
            }
        )
    }
}