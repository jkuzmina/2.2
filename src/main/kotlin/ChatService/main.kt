package ChatService

fun main() {
    val chatService = ChatService()
    val chatId = chatService.createChat(1, 2)
    val msg1 = chatService.createMessage(1, 2,"Привет!")
    val msg2 = chatService.createMessage(2,1,"Здравствуй!")
    val msg3 = chatService.createMessage(1,2,"Как дела?")
    //chatService.getChats(2)
    //chatService.getChats(1)
    //chatService.getChats(2)
    //chatService.getChats(3)
    //chatService.deleteMessage(chatId, msg3)
    //chatService.getChats(2)
    //println(chatService.getUnreadChatsCount(1))
    chatService.getMessages(chatId,2,1)
    //chatService.deleteMessage(1, 2, chatId, msg1)
    //chatService.deleteMessage(1, 2, chatId, msg2)
    chatService.getChats(2)
}