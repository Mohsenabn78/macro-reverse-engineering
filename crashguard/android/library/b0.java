package crashguard.android.library;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes6.dex */
class b0 {

    /* renamed from: a  reason: collision with root package name */
    protected SharedPreferences f38622a;

    /* renamed from: b  reason: collision with root package name */
    protected SharedPreferences.Editor f38623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f38622a = sharedPreferences;
        this.f38623b = sharedPreferences.edit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, long j4, boolean z3) {
        this.f38623b.putLong(str, j4);
        if (z3) {
            this.f38623b.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, String str2, boolean z3) {
        this.f38623b.putString(str, str2);
        if (z3) {
            this.f38623b.apply();
        }
    }
}
