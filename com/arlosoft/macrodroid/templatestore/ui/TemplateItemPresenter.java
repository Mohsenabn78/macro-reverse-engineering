package com.arlosoft.macrodroid.templatestore.ui;

import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import org.jetbrains.annotations.NotNull;

/* compiled from: TemplateItemPresenter.kt */
/* loaded from: classes3.dex */
public interface TemplateItemPresenter {
    void commentsClicked(@NotNull MacroTemplate macroTemplate);

    void flagClicked(@NotNull MacroTemplate macroTemplate);

    void menuClicked(@NotNull MacroTemplate macroTemplate);

    void reportClicked(@NotNull MacroTemplate macroTemplate);

    void starClicked(@NotNull MacroTemplate macroTemplate);

    void subscribeMacroClicked(@NotNull MacroTemplate macroTemplate, boolean z3);

    void templateClicked(@NotNull MacroTemplate macroTemplate);

    void usernameClicked(@NotNull MacroTemplate macroTemplate, @NotNull AvatarView avatarView);
}
