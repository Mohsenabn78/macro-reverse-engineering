package com.arlosoft.macrodroid.templatestore.ui.upload;

import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateUploadViewContract.kt */
/* loaded from: classes3.dex */
public interface TemplateUploadViewContract {

    /* compiled from: TemplateUploadViewContract.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void displayCategoryAndDescriptionDialog$default(TemplateUploadViewContract templateUploadViewContract, Macro macro, int i4, boolean z3, String str, String str2, int i5, Object obj) {
            boolean z4;
            if (obj == null) {
                if ((i5 & 4) != 0) {
                    z4 = false;
                } else {
                    z4 = z3;
                }
                templateUploadViewContract.displayCategoryAndDescriptionDialog(macro, i4, z4, str, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayCategoryAndDescriptionDialog");
        }

        public static /* synthetic */ void displayTemplatePreviewDialog$default(TemplateUploadViewContract templateUploadViewContract, MacroTemplate macroTemplate, int i4, boolean z3, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 4) != 0) {
                    z3 = false;
                }
                templateUploadViewContract.displayTemplatePreviewDialog(macroTemplate, i4, z3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: displayTemplatePreviewDialog");
        }
    }

    void closeUploadScreen();

    void dismissCategoryAndDescriptionDialog();

    void displayCategoryAndDescriptionDialog(@NotNull Macro macro, int i4, boolean z3, @Nullable String str, @Nullable String str2);

    void displayTemplatePreviewDialog(@NotNull MacroTemplate macroTemplate, int i4, boolean z3);

    void hideTemplatePreviewDialog();

    void setUploadingState(boolean z3);

    void showDuplicateError();

    void showInvalidDataError();

    void showSelectCategory();

    void showUploadFailedError();

    void showUploadedOk();
}
