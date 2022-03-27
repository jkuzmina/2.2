package ChatService

data class Message(
    val messageId:Int,
    val text:String,
    val direction: Direction,
    var isRead:Boolean = false
){
    fun messagePrint(userId:Int, userIdTo:Int){
        val status: String
        if(isRead)  status = "Прочитано" else status = "Не прочитано"
        if(direction == Direction.Out){
            println("$userId:")
            println("$text ($status)")
        }else {
            println("$userIdTo:")
            println("$text ($status)")
        }
    }
}
