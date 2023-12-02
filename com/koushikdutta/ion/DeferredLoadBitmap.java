package com.koushikdutta.ion;

/* loaded from: classes6.dex */
public class DeferredLoadBitmap extends a {
    public static int DEFER_COUNTER;

    /* renamed from: d  reason: collision with root package name */
    b f35696d;

    /* renamed from: e  reason: collision with root package name */
    int f35697e;

    public DeferredLoadBitmap(Ion ion, String str, b bVar) {
        super(ion, str, false);
        int i4 = DEFER_COUNTER + 1;
        DEFER_COUNTER = i4;
        this.f35697e = i4;
        this.f35696d = bVar;
    }
}
