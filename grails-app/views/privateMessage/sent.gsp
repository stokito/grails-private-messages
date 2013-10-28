<%@ page import="com.greenpaywiz.Message" %>
<html>
<head>
    <title><g:message code="message.sent.title"/></title>
    <meta name="layout" content="main">
</head>

<body>
<h1 class="headerid"><g:message code="message.sent.title"/></h1>

<div role="navigation">
    <ul>
        <li><g:link action="send"><g:message code="message.send.title"/></g:link></li>
        <li><g:link action="inbox"><g:message code="message.inbox.title"/></g:link></li>
    </ul>
</div>

<gp:renderTableDomain domainClass="${Message.class}" listParams="${filter}" showHeaders="true" cssClass="seatabledata_default"
                      templateColumns="['sender': 'sender', 'recipient': 'recipient', 'subject': 'subject', 'dateCreated': 'dateCreated']">
</gp:renderTableDomain>
<div class="pagination">
    <g:paginate total="${gp.paginationCount(domainClass: Message.class, listParams: filter)}" params="${filter.filterParams}"/>
</div>

</body>
</html>