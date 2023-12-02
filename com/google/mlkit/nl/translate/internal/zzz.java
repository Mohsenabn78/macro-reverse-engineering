package com.google.mlkit.nl.translate.internal;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzz {

    /* renamed from: a  reason: collision with root package name */
    private double f33141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void b(zzz zzzVar) {
        double max = Math.max(zzzVar.f33141a, 0.5d);
        double d4 = max + max;
        zzzVar.f33141a = d4;
        if (d4 > 60.0d) {
            zzzVar.f33141a = 60.0d;
            d4 = 60.0d;
        }
        zzzVar.f33141a = d4 + (Math.random() * zzzVar.f33141a);
    }
}
