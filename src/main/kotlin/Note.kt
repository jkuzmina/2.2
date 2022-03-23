data class Note(
    override val id: Int,
    val date: Int,
    val ownerId: Int,
    val title: String,
    val text: String,
    val comments: Int,
    val readComments: Int?,
    val viewUrl: String
) : Attachable
