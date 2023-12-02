package com.jsramraj.flags;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;

/* loaded from: classes6.dex */
public class Flags {

    /* renamed from: a  reason: collision with root package name */
    private static Context f34597a;

    /* loaded from: classes6.dex */
    public static class FlagsException extends UnsupportedOperationException {
        public FlagsException(String str) {
            super("com.jsramraj.flags" + str);
        }
    }

    private static Bitmap a(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e4) {
            e4.printStackTrace();
            return bitmap;
        }
    }

    public static BitmapDrawable forCountry(String str) throws FlagsException {
        if (f34597a != null) {
            if (str != null) {
                if (str.length() == 2) {
                    char[] charArray = str.toUpperCase().toCharArray();
                    Bitmap a4 = a(f34597a, "all_flags.png");
                    Bitmap createBitmap = Bitmap.createBitmap(a4, (charArray[0] - '@') * 32, (charArray[1] - '@') * 22, 32, 22);
                    String.valueOf(a4);
                    return new BitmapDrawable(f34597a.getResources(), createBitmap);
                }
                throw new InvalidParameterException("Country code is not valid. Supply a valid ISO two digit country code. Refer: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2");
            }
            throw new NullPointerException("Country code cannot be null. Supply a valid ISO two digit country code. Refer: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2");
        }
        throw new FlagsException("Context is not set. Call Flags.init(getApplicationContext()) before calling this method.");
    }

    public static void init(Context context) {
        f34597a = context;
    }
}
