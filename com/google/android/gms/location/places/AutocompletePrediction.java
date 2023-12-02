package com.google.android.gms.location.places;

import android.text.style.CharacterStyle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

@Deprecated
/* loaded from: classes4.dex */
public interface AutocompletePrediction extends Freezable<AutocompletePrediction> {
    CharSequence getFullText(@Nullable CharacterStyle characterStyle);

    @Nullable
    String getPlaceId();

    @Nullable
    List<Integer> getPlaceTypes();

    CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle);

    CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle);
}
