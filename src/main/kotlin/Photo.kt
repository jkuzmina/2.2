data class Photo(
    override val id: Int,
    val date: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val sizes: Array<PhotoSize>,
    val width: Int,
    val height: Int
) : Attachable
