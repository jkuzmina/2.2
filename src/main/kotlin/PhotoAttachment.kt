data class PhotoAttachment(
    override val type: String = "photo",
    val photo: Photo
    ): Attachment {
    override val attachable: Attachable
        get() = photo
}
