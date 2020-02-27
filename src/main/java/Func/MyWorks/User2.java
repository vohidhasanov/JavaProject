package Func.MyWorks;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static Func.MyWorks.UserValidation.*;
import static Func.MyWorks.ValidationRes.*;

public class User2 {
    public final String name;
    public final int age;
    public final String email;

    public User2(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


}
interface ValidationRes {
    static ValidationRes valid () {
        return ValidationSupport.valid();
    }
    static ValidationRes invalid (String reason) {
        return new Invalid (reason);
    }

    boolean isValid();
    Optional <String> getReason();
}

final class Invalid implements ValidationRes {
    private final String reason;
  //  private List<String> errors;

    public Invalid(String name) {
        this.reason = name;
      //  errors.add(name);
    }

//    public List<String> getErrors() {
//        return errors;
//    }

    @Override
    public boolean isValid() {
        return false;    }

    @Override
    public Optional<String> getReason() {
        return Optional.of(reason);    }
}

//class Invalid {
//    private final
//}


 final class ValidationSupport {
    private static final ValidationRes valid = new ValidationRes() {
        @Override
        public boolean isValid() {
            return false;  }

        @Override
        public Optional<String> getReason() {
            return Optional.empty(); }
    };
    static ValidationRes valid () {
        return valid;
    }
}

interface UserValidation extends Function<User2, ValidationRes> {
    static UserValidation nameIsNotEmpty () {
        return holds(user -> !user.name.trim().isEmpty(), "Name is Empty"   );
    }

    static UserValidation emailContainAtSign () {
        return holds (user -> user.email.contains("@"), "Missing '@' sign ");
    }

    static UserValidation ageGreaterThan25 () {
        return holds(user-> user.age > 25, "Age is under 25");
    }

    static UserValidation holds (Predicate<User2> p, String message) {
        return user -> p.test(user) ?
                valid() :
                invalid(message);
    }

//    default UserValidation and(UserValidation other) {
//        return user -> {
//            final ValidationRes result = this.apply(user);
//            return result
//                    .isValid() ?
//                    other.apply(user)
//                    :result;
//        };
//    }

//    default UserValidation all(UserValidation... validations) {
//        return user -> {
//            Arrays.stream(validations).forEach(validation -> {
//                System.out.println(validation.apply(user).getReason());
//            });
//       return null; };
//    }

    static Function <User2, List <ValidationRes>> all(UserValidation... validations) {
        return user -> {
            return Arrays.stream(validations).map(validation -> validation.apply(user))
                    .filter(vr->!vr.isValid())
                    .collect(Collectors.toList());
        };
    }



}
 class Main1 {
     public static void main(String[] args) {
        // UserValidation validation = nameIsNotEmpty().and(ageGreaterThan25().and(emailContainAtSign()));
        // UserValidation validation = nameIsNotEmpty().all(nameIsNotEmpty(),ageGreaterThan25(),emailContainAtSign());
         User2 gregor = new User2(" ", 24, "abcgmai.com");
        // ValidationRes result = validation.apply(gregor);
//         result.getReason().ifPresent(System.out::println);

         UserValidation rules [] = {nameIsNotEmpty(), emailContainAtSign(), ageGreaterThan25()};
         Function <User2, List<ValidationRes>> validation = UserValidation.all(rules);
         List <ValidationRes> result = validation.apply(gregor);
         result.forEach(item -> System.out.println(item.getReason().get()));


     }
 }

