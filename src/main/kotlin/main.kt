fun main() {
    val wallService = WallService()
    val post = wallService.add(Post(0,
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
        100,
        true,
        true,
        true,
        false,
        false,
        true,
        0
    ))
    println(post.toString())

    val postUpdated = wallService.update(Post(10,
        1,
        2,
        1,
        123455,
        "Test post",
        0,
        0,
        false,
        Comments(10,true, true, true, true),
        "https://vk.com/dev/objects/post",
        Likes(100, true, true, false),
        Reposts(2, false),
        Views(200),
        "post",
        100,
        true,
        true,
        true,
        false,
        false,
        true,
        0
    ))
    println(postUpdated)
}