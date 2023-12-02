package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Assert;

/* loaded from: classes5.dex */
public class TargetIdGenerator {

    /* renamed from: a  reason: collision with root package name */
    private int f30426a;

    /* renamed from: b  reason: collision with root package name */
    private int f30427b;

    TargetIdGenerator(int i4, int i5) {
        boolean z3;
        if ((i4 & 1) == i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i4), 1);
        this.f30427b = i4;
        a(i5);
    }

    private void a(int i4) {
        boolean z3;
        if ((i4 & 1) == this.f30427b) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Cannot supply target ID from different generator ID", new Object[0]);
        this.f30426a = i4;
    }

    public static TargetIdGenerator forSyncEngine() {
        return new TargetIdGenerator(1, 1);
    }

    public static TargetIdGenerator forTargetCache(int i4) {
        TargetIdGenerator targetIdGenerator = new TargetIdGenerator(0, i4);
        targetIdGenerator.nextId();
        return targetIdGenerator;
    }

    public int nextId() {
        int i4 = this.f30426a;
        this.f30426a = i4 + 2;
        return i4;
    }
}
