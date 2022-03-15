package NoteService

import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        assertNotEquals(noteId, 0)
    }

    @Test
    fun getByIdSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val note = noteService.getById(noteId)
        assertNotEquals(note, null)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getByIdThrow() {
        val noteService = NoteService()
        val note = noteService.getById(1)
        assertNotEquals(note, null)
    }

    @Test
    fun createComment() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val commentId = noteService.createComment(Comment(noteId, 0, 9, "Text", ""))
        assertNotEquals(commentId, 0)
    }

    @Test
    fun deleteSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val result = noteService.delete(noteId)
        assertEquals(result, true)
    }

    @Test
    fun deleteFail() {
        val noteService = NoteService()
        val result = noteService.delete(1)
        assertEquals(result, false)
    }

    @Test
    fun editSuccess() {
        val noteService = NoteService()
        val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
        val result = noteService.edit(noteId, "Test1", "Text1",0,0,"","")
        assertEquals(result, true)
    }

    @Test
    fun editFail() {
        val noteService = NoteService()
        val result = noteService.edit(1, "Test1", "Text1",0,0,"","")
        assertEquals(result, false)
    }
}