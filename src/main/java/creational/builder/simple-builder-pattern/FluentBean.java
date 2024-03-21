public class FluentBean {

    private final Long id;
    private final String username;
    private final String password;
    private final String roles;

    public FluentBean(
        final Long id, 
        final String username, 
        final String password, 
        final String roles
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long id() {
        return this.id;
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    public String roles() {
        return this.roles;
    }

    public static Builder builder() {
        return id -> username -> password -> roles -> () -> new FluentBean(id, username, password, roles);
    }

    interface Builder {
        Stage1 withId(Long id);

        public interface Stage1 {
            Stage2 withUsername(final String username);
        }

        public interface Stage2 {
            Stage3 withPassword(final String password);
        }

        public interface Stage3 {
            Stage4 withRoles(final String roles);
        }

        public interface Stage4 {
            FluentBean build();
        }
    }
}