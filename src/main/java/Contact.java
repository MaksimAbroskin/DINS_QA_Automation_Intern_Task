public class Contact {
        private Integer id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private User user;

    public Contact() {
    }

    public Contact(Integer id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Contact(Integer id, String firstName, String lastName, String phone, String email, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.user = user;
    }
}
