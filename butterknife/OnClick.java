package butterknife;

import androidx.annotation.IdRes;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(name = "doClick", parameters = {AndroidComposeViewAccessibilityDelegateCompat.ClassName})}, setter = "setOnClickListener", targetType = AndroidComposeViewAccessibilityDelegateCompat.ClassName, type = "butterknife.internal.DebouncingOnClickListener")
/* loaded from: classes2.dex */
public @interface OnClick {
    @IdRes
    int[] value() default {-1};
}
