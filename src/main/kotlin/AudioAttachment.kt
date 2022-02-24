data class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio
    ): Attachment {
    override val attachable: Attachable
        get() = audio
}
