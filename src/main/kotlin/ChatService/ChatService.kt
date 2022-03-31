package ChatService


class ChatService{
    private var chats = arrayListOf<Chat>()
    private var currentChatId = 0

    fun getChatById(chatId:Int):Chat{
        val chat = chats.find { chats -> chats.chatId == chatId }
        return chat ?: throw ChatNotFoundException("Чат $chatId не существует")
    }

    fun getChatByUsersDistinct(userId:Int, userIdTo:Int):Chat{
        val chat = chats.find { chats -> (chats.userId == userId) && (chats.userIdTo == userIdTo)}
        return chat ?: throw ChatNotFoundException("Чат для пользователей $userId и $userIdTo не существует")
    }

    fun getChatByUsers(userId:Int, userIdTo:Int):Chat{
        return try{
            getChatByUsersDistinct(userId, userIdTo)
        }catch(e: ChatNotFoundException){
            //меняем пользователей местами
            getChatByUsersDistinct(userIdTo, userId)
        }
    }

    fun createChat(userId:Int, userIdTo:Int):Int{
        currentChatId++
        val chat = Chat(userId, userIdTo, currentChatId, arrayListOf<Message>())
        chats.add(chat)
        return chat.chatId
    }

    fun createMessage(userId:Int, userIdTo:Int, message:String):Int{
        var chat:Chat
        try{
            chat = getChatByUsersDistinct(userId, userIdTo)
            return chat.addMessage(message, Direction.Out)
        }catch(e: ChatNotFoundException){
            try{
                //меняем пользователей местами
                chat = getChatByUsersDistinct(userIdTo, userId)
                return chat.addMessage(message, Direction.In)
            }catch(e: ChatNotFoundException) {
                println(e.message)
                return 0
            }
        }
    }

    fun deleteChat(chatId:Int):Boolean{
        return try{
            val chat = getChatById(chatId)
            chats.remove(chat)
        }catch(e: ChatNotFoundException){
            println(e.message)
            false
        }
    }

    fun deleteMessage(chatId:Int, messageId:Int):Boolean{
        val result: Boolean
        return try{
            val chat = getChatById(chatId)
            result = chat.deleteMessage(messageId)
            if(chat.messages.isEmpty()){
                chats.remove(chat)
            }
            result
        }catch(e: ChatNotFoundException){
            println(e.message)
            false
        }
    }

    fun getUnreadChatsCount(userId:Int):Int{
        return chats.filter { chats -> (chats.userId == userId || chats.userIdTo == userId) && chats.hasUnreadMsg() == true }.size
    }

    fun getChats(userId: Int):String{
        println("Чаты пользователя $userId:")
        return chats
            .filter { chats -> (chats.userId == userId || chats.userIdTo == userId)}
            .joinToString (separator = "\n"){it.chatId.toString() + "\n" + it.messagesToString()}
            .ifEmpty { "Нет сообщений" }
    }

    fun getMessages(chatId:Int, lastMsgId:Int, msgCount:Int){
        println("Сообщения чата $chatId:")
        try{
            val chat = getChatById(chatId)
            chat.messages
                .drop(lastMsgId - 1)
                .take(msgCount)
                .forEach { it.isRead = true
                println(it.msgToString(chat.userId, chat.userIdTo))
                }
        }catch(e: ChatNotFoundException){
            println(e.message)
        }catch (e: IllegalArgumentException) {
            println("Задан недопустимый диапазон")
        }

    }
}

