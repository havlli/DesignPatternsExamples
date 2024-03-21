public class SimpleBean {

    private final Long id;
    private final String username;
    private final String password;
    private final String roles;

    public SimpleBean(
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

    public static SimpleBeanBuilder builder() {
        return new SimpleBeanBuilder();
    }

    static class SimpleBeanBuilder {
        private Long id;
        private String username;
        private String password;
        private String roles;

        public SimpleBeanBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SimpleBeanBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public SimpleBeanBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public SimpleBeanBuilder withRoles(String roles) {
            this.roles = roles;
            return this;
        }

        public SimpleBean build() {
            return new SimpleBean(id, username, password, roles);
        }
    }
}