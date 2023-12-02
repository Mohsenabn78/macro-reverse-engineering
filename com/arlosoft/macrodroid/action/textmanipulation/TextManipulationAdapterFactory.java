package com.arlosoft.macrodroid.action.textmanipulation;

import com.arlosoft.macrodroid.gson.RuntimeTypeAdapterFactory;
import com.google.gson.TypeAdapterFactory;

/* loaded from: classes2.dex */
public class TextManipulationAdapterFactory {
    public static TypeAdapterFactory create() {
        return RuntimeTypeAdapterFactory.of(TextManipulation.class).registerSubtype(TextManipulation.class).registerSubtype(SubstringManipulation.class).registerSubtype(ReplaceAllManipulation.class).registerSubtype(ExtractTextManipulation.class).registerSubtype(UpperCaseManipulation.class).registerSubtype(LowerCaseManipulation.class).registerSubtype(TrimManipulation.class).registerSubtype(SplitManipulation.class).registerSubtype(RemoveTextManipulation.class);
    }
}
