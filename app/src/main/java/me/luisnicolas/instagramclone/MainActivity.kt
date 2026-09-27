package me.luisnicolas.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.luisnicolas.instagramclone.ui.screens.FeedScreen
import me.luisnicolas.instagramclone.ui.theme.InstagramcloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramcloneTheme {
                FeedScreen()
            }
        }
    }
}