package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes5.dex */
public final class Precondition {
    public static final Precondition NONE = new Precondition(null, null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final SnapshotVersion f31001a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f31002b;

    private Precondition(@Nullable SnapshotVersion snapshotVersion, @Nullable Boolean bool) {
        boolean z3;
        if (snapshotVersion != null && bool != null) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f31001a = snapshotVersion;
        this.f31002b = bool;
    }

    public static Precondition exists(boolean z3) {
        return new Precondition(null, Boolean.valueOf(z3));
    }

    public static Precondition updateTime(SnapshotVersion snapshotVersion) {
        return new Precondition(snapshotVersion, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Precondition.class != obj.getClass()) {
            return false;
        }
        Precondition precondition = (Precondition) obj;
        SnapshotVersion snapshotVersion = this.f31001a;
        if (snapshotVersion == null ? precondition.f31001a != null : !snapshotVersion.equals(precondition.f31001a)) {
            return false;
        }
        Boolean bool = this.f31002b;
        Boolean bool2 = precondition.f31002b;
        if (bool != null) {
            return bool.equals(bool2);
        }
        if (bool2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Boolean getExists() {
        return this.f31002b;
    }

    @Nullable
    public SnapshotVersion getUpdateTime() {
        return this.f31001a;
    }

    public int hashCode() {
        int i4;
        SnapshotVersion snapshotVersion = this.f31001a;
        int i5 = 0;
        if (snapshotVersion != null) {
            i4 = snapshotVersion.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        Boolean bool = this.f31002b;
        if (bool != null) {
            i5 = bool.hashCode();
        }
        return i6 + i5;
    }

    public boolean isNone() {
        if (this.f31001a == null && this.f31002b == null) {
            return true;
        }
        return false;
    }

    public boolean isValidFor(MutableDocument mutableDocument) {
        if (this.f31001a != null) {
            if (mutableDocument.isFoundDocument() && mutableDocument.getVersion().equals(this.f31001a)) {
                return true;
            }
            return false;
        }
        Boolean bool = this.f31002b;
        if (bool != null) {
            if (bool.booleanValue() == mutableDocument.isFoundDocument()) {
                return true;
            }
            return false;
        }
        Assert.hardAssert(isNone(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public String toString() {
        if (isNone()) {
            return "Precondition{<none>}";
        }
        if (this.f31001a != null) {
            return "Precondition{updateTime=" + this.f31001a + "}";
        } else if (this.f31002b != null) {
            return "Precondition{exists=" + this.f31002b + "}";
        } else {
            throw Assert.fail("Invalid Precondition", new Object[0]);
        }
    }
}
