package com.arlosoft.macrodroid.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserSubscription.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserSubscription {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f10719a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10720b;

    public UserSubscription(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.f10719a = i4;
        this.f10720b = username;
    }

    public static /* synthetic */ UserSubscription copy$default(UserSubscription userSubscription, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = userSubscription.f10719a;
        }
        if ((i5 & 2) != 0) {
            str = userSubscription.f10720b;
        }
        return userSubscription.copy(i4, str);
    }

    public final int component1() {
        return this.f10719a;
    }

    @NotNull
    public final String component2() {
        return this.f10720b;
    }

    @NotNull
    public final UserSubscription copy(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        return new UserSubscription(i4, username);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSubscription)) {
            return false;
        }
        UserSubscription userSubscription = (UserSubscription) obj;
        if (this.f10719a == userSubscription.f10719a && Intrinsics.areEqual(this.f10720b, userSubscription.f10720b)) {
            return true;
        }
        return false;
    }

    public final int getUserId() {
        return this.f10719a;
    }

    @NotNull
    public final String getUsername() {
        return this.f10720b;
    }

    public int hashCode() {
        return (this.f10719a * 31) + this.f10720b.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.f10719a;
        String str = this.f10720b;
        return "UserSubscription(userId=" + i4 + ", username=" + str + ")";
    }
}
