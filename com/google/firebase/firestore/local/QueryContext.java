package com.google.firebase.firestore.local;

/* loaded from: classes5.dex */
public class QueryContext {

    /* renamed from: a  reason: collision with root package name */
    private int f30691a = 0;

    public int getDocumentReadCount() {
        return this.f30691a;
    }

    public void incrementDocumentReadCount() {
        this.f30691a++;
    }
}
