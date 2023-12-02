package com.google.android.gms.internal.places;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzdp extends RuntimeException {
    private final List<String> zzmg;

    public zzdp(zzck zzckVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzmg = null;
    }
}
