package crashguard.android.library;

import android.content.Context;
import com.google.firebase.firestore.util.ExponentialBackoff;

/* loaded from: classes6.dex */
class u1 extends d1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u1(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        y0 y0Var = new y0(this.f38690a.get());
        int u3 = y0Var.u();
        long T = y0Var.T();
        long R = y0Var.R();
        y0Var.m(u3 + 1);
        y0Var.y(System.currentTimeMillis());
        long j4 = currentTimeMillis - R;
        if (currentTimeMillis - T <= ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS && j4 <= ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS) {
            if (u3 >= 9) {
                return false;
            }
            return true;
        }
        y0Var.m(0);
        y0Var.v(currentTimeMillis);
        return true;
    }
}
