package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public class AdRequest {
    @NonNull
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_AD_STRING = 11;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_REQUEST_ID_MISMATCH = 10;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;

    /* renamed from: a  reason: collision with root package name */
    protected final zzdx f18960a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        protected final zzdw f18961a;

        public Builder() {
            zzdw zzdwVar = new zzdw();
            this.f18961a = zzdwVar;
            zzdwVar.zzv("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        @NonNull
        @Deprecated
        public Builder addCustomEventExtrasBundle(@NonNull Class<? extends CustomEvent> cls, @NonNull Bundle bundle) {
            this.f18961a.zzq(cls, bundle);
            return this;
        }

        @NonNull
        public Builder addKeyword(@NonNull String str) {
            this.f18961a.zzs(str);
            return this;
        }

        @NonNull
        public Builder addNetworkExtrasBundle(@NonNull Class<? extends MediationExtrasReceiver> cls, @NonNull Bundle bundle) {
            this.f18961a.zzt(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f18961a.zzw("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        @NonNull
        public AdRequest build() {
            return new AdRequest(this);
        }

        @NonNull
        public Builder setAdString(@NonNull String str) {
            this.f18961a.zzx(str);
            return this;
        }

        @NonNull
        public Builder setContentUrl(@NonNull String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            int length = str.length();
            boolean z3 = false;
            Object[] objArr = {512, Integer.valueOf(str.length())};
            if (length <= 512) {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
            this.f18961a.zzz(str);
            return this;
        }

        @NonNull
        public Builder setHttpTimeoutMillis(int i4) {
            this.f18961a.zzB(i4);
            return this;
        }

        @NonNull
        public Builder setNeighboringContentUrls(@NonNull List<String> list) {
            if (list == null) {
                zzbzr.zzj("neighboring content URLs list should not be null");
                return this;
            }
            this.f18961a.zzD(list);
            return this;
        }

        @NonNull
        public Builder setRequestAgent(@NonNull String str) {
            this.f18961a.zzF(str);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zza(@NonNull String str) {
            this.f18961a.zzv(str);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zzb(@NonNull Date date) {
            this.f18961a.zzy(date);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zzc(int i4) {
            this.f18961a.zzA(i4);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zzd(boolean z3) {
            this.f18961a.zzC(z3);
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zze(boolean z3) {
            this.f18961a.zzG(z3);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdRequest(@NonNull Builder builder) {
        this.f18960a = new zzdx(builder.f18961a, null);
    }

    @Nullable
    public String getAdString() {
        return this.f18960a.zzj();
    }

    @NonNull
    public String getContentUrl() {
        return this.f18960a.zzk();
    }

    @Nullable
    @Deprecated
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(@NonNull Class<T> cls) {
        return this.f18960a.zzd(cls);
    }

    @NonNull
    public Bundle getCustomTargeting() {
        return this.f18960a.zze();
    }

    @NonNull
    public Set<String> getKeywords() {
        return this.f18960a.zzq();
    }

    @NonNull
    public List<String> getNeighboringContentUrls() {
        return this.f18960a.zzo();
    }

    @Nullable
    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(@NonNull Class<T> cls) {
        return this.f18960a.zzf(cls);
    }

    @NonNull
    public String getRequestAgent() {
        return this.f18960a.zzm();
    }

    public boolean isTestDevice(@NonNull Context context) {
        return this.f18960a.zzs(context);
    }

    public final zzdx zza() {
        return this.f18960a;
    }
}
