package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class DataBufferRef {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f20368a;
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    protected int f20369b;

    /* renamed from: c  reason: collision with root package name */
    private int f20370c;

    @KeepForSdk
    public DataBufferRef(@NonNull DataHolder dataHolder, int i4) {
        this.f20368a = (DataHolder) Preconditions.checkNotNull(dataHolder);
        g(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean a(@NonNull String str) {
        return this.f20368a.getBoolean(str, this.f20369b, this.f20370c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public byte[] b(@NonNull String str) {
        return this.f20368a.getByteArray(str, this.f20369b, this.f20370c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public float c(@NonNull String str) {
        return this.f20368a.zab(str, this.f20369b, this.f20370c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public int d(@NonNull String str) {
        return this.f20368a.getInteger(str, this.f20369b, this.f20370c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public String e(@NonNull String str) {
        return this.f20368a.getString(str, this.f20369b, this.f20370c);
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.equal(Integer.valueOf(dataBufferRef.f20369b), Integer.valueOf(this.f20369b)) && Objects.equal(Integer.valueOf(dataBufferRef.f20370c), Integer.valueOf(this.f20370c)) && dataBufferRef.f20368a == this.f20368a) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public boolean f(@NonNull String str) {
        return this.f20368a.hasNull(str, this.f20369b, this.f20370c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 < this.f20368a.getCount()) {
            z3 = true;
        }
        Preconditions.checkState(z3);
        this.f20369b = i4;
        this.f20370c = this.f20368a.getWindowIndex(i4);
    }

    @KeepForSdk
    public boolean hasColumn(@NonNull String str) {
        return this.f20368a.hasColumn(str);
    }

    @KeepForSdk
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20369b), Integer.valueOf(this.f20370c), this.f20368a);
    }

    @KeepForSdk
    public boolean isDataValid() {
        if (!this.f20368a.isClosed()) {
            return true;
        }
        return false;
    }
}
