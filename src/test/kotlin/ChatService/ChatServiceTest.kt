package ChatService

import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun getChatById() {
        val chatService = ChatService()
        val chatId = chatService.createChat(1, 2)
        assertNotEquals(chatId, 0)
    }

    @Test(expected = ChatNotFoundException::class)
    fun getChatByIdThrow() {
        val chatService = ChatService()
        val chat = chatService.getChatById(1)
        assertNotEquals(chat, null)
    }

    @Test
    fun getChatByUsersDistinct() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        val chat = chatService.getChatByUsersDistinct(1, 2)
        assertNotEquals(chat, null)
    }

    @Test(expected = ChatNotFoundException::class)
    fun getChatByUsersDistinctThrow() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        val chat = chatService.getChatByUsersDistinct(2, 3)
        assertNotEquals(chat, null)
    }

    @Test
    fun getChatByUsers() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        val chat = chatService.getChatByUsers(1, 2)
        assertNotEquals(chat, null)
    }

    @Test
    fun getChatByUsersRevert() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        val chat = chatService.getChatByUsers(2, 1)
        assertNotEquals(chat, null)
    }

    @Test
    fun createChat() {
        val chatService = ChatService()
        val chatId = chatService.createChat(1, 2)
        assertNotEquals(chatId, 0)
    }

    @Test
    fun createMessage() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        val messageId = chatService.createMessage(1, 2, "Hi")
        assertNotEquals(messageId, 0)
    }

    @Test
    fun deleteChatSuccess() {
        val chatService = ChatService()
        val chatId = chatService.createChat(1, 2)
        val result = chatService.deleteChat(chatId)
        assertEquals(result, true)
    }

    @Test
    fun deleteChatFail() {
        val chatService = ChatService()
        val result = chatService.deleteChat(1)
        assertEquals(result, false)
    }

    @Test
    fun deleteMessageSuccess() {
        val chatService = ChatService()
        val chatId = chatService.createChat(1, 2)
        val messageId = chatService.createMessage(1, 2, "Hi")
        val result = chatService.deleteMessage(chatId, messageId)
        assertEquals(result, true)
    }

    @Test
    fun deleteMessageFail() {
        val chatService = ChatService()
        val result = chatService.deleteMessage(1, 1)
        assertEquals(result, false)
    }

    @Test
    fun getUnreadChatsCount() {
        val chatService = ChatService()
        chatService.createChat(1, 2)
        chatService.createMessage(1, 2, "Hi")
        val result = chatService.getUnreadChatsCount(1)
        assertEquals(result, 1)
    }
}