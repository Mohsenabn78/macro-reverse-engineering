package com.firebase.ui.auth.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public final class Resource<T> {

    /* renamed from: a  reason: collision with root package name */
    private final State f17977a;

    /* renamed from: b  reason: collision with root package name */
    private final T f17978b;

    /* renamed from: c  reason: collision with root package name */
    private final Exception f17979c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17980d;

    private Resource(State state, T t3, Exception exc) {
        this.f17977a = state;
        this.f17978b = t3;
        this.f17979c = exc;
    }

    @NonNull
    public static <T> Resource<T> forFailure(@NonNull Exception exc) {
        return new Resource<>(State.FAILURE, null, exc);
    }

    @NonNull
    public static <T> Resource<T> forLoading() {
        return new Resource<>(State.LOADING, null, null);
    }

    @NonNull
    public static <T> Resource<T> forSuccess(@NonNull T t3) {
        return new Resource<>(State.SUCCESS, t3, null);
    }

    public boolean equals(Object obj) {
        T t3;
        if (this == obj) {
            return true;
        }
        if (obj == null || Resource.class != obj.getClass()) {
            return false;
        }
        Resource resource = (Resource) obj;
        if (this.f17977a == resource.f17977a && ((t3 = this.f17978b) != null ? t3.equals(resource.f17978b) : resource.f17978b == null)) {
            Exception exc = this.f17979c;
            Exception exc2 = resource.f17979c;
            if (exc == null) {
                if (exc2 == null) {
                    return true;
                }
            } else if (exc.equals(exc2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final Exception getException() {
        this.f17980d = true;
        return this.f17979c;
    }

    @NonNull
    public State getState() {
        return this.f17977a;
    }

    @Nullable
    public T getValue() {
        this.f17980d = true;
        return this.f17978b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.f17977a.hashCode() * 31;
        T t3 = this.f17978b;
        int i4 = 0;
        if (t3 == null) {
            hashCode = 0;
        } else {
            hashCode = t3.hashCode();
        }
        int i5 = (hashCode2 + hashCode) * 31;
        Exception exc = this.f17979c;
        if (exc != null) {
            i4 = exc.hashCode();
        }
        return i5 + i4;
    }

    public boolean isUsed() {
        return this.f17980d;
    }

    public String toString() {
        return "Resource{mState=" + this.f17977a + ", mValue=" + this.f17978b + ", mException=" + this.f17979c + '}';
    }
}
