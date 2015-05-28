<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" language="java"%>
<%@ page import="java.util.Iterator" language="java"%>
<%@ page import="com.rubrica.BC.*" language="java"%>
<%@ page import="com.rubrica.DL.*" language="java"%>
<jsp:useBean id = "lista" scope = "session" class = "com.rubrica.BC.Lista"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rubrica telefonica</title>
</head>
<body bgcolor="#98FB98">
	<form action=Inserisci.jsp method="get">
		<%!
	public Vector<Persona> elenco;
	private String realPath;%>

		<%
			ServletContext context = pageContext.getServletContext();
			realPath = context.getRealPath(DataConstants.PATH);
			lista.getData(realPath);
		%>

		<b>Attualmente presenti:<br>
		 <%=lista.getElenco().size()%> contatti.
		</b>
		<table align="center" border="1">
			<tr bgcolor="#7FFFD4">
				<td></td>
				<td><b>Nome</b></td>
				<td><b>Cognome</b></td>
				<td><b>Telefono</b></td>
			</tr>
			<%
				elenco = lista.getElenco();
				Iterator<Persona> iterator = elenco.iterator();
				while (iterator.hasNext()) {
					Persona record = new Persona();
					record = (Persona) iterator.next();
			%>

			<tr bgcolor="#5F9EA0">
				<td><input type="radio" name = "id" value = <%= elenco.indexOf(record) %>></td>
				<td><%=record.getNome()%></td>
				<td><%=record.getCognome()%></td>
				<td><%=record.getTelefono()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table align="center">
			<tr align="center">
				<td><input type="submit" name = "new" value="nuovo"></td>
				<td><input type="submit" name = "modif" value="modifica"></td>
				<td><input type="submit" name = "del" value="elimina"></td>
			</tr>
		</table>
	</form>

</body>
</html>