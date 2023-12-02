package com.sun.mail.imap;

import com.sun.mail.imap.protocol.UIDSet;

/* loaded from: classes6.dex */
public class ResyncData {
    public static final ResyncData CONDSTORE = new ResyncData(-1, -1);

    /* renamed from: a  reason: collision with root package name */
    private long f37804a;

    /* renamed from: b  reason: collision with root package name */
    private long f37805b;

    /* renamed from: c  reason: collision with root package name */
    private UIDSet[] f37806c;

    public ResyncData(long j4, long j5) {
        this.f37804a = j4;
        this.f37805b = j5;
        this.f37806c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UIDSet[] a() {
        return this.f37806c;
    }

    public long getModSeq() {
        return this.f37805b;
    }

    public long getUIDValidity() {
        return this.f37804a;
    }

    public ResyncData(long j4, long j5, long j6, long j7) {
        this.f37806c = null;
        this.f37804a = j4;
        this.f37805b = j5;
        this.f37806c = new UIDSet[]{new UIDSet(j6, j7)};
    }

    public ResyncData(long j4, long j5, long[] jArr) {
        this.f37806c = null;
        this.f37804a = j4;
        this.f37805b = j5;
        this.f37806c = UIDSet.createUIDSets(jArr);
    }
}
