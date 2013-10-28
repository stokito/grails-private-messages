<%@ page import="com.greenpaywiz.User" %>
<html>
<head>
    <title><g:message code="message.send.title"/></title>
    <meta name="layout" content="main">
</head>

<body>
<h1><g:message code="message.send.title"/></h1>

<div role="navigation">
    <ul>
        <li><g:link action="sent"><g:message code="message.sent.title"/></g:link></li>
        <li><g:link action="inbox"><g:message code="message.inbox.title"/></g:link></li>
    </ul>
</div>

<g:form action="sendSubmit" useToken="true">
    <div>
        <div><label for="recipient.id"><g:message code="message.recipient.id.label"/></label></div>
        <g:select name="recipient.id" id="recipient.id" from="${User.list()}" noSelection="['': g.message(code: 'pleaseSelect')]" value="${message.recipient?.id ?: ''}" optionKey="id" optionValue="accountName"/>
        <div class="errors"><g:renderErrors bean="${message}" field="recipient"/></div>
    </div>

    <div>
        <div><label for="subject"><g:message code="message.subject.label"/></label></div>
        <input type="text" name="subject" id="subject" value="${message.subject}" placeholder="${g.message(code: 'message.subject.label')}" size="60"/>
        <div class="errors"><g:renderErrors bean="${message}" field="subject"/></div>
    </div>

    <div>
        <div><label for="msgText"><g:message code="message.msgText.label"/></label></div>
        <textarea name="msgText" id="msgText" cols="60" rows="10">${message.msgText}</textarea>
        <div class="errors"><g:renderErrors bean="${message}" field="msgText"/></div>
    </div>
    <input type="submit" value="${g.message(code: 'message.send')}" class="styled-button"/>
</g:form>
</body>
</html>