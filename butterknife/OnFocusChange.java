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
@ListenerClass(method = {@ListenerMethod(name = "onFocusChange", parameters = {AndroidComposeViewAccessibilityDelegateCompat.ClassName, "boolean"})}, setter = "setOnFocusChangeListener", targetType = AndroidComposeViewAccessibilityDelegateCompat.ClassName, type = "android.view.View.OnFocusChangeListener")
/* loaded from: classes2.dex */
public @interface OnFocusChange {
    @IdRes
    int[] value() default {-1};
}
