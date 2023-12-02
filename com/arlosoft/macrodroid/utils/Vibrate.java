package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.os.Vibrator;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Vibrate {
    public static final int BLIP = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, long[]> f16090a;

    static {
        HashMap<Integer, long[]> hashMap = new HashMap<>();
        f16090a = hashMap;
        hashMap.put(0, new long[]{0, 100});
        hashMap.put(1, new long[]{0, 300});
        hashMap.put(2, new long[]{0, 1000});
        hashMap.put(3, new long[]{0, 100, 50, 100, 50, 100, 50, 100, 50, 100, 50, 100, 50, 100});
        hashMap.put(4, new long[]{0, 600, 400, 600, 400, 600});
        hashMap.put(5, new long[]{0, 150, 300, 300, 300, 450, 300, 600});
        hashMap.put(6, new long[]{0, 300, 500, 300, 500, 300, 500, 300, 500});
        hashMap.put(7, new long[]{0, 600, 300, 450, 300, 300, 300, 150});
        hashMap.put(8, new long[]{0, 50, 100, 50, 100, 50, 100, 400, 100, 300, 100, 350, 50, 200, 100, 100, 50, 600});
        hashMap.put(9, new long[]{0, 100, 200, 100, 100, 100, 100, 100, 200, 100, 500, 100, 225, 100});
        hashMap.put(10, new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500});
        hashMap.put(11, new long[]{0, 35});
        hashMap.put(12, new long[]{0, 10});
    }

    public static String[] getPatternNames() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.vibrate_blip), MacroDroidApplication.getInstance().getString(R.string.vibrate_short_buzz), MacroDroidApplication.getInstance().getString(R.string.vibrate_long_buzz), MacroDroidApplication.getInstance().getString(R.string.vibrate_rapid), MacroDroidApplication.getInstance().getString(R.string.vibrate_slow), MacroDroidApplication.getInstance().getString(R.string.vibrate_increasing), MacroDroidApplication.getInstance().getString(R.string.vibrate_constant), MacroDroidApplication.getInstance().getString(R.string.vibrate_decreasing), MacroDroidApplication.getInstance().getString(R.string.vibrate_final_fantasy), MacroDroidApplication.getInstance().getString(R.string.vibrate_game_over), MacroDroidApplication.getInstance().getString(R.string.vibrate_star_wars), MacroDroidApplication.getInstance().getString(R.string.vibrate_mini_blip), MacroDroidApplication.getInstance().getString(R.string.vibrate_micro_blip)};
    }

    public static void vibrateDevice(Context context, int i4) {
        HashMap<Integer, long[]> hashMap = f16090a;
        if (i4 >= hashMap.size()) {
            SystemLog.logError("Illegal vibrate pattern selected. Reverting to Blip");
            i4 = 0;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(hashMap.get(Integer.valueOf(i4)), -1);
    }
}
