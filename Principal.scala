import java.sql.{Connection, DriverManager, ResultSet}
import scala.io.StdIn
object Principal {
  def main(args: Array[String]): Unit = {

    // Configuración de la conexión
    val url = "jdbc:mysql://localhost:3306/Northwind"
    val user = "root"
    val password = "123"

    // Cargar el controlador JDBC
    Class.forName("com.mysql.cj.jdbc.Driver")

    // Establecer la conexión
    val connection: Connection = DriverManager.getConnection(url, user, password)
    var entrada: Int = 11

    try {
      do {
        println("Elige la tabla que deseas presentar:")
        print(
          "1. Categories\n" +
          "2. Customers\n" +
          "3. Employees\n" +
          "4. OrderDetails\n" +
          "5. Orders\n" +
          "6. Products\n" +
          "7. Shippers\n" +
          "8. Supliers\n" +
          "0. Salir\n" +
          "")

        entrada = StdIn.readInt()

      entrada match {
        case 0 => println("Gracias por usar el programa")

     case 1 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Categories")

      printf("|%-15s| %-30s| %-75s|\n", "CategoryID", "CategoryName", "Description")
      while (resultSet.next()) {
        val categoryID = resultSet.getInt("CategoryID")
        val categoryName = resultSet.getString("CategoryName")
        val description = resultSet.getString("Description")

        printf("|%-15d| %-30s| %-75s|\n", categoryID, categoryName, description)
      }

    case 2 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Customers")

      printf("%-15s| %-45s| %-30s| %-50s| %-20s| %-15s| %-15s|\n", "CustomerID", "CustomerName", "ContactName", "Address", "City", "PostalCode", "Country")
      while (resultSet.next()) {
        val CustomerID = resultSet.getInt("CustomerID")
        val CustomerName = resultSet.getString("CustomerName")
        val ContactName = resultSet.getString("ContactName")
        val Address = resultSet.getString("Address")
        val City = resultSet.getString("City")
        val PostalCode = resultSet.getString("PostalCode")
        val Country = resultSet.getString("Country")

        printf("%-15d| %-45s| %-30s| %-50s| %-20s| %-15s| %-15s|\n", CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
      }

    case 3 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Employees")

      printf("%-15s| %-15s| %-15s| %-15s| %-50s| %-430s|\n", "EmployeeID", "LastName", "FirstName", "BirthDate", "Photo", "Notes")
      while (resultSet.next()) {
        val EmployeeID = resultSet.getInt("EmployeeID")
        val LastName = resultSet.getString("LastName")
        val FirstName = resultSet.getString("FirstName")
        val BirthDate = resultSet.getDate("BirthDate")
        val Photo = resultSet.getString("Photo")
        val Notes = resultSet.getString("Notes")

        printf("%15d| %-15s| %-15s| %-15tF| %-50s| %-430s|\n", EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
      }

    case 4 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM OrderDetails")

      printf("|%-15s| %-15s| %-15s| %-15s|\n", "OrderDetailID", "OrderID", "ProductID", "Quantity")
      while (resultSet.next()) {
        val OrderDetailID = resultSet.getInt("OrderDetailID")
        val OrderID = resultSet.getInt("OrderID")
        val ProductID = resultSet.getInt("ProductID")
        val Quantity = resultSet.getInt("Quantity")

        printf("|%-15d| %-15d| %-15d| %-15d|\n", OrderDetailID, OrderID, ProductID, Quantity)
      }

    case 5 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Orders")

      printf("|%-15s| %-15s| %-15s| %-15s| %-15s|\n", "OrderID", "CustomerID", "EmployeeID", "OrderDate", "ShipperID")
      while (resultSet.next()) {
        val OrderID = resultSet.getInt("OrderID")
        val CustomerID = resultSet.getInt("CustomerID")
        val EmployeeID = resultSet.getInt("EmployeeID")
        val OrderDate = resultSet.getDate("OrderDate")
        val ShipperID = resultSet.getInt("ShipperID")

        printf("|%-15d| %-15d| %-15d| %-15tF| %-15d|\n", OrderID, CustomerID, EmployeeID, OrderDate, ShipperID)
      }

    case 6 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Products")

      printf("|%-15s| %-40s| %-15s| %-15s| %-25s| %-15s|\n", "ProductID", "ProductName", "SupplierID", "CategoryID", "Unit", "Price")
      while (resultSet.next()) {
        val ProductID = resultSet.getInt("ProductID")
        val ProductName = resultSet.getString("ProductName")
        val SupplierID = resultSet.getInt("SupplierID")
        val CategoryID = resultSet.getInt("CategoryID")
        val Unit = resultSet.getString("Unit")
        val Price = resultSet.getDouble("Price")

        printf("|%-15d| %-40s| %-15d| %-15d| %-25s| %-15.2f|\n", ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
      }
    case 7 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Shippers")

      printf("|%-15s| %-30s| %-20s|\n", "ShipperID", "ShipperName", "Phone")
      while (resultSet.next()) {
        val ShipperID = resultSet.getInt("ShipperID")
        val ShipperName = resultSet.getString("ShipperName")
        val Phone = resultSet.getString("Phone")

        printf("|%-15d| %-30s| %-20s|\n", ShipperID, ShipperName, Phone)
      }
    case 8 =>
      val statement = connection.createStatement()
      val resultSet: ResultSet = statement.executeQuery("SELECT * FROM Suppliers")

      printf("|%-15s| %-50s| %-30s| %-50s| %-15s| %-15s| %-15s| %-20s|\n", "SupplierID", "SupplierName", "ContactName", "Address", "City", "PostalCode", "Country", "Phone")
      while (resultSet.next()) {
        val SupplierID = resultSet.getInt("SupplierID")
        val SupplierName = resultSet.getString("SupplierName")
        val ContactName = resultSet.getString("ContactName")
        val Address = resultSet.getString("Address")
        val City = resultSet.getString("City")
        val PostalCode = resultSet.getString("PostalCode")
        val Country = resultSet.getString("Country")
        val Phone = resultSet.getString("Phone")

        printf("|%-15d| %-50s| %-30s| %-50s| %-15s| %-15s| %-15s| %-20s|\n", SupplierID, SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
      }
    case _ =>
      println("Opcion incorrecta")

  }

}while (entrada !=  0)

    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      // Cerrar la conexión al finalizar
      connection.close()
    }
  }
}