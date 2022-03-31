package ChatService


data class Chat(
    val userId:Int, //тот, кто первый начвал переписку
    val userIdTo:Int,
    val chatId:Int,
    val messages:ArrayList<Message>
){
    private var currentMessageId = 0

    fun addMessage(text:String, direction: Direction):Int{
        currentMessageId++
        val message = Message(currentMessageId, text, direction)
        messages.add(message)
        return message.messageId
    }

    fun getMessageById(messageId:Int):Message{
        val message = messages.find { messages -> messages.messageId == messageId}
        return message ?: throw MsgNotFoundException("Сообщение {$messageId} не существует")
    }

    fun deleteMessage(messageId:Int):Boolean{
        return try{
            val message = getMessageById(messageId)
            messages.remove(message)
        }catch(e: MsgNotFoundException){
            println(e.message)
            false
        }
    }

    fun hasUnreadMsg():Boolean{
        return messages.any { messages -> messages.isRead == false }
    }

    fun printChat(){
        println("Чат $chatId:")
        messages.forEach{ messages -> messages.messagePrint(userId, userIdTo) }
    }

    fun messagesToString(): String {
        return messages.joinToString (separator = "\n"){ it.msgToString(userId, userIdTo) }
    }

}
