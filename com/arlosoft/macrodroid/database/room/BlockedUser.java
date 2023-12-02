package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockedUser.kt */
@StabilityInferred(parameters = 0)
@Entity(tableName = BlockedUser.TABLE_NAME)
/* loaded from: classes3.dex */
public final class BlockedUser {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "BlockedUser";
    @PrimaryKey

    /* renamed from: a  reason: collision with root package name */
    private final int f10790a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10791b;

    /* compiled from: BlockedUser.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BlockedUser(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        this.f10790a = i4;
        this.f10791b = username;
    }

    public static /* synthetic */ BlockedUser copy$default(BlockedUser blockedUser, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = blockedUser.f10790a;
        }
        if ((i5 & 2) != 0) {
            str = blockedUser.f10791b;
        }
        return blockedUser.copy(i4, str);
    }

    public final int component1() {
        return this.f10790a;
    }

    @NotNull
    public final String component2() {
        return this.f10791b;
    }

    @NotNull
    public final BlockedUser copy(int i4, @NotNull String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        return new BlockedUser(i4, username);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedUser)) {
            return false;
        }
        BlockedUser blockedUser = (BlockedUser) obj;
        if (this.f10790a == blockedUser.f10790a && Intrinsics.areEqual(this.f10791b, blockedUser.f10791b)) {
            return true;
        }
        return false;
    }

    public final int getUserId() {
        return this.f10790a;
    }

    @NotNull
    public final String getUsername() {
        return this.f10791b;
    }

    public int hashCode() {
        return (this.f10790a * 31) + this.f10791b.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.f10790a;
        String str = this.f10791b;
        return "BlockedUser(userId=" + i4 + ", username=" + str + ")";
    }
}
