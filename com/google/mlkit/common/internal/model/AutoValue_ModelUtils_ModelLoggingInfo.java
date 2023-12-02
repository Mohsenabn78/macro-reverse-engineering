package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public final class AutoValue_ModelUtils_ModelLoggingInfo extends ModelUtils.ModelLoggingInfo {

    /* renamed from: a  reason: collision with root package name */
    private final long f32920a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32921b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32922c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ModelUtils_ModelLoggingInfo(long j4, String str, boolean z3) {
        this.f32920a = j4;
        this.f32921b = str;
        this.f32922c = z3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.ModelLoggingInfo) {
            ModelUtils.ModelLoggingInfo modelLoggingInfo = (ModelUtils.ModelLoggingInfo) obj;
            if (this.f32920a == modelLoggingInfo.getSize() && this.f32921b.equals(modelLoggingInfo.getHash()) && this.f32922c == modelLoggingInfo.isManifestModel()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public String getHash() {
        return this.f32921b;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public long getSize() {
        return this.f32920a;
    }

    public final int hashCode() {
        int i4;
        long j4 = this.f32920a;
        int hashCode = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f32921b.hashCode()) * 1000003;
        if (true != this.f32922c) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        return i4 ^ hashCode;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo
    @KeepForSdk
    public boolean isManifestModel() {
        return this.f32922c;
    }

    public final String toString() {
        long j4 = this.f32920a;
        String str = this.f32921b;
        boolean z3 = this.f32922c;
        return "ModelLoggingInfo{size=" + j4 + ", hash=" + str + ", manifestModel=" + z3 + "}";
    }
}
