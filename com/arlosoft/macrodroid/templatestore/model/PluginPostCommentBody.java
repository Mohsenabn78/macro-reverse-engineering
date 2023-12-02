package com.arlosoft.macrodroid.templatestore.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Comment.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class PluginPostCommentBody {
    public static final int $stable = 0;
    private final int pluginId;
    @NotNull
    private final String text;
    private final int userId;

    public PluginPostCommentBody(int i4, int i5, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.userId = i4;
        this.pluginId = i5;
        this.text = text;
    }

    public static /* synthetic */ PluginPostCommentBody copy$default(PluginPostCommentBody pluginPostCommentBody, int i4, int i5, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = pluginPostCommentBody.userId;
        }
        if ((i6 & 2) != 0) {
            i5 = pluginPostCommentBody.pluginId;
        }
        if ((i6 & 4) != 0) {
            str = pluginPostCommentBody.text;
        }
        return pluginPostCommentBody.copy(i4, i5, str);
    }

    public final int component1() {
        return this.userId;
    }

    public final int component2() {
        return this.pluginId;
    }

    @NotNull
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final PluginPostCommentBody copy(int i4, int i5, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new PluginPostCommentBody(i4, i5, text);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PluginPostCommentBody)) {
            return false;
        }
        PluginPostCommentBody pluginPostCommentBody = (PluginPostCommentBody) obj;
        if (this.userId == pluginPostCommentBody.userId && this.pluginId == pluginPostCommentBody.pluginId && Intrinsics.areEqual(this.text, pluginPostCommentBody.text)) {
            return true;
        }
        return false;
    }

    public final int getPluginId() {
        return this.pluginId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.userId * 31) + this.pluginId) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.userId;
        int i5 = this.pluginId;
        String str = this.text;
        return "PluginPostCommentBody(userId=" + i4 + ", pluginId=" + i5 + ", text=" + str + ")";
    }
}
