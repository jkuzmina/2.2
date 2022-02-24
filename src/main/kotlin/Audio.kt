data class Audio(
    override val id: Int,
    val date: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val noSeacrh: Int?,
    val isHq: Int,
    ) : Attachable{

}
