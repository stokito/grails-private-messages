

import grails.transaction.Transactional

import org.springframework.security.core.userdetails.UserDetails

@Transactional(readOnly = true)
class MessageService {
    def springSecurityService

    @Transactional
    void sendMessage(PrivateMessage msg) {
        msg.save(flush: true, failOnError: true)
    }

    Integer getUnreadMessagesCount() {
        UserDetails currentUser = springSecurityService.currentUser
        if (currentUser) {
            return PrivateMessage.countByIsReadAndRecipient(false, currentUser.id)
        } else {
            return null
        }
    }

}
