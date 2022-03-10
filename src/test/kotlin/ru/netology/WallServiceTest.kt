package ru.netology

import Comment
import CommentNotFoundException
import CommentReport
import Comments
import Likes
import Post
import PostNotFoundException
import PostSource
import ReasonNotFoundException
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

    @Test
    fun createComment() {
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
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))

        service.createComment(Comment(1,1,2,"Test",0,null,0, ""))
        assertNotEquals(service.comments, emptyArray<Comment>())
    }

    @Test(expected = PostNotFoundException::class)
    fun createCommentException() {
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
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))

        service.createComment(Comment(1,10,2,"Test",0,null,0, ""))
    }

    @Test
    fun reportComment(){
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
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))

        service.createComment(Comment(1,1,2,"Test",0,null,0, ""))
        service.reportComment(CommentReport(1, 0, 2))
        assertNotEquals(service.commentReports, emptyArray<Comment>())
    }

    @Test(expected = CommentNotFoundException::class)
    fun reportCommentNotFoundComment(){
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
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))

        service.createComment(Comment(1,1,2,"Test",0,null,0, ""))
        service.reportComment(CommentReport(1, 2, 2))
        assertNotEquals(service.commentReports, emptyArray<Comment>())
    }

    @Test(expected = ReasonNotFoundException::class)
    fun reportCommentNotFoundReason(){
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
            null,
            100,
            true,
            true,
            true,
            false,
            false,
            true,
            0))

        service.createComment(Comment(1,1,2,"Test",0,null,0, ""))
        service.reportComment(CommentReport(1, 0, 10))
        assertNotEquals(service.commentReports, emptyArray<Comment>())
    }
}