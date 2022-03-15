package NoteService

data class Comment(
    val noteId:Int,
    val commentId:Int,
    val replyTo:Int,
    val message:String,
    val guid:String,
    var isDeleted:Boolean = false
)
