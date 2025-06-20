# 💰 SpringBoot Backend - Personal Budget Planner

A backend REST API for a **Personal Budget Planner** application built using Spring Boot. This system allows users to manage income, expenses, and budgets efficiently with a structured database and clean RESTful architecture. Ideal for personal finance management with potential for full-stack expansion.

---

## 🚀 Features

- Add, update, delete income & expense entries  
- Budget limit configuration  
- User-friendly endpoints for financial tracking  
- Modular architecture with clear separation of concerns  
- Swagger UI for easy API testing  
- Integration with MySQL database  

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot  
- **Database:** MySQL  
- **Tools:** Postman, Swagger UI, MySQL Workbench  
- **Version Control:** Git, GitHub  
- **IDE:** spring tool suite(sts) 
- **Build Tool:** Maven  

---

## 📊 Database Schema

This project uses a MySQL database with four primary entities. Below is the table structure based on the ER diagram.

---

### 🧍 USER

| Field       | Type      | Description                   |
|-------------|-----------|-------------------------------|
| `userId`    | `varchar` | Primary Key – Unique user ID  |
| `name`      | `varchar` | User's full name              |
| `email`     | `varchar` | User's email address          |
| `password`  | `varchar` | Hashed password               |
| `createdAt` | `datetime`| Timestamp of registration     |
| `updatedAt` | `datetime`| Last update timestamp         |

---

### 💰 INCOME

| Field     | Type      | Description                            |
|-----------|-----------|----------------------------------------|
| `incomeId`| `varchar` | Primary Key – Unique income record ID  |
| `userId`  | `varchar` | Foreign Key – References `USER.userId` |
| `amount`  | `float`   | Income amount                          |
| `source`  | `varchar` | Source of income (e.g., Salary, Freelance) |
| `date`    | `date`    | Date the income was received           |

---

### 💸 EXPENSE

| Field        | Type      | Description                             |
|--------------|-----------|-----------------------------------------|
| `expenseId`  | `varchar` | Primary Key – Unique expense record ID  |
| `userId`     | `varchar` | Foreign Key – References `USER.userId`  |
| `amount`     | `float`   | Amount spent                            |
| `description`| `varchar` | Description or category of the expense  |
| `date`       | `date`    | Date the expense occurred               |

---

### 📈 BUDGETREPORT

| Field             | Type      | Description                                |
|------------------|-----------|--------------------------------------------|
| `reportId`        | `varchar` | Primary Key – Unique report ID             |
| `userId`          | `varchar` | Foreign Key – References `USER.userId`     |
| `totalIncome`     | `float`   | Aggregated total income for the user       |
| `totalExpense`    | `float`   | Aggregated total expense for the user      |
| `remainingBalance`| `float`   | Calculated: `totalIncome - totalExpense`   |

---

### 🔗 Relationships

- One **User** can have many **Incomes**
- One **User** can have many **Expenses**
- One **User** can have many **Budget Reports**

## 📡 API Endpoints

Your application follows RESTful conventions and is organized into controllers based on functionality.

---

### 👤 User Controller

| Method | Endpoint                  | Description                     |
|--------|---------------------------|---------------------------------|
| `POST` | `/Users/post`             | Create a new user               |
| `GET`  | `/Users/get/{userId}`     | Get details of a specific user  |
| `PUT`  | `/Users/put/{userId}`     | Update user details             |
| `DELETE` | `/Users/delete/{userId}`| Delete a user                   |

---

### 💰 Income Controller

| Method | Endpoint                         | Description                          |
|--------|----------------------------------|--------------------------------------|
| `POST` | `/Income/post`                   | Add income for a user                |
| `GET`  | `/Income/get/{userId}`           | Get all income records for a user    |
| `GET`  | `/Income/getSumIncome/{userId}`  | Get total income amount for a user   |
| `PUT`  | `/Income/put/{userId}`           | Update an income record              |
| `DELETE` | `/Income/delete/{userId}`      | Delete income records for a user     |

---

### 💸 Expense Controller

| Method | Endpoint                            | Description                           |
|--------|-------------------------------------|---------------------------------------|
| `POST` | `/Expense/PostData`                 | Add a new expense entry               |
| `GET`  | `/Expense/get/{userId}`             | Get expense records by user ID        |
| `GET`  | `/Expense/getAllExpense/{userId}`   | Get all expense entries for a user    |
| `PUT`  | `/Expense/update/{userId}`          | Update an expense entry               |
| `DELETE` | `/Expense/delete/{userId}`        | Delete expenses by user ID            |

---

### 📈 Report Controller

| Method | Endpoint                                | Description                                |
|--------|-----------------------------------------|--------------------------------------------|
| `POST` | `/Report/PostUserReport/{userId}`       | Create or update a user’s budget report    |
| `GET`  | `/Report/get/{userId}`                  | Fetch budget report for a specific user    |

---

> 🔍 All endpoints can be tested using Swagger UI:  
> [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository

# bash
  git clone https://github.com/sanjaicrv/SpringBoot-Backend-Personal-Budget-Planner.git
  cd SpringBoot-Backend-Personal-Budget-Planner

# Update the application.properties file:
  spring.datasource.url=jdbc:mysql://localhost:3306/budget_db
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update
  
# Run the Application
  mvn spring-boot:run
  
# Access Swagger UI
http://localhost:8080/swagger-ui/index.html

---

## 📌 Future Enhancements

- [ ] JWT-based authentication and role-based access control
- [ ] Add pagination & sorting to income/expense endpoints
- [ ] Add category support for expenses
- [ ] Monthly/Yearly filters for reports
- [ ] Export budget reports to PDF/Excel
- [ ] Integrate with frontend (React.js)

## 🧑‍💻 Author

**Sanjai CRV**  
📧 sanjaicrv05@gmail.com  
🔗 [LinkedIn](https://in.linkedin.com/in/sanjai-crv-3b4813292)  
💻 [GitHub](https://github.com/sanjaicrv)

## ⭐️ Show Your Support

If you found this project helpful, please give it a ⭐ on GitHub.  
Pull requests, issues, and feedback are welcome!





