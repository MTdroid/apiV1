package ru.kata.repositoryClasses;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import ru.kata.entity.RoleTable;
import ru.kata.entity.UserTable;
import ru.kata.models.AdminUserRestController.deleteUserById.DeleteUserResponse;

import java.awt.print.Book;
import java.util.List;

import static ru.kata.environments.UserDatabaseConfiguration.getSession;

public class UserRepository {
    static Session session;

    public UserRepository() {

        session = getSession();
    }

    public static List<UserTable> findAll() {
        final String hql = """
           SELECT * FROM users
                """;
        return session.createNativeQuery(hql, UserTable.class).getResultList();
    }
    public static List<UserTable> findAllCurators() {
        final String hql = """
           SELECT * FROM users WHERE dtype ='Curator'
                """;
        return session.createNativeQuery(hql, UserTable.class).getResultList();
    }

    public static List<UserTable> findUser(Integer id) {
        final String hql = """
           SELECT * FROM users WHERE id =:id
           """;
        return session.createNativeQuery(hql, UserTable.class).setParameter("id",id).getResultList();

    }

    public static List<DeleteUserResponse> deleteUser(Integer id) {
        final String hql = """
           DELETE FROM users WHERE id =:id
           """;
        Transaction tr = session.beginTransaction();
        NativeQuery<DeleteUserResponse> query = session.createNativeQuery(hql, DeleteUserResponse.class);
        query.setParameter("id",id).executeUpdate();
        tr.commit();
        return query.getResultList();
    }
    public static void deleteUserV2(Integer id) {
        final String hql = "DELETE FROM users WHERE id =:id" ;

        Transaction tr = session.beginTransaction();
        session.createNativeQuery(hql, UserTable.class).setParameter("id",id).executeUpdate();
        tr.commit();

    }
    public static void addUser(String birthday, String email, String firstName, String lastName, String password, String role) {
        final String hql = """
                INSERT INTO users (birthday, email, first_name, last_name, password,dtype)
                VALUES($birthday,$email, $firstName, $lastName, $password,$dtype)
                """;

        Transaction tr = session.beginTransaction();
        NativeQuery<UserTable> query = session.createNativeQuery(hql, UserTable.class);
        query.setParameter("birthday", birthday);
        query.setParameter("email", email);
        query.setParameter("first_name", firstName);
        query.setParameter("last_name", lastName);
        query.setParameter("password", password);
        query.setParameter("dtype", role);
        query.executeUpdate();
        tr.commit();
    }

/*    public List<Book> findBook(String bookTitle) {
        final String hql = """
           SELECT * FROM book WHERE book_title =:bookTitle
           """;
        return session.createNativeQuery(hql, Book.class).setParameter("bookTitle",bookTitle).getResultList();
    }*/
}
