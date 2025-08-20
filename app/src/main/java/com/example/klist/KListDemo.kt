package com.example.klist

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun KListDemo() {
    var context = LocalContext.current
    val listOfCoins = listOf("Bitcoin", "Ethereum", "Solana", "Dogecoin",
        "Cardano","Bitcoin1", "Ethereum1", "Solana1", "Dogecoin1", "Cardano1",
        "Bitcoin2", "Ethereum2", "Solana2", "Dogecoin2", "Cardano2")

    KList.padding(16.dp)
        .header("Top Gainers")
        .onItemClick<String> { selected ->
            Toast.makeText(context, "working $selected", Toast.LENGTH_SHORT).show()

        }
        .items(listOfCoins) { coin ->
            KListItem(coin)
        }.render()

}