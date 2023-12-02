package com.arlosoft.macrodroid.templatestore.ui.templateList;

import androidx.lifecycle.LifecycleOwner;
import androidx.paging.PagedList;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateStoreListViewContract.kt */
/* loaded from: classes3.dex */
public interface TemplateStoreListViewContract extends LifecycleOwner {
    void clearEditTextDialog();

    void initialiseList();

    void loadCommentsScreen(@NotNull MacroTemplate macroTemplate);

    void refresh();

    void setSwipeRefreshVisible(boolean z3);

    void setUpdatingText(boolean z3);

    void showConfirmDelete(@NotNull MacroTemplate macroTemplate);

    void showContent();

    void showDeleteFailed();

    void showDeleteSuccess();

    void showEditDescriptionDialog(@NotNull MacroTemplate macroTemplate);

    void showEditNameDialog(@NotNull MacroTemplate macroTemplate);

    void showEmptyState();

    void showInvalidText(boolean z3);

    void showLoadDataError();

    void showLoadingState();

    void showOptionsMenu(@NotNull MacroTemplate macroTemplate, boolean z3, boolean z4);

    void showOwnMacroStarMessage();

    void showPirateVersionError();

    void showReportFailed();

    void showReportMacroDialog(@NotNull MacroTemplate macroTemplate);

    void showReportUploading(boolean z3);

    void showReported();

    void showRequiresSignIn();

    void showSubscriptionProOnly();

    void showSubscriptionSignedInOnly();

    void showUpdateFailed();

    void updateList(@Nullable PagedList<MacroTemplate> pagedList);
}
