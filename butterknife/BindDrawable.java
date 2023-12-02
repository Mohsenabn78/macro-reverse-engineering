package butterknife;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface BindDrawable {
    @AttrRes
    int tint() default -1;

    @DrawableRes
    int value();
}
