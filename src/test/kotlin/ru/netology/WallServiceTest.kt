package ru.netology

import Comments
import Likes
import Post
import PostSource
import Reposts
import Views
import WallService
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val wallServiceTest = WallService()
        val post = wallServiceTest.add(Post(0,
            1,
            2,
            1,
            123455,
            "Test",
            0,
            0,
            false,
            Comments(10,true, true, true, true),
            "https://vk.com/dev/objects/post",
            Likes(100, true, true, false),
            Reposts(2, false),
            Views(200),
            "post",
            PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
            null,
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))
        assertNotEquals(post.id, 0)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService()
        service.add(Post(0,
            1,
            2,
            1,
            123455,
            "Test",
            0,
            0,
            false,
            Comments(10,true, true, true, true),
            "https://vk.com/dev/objects/post",
            Likes(100, true, true, false),
            Reposts(2, false),
            Views(200),
            "post",
            PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
            null,
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))
        val update = Post(10,
            1,
            2,
            1,
            123455,
            "Test",
            0,
            0,
            false,
            Comments(11,true, true, true, true),
            "https://vk.com/dev/objects/post",
            Likes(120, true, true, false),
            Reposts(2, false),
            Views(230),
            "post",
            PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
            null,
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0)

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun updateExisting() {
        val service = WallService()
        service.add(Post(0,
            1,
            2,
            1,
            123455,
            "Test",
            0,
            0,
            false,
            Comments(11,true, true, true, true),
            "https://vk.com/dev/objects/post",
            Likes(120, true, true, false),
            Reposts(2, false),
            Views(230),
            "post",
            PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
            null,
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))
        val update = Post(1,
            1,
            2,
            1,
            123455,
            "Test",
            0,
            0,
            false,
            Comments(10,true, true, true, true),
            "https://vk.com/dev/objects/post",
            Likes(100, true, true, false),
            Reposts(2, false),
            Views(200),
            "post",
            PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
            null,
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0)

        val result = service.update(update)

        assertTrue(result)
    }
}