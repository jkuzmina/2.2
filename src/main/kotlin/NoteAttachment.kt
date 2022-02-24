data class NoteAttachment(
    override val type: String = "note",
    val note: Note
    ): Attachment {
    override val attachable: Attachable
        get() = note
}
