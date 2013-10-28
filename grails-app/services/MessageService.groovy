

import grails.transaction.Transactional
import groovy.transform.TypeChecked

import static groovy.transform.TypeCheckingMode.SKIP

@Transactional(readOnly = true)
class MessageService {
    def springSecurityService

    @Transactional
    void sendMessage(PrivateMessage msg) {
        msg.save(flush: true, failOnError: true)
    }

    @TypeChecked(SKIP)
    Integer getUnreadMessagesCount() {
        UserDetails currentUser = springSecurityService.currentUser
        if (currentUser) {
            return PrivateMessage.countByIsReadAndRecipient(false, currentUser.id)
        } else {
            return null
        }
    }

}
