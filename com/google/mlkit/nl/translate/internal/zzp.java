package com.google.mlkit.nl.translate.internal;

import androidx.annotation.Nullable;
import java.io.File;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
final class zzp {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    String f33130a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    String f33131b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    String f33132c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ TranslateJni f33133d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzp(TranslateJni translateJni, zzo zzoVar) {
        this.f33133d = translateJni;
    }

    @Nullable
    private static final String b(File file) {
        if (!file.exists()) {
            return null;
        }
        return file.getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3) {
        TranslateJni.c(this.f33133d).a(str2, str3);
        File file = new File(str, zzaf.c(str2, str3));
        File file2 = new File(str, zzaf.b(str2, str3));
        File file3 = new File(str, zzaf.d(str2, str3));
        this.f33130a = b(file);
        this.f33131b = b(file2);
        this.f33132c = b(file3);
    }
}
