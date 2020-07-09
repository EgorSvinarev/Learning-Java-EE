package IdGenerator.Qualifiers;

import java.lang.annotation.*;
import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;
import javax.inject.Qualifier;

@Qualifier
@Retention(RUNTIME)
@Target({FIELD, TYPE})
public @interface StringIdentificator { }
