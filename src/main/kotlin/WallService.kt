class WallService {
    private var posts = emptyArray<Post>()
    private var currentId = 0
    var comments = emptyArray<Comment>()
    var commentReports = emptyArray<CommentReport>()

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

    fun findPostById(id:Int): Post? {
        return posts.find { post -> post.id == id }
    }


    fun createComment(comment: Comment){
        val post = findPostById(comment.postId)
        if(post != null) {
            comments += comment
        } else throw PostNotFoundException("Пост ${comment.postId} не существует")
    }

    fun findCommentById(id:Int): Comment? {
        if(id < comments.size){
            return comments[id]
        }else {
            return null
        }
    }

    fun reportComment(commentReport: CommentReport){
        //if()
        if(findCommentById(commentReport.commentId) == null){
            throw CommentNotFoundException("Комментарий ${commentReport.commentId} не существует")
        }
        if(!(commentReport.reason in 0..8)){
            throw ReasonNotFoundException("Код причины ${commentReport.reason} не существует")
        }
        commentReports += commentReport
    }

    fun eeee(){
        var array = emptyArray<Int>()
        array += 1
        array += 2
        array += 3
        println(array.get(2))
    }
}