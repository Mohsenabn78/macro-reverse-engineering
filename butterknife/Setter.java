package butterknife;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

/* loaded from: classes2.dex */
public interface Setter<T extends View, V> {
    @UiThread
    void set(@NonNull T t3, @Nullable V v3, int i4);
}
