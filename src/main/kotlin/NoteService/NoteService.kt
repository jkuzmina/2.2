package NoteService

class NoteService {
    private var notes = arrayListOf<Note>()
    private var currentId = 0
    private var currentCommentId = 0

    fun add(note: Note): Int {
        currentId++
        val noteAdd = note.copy(noteId = currentId)
        notes.add(noteAdd)
        return noteAdd.noteId
    }

    fun getById(noteId: Int): Note {
        val note = notes.find { note -> note.noteId == noteId }
        return note ?: throw NoteNotFoundException("Заметка {$noteId} не существует")
    }

    fun createComment(comment: Comment):Int {
        try{
            val note = getById(comment.noteId)
            currentCommentId++
            val commentAdd = comment.copy(commentId = currentCommentId)
            note.comments.add(commentAdd)
        }catch(e:NoteNotFoundException){
            println(e.message)
        }
        return currentCommentId
    }

    fun delete(noteId: Int): Boolean {
        return try {
            val note = getById(noteId)
            notes.remove(note)
        }catch(e:NoteNotFoundException){
            println(e.message)
            false
        }

    }

    fun edit(
        noteId: Int,
        title: String,
        text: String,
        privacy: Int,
        commentPrivacy: Int,
        privacyView: String,
        privacyComment: String
    ): Boolean {
        try {
            val note = getById(noteId)
            val idx = notes.indexOf(note)
            val noteEdited = note.copy(
                title = title,
                text = text,
                privacy = privacy,
                commentPrivacy = commentPrivacy,
                privacyView = privacyView,
                privacyComment = privacyComment
            )
            notes.remove(note)
            notes.add(idx, noteEdited)
            return true
        }catch(e:NoteNotFoundException){
            println(e.message)
            return false
        }
    }

    fun getComments(noteId: Int, offset: Int, count: Int): MutableList<Comment> {
        var result = mutableListOf<Comment>()
        try {
            val note = getById(noteId)
            result = note.comments.subList(offset, offset + count)
        }catch(e:NoteNotFoundException){
            println(e.message)
        }catch (e: IndexOutOfBoundsException) {
            println("Задан недопустимый диапазон")
        }
        return result
    }

    fun getFriendsNotes(offset: Int, count: Int): MutableList<Note> {
        var result = mutableListOf<Note>()
        try {
            result = notes.subList(offset, offset + count)
        } catch (e: IndexOutOfBoundsException) {
            println("Задан недопустимый диапазон")
        }
        return result
    }

    fun printNotes(){
        for(note in notes){
            println(note)
        }
    }
}