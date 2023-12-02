package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class UwbComplexChannel {

    /* renamed from: a  reason: collision with root package name */
    private final int f22544a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22545b;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f22546a;

        /* renamed from: b  reason: collision with root package name */
        private int f22547b;

        @NonNull
        public UwbComplexChannel build() {
            return new UwbComplexChannel(this.f22546a, this.f22547b, null);
        }

        @NonNull
        public Builder setChannel(int i4) {
            this.f22546a = i4;
            return this;
        }

        @NonNull
        public Builder setPreambleIndex(int i4) {
            this.f22547b = i4;
            return this;
        }
    }

    /* synthetic */ UwbComplexChannel(int i4, int i5, zzb zzbVar) {
        this.f22544a = i4;
        this.f22545b = i5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbComplexChannel)) {
            return false;
        }
        UwbComplexChannel uwbComplexChannel = (UwbComplexChannel) obj;
        if (this.f22544a == uwbComplexChannel.f22544a && this.f22545b == uwbComplexChannel.f22545b) {
            return true;
        }
        return false;
    }

    public int getChannel() {
        return this.f22544a;
    }

    public int getPreambleIndex() {
        return this.f22545b;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22544a), Integer.valueOf(this.f22545b));
    }

    @NonNull
    public String toString() {
        int i4 = this.f22544a;
        int i5 = this.f22545b;
        return "UwbComplexChannel{channel=" + i4 + ", preambleIndex=" + i5 + "}";
    }
}
