package butterknife;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

/* loaded from: classes2.dex */
public interface Action<T extends View> {
    @UiThread
    void apply(@NonNull T t3, int i4);
}
