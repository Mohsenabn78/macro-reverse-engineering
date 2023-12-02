package com.google.firebase.auth;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class PhoneAuthOptions {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseAuth f28913a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f28914b;

    /* renamed from: c  reason: collision with root package name */
    private final PhoneAuthProvider.OnVerificationStateChangedCallbacks f28915c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f28916d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f28917e;

    /* renamed from: f  reason: collision with root package name */
    private final Activity f28918f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final PhoneAuthProvider.ForceResendingToken f28919g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final MultiFactorSession f28920h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final PhoneMultiFactorInfo f28921i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f28922j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f28923k;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final FirebaseAuth f28924a;

        /* renamed from: b  reason: collision with root package name */
        private String f28925b;

        /* renamed from: c  reason: collision with root package name */
        private Long f28926c;

        /* renamed from: d  reason: collision with root package name */
        private PhoneAuthProvider.OnVerificationStateChangedCallbacks f28927d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f28928e;

        /* renamed from: f  reason: collision with root package name */
        private Activity f28929f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private PhoneAuthProvider.ForceResendingToken f28930g;

        /* renamed from: h  reason: collision with root package name */
        private MultiFactorSession f28931h;

        /* renamed from: i  reason: collision with root package name */
        private PhoneMultiFactorInfo f28932i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f28933j;

        public Builder(@NonNull FirebaseAuth firebaseAuth) {
            this.f28924a = (FirebaseAuth) Preconditions.checkNotNull(firebaseAuth);
        }

        @NonNull
        public PhoneAuthOptions build() {
            boolean z3;
            Preconditions.checkNotNull(this.f28924a, "FirebaseAuth instance cannot be null");
            Preconditions.checkNotNull(this.f28926c, "You must specify an auto-retrieval timeout; please call #setTimeout()");
            Preconditions.checkNotNull(this.f28927d, "You must specify callbacks on your PhoneAuthOptions. Please call #setCallbacks()");
            this.f28928e = this.f28924a.zzN();
            if (this.f28926c.longValue() >= 0 && this.f28926c.longValue() <= 120) {
                MultiFactorSession multiFactorSession = this.f28931h;
                boolean z4 = false;
                if (multiFactorSession == null) {
                    Preconditions.checkNotEmpty(this.f28925b, "The given phoneNumber is empty. Please set a non-empty phone number with #setPhoneNumber()");
                    Preconditions.checkArgument(!this.f28933j, "You cannot require sms validation without setting a multi-factor session.");
                    if (this.f28932i == null) {
                        z4 = true;
                    }
                    Preconditions.checkArgument(z4, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                } else if (((com.google.firebase.auth.internal.zzag) multiFactorSession).zzf()) {
                    Preconditions.checkNotEmpty(this.f28925b);
                    if (this.f28932i == null) {
                        z4 = true;
                    }
                    Preconditions.checkArgument(z4, "Invalid MultiFactorSession - use the getSession method in MultiFactorResolver to get a valid sign-in session.");
                } else {
                    if (this.f28932i != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkArgument(z3, "A phoneMultiFactorInfo must be set for second factor sign-in.");
                    if (this.f28925b == null) {
                        z4 = true;
                    }
                    Preconditions.checkArgument(z4, "A phone number must not be set for MFA sign-in. A PhoneMultiFactorInfo should be set instead.");
                }
                return new PhoneAuthOptions(this.f28924a, this.f28926c, this.f28927d, this.f28928e, this.f28925b, this.f28929f, this.f28930g, this.f28931h, this.f28932i, this.f28933j, null);
            }
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }

        @NonNull
        public Builder requireSmsValidation(boolean z3) {
            this.f28933j = z3;
            return this;
        }

        @NonNull
        public Builder setActivity(@NonNull Activity activity) {
            this.f28929f = activity;
            return this;
        }

        @NonNull
        public Builder setCallbacks(@NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
            this.f28927d = onVerificationStateChangedCallbacks;
            return this;
        }

        @NonNull
        public Builder setForceResendingToken(@NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            this.f28930g = forceResendingToken;
            return this;
        }

        @NonNull
        public Builder setMultiFactorHint(@NonNull PhoneMultiFactorInfo phoneMultiFactorInfo) {
            this.f28932i = phoneMultiFactorInfo;
            return this;
        }

        @NonNull
        public Builder setMultiFactorSession(@NonNull MultiFactorSession multiFactorSession) {
            this.f28931h = multiFactorSession;
            return this;
        }

        @NonNull
        public Builder setPhoneNumber(@NonNull String str) {
            this.f28925b = str;
            return this;
        }

        @NonNull
        public Builder setTimeout(@NonNull Long l4, @NonNull TimeUnit timeUnit) {
            this.f28926c = Long.valueOf(TimeUnit.SECONDS.convert(l4.longValue(), timeUnit));
            return this;
        }
    }

    /* synthetic */ PhoneAuthOptions(FirebaseAuth firebaseAuth, Long l4, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, String str, Activity activity, PhoneAuthProvider.ForceResendingToken forceResendingToken, MultiFactorSession multiFactorSession, PhoneMultiFactorInfo phoneMultiFactorInfo, boolean z3, zzar zzarVar) {
        this.f28913a = firebaseAuth;
        this.f28917e = str;
        this.f28914b = l4;
        this.f28915c = onVerificationStateChangedCallbacks;
        this.f28918f = activity;
        this.f28916d = executor;
        this.f28919g = forceResendingToken;
        this.f28920h = multiFactorSession;
        this.f28921i = phoneMultiFactorInfo;
        this.f28922j = z3;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(FirebaseAuth.getInstance());
    }

    @Nullable
    public final Activity zza() {
        return this.f28918f;
    }

    @NonNull
    public final FirebaseAuth zzb() {
        return this.f28913a;
    }

    @Nullable
    public final MultiFactorSession zzc() {
        return this.f28920h;
    }

    @Nullable
    public final PhoneAuthProvider.ForceResendingToken zzd() {
        return this.f28919g;
    }

    @NonNull
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks zze() {
        return this.f28915c;
    }

    @Nullable
    public final PhoneMultiFactorInfo zzf() {
        return this.f28921i;
    }

    @NonNull
    public final Long zzg() {
        return this.f28914b;
    }

    @Nullable
    public final String zzh() {
        return this.f28917e;
    }

    @NonNull
    public final Executor zzi() {
        return this.f28916d;
    }

    public final void zzj(boolean z3) {
        this.f28923k = true;
    }

    public final boolean zzk() {
        return this.f28923k;
    }

    public final boolean zzl() {
        return this.f28922j;
    }

    public final boolean zzm() {
        if (this.f28920h != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public static Builder newBuilder(@NonNull FirebaseAuth firebaseAuth) {
        return new Builder(firebaseAuth);
    }
}
