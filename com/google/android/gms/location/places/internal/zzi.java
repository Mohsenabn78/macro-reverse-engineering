package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public final class zzi {
    public static CharSequence zzb(String str, List<zzb> list, @Nullable CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (zzb zzbVar : list) {
            CharacterStyle wrap = CharacterStyle.wrap(characterStyle);
            int i4 = zzbVar.f21123a;
            spannableString.setSpan(wrap, i4, zzbVar.f21124b + i4, 0);
        }
        return spannableString;
    }

    @Nullable
    public static String zzc(@Nullable Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            return TextUtils.join(", ", collection);
        }
        return null;
    }
}
