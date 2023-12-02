package butterknife;

import androidx.annotation.IdRes;
import butterknife.internal.ListenerClass;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@ListenerClass(callbacks = Callback.class, setter = "setOnItemSelectedListener", targetType = "android.widget.AdapterView<?>", type = "android.widget.AdapterView.OnItemSelectedListener")
/* loaded from: classes2.dex */
public @interface OnItemSelected {

    /* loaded from: classes2.dex */
    public enum Callback {
        ITEM_SELECTED,
        NOTHING_SELECTED
    }

    Callback callback() default Callback.ITEM_SELECTED;

    @IdRes
    int[] value() default {-1};
}
