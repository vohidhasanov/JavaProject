//package Func.MyWorks;
//
//
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//import static Func.MyWorks.UserValidation.ageGreaterThan30;
//import static Func.MyWorks.UserValidation.nameIsNotEmpty;
//
//import static Func.MyWorks.ValidationResult.invalid;
//import static Func.MyWorks.ValidationSupport.valid;
//
//
//interface UserValidation extends Function <User, ValidationResult> {
//    static UserValidation nameIsNotEmpty()
//    {
//        return holds(user -> !user.name.isEmpty(), "Name is Empty", ErrorEnum.NAME_EMPTY);
//    }
//    static UserValidation emailContainsAtSign()
//    {
//        return holds(user -> user.email.contains("@"), "Missing @ sign", ErrorEnum.EMAIL_FORM_ERROR);
//    }
//     static UserValidation ageGreaterThan30 () {
//         return holds(user -> user.age > 30, "Age is under 30", ErrorEnum.AGE_NOT_SUITABLE);
//     }
//    //static UserValidation ageGreaterThan18 = user -> user.age > 18;
//    static UserValidation holds(Predicate<User> p, String message, ErrorEnum errorEnum)
//    {
//        return user -> p.test(user) ? valid() : invalid(List <Violation> errorEnum);
//    }
//
//
//    default UserValidation and(UserValidation other) {
//        return user -> {
//            final ValidationResult result = this.apply(user);
//            return result
//                    .isValid() ?
//                    other.apply(user)
//                    : result;
//        };
//    }
//
//    static UserValidation all (UserValidation ...validations) {
//        return user -> Arrays.stream(validations).map(v-> v.apply(user)).reduce(valid(), (acc, b) -> {
//            if (b.isValid()) return acc;
//            List<Violation> violations = new ArrayList<Violation>(acc.);
//            violations.addAll(b.getViolti)
//
//        });
//    }
//
//}
//
// interface ValidationResult {
//     boolean isValid();
//    // Optional<String> getReason();
//
//     static ValidationResult valid ()
//            {
//                return ValidationSupport.valid();
//            }
//        static ValidationResult invalid (List <Violation> reason)
//            {
//                return (ValidationResult) new Invalid (reason);
//            }
//}
//
////  final class Invalid implements ValidationResult {
////        private final String reason;
////       //Constructor
////     public Invalid(String reason)
////     {this.reason = reason;}
////
////     @Override
////     public boolean isValid() {
////         return false;
////     }
////
////     @Override
////     public Optional<String> getReason() {
////         return Optional.of(reason);
////     }
//// }
//
//class Invalid {
//    private final List <Violation> violations;
//
//    public Invalid (List<Violation> violations) {
//        this.violations = violations;
//    }
//    public List <Violation> getViolations () {
//        return   Collections.unmodifiableList(violations);
//    }
//}
//
//
//  final class ValidationSupport {
//  private static final ValidationResult valid = new ValidationResult() {
//     @Override
//      public boolean isValid() {
//          return true;
//      }
//
// };
//    static ValidationResult valid () {
//        return valid;}
// }
//
//
//
//public class User {
//    public final String name;
//    public final int age;
//    public final String email;
//
//    public User(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }
//
//    public boolean isValid() {
//        return nameIsNotEmpty() && emailContainsAtSign();
//    }
//
//    boolean nameIsNotEmpty() {
//        return !name.trim().isEmpty();
//    }
//
//    private boolean emailContainsAtSign() {
//        return email.contains("@");
//    }
//
//    @Override
//    public String toString() {
//        return "name='" + name + '\'' + ", age=" + age + ", email= " + email;
//    }
//
//
//
//    public static  void main(String[] args) {
//        User gregor = new User("", 30, "abc@gmail.com");
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("Tom", 11, "aaa@list.ru"));
//        users.add(new User("John", 15, "bb@mail.ru"));
//        users.add(new User("Mulder", 18, "star@gmail.com"));
//        users.add(new User("Mike", 33, "kk@mail.ru"));
//
//        //UserValidation validation = UserValidation.nameIsNotEmpty().and(UserValidation.emailContainsAtSign());
//        UserValidation validation = UserValidation.nameIsNotEmpty().and(UserValidation.emailContainsAtSign().and(UserValidation.ageGreaterThan30()));
//      //  UserValidation validation = nameIsNotEmpty().all(UserValidation.emailContainsAtSign().all((ageGreaterThan30())));
//        ValidationResult result1 = validation.apply(gregor);
//        //result1.getReason().ifPresent(System.out::println);
//     // result1.getReason().ifPresent(System.out::println);
//
//
//
////        List<User> us = users.stream().parallel().filter(nameIsNotEmpty.and(ageGreaterThan18)::apply)
////                .collect(Collectors.toList());
////        System.out.println(us.toString());
////
////        nameIsNotEmpty.and(emailContainsAtSign).and(ageGreaterThan18).apply(gregor);
//
//    }
//    }
//
//
//    class Violation {
//     private final String errorMessage;
//     private final ErrorEnum error;
//
//        public Violation(String errorMessage, ErrorEnum error) {
//            this.errorMessage = errorMessage;
//            this.error = error;
//        }
//        public static Violation violation (String errorMessage, ErrorEnum error) {
//            return new Violation (errorMessage, error);
//        }
//
//        public String getErrorMessage() {  return errorMessage; }
//
//
//        public ErrorEnum getError() {  return error;  }
//
//
//    }
//
//    enum ErrorEnum {
//     NAME_EMPTY,
//     EMAIL_FORM_ERROR,
//     AGE_NOT_SUITABLE
//    }
//
//
