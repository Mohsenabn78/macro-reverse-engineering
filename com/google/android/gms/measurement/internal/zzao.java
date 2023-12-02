package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzao extends zzgx {

    /* renamed from: c  reason: collision with root package name */
    private long f21460c;

    /* renamed from: d  reason: collision with root package name */
    private String f21461d;

    /* renamed from: e  reason: collision with root package name */
    private AccountManager f21462e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f21463f;

    /* renamed from: g  reason: collision with root package name */
    private long f21464g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(zzgd zzgdVar) {
        super(zzgdVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    protected final boolean b() {
        Calendar calendar = Calendar.getInstance();
        this.f21460c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        this.f21461d = lowerCase + "-" + lowerCase2;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final long d() {
        zzg();
        return this.f21464g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void e() {
        zzg();
        this.f21463f = null;
        this.f21464g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final boolean f() {
        Account[] result;
        zzg();
        long currentTimeMillis = this.f21734a.zzax().currentTimeMillis();
        if (currentTimeMillis - this.f21464g > 86400000) {
            this.f21463f = null;
        }
        Boolean bool = this.f21463f;
        if (bool == null) {
            if (ContextCompat.checkSelfPermission(this.f21734a.zzaw(), "android.permission.GET_ACCOUNTS") != 0) {
                this.f21734a.zzaA().zzm().zza("Permission error checking for dasher/unicorn accounts");
                this.f21464g = currentTimeMillis;
                this.f21463f = Boolean.FALSE;
                return false;
            }
            if (this.f21462e == null) {
                this.f21462e = AccountManager.get(this.f21734a.zzaw());
            }
            try {
                result = this.f21462e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            } catch (AuthenticatorException | OperationCanceledException | IOException e4) {
                this.f21734a.zzaA().zzh().zzb("Exception checking account types", e4);
            }
            if (result != null && result.length > 0) {
                this.f21463f = Boolean.TRUE;
                this.f21464g = currentTimeMillis;
                return true;
            }
            Account[] result2 = this.f21462e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.f21463f = Boolean.TRUE;
                this.f21464g = currentTimeMillis;
                return true;
            }
            this.f21464g = currentTimeMillis;
            this.f21463f = Boolean.FALSE;
            return false;
        }
        return bool.booleanValue();
    }

    public final long zzb() {
        c();
        return this.f21460c;
    }

    public final String zzc() {
        c();
        return this.f21461d;
    }
}
