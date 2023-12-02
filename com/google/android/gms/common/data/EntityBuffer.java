package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20385a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f20386b;

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.f20385a = false;
    }

    private final void f() {
        synchronized (this) {
            if (!this.f20385a) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList arrayList = new ArrayList();
                this.f20386b = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String d4 = d();
                    String string = this.mDataHolder.getString(d4, 0, this.mDataHolder.getWindowIndex(0));
                    for (int i4 = 1; i4 < count; i4++) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i4);
                        String string2 = this.mDataHolder.getString(d4, i4, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.f20386b.add(Integer.valueOf(i4));
                                string = string2;
                            }
                        } else {
                            throw new NullPointerException("Missing value for markerColumn: " + d4 + ", at row: " + i4 + ", for window: " + windowIndex);
                        }
                    }
                }
                this.f20385a = true;
            }
        }
    }

    @Nullable
    @KeepForSdk
    protected String b() {
        return null;
    }

    @NonNull
    @KeepForSdk
    protected abstract T c(int i4, int i5);

    @NonNull
    @KeepForSdk
    protected abstract String d();

    final int e(int i4) {
        if (i4 >= 0 && i4 < this.f20386b.size()) {
            return ((Integer) this.f20386b.get(i4)).intValue();
        }
        throw new IllegalArgumentException("Position " + i4 + " is out of bounds for this buffer");
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final T get(int i4) {
        int intValue;
        int intValue2;
        f();
        int e4 = e(i4);
        int i5 = 0;
        if (i4 >= 0 && i4 != this.f20386b.size()) {
            if (i4 == this.f20386b.size() - 1) {
                intValue = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                intValue2 = ((Integer) this.f20386b.get(i4)).intValue();
            } else {
                intValue = ((Integer) this.f20386b.get(i4 + 1)).intValue();
                intValue2 = ((Integer) this.f20386b.get(i4)).intValue();
            }
            int i6 = intValue - intValue2;
            if (i6 == 1) {
                int e5 = e(i4);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(e5);
                String b4 = b();
                if (b4 == null || this.mDataHolder.getString(b4, e5, windowIndex) != null) {
                    i5 = 1;
                }
            } else {
                i5 = i6;
            }
        }
        return c(e4, i5);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        f();
        return this.f20386b.size();
    }
}
