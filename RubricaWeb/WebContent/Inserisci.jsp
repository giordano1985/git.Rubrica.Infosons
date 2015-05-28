<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.rubrica.BC.*" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci o modifica un contatto</title>
</head>
<body bgcolor="#98FB98">
	
	<% 
	if ((request.getParameter("id")!= null)&(request.getParameter("modif")!=null))	 {
		Lista lista = (Lista)session.getAttribute("lista");
		int index = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("id", index);
 		%> 
	<!-- correct updating selection -->
	<form action="Salvataggio.jsp" method="get">
		<table align=center>
			<tr>
				<td><b>Nome</b></td>
				<td><input type="text" name="nome" value = <%= lista.getElenco().elementAt(index).getNome() %>></td>
			</tr>
			<tr>
				<td><b>Cognome</b></td>
				<td><input type="text" name="cognome" value = <%= lista.getElenco().elementAt(index).getCognome() %>></td>
			</tr>
			<tr>
				<td><b>Indirizzo</b></td>
				<td><input type="text" name="indirizzo" value = <%= lista.getElenco().elementAt(index).getIndirizzo() %>>
				<td>
			</tr>
			<tr>
				<td><b>Telefono</b></td>
				<td><input type="text" name="telefono" value = <%= lista.getElenco().elementAt(index).getTelefono() %>></td>
			</tr>
			<tr>
				<td><b>Età</b></td>
				<td><input type="text" name="eta" value = <%= lista.getElenco().elementAt(index).getEta() %>></td>
			</tr>
			<tr align = "center">
				<td><input type="submit" name = "up" value="Salva"></td>
				<td><input type = "reset" value = "Cancella modulo"></td>
			</tr>
		</table>
	</form>
	<%
		} else if (((request.getParameter("id")== null)&
				(request.getParameter("modif")!=null))||
				((request.getParameter("id")== null)&
						(request.getParameter("del")!=null))){
	%>
	<!-- wrong updating or deleting selection (no row selected) -->
	Nessuna riga selezionata. Operazione non possibile.
	<%	
	} else if ((request.getParameter("id")!= null)&(request.getParameter("del")!=null)){
		Lista lista = (Lista)session.getAttribute("lista");
		int index = Integer.parseInt(request.getParameter("id"));
		session.setAttribute("id", index);
	%>
	<!-- correct deleting selection -->
	<form action = "Salvataggio.jsp" method = "get">
	Eliminare il record <br>
	<%= lista.getElenco().elementAt(index).getNome() %>, <%= lista.getElenco().elementAt(index).getCognome() %>?<br>
	<input type = "submit" name = "dd" value = "prosegui">
	</form>
		<% } else {%>
		<!-- normal new record selection -->
		<form action="Salvataggio.jsp" method="get">
		<table align=center>
			<tr>
				<td><b>Nome</b></td>
				<td><input type="text" name="nome"></td>
			</tr>
			<tr>
				<td><b>Cognome</b></td>
				<td><input type="text" name="cognome"></td>
			</tr>
			<tr>
				<td><b>Indirizzo</b></td>
				<td><input type="text" name="indirizzo">
				<td>
			</tr>
			<tr>
				<td><b>Telefono</b></td>
				<td><input type="text" name="telefono"></td>
			</tr>
			<tr>
				<td><b>Età</b></td>
				<td><input type="text" name="eta"></td>
			</tr>
			<tr align = "center">
				<td><input type="submit" name = "new" value="Salva"></td>
				<td><input type = "reset" value = "Cancella modulo"></td>
			</tr>
		</table>
	</form>
	<% } %>
	<br>
	<a href = "Annullamento.jsp">Torna indietro</a>
</body>
</html>