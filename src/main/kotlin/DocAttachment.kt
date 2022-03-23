data class DocAttachment(
    override val type: String = "doc",
    val doc: Document
    ): Attachment {
    override val attachable: Attachable
        get() = doc
}
