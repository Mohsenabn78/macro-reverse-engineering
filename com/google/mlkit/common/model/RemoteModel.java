package com.google.mlkit.common.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzw;
import com.google.android.gms.internal.mlkit_common.zzx;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class RemoteModel {

    /* renamed from: e  reason: collision with root package name */
    private static final Map f32943e = new EnumMap(BaseModel.class);
    @NonNull
    @VisibleForTesting
    public static final Map zza = new EnumMap(BaseModel.class);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f32944a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final BaseModel f32945b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelType f32946c;

    /* renamed from: d  reason: collision with root package name */
    private String f32947d;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public RemoteModel(@Nullable String str, @Nullable BaseModel baseModel, @NonNull ModelType modelType) {
        boolean z3;
        boolean isEmpty = TextUtils.isEmpty(str);
        if (baseModel == null) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(isEmpty == z3, "One of cloud model name and base model cannot be empty");
        this.f32944a = str;
        this.f32945b = baseModel;
        this.f32946c = modelType;
    }

    @KeepForSdk
    public boolean baseModelHashMatches(@NonNull String str) {
        BaseModel baseModel = this.f32945b;
        if (baseModel == null) {
            return false;
        }
        return str.equals(f32943e.get(baseModel));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoteModel)) {
            return false;
        }
        RemoteModel remoteModel = (RemoteModel) obj;
        if (Objects.equal(this.f32944a, remoteModel.f32944a) && Objects.equal(this.f32945b, remoteModel.f32945b) && Objects.equal(this.f32946c, remoteModel.f32946c)) {
            return true;
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public String getModelHash() {
        return this.f32947d;
    }

    @Nullable
    @KeepForSdk
    public String getModelName() {
        return this.f32944a;
    }

    @NonNull
    @KeepForSdk
    public String getModelNameForBackend() {
        String str = this.f32944a;
        if (str != null) {
            return str;
        }
        return (String) zza.get(this.f32945b);
    }

    @NonNull
    @KeepForSdk
    public ModelType getModelType() {
        return this.f32946c;
    }

    @NonNull
    @KeepForSdk
    public String getUniqueModelNameForPersist() {
        String str = this.f32944a;
        if (str != null) {
            return str;
        }
        return "COM.GOOGLE.BASE_".concat(String.valueOf((String) zza.get(this.f32945b)));
    }

    public int hashCode() {
        return Objects.hashCode(this.f32944a, this.f32945b, this.f32946c);
    }

    @KeepForSdk
    public boolean isBaseModel() {
        if (this.f32945b != null) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public void setModelHash(@NonNull String str) {
        this.f32947d = str;
    }

    @NonNull
    public String toString() {
        zzw zzb = zzx.zzb("RemoteModel");
        zzb.zza("modelName", this.f32944a);
        zzb.zza("baseModel", this.f32945b);
        zzb.zza("modelType", this.f32946c);
        return zzb.toString();
    }
}
