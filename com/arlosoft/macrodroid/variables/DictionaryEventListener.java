package com.arlosoft.macrodroid.variables;

import com.arlosoft.macrodroid.variables.VariableValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DictionaryEventListener.kt */
/* loaded from: classes3.dex */
public interface DictionaryEventListener {
    void dictionaryDeleted();

    void entriesCleared();

    void entryRemoved(@NotNull VariableValue.DictionaryEntry dictionaryEntry);

    void entryUpdated(@NotNull VariableValue.DictionaryEntry dictionaryEntry, @Nullable VariableValue.DictionaryEntry dictionaryEntry2);

    void refreshRequired();
}
