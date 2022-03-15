package NoteService

fun main(){
    val noteService = NoteService()
    val noteId = noteService.add(Note(0,111,"Test","Text",0,0,"","", arrayListOf<Comment>()))
    println(noteId)
    val note = noteService.getById(noteId)
    noteService.printNotes()
    val commentId = noteService.createComment(Comment(noteId, 0, 0, "Text", ""))
    val commentId2 = noteService.createComment(Comment(noteId, 0, 0, "Text1", ""))
    note.printComments()
    val list = noteService.getComments(noteId,1,1)
    for(listElement in list){
        println(listElement)
    }
}