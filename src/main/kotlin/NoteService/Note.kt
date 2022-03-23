package NoteService


data class Note(
    val noteId:Int,
    val ownerId:Int,
    val title:String,
    val text:String,
    val privacy:Int,
    val commentPrivacy:Int,
    val privacyView:String,
    val privacyComment:String,
    val comments:ArrayList<Comment>
){
    fun getCommentById(commentId: Int): Comment {
        val comment = comments.find { comments -> (comments.commentId == commentId) && !comments.isDeleted }
        return comment ?: throw CommentNotFoundException("Комментарий {$commentId} не существует")
    }

    fun getCommentByIdDeleted(commentId: Int): Comment {
        val comment = comments.find { comments -> (comments.commentId == commentId) && comments.isDeleted }
        return comment ?: throw CommentNotFoundException("Комментарий {$commentId} не существует")
    }

    fun deleteComment(commentId:Int):Boolean{
        return try{
            val comment = getCommentById(commentId)
            comment.isDeleted = true
            true
        }catch(e:CommentNotFoundException){
            println(e.message)
            false
        }
    }

    fun editComment(commentId:Int, message:String):Boolean{
        return try {
            val comment = getCommentById(commentId)
            val commentEdited = comment.copy(message = message)
            val idx = comments.indexOf(comment)
            comments.remove(comment)
            comments.add(idx, commentEdited)
            true
        }catch (e:CommentNotFoundException){
            println(e.message)
            false
        }
    }

    fun restoreComment(commentId:Int):Boolean{
        return try {
            val comment = getCommentByIdDeleted(commentId)
            comment.isDeleted = false
            true
        }catch (e:CommentNotFoundException){
            try {
                val comment = getCommentById(commentId)
                comment.isDeleted = false
                true
            }catch (e:CommentNotFoundException){
                println(e.message)
                false
            }
        }
    }

    fun printComments(){
        for(comment in comments){
            println(comment)
        }
    }
}
