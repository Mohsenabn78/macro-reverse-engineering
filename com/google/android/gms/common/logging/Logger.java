package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private final String f20595a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20596b;

    /* renamed from: c  reason: collision with root package name */
    private final GmsLogger f20597c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20598d;

    @KeepForSdk
    public Logger(@NonNull String str, @NonNull String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.f20596b = sb;
        this.f20595a = str;
        this.f20597c = new GmsLogger(str);
        int i4 = 2;
        while (i4 <= 7 && !Log.isLoggable(this.f20595a, i4)) {
            i4++;
        }
        this.f20598d = i4;
    }

    @NonNull
    @KeepForSdk
    protected String a(@NonNull String str, @NonNull Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f20596b.concat(str);
    }

    @KeepForSdk
    public void d(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(3)) {
            a(str, objArr);
        }
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.e(this.f20595a, a(str, objArr), th);
    }

    @NonNull
    @KeepForSdk
    public String getTag() {
        return this.f20595a;
    }

    @KeepForSdk
    public void i(@NonNull String str, @NonNull Object... objArr) {
        Log.i(this.f20595a, a(str, objArr));
    }

    @KeepForSdk
    public boolean isLoggable(int i4) {
        if (this.f20598d <= i4) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            a(str, objArr);
        }
    }

    @KeepForSdk
    public void w(@NonNull String str, @NonNull Object... objArr) {
        Log.w(this.f20595a, a(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull String str, @NonNull Throwable th, @NonNull Object... objArr) {
        Log.wtf(this.f20595a, a(str, objArr), th);
    }

    @KeepForSdk
    public void e(@NonNull String str, @NonNull Object... objArr) {
        Log.e(this.f20595a, a(str, objArr));
    }

    @KeepForSdk
    public void wtf(@NonNull Throwable th) {
        Log.wtf(this.f20595a, th);
    }

    @KeepForSdk
    public void v(@NonNull String str, @NonNull Object... objArr) {
        if (isLoggable(2)) {
            a(str, objArr);
        }
    }
}
