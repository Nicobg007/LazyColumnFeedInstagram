package me.luisnicolas.instagramclone.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import me.luisnicolas.instagramclone.model.Post

@Composable
fun PostCard(
    post: Post,
    onLikeClick: (Post) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var liked by remember { mutableStateOf(post.isLiked) }

    Column(modifier = modifier.fillMaxWidth()) {
        PostHeader(post)
        AsyncImage(
            model = post.imageUrl,
            contentDescription = "Imagen del post",
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        PostActions(liked = liked, onLikeClick = {
            liked = !liked
            onLikeClick(post)
        })
        PostFooter(
            likes = if (liked) post.likes + 1 else post.likes,
            username = post.username,
            caption = post.caption
        )
    }
}

@Composable
private fun PostHeader(post: Post) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = post.profileImageUrl,
            contentDescription = "Avatar",
            modifier = Modifier.size(36.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(post.username, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Icon(Icons.Outlined.MoreVert, contentDescription = "Más opciones")
    }
}

@Composable
private fun PostActions(liked: Boolean, onLikeClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onLikeClick) {
            Icon(
                imageVector = if (liked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Like",
                tint = if (liked) Color.Red else Color.Black
            )
        }
        IconButton(onClick = {}) { Icon(Icons.Outlined.ChatBubbleOutline, contentDescription = "Comentar") }
        IconButton(onClick = {}) { Icon(Icons.Outlined.Send, contentDescription = "Compartir") }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = {}) { Icon(Icons.Outlined.BookmarkBorder, contentDescription = "Guardar") }
    }
}

@Composable
private fun PostFooter(likes: Int, username: String, caption: String) {
    Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
        Text("$likes me gusta", fontWeight = FontWeight.Bold)
        Row {
            Text(username, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(4.dp))
            Text(caption, maxLines = 2, style = MaterialTheme.typography.bodyMedium)
        }
    }
}