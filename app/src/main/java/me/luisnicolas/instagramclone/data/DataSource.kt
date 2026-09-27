package me.luisnicolas.instagramclone.data

import me.luisnicolas.instagramclone.model.Post
import me.luisnicolas.instagramclone.model.Story

object DataSource {

    fun getPosts(): List<Post> = listOf(
        Post(1, "android_developer", "https://picsum.photos/seed/user1/200/200", "https://picsum.photos/seed/post1/800/800", 1_284, "Explorando Jetpack Compose 🚀 #Android #Kotlin"),
        Post(2, "kotlin_ninja", "https://picsum.photos/seed/user2/200/200", "https://picsum.photos/seed/post2/800/800", 847, "Data classes son la mejor feature de Kotlin ❤️", isLiked = true),
        Post(3, "compose_ui", "https://picsum.photos/seed/user3/200/200", "https://picsum.photos/seed/post3/800/800", 3_456, "Material3 + Compose = perfecta combinación 🎨"),
        Post(4, "google_devs", "https://picsum.photos/seed/user4/200/200", "https://picsum.photos/seed/post4/800/800", 12_891, "Android 15 trae increíbles mejoras de performance! 📱"),
        Post(5, "mobile_craft", "https://picsum.photos/seed/user5/200/200", "https://picsum.photos/seed/post5/800/800", 629, "LazyColumn vs RecyclerView: ¿cuál prefieres? 💭"),
        Post(6, "ui_ux_master", "https://picsum.photos/seed/user6/200/200", "https://picsum.photos/seed/post6/800/800", 2_103, "El buen diseño es invisible ✨"),
        Post(7, "code_with_maria", "https://picsum.photos/seed/user7/200/200", "https://picsum.photos/seed/post7/800/800", 985, "Aprendiendo Coil para cargar imágenes 📸", isLiked = true),
        Post(8, "dev_life", "https://picsum.photos/seed/user8/200/200", "https://picsum.photos/seed/post8/800/800", 431, "Un café y muchas líneas de código ☕"),
        Post(9, "kotlin_daily", "https://picsum.photos/seed/user9/200/200", "https://picsum.photos/seed/post9/800/800", 5_678, "Los scope functions cambiaron mi forma de programar 🧠"),
        Post(10, "app_builder", "https://picsum.photos/seed/user10/200/200", "https://picsum.photos/seed/post10/800/800", 1_920, "Feed terminado con LazyColumn + Coil 🎉")
    )

    fun getStories(): List<Story> = listOf(
        Story(1, "android_dev", "https://picsum.photos/seed/story1/200/200", hasSeen = false),
        Story(2, "kotlin_ninja", "https://picsum.photos/seed/story2/200/200", hasSeen = false),
        Story(3, "compose_ui", "https://picsum.photos/seed/story3/200/200", hasSeen = true),
        Story(4, "google_devs", "https://picsum.photos/seed/story4/200/200", hasSeen = false),
        Story(5, "mobile_craft", "https://picsum.photos/seed/story5/200/200", hasSeen = true),
        Story(6, "ui_ux_master", "https://picsum.photos/seed/story6/200/200", hasSeen = false),
        Story(7, "dev_life", "https://picsum.photos/seed/story7/200/200", hasSeen = true)
    )
}