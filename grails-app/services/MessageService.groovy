import grails.transaction.Transactional

@Transactional(readOnly = true)
class MessageService {
    def springSecurityService

    @Transactional
    void sendMessage(PrivateMessage msg) {
        msg.save(flush: true, failOnError: true)
    }

    Integer getUnreadMessagesCount() {
        def currentUser = springSecurityService.currentUser
        if (currentUser) {
            return PrivateMessage.countByIsReadAndRecipient(false, currentUser.id)
        } else {
            return null
        }
    }

    List<PrivateMessage> getInboxMessages() {
        def currentUser = springSecurityService.currentUser
        List<PrivateMessage> messages = PrivateMessage.findAllByRecipient(currentUser.id)
        return messages
    }

    List<PrivateMessage> getSentMessages() {
        def currentUser = springSecurityService.currentUser
        List<PrivateMessage> messages = PrivateMessage.findAllBySender(currentUser.id)
        return messages
    }



}
