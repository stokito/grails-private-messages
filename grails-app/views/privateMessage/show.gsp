<html>
<head>
    <title><g:message code="message.show.title"/></title>
    <meta name="layout" content="main">
</head>
<body>
<h1 class="headerid"><g:message code="message.show.title"/></h1>

<div role="navigation">
    <ul>
        <li><g:link action="send"><g:message code="message.send.title"/></g:link></li>
        <li><g:link action="sent"><g:message code="message.sent.title"/></g:link></li>
        <li><g:link action="inbox"><g:message code="message.inbox.title"/></g:link></li>
    </ul>
</div>

<div>
    <div id="recipient">
       ${msg.recipient.accountName.encodeAsHTML()}
    </div>
    <div id="dataCreated">
        <joda:format value="${msg.dateCreated}"/>
    </div>
    <div id="textMessage">
        ${msg.msgText.encodeAsHTML()}
    </div>
</div>

</body>
</html>