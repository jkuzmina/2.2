package NoteService

import org.junit.Test

import org.junit.Assert.*

class NoteTest {

    @Test
    fun getCommentById() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        val commentFound = note.getCommentById(commentId)
        assertNotEquals(commentFound, null)
    }

    @Test(expected = CommentNotFoundException::class)
    fun getCommentByIdThrow() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentFound = note.getCommentById(1)
        assertNotEquals(commentFound, null)
    }

    @Test
    fun getCommentByIdDeleted() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", "", true))
        val commentFound = note.getCommentByIdDeleted(commentId)
        assertNotEquals(commentFound, null)
    }

    @Test(expected = CommentNotFoundException::class)
    fun getCommentByIdDeletedThrow() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentFound = note.getCommentById(1)
        assertNotEquals(commentFound, null)
    }

    @Test
    fun deleteCommentSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        val result = note.deleteComment(commentId)
        assertEquals(result, true)
    }

    @Test
    fun deleteCommentFail() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val result = note.deleteComment(1)
        assertEquals(result, false)
    }

    @Test
    fun editCommentSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        val result = note.editComment(commentId, "Text1")
        assertEquals(result, true)
    }

    @Test
    fun editCommentFail() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val result = note.editComment(1, "Text1")
        assertEquals(result, false)
    }

    @Test
    fun restoreCommentSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        note.deleteComment(commentId)
        val result = note.restoreComment(commentId)
        assertEquals(result, true)
    }

    @Test
    fun restoreCommentFail() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        note.deleteComment(commentId)
        val result = note.restoreComment(commentId + 1)
        assertEquals(result, false)
    }
}