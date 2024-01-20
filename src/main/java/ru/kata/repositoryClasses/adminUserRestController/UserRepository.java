package ru.kata.repositoryClasses.adminUserRestController;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import ru.kata.entity.adminUserRestController.UserTable;
import ru.kata.models.response.DeleteUserResponse;

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
    public static List<UserTable> findUserByEmail(String email) {
        final String hql = """
           SELECT * FROM users WHERE email =:email
           """;
        return session.createNativeQuery(hql, UserTable.class).setParameter("email",email).getResultList();

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
    public static void deleteAllCurators(String dtype) {

        final String hql = "DELETE FROM users WHERE dtype =:dtype" ;

        Transaction tr = session.beginTransaction();

        session.createNativeQuery(hql, UserTable.class).setParameter("dtype",dtype).executeUpdate();
        tr.commit();

    }
    public static List<UserTable> addUser(String birthday, String email, String firstName, String lastName, String password, String dtype) {

        final String hql = """
                INSERT INTO users (birthday, email, first_name, last_name, password)
                VALUES(:birthday,:email, :firstName, :lastName, :password)
                """;


       return session.createNativeQuery(hql,UserTable.class)
                .setParameter("birthday", birthday)
        .setParameter("email", email)
        .setParameter("first_name", firstName)
        .setParameter("last_name", lastName)
        .setParameter("password", password)
        .setParameter("dtype", dtype)
        .getResultList();
    }

/*    public List<Book> findBook(String bookTitle) {
        final String hql = """
           SELECT * FROM book WHERE book_title =:bookTitle
           """;
        return session.createNativeQuery(hql, Book.class).setParameter("bookTitle",bookTitle).getResultList();
    }*/
}
