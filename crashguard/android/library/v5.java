package crashguard.android.library;

import crashguard.android.library.v;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;

/* loaded from: classes6.dex */
final class v5 extends v {
    /* JADX INFO: Access modifiers changed from: protected */
    public v5(c0 c0Var) {
        super(c0Var);
    }

    /* loaded from: classes6.dex */
    static class a extends v.a<a, v5> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
            super(t.class);
            c(CycledLeScanner.ANDROID_N_MAX_SCAN_DURATION_MILLIS);
        }

        @Override // crashguard.android.library.v.a
        protected final a a() {
            return this;
        }
    }
}
