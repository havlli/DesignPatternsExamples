public class Examples {

    public static void main(String[] args) {
        System.out.println(simpleBuilderPattern());
        System.out.println(fluentBuilderPattern());
        System.out.println(fluentRecordBuilder());
    }

    public static SimpleBean simpleBuilderPattern() {
        return SimpleBean.builder()
                .withId(1L)
                .withPassword("password")
                .withUsername("username")
                .withRoles("roles")
                .build();
    }

    public static FluentBean fluentBuilderPattern() {
        return FluentBean.builder()
                .withId(1L)
                .withUsername("username")
                .withPassword("password")
                .withRoles("roles")
                .build();
    }

    public static FluentRecord fluentRecordBuilder() {
        return FluentRecord.builder()
                .id(1L)
                .username("username")
                .password("password")
                .roles("roles");
    }
}