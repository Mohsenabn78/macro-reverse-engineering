package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

/* loaded from: classes5.dex */
public class ListenerRegistrationImpl implements ListenerRegistration {

    /* renamed from: a  reason: collision with root package name */
    private final FirestoreClient f30368a;

    /* renamed from: b  reason: collision with root package name */
    private final QueryListener f30369b;

    /* renamed from: c  reason: collision with root package name */
    private final AsyncEventListener<ViewSnapshot> f30370c;

    public ListenerRegistrationImpl(FirestoreClient firestoreClient, QueryListener queryListener, AsyncEventListener<ViewSnapshot> asyncEventListener) {
        this.f30368a = firestoreClient;
        this.f30369b = queryListener;
        this.f30370c = asyncEventListener;
    }

    @Override // com.google.firebase.firestore.ListenerRegistration
    public void remove() {
        this.f30370c.mute();
        this.f30368a.stopListening(this.f30369b);
    }
}
