package butterknife;

import androidx.annotation.UiThread;

/* loaded from: classes2.dex */
public interface Unbinder {
    public static final Unbinder EMPTY = new Unbinder() { // from class: butterknife.a
        @Override // butterknife.Unbinder
        public final void unbind() {
            b.a();
        }
    };

    @UiThread
    void unbind();
}
