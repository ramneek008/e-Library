# e-Library

A <b>Library Management System</b> that covers all the specifications required to administer libraries. It requires Admin and Librarians to login initially and perform their specified tasks.

## Users & Tasks

1. **Admin**<br>
  ~ Add Librarian<br>
  ~ View Librarian<br>
  ~ Edit Librarian<br>
  ~ Delete Librarian<br>
  ~ Logout<br><br>
2. **Librarian**<br>
  ~ Add Book<br>
  ~ View Book<br>
  ~ Issue Book<br>
  ~ View Issued Book<br>
  ~ Return Book<br>
  ~ Logout<br>

## Screenshots

<h4>Login Page</h4>
<p align="center"><img src="Screenshots/Login_Page.jpg" width="100%"></p>

<table>
  <tr>
    <th>Admin Section</th>
    <th>Librarian Section</th>
  </tr>
  <tr>
    <td><img src="Screenshots/Admin_Section.jpg" width="100%"></td>
    <td><img src="Screenshots/Librarian_Section.jpg" width="100%"></td>
  </tr>
</table>

<h4>Issue Book Form</h4>
<p align="center"><img src="Screenshots/Issue_Book_Form.jpg" width="100%"></p>

## Built With

- Servlet
- JDBC
- HTML, CSS
- JSP
- Oracle

***IDE used : Eclipse [Enterprise Edition]***

## Setup

1. Clone the repository.

2. Import following jar files to the project:
    * Servlet jar file
    * Oracle DB jar file

3. You can see commands from [oracle.txt](oracle.txt) to create each table manually in Oracle database.

4. Run the project on server.

5. To login as admin, use : 
    `Email: admin1@gmail.com`,
    `Password: 123456`

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details