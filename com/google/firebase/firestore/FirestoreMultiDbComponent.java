package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.inject.Deferred;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class FirestoreMultiDbComponent implements FirebaseAppLifecycleListener, FirebaseFirestore.InstanceRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseFirestore> f30186a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f30187b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f30188c;

    /* renamed from: d  reason: collision with root package name */
    private final Deferred<InternalAuthProvider> f30189d;

    /* renamed from: e  reason: collision with root package name */
    private final Deferred<InteropAppCheckTokenProvider> f30190e;

    /* renamed from: f  reason: collision with root package name */
    private final GrpcMetadataProvider f30191f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirestoreMultiDbComponent(@NonNull Context context, @NonNull FirebaseApp firebaseApp, @NonNull Deferred<InternalAuthProvider> deferred, @NonNull Deferred<InteropAppCheckTokenProvider> deferred2, @Nullable GrpcMetadataProvider grpcMetadataProvider) {
        this.f30188c = context;
        this.f30187b = firebaseApp;
        this.f30189d = deferred;
        this.f30190e = deferred2;
        this.f30191f = grpcMetadataProvider;
        firebaseApp.addLifecycleEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseFirestore a(@NonNull String str) {
        FirebaseFirestore firebaseFirestore;
        firebaseFirestore = this.f30186a.get(str);
        if (firebaseFirestore == null) {
            firebaseFirestore = FirebaseFirestore.t(this.f30188c, this.f30187b, this.f30189d, this.f30190e, str, this, this.f30191f);
            this.f30186a.put(str, firebaseFirestore);
        }
        return firebaseFirestore;
    }

    @Override // com.google.firebase.FirebaseAppLifecycleListener
    public synchronized void onDeleted(String str, FirebaseOptions firebaseOptions) {
        boolean z3;
        Iterator it = new ArrayList(this.f30186a.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((FirebaseFirestore) entry.getValue()).terminate();
            if (!this.f30186a.containsKey(entry.getKey())) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "terminate() should have removed its entry from `instances` for key: %s", entry.getKey());
        }
    }

    @Override // com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry
    public synchronized void remove(@NonNull String str) {
        this.f30186a.remove(str);
    }
}
