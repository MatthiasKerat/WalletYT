package com.kapps.wallet.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapps.wallet.ui.theme.*

@Composable
fun WalletOverview(
    valueBeforeComma:()->Int,
    valueAfterComma:()->Int,
    onDepositClick:()->Unit,
    onWithdrawClick:()->Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = {
            onWithdrawClick()
        }) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "withdraw",
                tint = white,
                modifier = Modifier.size(28.dp)
            )
        }
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.BottomCenter
        ){
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                Text(
                    "${valueBeforeComma()}",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    ",",
                    fontSize = 20.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
                Text(
                    "%02d".format(valueAfterComma()),
                    fontSize = 20.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
                Text(
                    "€",
                    fontSize = 18.sp,
                    modifier = Modifier.offset(x = 0.dp, y = (-3.5).dp)
                )
            }
        }

        IconButton(onClick = {
            onDepositClick()
        }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "deposit",
                tint = white,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}