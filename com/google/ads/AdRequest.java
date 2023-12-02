package com.google.ads;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class AdRequest {
    @NonNull
    public static final String LOGTAG = "Ads";
    @NonNull
    public static final String TEST_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    @NonNull
    public static final String VERSION = "0.0.0";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes3.dex */
    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String zzb;

        ErrorCode(String str) {
            this.zzb = str;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return this.zzb;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes3.dex */
    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    private AdRequest() {
    }
}
