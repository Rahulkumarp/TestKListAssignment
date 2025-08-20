package com.example.klist.screens.custombuilders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


val KList: KListBuilder get() = KListBuilder()

class KListBuilder internal constructor() {
    private var padding: Dp = 0.dp
    private var headerTitle: String? = null

    private var data: List<Any> = emptyList()
    private var itemContent: @Composable (Any) -> Unit = {}
    private var onItemClick: (Any) -> Unit = {}

    fun padding(dp: Dp): KListBuilder = apply { this.padding = dp }

    fun header(title: String): KListBuilder = apply { this.headerTitle = title }

    fun <T> items(list: List<T>, itemContent: @Composable (T) -> Unit): KListBuilder = apply {
        @Suppress("UNCHECKED_CAST")
        this.data = list as List<Any>
        this.itemContent = { any -> itemContent(any as T) }
    }
    fun <T> onItemClick(listener: (T) -> Unit): KListBuilder = apply {
        this.onItemClick = { any -> listener(any as T) }
    }

    @Composable
    fun render() {
        val context = LocalContext.current
        LazyColumn(modifier = Modifier.padding(padding)) {
            headerTitle?.let { title ->
                item {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            itemsIndexed(data) { _, item ->
                Box(
                    modifier = Modifier.clickable{
                        onItemClick(item)
                    }
                ){
                    itemContent(item)
                }
            }
        }
    }
}