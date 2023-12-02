package com.arlosoft.macrodroid.interfaces;

import com.arlosoft.macrodroid.variables.DictionaryKeys;
import org.jetbrains.annotations.NotNull;

/* compiled from: HasMultipleDictionaryKeys.kt */
/* loaded from: classes3.dex */
public interface HasMultipleDictionaryKeys {
    @NotNull
    DictionaryKeys[] getDictionaryKeys();

    void setDictionaryKeys(@NotNull DictionaryKeys[] dictionaryKeysArr);
}
