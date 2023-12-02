package com.hanks.htextview.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes6.dex */
public class CharacterUtils {
    public static List<CharacterDiffResult> diff(CharSequence charSequence, CharSequence charSequence2) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            char charAt = charSequence.charAt(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= charSequence2.length()) {
                    break;
                }
                if (!hashSet.contains(Integer.valueOf(i5)) && charAt == charSequence2.charAt(i5)) {
                    hashSet.add(Integer.valueOf(i5));
                    CharacterDiffResult characterDiffResult = new CharacterDiffResult();
                    characterDiffResult.f34017c = charAt;
                    characterDiffResult.fromIndex = i4;
                    characterDiffResult.moveIndex = i5;
                    arrayList.add(characterDiffResult);
                    break;
                }
                i5++;
            }
        }
        return arrayList;
    }

    public static float getOffset(int i4, int i5, float f4, float f5, float f6, List<Float> list, List<Float> list2) {
        for (int i6 = 0; i6 < i5; i6++) {
            f5 += list.get(i6).floatValue();
        }
        for (int i7 = 0; i7 < i4; i7++) {
            f6 += list2.get(i7).floatValue();
        }
        return f6 + ((f5 - f6) * f4);
    }

    public static int needMove(int i4, List<CharacterDiffResult> list) {
        for (CharacterDiffResult characterDiffResult : list) {
            if (characterDiffResult.fromIndex == i4) {
                return characterDiffResult.moveIndex;
            }
        }
        return -1;
    }

    public static boolean stayHere(int i4, List<CharacterDiffResult> list) {
        for (CharacterDiffResult characterDiffResult : list) {
            if (characterDiffResult.moveIndex == i4) {
                return true;
            }
        }
        return false;
    }
}
