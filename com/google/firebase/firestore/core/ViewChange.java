package com.google.firebase.firestore.core;

import java.util.List;

/* loaded from: classes5.dex */
public class ViewChange {

    /* renamed from: a  reason: collision with root package name */
    private final ViewSnapshot f30467a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LimboDocumentChange> f30468b;

    public ViewChange(ViewSnapshot viewSnapshot, List<LimboDocumentChange> list) {
        this.f30467a = viewSnapshot;
        this.f30468b = list;
    }

    public List<LimboDocumentChange> getLimboChanges() {
        return this.f30468b;
    }

    public ViewSnapshot getSnapshot() {
        return this.f30467a;
    }
}
