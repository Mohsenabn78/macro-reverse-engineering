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
public final class PostCommentBody {
    public static final int $stable = 0;
    private final int macroId;
    @NotNull
    private final String text;
    private final int userId;

    public PostCommentBody(int i4, int i5, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.userId = i4;
        this.macroId = i5;
        this.text = text;
    }

    public static /* synthetic */ PostCommentBody copy$default(PostCommentBody postCommentBody, int i4, int i5, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i4 = postCommentBody.userId;
        }
        if ((i6 & 2) != 0) {
            i5 = postCommentBody.macroId;
        }
        if ((i6 & 4) != 0) {
            str = postCommentBody.text;
        }
        return postCommentBody.copy(i4, i5, str);
    }

    public final int component1() {
        return this.userId;
    }

    public final int component2() {
        return this.macroId;
    }

    @NotNull
    public final String component3() {
        return this.text;
    }

    @NotNull
    public final PostCommentBody copy(int i4, int i5, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new PostCommentBody(i4, i5, text);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostCommentBody)) {
            return false;
        }
        PostCommentBody postCommentBody = (PostCommentBody) obj;
        if (this.userId == postCommentBody.userId && this.macroId == postCommentBody.macroId && Intrinsics.areEqual(this.text, postCommentBody.text)) {
            return true;
        }
        return false;
    }

    public final int getMacroId() {
        return this.macroId;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (((this.userId * 31) + this.macroId) * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.userId;
        int i5 = this.macroId;
        String str = this.text;
        return "PostCommentBody(userId=" + i4 + ", macroId=" + i5 + ", text=" + str + ")";
    }
}
