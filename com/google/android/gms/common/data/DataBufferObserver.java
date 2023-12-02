package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public interface DataBufferObserver {

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public interface Observable {
        void addObserver(@NonNull DataBufferObserver dataBufferObserver);

        void removeObserver(@NonNull DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(int i4, int i5);

    void onDataRangeInserted(int i4, int i5);

    void onDataRangeMoved(int i4, int i5, int i6);

    void onDataRangeRemoved(int i4, int i5);
}
