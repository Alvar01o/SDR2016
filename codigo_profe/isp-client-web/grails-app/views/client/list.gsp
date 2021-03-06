
<%@ page import="com.sd.isp.client.Client" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-client" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-client" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
									
						<g:sortableColumn property="document" title="Document" />	
						<g:sortableColumn property="firstName" title="First Name" />					
						<g:sortableColumn property="lastName" title="Last Name" />						
						<g:sortableColumn property="city" title="City" />
						<g:sortableColumn property="city.state" title="State" />
						<g:sortableColumn property="city.state.country" title="Country" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${clientInstanceList}" status="i" var="clientInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${clientInstance.id}">${fieldValue(bean: clientInstance, field: "document")}</g:link></td>
						<td>${fieldValue(bean: clientInstance, field: "firstName")}</td>					
						<td>${fieldValue(bean: clientInstance, field: "lastName")}</td>	
						<td>${fieldValue(bean: clientInstance, field: "city.name")}</td>
						<td>${fieldValue(bean: clientInstance, field: "city.state.name")}</td>					
						<td>${fieldValue(bean: clientInstance, field: "city.state.country.name")}</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${clientInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
