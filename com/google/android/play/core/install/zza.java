package com.google.android.play.core.install;

import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zza extends InstallState {

    /* renamed from: a  reason: collision with root package name */
    private final int f25276a;

    /* renamed from: b  reason: collision with root package name */
    private final long f25277b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25278c;

    /* renamed from: d  reason: collision with root package name */
    private final int f25279d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25280e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(int i4, long j4, long j5, int i5, String str) {
        this.f25276a = i4;
        this.f25277b = j4;
        this.f25278c = j5;
        this.f25279d = i5;
        if (str != null) {
            this.f25280e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long bytesDownloaded() {
        return this.f25277b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.f25276a == installState.installStatus() && this.f25277b == installState.bytesDownloaded() && this.f25278c == installState.totalBytesToDownload() && this.f25279d == installState.installErrorCode() && this.f25280e.equals(installState.packageName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4 = this.f25276a;
        long j4 = this.f25277b;
        long j5 = this.f25278c;
        return ((((((((i4 ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003) ^ this.f25279d) * 1000003) ^ this.f25280e.hashCode();
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallErrorCode
    public final int installErrorCode() {
        return this.f25279d;
    }

    @Override // com.google.android.play.core.install.InstallState
    @InstallStatus
    public final int installStatus() {
        return this.f25276a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String packageName() {
        return this.f25280e;
    }

    public final String toString() {
        int i4 = this.f25276a;
        long j4 = this.f25277b;
        long j5 = this.f25278c;
        int i5 = this.f25279d;
        String str = this.f25280e;
        return "InstallState{installStatus=" + i4 + ", bytesDownloaded=" + j4 + ", totalBytesToDownload=" + j5 + ", installErrorCode=" + i5 + ", packageName=" + str + "}";
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long totalBytesToDownload() {
        return this.f25278c;
    }
}
