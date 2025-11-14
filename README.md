Expense Share App (Spring Boot)

A simple and clean expense-sharing backend built using Spring Boot, Spring Data JPA, and MySQL.
It allows users to add expenses, split amounts, and see how much each person owes.

📌 Features

Create users

Add expenses with description, amount, payer, and participants

Split expenses equally

Calculate amount owed between users

Auto-categorize expenses using AI keyword detection

REST API endpoints for all operations

Tech Stack

Java 17 / 21

Spring Boot

Spring Data JPA

MySQL 

Postman / Swagger for API testing

src/
 ├── controller
 ├── service
 ├── repository
 ├── model
 └── ExpenseShareApplication.java
 
🔗 API Endpoints
👤 User APIs
| Method | Endpoint     | Description   |
| ------ | ------------ | ------------- |
| POST   | `/api/users` | Create a user |
| GET    | `/api/users` | Get all users |

💸 Expense APIs
| Method | Endpoint             | Description       |
| ------ | -------------------- | ----------------- |
| POST   | `/api/expenses`      | Create an expense |
| GET    | `/api/expenses`      | Get all expenses  |
| GET    | `/api/expenses/{id}` | Get expense by ID |

🧮 Expense Share APIs
| Method | Endpoint                   | Description                  |
| ------ | -------------------------- | ---------------------------- |
| GET    | `/api/share/{userId}/owed` | How much others owe TO user  |
| GET    | `/api/share/{userId}/owes` | How much user OWES to others |
| GET    | `/api/share/summary`       | All balances                 |

🤖 AI Category Auto-Detection
Expenses are auto-categorized based on keywords:
coffee → Food  
uber → Travel  
rent → Rent  
movie → Entertainment

🧪 Example JSON – Create Expense
{
  "description": "Lunch at Chipotle",
  "amount": 30,
  "paidBy": 1,
  "participants": [1, 2, 3]
}
🗄️ Setup Instructions
1️⃣ Clone the repository
git clone https://github.com/your-username/expense-share.git

2️⃣ Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_db
spring.datasource.username=root
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update

3️⃣ Run the application
mvn spring-boot:run

✨ Future Enhancements
Login + JWT Authentication
User Groups
Smart AI categorization (NLP)
Monthly reports
Export to Excel / PDF
