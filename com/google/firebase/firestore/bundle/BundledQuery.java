package com.google.firebase.firestore.bundle;

import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;

/* loaded from: classes5.dex */
public class BundledQuery implements BundleElement {

    /* renamed from: a  reason: collision with root package name */
    private final Target f30295a;

    /* renamed from: b  reason: collision with root package name */
    private final Query.LimitType f30296b;

    public BundledQuery(Target target, Query.LimitType limitType) {
        this.f30295a = target;
        this.f30296b = limitType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BundledQuery bundledQuery = (BundledQuery) obj;
        if (this.f30295a.equals(bundledQuery.f30295a) && this.f30296b == bundledQuery.f30296b) {
            return true;
        }
        return false;
    }

    public Query.LimitType getLimitType() {
        return this.f30296b;
    }

    public Target getTarget() {
        return this.f30295a;
    }

    public int hashCode() {
        return (this.f30295a.hashCode() * 31) + this.f30296b.hashCode();
    }
}
