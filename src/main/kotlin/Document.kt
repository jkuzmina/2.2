data class Document(
    override val id: Int,
    val date: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val type: Int,
    val preview: DocPreview
) : Attachable

