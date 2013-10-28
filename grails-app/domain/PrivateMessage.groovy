

import groovy.transform.EqualsAndHashCode
import org.joda.time.DateTime

/**
 * Private message between users
 * Only insert, never update.
 * May be cached
 **/
@EqualsAndHashCode(includes = ['sender', 'recipient', 'subject', 'msgText'])
class PrivateMessage {
    static final int SUBJECT_MAX_SIZE = 100
    Long id
    Long sender
    Long recipient
    String subject
    String msgText
    boolean isRead = false
    DateTime dateCreated

    static constraints = {
        sender(nullable: false)
        recipient(nullable: false, validator: { value, msg ->
            if (value == msg.sender) {
                return 'privateMessage.recipient.cantSendToItself.error'
            }
        })
        subject(nullable: true, blank: false, maxSize: SUBJECT_MAX_SIZE)
        msgText(nullable: false, blank: false)
    }

    static mapping = {
        version false
        autoTimestamp true
        cache true
        msgText type: 'text'
    }

}
