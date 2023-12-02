package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TotpSecret;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbw implements TotpSecret {

    /* renamed from: a  reason: collision with root package name */
    private final String f29047a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29048b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29049c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29050d;

    /* renamed from: e  reason: collision with root package name */
    private final long f29051e;

    /* renamed from: f  reason: collision with root package name */
    final String f29052f;

    /* renamed from: g  reason: collision with root package name */
    final FirebaseAuth f29053g;

    public zzbw(String str, String str2, int i4, int i5, long j4, String str3, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str3, "sessionInfo cannot be empty.");
        Preconditions.checkNotNull(firebaseAuth, "firebaseAuth cannot be null.");
        this.f29047a = Preconditions.checkNotEmpty(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.f29048b = Preconditions.checkNotEmpty(str2, "hashAlgorithm cannot be empty.");
        this.f29049c = i4;
        this.f29050d = i5;
        this.f29051e = j4;
        this.f29052f = str3;
        this.f29053g = firebaseAuth;
    }

    private final void a(String str) {
        this.f29053g.getApp().getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    private static final void b(String str, Activity activity) {
        Preconditions.checkNotNull(activity, "Activity cannot be null.");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String generateQrCodeUrl() {
        String checkNotEmpty = Preconditions.checkNotEmpty(((FirebaseUser) Preconditions.checkNotNull(this.f29053g.getCurrentUser(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).getEmail(), "Email cannot be empty, since verified email is required to use MFA.");
        String name = this.f29053g.getApp().getName();
        Preconditions.checkNotEmpty(checkNotEmpty, "accountName cannot be empty.");
        Preconditions.checkNotEmpty(name, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", name, checkNotEmpty, this.f29047a, name, this.f29048b, Integer.valueOf(this.f29049c));
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final int getCodeIntervalSeconds() {
        return this.f29050d;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final int getCodeLength() {
        return this.f29049c;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final long getEnrollmentCompletionDeadline() {
        return this.f29051e;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getHashAlgorithm() {
        return this.f29048b;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getSessionInfo() {
        return this.f29052f;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String getSharedSecretKey() {
        return this.f29047a;
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final void openInOtpApp(String str) {
        Preconditions.checkNotEmpty(str, "qrCodeUrl cannot be empty.");
        try {
            a(str);
        } catch (ActivityNotFoundException unused) {
            a("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final void openInOtpApp(String str, String str2, Activity activity) {
        Preconditions.checkNotEmpty(str, "QrCodeUrl cannot be empty.");
        Preconditions.checkNotEmpty(str2, "FallbackUrl cannot be empty.");
        Preconditions.checkNotNull(activity, "Activity cannot be null.");
        try {
            b(str, activity);
        } catch (ActivityNotFoundException unused) {
            b(str2, activity);
        }
    }

    @Override // com.google.firebase.auth.TotpSecret
    public final String generateQrCodeUrl(String str, String str2) {
        Preconditions.checkNotEmpty(str, "accountName cannot be empty.");
        Preconditions.checkNotEmpty(str2, "issuer cannot be empty.");
        return String.format(null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", str2, str, this.f29047a, str2, this.f29048b, Integer.valueOf(this.f29049c));
    }
}
