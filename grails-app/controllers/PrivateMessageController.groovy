class PrivateMessageController {
    static allowedMethods = [send: 'GET', sendSubmit: 'POST']
    static defaultAction = 'send'
    def springSecurityService
    MessageService messageService

    def send() {
        PrivateMessage message = chainModel?.message ?: new PrivateMessage()
        [message: message]
    }

    def sendSubmit(PrivateMessage msg) {
        msg.sender = springSecurityService.currentUser
        msg.validate()
        if (msg.hasErrors()) {
            chain(action: 'send', model: [message: msg])
            return
        }
        messageService.sendMessage(msg)
        flash.message = g.message(code: 'privateMessage.sent')
        redirect(action: 'sent')
    }

    def inbox() {
//        filter.recipient = springSecurityService.currentUser
        [filter: filter]
    }

    def sent() {
//        filter.sender = springSecurityService.currentUser
        [filter: filter]
    }


    def show(Long id) {
        PrivateMessage msg = PrivateMessage.get(id)
        if (!msg) {
            flash.message = g.message(code: 'privateMessage.notFound')
            redirect(action: 'inbox')
            return
        }
        def currentUser = springSecurityService.currentUser
        if (!(currentUser.id in [msg.sender, msg.recipient])) {
            flash.message = g.message(code: 'privateMessage.accessDenied')
            redirect(action: 'inbox')
            return
        }
        if (msg.recipient == currentUser && !msg.isRead){
            msg.isRead = true
            msg.save(flush: true, failOnError: true)
        }
        [msg: msg]
    }

}
