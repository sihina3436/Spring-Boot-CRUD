# 📚 Spring Boot CRUD Application - Book Management

This is a simple **Spring Boot CRUD** application for managing books.  
It demonstrates how to build REST APIs using **Spring Boot, JPA, and H2 Database**.

---

## 🚀 Features

- Create a new Book
- Get all Books
- Get Book by ID
- Update Book details
- Delete Book by ID

---

## 🛠️ Technologies Used

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Spring Web**

---

## 📂 Project Structure

```
src/main/java/com/example/springcrud
│
├── Controller
│   └── BookController.java     # Handles API requests
│
├── Model
│   └── Book.java               # Book entity (id, title, author)
│
├── Repo
│   └── BookRepo.java           # Repository interface (JpaRepository)
│
└── Service
    └── BookService.java        # Business logic for Book entity
```

---

## 🔗 API Endpoints

### Get all books
```
GET /books
```

### Get book by ID
```
GET /books/getBookById/{id}
```

### Create new book
```
POST /books
```
**Request body (JSON):**
```json
{
  "title": "Spring in Action",
  "author": "Craig Walls"
}
```

### Update book by ID
```
PATCH /books/update/{id}
```
**Request body (JSON):**
```json
{
  "title": "Updated Title"
}
```

### Delete book by ID
```
DELETE /books/{id}
```

---

## ▶️ Run the Project

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/spring-crud.git
   cd spring-crud
   ```

2. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Open H2 Database Console (optional):  
   ```
   http://localhost:8080/h2-console
   ```

---

## 📖 Notes
- Default DB: **H2 (in-memory)**  
- When the app restarts, data will reset.  
- You can switch to MySQL/PostgreSQL by updating `application.properties`.  

---

## 👨‍💻 Author
- Developed with ❤️ using **Spring Boot**
