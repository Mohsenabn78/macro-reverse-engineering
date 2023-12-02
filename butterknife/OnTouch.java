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
@ListenerClass(method = {@ListenerMethod(defaultReturn = "true", name = "onTouch", parameters = {AndroidComposeViewAccessibilityDelegateCompat.ClassName, "android.view.MotionEvent"}, returnType = "boolean")}, setter = "setOnTouchListener", targetType = AndroidComposeViewAccessibilityDelegateCompat.ClassName, type = "android.view.View.OnTouchListener")
/* loaded from: classes2.dex */
public @interface OnTouch {
    @IdRes
    int[] value() default {-1};
}
