package com.google.firebase.firestore.core;

/* loaded from: classes5.dex */
public class ListenSequence {
    public static final long INVALID = -1;

    /* renamed from: a  reason: collision with root package name */
    private long f30367a;

    public ListenSequence(long j4) {
        this.f30367a = j4;
    }

    public long next() {
        long j4 = this.f30367a + 1;
        this.f30367a = j4;
        return j4;
    }
}
