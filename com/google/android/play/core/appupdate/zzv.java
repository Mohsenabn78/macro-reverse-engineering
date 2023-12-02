package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzv extends AppUpdateOptions.Builder {

    /* renamed from: a  reason: collision with root package name */
    private int f25261a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25262b;

    /* renamed from: c  reason: collision with root package name */
    private byte f25263c;

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions build() {
        if (this.f25263c != 3) {
            StringBuilder sb = new StringBuilder();
            if ((this.f25263c & 1) == 0) {
                sb.append(" appUpdateType");
            }
            if ((this.f25263c & 2) == 0) {
                sb.append(" allowAssetPackDeletion");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new zzx(this.f25261a, this.f25262b, null);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z3) {
        this.f25262b = z3;
        this.f25263c = (byte) (this.f25263c | 2);
        return this;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAppUpdateType(int i4) {
        this.f25261a = i4;
        this.f25263c = (byte) (this.f25263c | 1);
        return this;
    }
}
