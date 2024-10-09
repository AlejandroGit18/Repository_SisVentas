<%@page import="modelo.Puesto" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="master.jsp" />

<!DOCTYPE html>
<html>

<body>
    <h1 class="text-center">Formulario Puestos</h1>

    <div class="container">
        <!-- Formulario para manejar el CRUD -->
        <form action="sr_puestos" method="post" class="form-group">
            <label for="lbl_id"><b>ID</b></label>
            <input type="text" name="txt_id" id="txt_id" class="form-control" value="0" readonly>
            <label for="lbl_nombre"><b>Nombre</b></label>
            <input type="text" name="txt_nombre" id="txt_nombre" class="form-control" placeholder="Ejemplo: Gerente" required>
            <br>
            <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
            <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success btn-lg">Modificar</button>
            <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">Eliminar</button>
            <button type="button" class="btn btn-warning btn-lg" onclick="limpiar()">Limpiar</button>
        </form>

        <!-- Tabla para mostrar los datos de los puestos -->
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody id="tbl_puestos">
                <% 
                Puesto puesto = new Puesto();
                DefaultTableModel tabla = puesto.leer(); // Llamada a la función que lee la tabla TBL_PUESTOS
                
                // Verificamos si la tabla tiene datos
                if (tabla != null && tabla.getRowCount() > 0) {
                    for (int t = 0; t < tabla.getRowCount(); t++) {
                        out.println("<tr data-id='" + tabla.getValueAt(t, 0) + "'>");
                        out.println("<td>" + tabla.getValueAt(t, 0) + "</td>"); // ID en la columna 0
                        out.println("<td>" + tabla.getValueAt(t, 1) + "</td>"); // Nombre en la columna 1
                        out.println("</tr>");
                    }
                } else {
                    // Si no hay datos, mostramos un mensaje
                    out.println("<tr>");
                    out.println("<td colspan='2' style='text-align: center;'>No hay datos disponibles</td>");
                    out.println("</tr>");
                }
                %>
            </tbody>
        </table>
    </div>
            
    <jsp:include page="footer.jsp" />


<script src="${pageContext.request.contextPath}/js/puesto.js"></script>

</body>
</html>
