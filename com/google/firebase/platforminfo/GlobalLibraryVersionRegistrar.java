package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class GlobalLibraryVersionRegistrar {

    /* renamed from: b  reason: collision with root package name */
    private static volatile GlobalLibraryVersionRegistrar f31867b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<LibraryVersion> f31868a = new HashSet();

    GlobalLibraryVersionRegistrar() {
    }

    public static GlobalLibraryVersionRegistrar getInstance() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = f31867b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = f31867b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    f31867b = globalLibraryVersionRegistrar;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<LibraryVersion> a() {
        Set<LibraryVersion> unmodifiableSet;
        synchronized (this.f31868a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f31868a);
        }
        return unmodifiableSet;
    }

    public void registerVersion(String str, String str2) {
        synchronized (this.f31868a) {
            this.f31868a.add(LibraryVersion.a(str, str2));
        }
    }
}
