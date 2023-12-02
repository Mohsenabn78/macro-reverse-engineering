package com.google.android.play.core.appupdate;

import com.google.android.play.core.install.model.AppUpdateType;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzx extends AppUpdateOptions {

    /* renamed from: a  reason: collision with root package name */
    private final int f25264a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25265b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzx(int i4, boolean z3, zzw zzwVar) {
        this.f25264a = i4;
        this.f25265b = z3;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean allowAssetPackDeletion() {
        return this.f25265b;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    @AppUpdateType
    public final int appUpdateType() {
        return this.f25264a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            if (this.f25264a == appUpdateOptions.appUpdateType() && this.f25265b == appUpdateOptions.allowAssetPackDeletion()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int i5 = (this.f25264a ^ 1000003) * 1000003;
        if (true != this.f25265b) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        return i5 ^ i4;
    }

    public final String toString() {
        int i4 = this.f25264a;
        boolean z3 = this.f25265b;
        return "AppUpdateOptions{appUpdateType=" + i4 + ", allowAssetPackDeletion=" + z3 + "}";
    }
}
