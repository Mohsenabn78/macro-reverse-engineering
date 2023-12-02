package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.zzv;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class RevocationBoundService extends Service {
    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        String str;
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                str = "Unknown action sent to RevocationBoundService: ".concat(valueOf);
            } else {
                str = new String("Unknown action sent to RevocationBoundService: ");
            }
            Log.w("RevocationService", str);
            return null;
        }
        if (Log.isLoggable("RevocationService", 2)) {
            String valueOf2 = String.valueOf(intent.getAction());
            if (valueOf2.length() != 0) {
                "RevocationBoundService handling ".concat(valueOf2);
            }
        }
        return new zzv(this);
    }
}
