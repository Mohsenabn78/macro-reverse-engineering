package com.araujo.jordan.excuseme.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PermissionStatus.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003J)\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/araujo/jordan/excuseme/model/PermissionStatus;", "", "", "", "component1", "component2", "granted", "denied", "copy", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/util/List;", "getGranted", "()Ljava/util/List;", "setGranted", "(Ljava/util/List;)V", "b", "getDenied", "setDenied", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/util/List;Ljava/util/List;)V", "excuseme_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class PermissionStatus {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<String> f1920a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private List<String> f1921b;

    public PermissionStatus() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PermissionStatus copy$default(PermissionStatus permissionStatus, List list, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = permissionStatus.f1920a;
        }
        if ((i4 & 2) != 0) {
            list2 = permissionStatus.f1921b;
        }
        return permissionStatus.copy(list, list2);
    }

    @NotNull
    public final List<String> component1() {
        return this.f1920a;
    }

    @NotNull
    public final List<String> component2() {
        return this.f1921b;
    }

    @NotNull
    public final PermissionStatus copy(@NotNull List<String> granted, @NotNull List<String> denied) {
        Intrinsics.checkParameterIsNotNull(granted, "granted");
        Intrinsics.checkParameterIsNotNull(denied, "denied");
        return new PermissionStatus(granted, denied);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PermissionStatus) {
                PermissionStatus permissionStatus = (PermissionStatus) obj;
                if (!Intrinsics.areEqual(this.f1920a, permissionStatus.f1920a) || !Intrinsics.areEqual(this.f1921b, permissionStatus.f1921b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<String> getDenied() {
        return this.f1921b;
    }

    @NotNull
    public final List<String> getGranted() {
        return this.f1920a;
    }

    public int hashCode() {
        int i4;
        List<String> list = this.f1920a;
        int i5 = 0;
        if (list != null) {
            i4 = list.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        List<String> list2 = this.f1921b;
        if (list2 != null) {
            i5 = list2.hashCode();
        }
        return i6 + i5;
    }

    public final void setDenied(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f1921b = list;
    }

    public final void setGranted(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f1920a = list;
    }

    @NotNull
    public String toString() {
        return "PermissionStatus(granted=" + this.f1920a + ", denied=" + this.f1921b + ")";
    }

    public PermissionStatus(@NotNull List<String> granted, @NotNull List<String> denied) {
        Intrinsics.checkParameterIsNotNull(granted, "granted");
        Intrinsics.checkParameterIsNotNull(denied, "denied");
        this.f1920a = granted;
        this.f1921b = denied;
    }

    public /* synthetic */ PermissionStatus(List list, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new ArrayList() : list, (i4 & 2) != 0 ? new ArrayList() : list2);
    }
}
