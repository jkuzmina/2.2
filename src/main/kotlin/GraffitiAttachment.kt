data class GraffitiAttachment(
    override val type: String = "graffiti",
    val graffiti: Graffiti
    ): Attachment {
    override val attachable: Attachable
        get() = graffiti
}
