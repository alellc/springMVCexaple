<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<form action="/show">
		<p>
			<select name="clave">
				<c:forEach var = "item" items="${list}">
					<option>${item}</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Ver">
	</form>
</body>
</html>