class WallService {
    private var posts = emptyArray<Post>()
    private var currentId = 0

    fun add(post: Post): Post{
        currentId ++
        val postAdd = post.copy(id = currentId)
        posts += postAdd
        return postAdd
    }

    fun update(post: Post): Boolean{
        var postFound = false
        for((index, postExist) in posts.withIndex()){
            if(postExist.id == post.id){
                posts.set(index, post.copy(
                    ownerId = postExist.ownerId,
                    date = postExist.date
                    ))
                postFound = true
            }
        }
        return postFound
    }
}