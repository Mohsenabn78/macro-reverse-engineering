package crashguard.android.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import java.util.LinkedList;

/* loaded from: classes6.dex */
final class f6 {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList f38744a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private z4 f38745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context) {
        for (i6 i6Var : this.f38744a) {
            if (i6Var.a(context)) {
                context.unregisterReceiver(i6Var);
            }
        }
        this.f38744a.clear();
        z4 z4Var = this.f38745b;
        if (z4Var != null) {
            z4Var.a(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public final void b(Context context) {
        PowerReceiver powerReceiver = new PowerReceiver();
        if (powerReceiver.a(context)) {
            this.f38744a.add(powerReceiver);
        }
        NetworkReceiver networkReceiver = new NetworkReceiver();
        if (networkReceiver.a(context)) {
            this.f38744a.add(networkReceiver);
        }
        for (i6 i6Var : this.f38744a) {
            if (i6Var.a(context)) {
                if (i6Var.f38850a == null) {
                    i6Var.f38850a = new IntentFilter();
                    for (String str : i6Var.getActions()) {
                        i6Var.f38850a.addAction(str);
                    }
                }
                context.registerReceiver(i6Var, i6Var.f38850a);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 27 && i4 < 31) {
            this.f38745b = new z4().b(context);
        }
    }
}
