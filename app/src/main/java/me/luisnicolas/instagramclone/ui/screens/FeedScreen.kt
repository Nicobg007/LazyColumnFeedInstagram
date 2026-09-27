package me.luisnicolas.instagramclone.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import me.luisnicolas.instagramclone.data.DataSource
import me.luisnicolas.instagramclone.ui.components.PostCard
import me.luisnicolas.instagramclone.ui.components.StoriesRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = { Text("Instagram", fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold) },
        actions = {
            IconButton(onClick = {}) { Icon(Icons.Outlined.FavoriteBorder, "Notificaciones") }
            IconButton(onClick = {}) { Icon(Icons.Outlined.Send, "Mensajes") }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun FeedScreen() {
    val posts = remember { DataSource.getPosts() }
    val stories = remember { DataSource.getStories() }

    Scaffold(topBar = { InstagramTopBar() }) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            item {
                StoriesRow(stories = stories)
                HorizontalDivider()
            }
            items(items = posts, key = { it.id }) { post ->
                PostCard(post = post)
                HorizontalDivider()
            }
        }
    }
}