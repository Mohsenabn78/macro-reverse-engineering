package com.arlosoft.macrodroid.templatestore.ui;

import org.jetbrains.annotations.NotNull;

/* compiled from: SerchTermProvider.kt */
/* loaded from: classes3.dex */
public interface SearchTermProvider {
    void addSearchTermListener(@NotNull SearchTermListener searchTermListener);

    @NotNull
    String getSearchTerm();

    void removeSearchTermListener(@NotNull SearchTermListener searchTermListener);
}
