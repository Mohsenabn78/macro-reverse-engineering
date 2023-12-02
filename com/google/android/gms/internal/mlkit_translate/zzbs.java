package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public class zzbs extends RuntimeException {
    public zzbs(String str) {
        super("Did not consume the entire document.");
    }

    public zzbs(String str, Throwable th) {
        super(str, th);
    }

    public zzbs(Throwable th) {
        super(th);
    }
}
