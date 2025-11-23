package appointmentsApp.users;

public class managerUsuario {
    public static Usuario user;

    public static void setUser(Usuario user) {
        managerUsuario.user = user;
    }
    public static Usuario getUser() {
        return user;
    }
}
