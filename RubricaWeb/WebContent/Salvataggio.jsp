<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rubrica.BC.*" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salvataggio</title>
</head>
<body bgcolor="#98FB98">
<%! Persona record; %>
<% 
Lista lista = (Lista)session.getAttribute("lista");
if (request.getParameter("new") != null) {
	try {
		record = new Persona();
		record.setNome(request.getParameter("nome"));
		record.setCognome(request.getParameter("cognome"));
		record.setIndirizzo(request.getParameter("indirizzo"));
		record.setTelefono(request.getParameter("telefono"));
		record.setEta(Integer.parseInt(request.getParameter("eta")));
		lista.create(record);
		
	}
	catch (NumberFormatException nfe) {
			response.sendRedirect("FormatException.html");
		}	
	catch (Exception e) {
			response.sendRedirect("Error.html");
	}
%>
Nuovo record:<br> 
<%= record.getNome() %>, <%= record.getCognome() %>, <br>
<%= record.getIndirizzo() %>, <%= record.getTelefono() %>, <br>
salvato correttamente in rubrica <br>
<% } else if (request.getParameter("up")!=null) {
	try {

	int index = Integer.parseInt(session.getAttribute("id").toString());
	record = new Persona();
	record.setNome(request.getParameter("nome"));
	record.setCognome(request.getParameter("cognome"));
	record.setIndirizzo(request.getParameter("indirizzo"));
	record.setTelefono(request.getParameter("telefono"));
	record.setEta(Integer.parseInt(request.getParameter("eta")));
	lista.update(record, index);
	}
	catch (NumberFormatException nfe) {
			response.sendRedirect("FormatException.html");
		}	
	catch (Exception e) {
			response.sendRedirect("Error.html");
	}
	%>
Record:<br> 
<%= record.getNome() %>, <%= record.getCognome() %>, <br>
<%= record.getIndirizzo() %>, <%= record.getTelefono() %>, <br>
modificato correttamente in rubrica <br>
<% } else if (request.getParameter("dd") != null) {
	
	int index = Integer.parseInt(session.getAttribute("id").toString());
	record = new Persona();
	record.setNome(lista.getElenco().elementAt(index).getNome());
	record.setCognome(lista.getElenco().elementAt(index).getCognome());
	record.setIndirizzo(lista.getElenco().elementAt(index).getIndirizzo());
	record.setTelefono(lista.getElenco().elementAt(index).getTelefono());
	record.setEta(lista.getElenco().elementAt(index).getEta());
	lista.delete(record, index);
	%>
Record:<br> 
<%= record.getNome() %>, <%= record.getCognome() %>, <br>
<%= record.getIndirizzo() %>, <%= record.getTelefono() %>, <br>
eliminato correttamente dalla rubrica <br>
<% } %>
<a href="Launcher.jsp">Torna alla pagina principale</a>
</body>
</html>