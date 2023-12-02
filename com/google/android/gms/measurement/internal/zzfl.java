package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfl {

    /* renamed from: a  reason: collision with root package name */
    final zzgd f21618a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzlh zzlhVar) {
        this.f21618a = zzlhVar.O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean a() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.f21618a.zzaw());
            if (packageManager == null) {
                this.f21618a.zzaA().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode < 80837300) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e4) {
            this.f21618a.zzaA().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e4);
            return false;
        }
    }
}
