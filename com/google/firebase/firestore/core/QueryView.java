package com.google.firebase.firestore.core;

/* loaded from: classes5.dex */
final class QueryView {

    /* renamed from: a  reason: collision with root package name */
    private final Query f30396a;

    /* renamed from: b  reason: collision with root package name */
    private final int f30397b;

    /* renamed from: c  reason: collision with root package name */
    private final View f30398c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QueryView(Query query, int i4, View view) {
        this.f30396a = query;
        this.f30397b = i4;
        this.f30398c = view;
    }

    public Query a() {
        return this.f30396a;
    }

    public int b() {
        return this.f30397b;
    }

    public View c() {
        return this.f30398c;
    }
}
