## Usage

```kotlin
@Composable
fun KListDemo() {
    val coins = listOf("Bitcoin", "Ethereum", "Solana")

    KList
        .padding(16.dp)
        .header("Top Gainers")
        .items(coins) { coin ->
            KListItem(coin)
        }
        .render()
}
```

## Modules
- **KList.kt** – the DSL and renderer (LazyColumn)
- **KListItem.kt** – sample reusable item
- **KListDemo.kt** – demo composable
- **MainActivity.kt** – entry point
