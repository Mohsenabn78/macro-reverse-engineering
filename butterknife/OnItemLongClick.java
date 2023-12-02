package butterknife;

import androidx.annotation.IdRes;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = "true", name = "onItemLongClick", parameters = {"android.widget.AdapterView<?>", AndroidComposeViewAccessibilityDelegateCompat.ClassName, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG}, returnType = "boolean")}, setter = "setOnItemLongClickListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemLongClickListener")
/* loaded from: classes2.dex */
public @interface OnItemLongClick {
    @IdRes
    int[] value() default {-1};
}
