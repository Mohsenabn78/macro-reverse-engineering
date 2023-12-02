package com.google.firebase.appindexing.internal;

import android.os.Parcelable;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzab implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    static final Comparator f28800a = new zzab();

    private zzab() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        Parcelable.Creator<Thing> creator = Thing.CREATOR;
        if (str == null) {
            if (str2 != null) {
                return -1;
            }
            return 0;
        } else if (str2 == null) {
            return 1;
        } else {
            return str.compareTo(str2);
        }
    }
}
