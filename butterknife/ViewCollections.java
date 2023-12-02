package butterknife;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import java.util.List;

/* loaded from: classes2.dex */
public final class ViewCollections {
    private ViewCollections() {
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull List<T> list, @NonNull Action<? super T>... actionArr) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (Action<? super T> action : actionArr) {
                action.apply(list.get(i4), i4);
            }
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull List<T> list, @NonNull Setter<? super T, V> setter, @Nullable V v3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            setter.set(list.get(i4), v3, i4);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T[] tArr, @NonNull Setter<? super T, V> setter, @Nullable V v3) {
        int length = tArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            setter.set(tArr[i4], v3, i4);
        }
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull T[] tArr, @NonNull Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            for (Action<? super T> action : actionArr) {
                action.apply(tArr[i4], i4);
            }
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T t3, @NonNull Setter<? super T, V> setter, @Nullable V v3) {
        setter.set(t3, v3, 0);
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull List<T> list, @NonNull Property<? super T, V> property, @Nullable V v3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            property.set(list.get(i4), v3);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull List<T> list, @NonNull Action<? super T> action) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.apply(list.get(i4), i4);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T[] tArr, @NonNull Property<? super T, V> property, @Nullable V v3) {
        for (T t3 : tArr) {
            property.set(t3, v3);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull T[] tArr, @NonNull Action<? super T> action) {
        int length = tArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            action.apply(tArr[i4], i4);
        }
    }

    @UiThread
    public static <T extends View, V> void set(@NonNull T t3, @NonNull Property<? super T, V> property, @Nullable V v3) {
        property.set(t3, v3);
    }

    @SafeVarargs
    @UiThread
    public static <T extends View> void run(@NonNull T t3, @NonNull Action<? super T>... actionArr) {
        for (Action<? super T> action : actionArr) {
            action.apply(t3, 0);
        }
    }

    @UiThread
    public static <T extends View> void run(@NonNull T t3, @NonNull Action<? super T> action) {
        action.apply(t3, 0);
    }
}
