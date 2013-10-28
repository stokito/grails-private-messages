<html>
<head>
    <title><g:message code="privateMessage.inbox.title"/></title>
    <meta name="layout" content="main">
</head>

<body>
<h1><g:message code="privateMessage.inbox.title"/></h1>

<div role="navigation">
    <ul>
        <li><g:link action="send"><g:message code="privateMessage.send.title"/></g:link></li>
        <li><g:link action="sent"><g:message code="privateMessage.sent.title"/></g:link></li>
    </ul>
</div>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>

<table>
    <thead>
    <tr>
        <g:sortableColumn property="username" title="${message(code: 'privateMessage.dateCreated.label')}" />
    </tr>
    </thead>
    <tbody>
    <g:each in="${messages}" var="message">
        <tr>
            <td><g:link action="show" id="${message.id}"><joda:format value="${message.dateCreated}"/></g:link></td>
            <td>${message.sender}</td>
            <td><g:formatBoolean boolean="${message.isRead}"/></td>
            <td><g:formatBoolean boolean="${message.subject}"/></td>
        </tr>
    </g:each>
    </tbody>
</table>
%{--<div class="pagination">--}%
    %{--<g:paginate total="${personInstanceCount ?: 0}" />--}%
%{--</div>--}%


</body>
</html>