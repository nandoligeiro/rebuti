package com.nandoligeiro.ituber.ui.components

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun CategoryTab(categories: List<String>, onCategorySelected: (String) -> Unit) {
    var selectedCategory by remember { mutableStateOf(categories.first()) }
    ScrollableTabRow(
        selectedTabIndex = categories.indexOf(selectedCategory)
    ) {
        categories.forEach { category ->
            Tab(
                selected = category == selectedCategory,
                onClick = {
                    selectedCategory = category
                    onCategorySelected(category)
                },
                text = { Text(category) }
            )
        }
    }
}
