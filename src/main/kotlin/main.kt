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
        PostSource("vk", "android", "profile_activity", "https://vk.com/dev/objects/post"),
        null,
        Array<Attachment>(5){
                            AudioAttachment(audio = Audio(1,23435,2,"Zivert", "Beverly Hills", 3000, "", 3,123,5,null, 1))
                            NoteAttachment(note = Note(1,232443,1,"noteTitle", "noteText", 0, 0, ""))
                            PhotoAttachment(photo = Photo(4, 1232424,200,1,1,"photo", Array<PhotoSize>(1){PhotoSize("orig", "",200, 300)}, 200, 300))
                            DocAttachment(doc = Document(3,1232424,1,"docTitle", 100,"", "https://vk.com/dev/objects/post",4, DocPreview(PhotoPreview(Array<PhotoSize>(1){PhotoSize("orig", "",200, 300)}), null, null)))
                            GraffitiAttachment(graffiti = Graffiti(23, 1, "", ""))},
        null,
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

    val postUpdated = wallService.add(Post(0,
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
        0
    ))
    println(postUpdated)
}

