package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class AndroidClientInfo {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        @NonNull
        public abstract AndroidClientInfo build();

        @NonNull
        public abstract Builder setApplicationBuild(@Nullable String str);

        @NonNull
        public abstract Builder setCountry(@Nullable String str);

        @NonNull
        public abstract Builder setDevice(@Nullable String str);

        @NonNull
        public abstract Builder setFingerprint(@Nullable String str);

        @NonNull
        public abstract Builder setHardware(@Nullable String str);

        @NonNull
        public abstract Builder setLocale(@Nullable String str);

        @NonNull
        public abstract Builder setManufacturer(@Nullable String str);

        @NonNull
        public abstract Builder setMccMnc(@Nullable String str);

        @NonNull
        public abstract Builder setModel(@Nullable String str);

        @NonNull
        public abstract Builder setOsBuild(@Nullable String str);

        @NonNull
        public abstract Builder setProduct(@Nullable String str);

        @NonNull
        public abstract Builder setSdkVersion(@Nullable Integer num);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_AndroidClientInfo.Builder();
    }

    @Nullable
    public abstract String getApplicationBuild();

    @Nullable
    public abstract String getCountry();

    @Nullable
    public abstract String getDevice();

    @Nullable
    public abstract String getFingerprint();

    @Nullable
    public abstract String getHardware();

    @Nullable
    public abstract String getLocale();

    @Nullable
    public abstract String getManufacturer();

    @Nullable
    public abstract String getMccMnc();

    @Nullable
    public abstract String getModel();

    @Nullable
    public abstract String getOsBuild();

    @Nullable
    public abstract String getProduct();

    @Nullable
    public abstract Integer getSdkVersion();
}
