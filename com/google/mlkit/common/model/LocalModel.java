package com.google.mlkit.common.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzw;
import com.google.android.gms.internal.mlkit_common.zzx;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public class LocalModel {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f32935a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f32936b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Uri f32937c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32938d;

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    /* loaded from: classes5.dex */
    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f32939a = null;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private String f32940b = null;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Uri f32941c = null;

        /* renamed from: d  reason: collision with root package name */
        private boolean f32942d = false;

        @NonNull
        public LocalModel build() {
            String str = this.f32939a;
            boolean z3 = true;
            if ((str == null || this.f32940b != null || this.f32941c != null) && ((str != null || this.f32940b == null || this.f32941c != null) && (str != null || this.f32940b != null || this.f32941c == null))) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Set one of filePath, assetFilePath and URI.");
            return new LocalModel(this.f32939a, this.f32940b, this.f32941c, this.f32942d, null);
        }

        @NonNull
        public Builder setAbsoluteFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            boolean z3 = false;
            if (this.f32940b == null && this.f32941c == null && !this.f32942d) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f32939a = str;
            return this;
        }

        @NonNull
        public Builder setAbsoluteManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            boolean z3 = false;
            if (this.f32940b == null && this.f32941c == null && (this.f32939a == null || this.f32942d)) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f32939a = str;
            this.f32942d = true;
            return this;
        }

        @NonNull
        public Builder setAssetFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Model Source file path can not be empty");
            boolean z3 = false;
            if (this.f32939a == null && this.f32941c == null && !this.f32942d) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f32940b = str;
            return this;
        }

        @NonNull
        public Builder setAssetManifestFilePath(@NonNull String str) {
            Preconditions.checkNotEmpty(str, "Manifest file path can not be empty");
            boolean z3 = false;
            if (this.f32939a == null && this.f32941c == null && (this.f32940b == null || this.f32942d)) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f32940b = str;
            this.f32942d = true;
            return this;
        }

        @NonNull
        public Builder setUri(@NonNull Uri uri) {
            boolean z3 = false;
            if (this.f32939a == null && this.f32940b == null) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "A local model source is from absolute file path, asset file path or URI, you can only set one of them.");
            this.f32941c = uri;
            return this;
        }
    }

    /* synthetic */ LocalModel(String str, String str2, Uri uri, boolean z3, zzc zzcVar) {
        this.f32935a = str;
        this.f32936b = str2;
        this.f32937c = uri;
        this.f32938d = z3;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalModel)) {
            return false;
        }
        LocalModel localModel = (LocalModel) obj;
        if (!Objects.equal(this.f32935a, localModel.f32935a) || !Objects.equal(this.f32936b, localModel.f32936b) || !Objects.equal(this.f32937c, localModel.f32937c) || this.f32938d != localModel.f32938d) {
            return false;
        }
        return true;
    }

    @Nullable
    @KeepForSdk
    public String getAbsoluteFilePath() {
        return this.f32935a;
    }

    @Nullable
    @KeepForSdk
    public String getAssetFilePath() {
        return this.f32936b;
    }

    @Nullable
    @KeepForSdk
    public Uri getUri() {
        return this.f32937c;
    }

    public int hashCode() {
        return Objects.hashCode(this.f32935a, this.f32936b, this.f32937c, Boolean.valueOf(this.f32938d));
    }

    @KeepForSdk
    public boolean isManifestFile() {
        return this.f32938d;
    }

    @NonNull
    public String toString() {
        zzw zza = zzx.zza(this);
        zza.zza("absoluteFilePath", this.f32935a);
        zza.zza("assetFilePath", this.f32936b);
        zza.zza("uri", this.f32937c);
        zza.zzb("isManifestFile", this.f32938d);
        return zza.toString();
    }
}
