package com.google.firebase.functions;

import androidx.annotation.GuardedBy;
import com.google.firebase.functions.dagger.assisted.Assisted;
import com.google.firebase.functions.dagger.assisted.AssistedFactory;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
@Singleton
/* loaded from: classes5.dex */
public class FunctionsMultiResourceComponent {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseFunctions> f31378a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseFunctionsFactory f31379b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @AssistedFactory
    /* loaded from: classes5.dex */
    public interface FirebaseFunctionsFactory {
        FirebaseFunctions create(@Assisted String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FunctionsMultiResourceComponent(FirebaseFunctionsFactory firebaseFunctionsFactory) {
        this.f31379b = firebaseFunctionsFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized FirebaseFunctions a(String str) {
        FirebaseFunctions firebaseFunctions;
        firebaseFunctions = this.f31378a.get(str);
        if (firebaseFunctions == null) {
            firebaseFunctions = this.f31379b.create(str);
            this.f31378a.put(str, firebaseFunctions);
        }
        return firebaseFunctions;
    }
}
