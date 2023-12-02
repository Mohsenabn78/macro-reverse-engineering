package com.arlosoft.macrodroid.templatestore.ui.comments;

import com.arlosoft.macrodroid.templatestore.model.Comment;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import org.jetbrains.annotations.NotNull;

/* compiled from: TemplateCommentsViewContract.kt */
/* loaded from: classes3.dex */
public interface TemplateCommentsViewContract {
    void clearCommentText();

    void clearUpdateDialog();

    void commentsUpdated();

    void confirmDelete(@NotNull Comment comment);

    void editComment(@NotNull Comment comment);

    void setCommentEnabledState(boolean z3);

    void setDialogCommentEnabledState(boolean z3);

    void setUpdatingComment(boolean z3);

    void showCommentOptions(@NotNull Comment comment);

    void showCommentUploadFailed(boolean z3);

    void showDeleteFailed();

    void showMacroTemplate(@NotNull MacroTemplate macroTemplate);

    void showSendingComment();

    void showTemplateError();
}
