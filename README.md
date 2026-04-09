🔐 Login & Registration Web Application
(Spring Boot + Thymeleaf + MySQL)

A simple and beginner-friendly User Authentication Web Application built using Java 17, Spring Boot, Thymeleaf, and MySQL.

This project demonstrates how login and registration functionality works in a real-world web application using Spring Boot MVC Architecture.

📌 Project Overview

This application allows:

New users to register
Existing users to log in
Authenticated users to access a home page
Users to logout securely
Data to be stored in MySQL Database

The main goal of this project is to understand:

User Authentication Flow
MVC Architecture in Spring Boot
Session Handling
Database Integration using JPA
Form Validation
🚀 Main Functionalities
1️⃣ User Registration
Users can create a new account
Required fields:
First Name
Last Name
Email
Password
Email uniqueness validation
Form validation applied
Data stored in MySQL database

2️⃣ User Login
Login using:
Registered Email
Password
Credentials verified from database
Error message shown for invalid login

3️⃣ Session Management
User details stored in session after login
Maintains login state across pages
Session cleared on logout

4️⃣ Home Page
After successful login:
User is redirected to home page

Displays:
Full Name
Email
Role
Welcome message

5️⃣ Logout
Logout button available
Session invalidated
Redirected to login page

6️⃣ Database Integration
MySQL used as database
Spring Data JPA for CRUD operations
Automatic table creation using Hibernate

7️⃣ Form Validation
Required fields cannot be empty
Valid email format required
Password length validation

🛠️ Technologies Used
☕ Java 17
🌱 Spring Boot
🌿 Spring MVC
🗄️ Spring Data JPA
🧩 Thymeleaf
🐬 MySQL
🎨 HTML
🎨 CSS
🛠️ STS (Spring Tool Suite)
📂 Project Structure
src
 └── main
      ├── java
      │     ├── controller
      │     ├── service
      │     ├── repository
      │     ├── model
      │     └── LoginRegistrationApplication.java
      │
      └── resources
            ├── templates
            │     ├── login.html
            │     ├── register.html
            │     └── home.html
            │
            ├── static
            │     └── css
            │
            └── application.properties
⚙️ How to Run This Project
Step 1️⃣ Clone Repository
git clone https://github.com/your-username/your-repo-name.git
Step 2️⃣ Open in STS / IntelliJ / VS Code
Step 3️⃣ Configure MySQL Database

Create database in MySQL:

CREATE DATABASE login_registration_db;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/login_registration_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Step 4️⃣ Run Application

Run main class:

LoginRegistrationApplication.java

Open browser:

http://localhost:8080
🧠 Learning Outcomes

After completing this project, you will understand:

Spring Boot MVC Flow
Controller → Service → Repository Architecture
JPA Entity Mapping
Form Handling with Thymeleaf
Session Management
Basic Authentication Logic
🎯 Future Enhancements
Password Encryption using BCrypt
Spring Security Integration
Role-Based Authentication (Admin/User)
Email Verification
Forgot Password Feature
Responsive UI Improvements
📸 Screenshots (Optional Section)

You can add screenshots here:

![Login Page](images/login.png)
![Register Page](images/register.png)
![Home Page](images/home.png)
👨‍💻 Author

Deep Ghinaiya
Software Developer | Web Developer

⭐ Support

If you like this project:

⭐ Star the repository
🍴 Fork it
🔗 Share with others
