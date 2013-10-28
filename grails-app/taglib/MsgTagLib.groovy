class MsgTagLib {
    static String namespace = 'msg'
    MessageService messageService

    def unreadMessagesCount = { attrs, body ->
        Integer unreadMessagesCount = messageService.getUnreadMessagesCount()
        out << unreadMessagesCount.toString()
    }
}
