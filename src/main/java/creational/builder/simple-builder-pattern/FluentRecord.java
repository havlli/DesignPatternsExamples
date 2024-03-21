public record FluentRecord(
    Long id,
    String username,
    String password,
    String roles
) {
    public static Builder builder() {
        return id -> username -> password -> roles -> new FluentRecord(id, username, password, roles);
    }

    interface Builder {
        Stage1 id(final Long id);

        public interface Stage1 {
            Stage2 username(final String username);
        }

        public interface Stage2 {
            StageFinish password(final String password);
        }

        public interface StageFinish {
            FluentRecord roles(final String roles);
        }
    }
}


