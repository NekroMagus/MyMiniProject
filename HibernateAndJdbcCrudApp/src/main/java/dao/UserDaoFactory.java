package dao;

public abstract class UserDaoFactory {

    public static UserDaoHibernate createUserDaoHibernate() {
        return new UserDaoHibernateImpl();
    }

    public static UserDaoJDBC createUserDaoJDBC() {
        return new UserDaoJDBCimpl();
    }
}
