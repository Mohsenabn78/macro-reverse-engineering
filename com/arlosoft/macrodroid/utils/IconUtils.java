package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.io.IOException;

/* loaded from: classes3.dex */
public class IconUtils {
    public static void setImageOnImageView(Context context, ImageView imageView, String str, String str2, int i4, String str3) {
        setImageOnImageView(context, imageView, str, str2, i4, str3 != null ? Uri.parse(str3) : null, null);
    }

    public static void setImageOnRemoteView(Context context, RemoteViews remoteViews, int i4, String str, String str2, int i5, String str3, Integer num, String str4) {
        boolean z3;
        int i6;
        if (!TextUtils.isEmpty(str4)) {
            remoteViews.setImageViewBitmap(i4, BitmapUtils.textAsBitmap(str4, -1));
        } else if (str3 != null) {
            try {
                remoteViews.setImageViewBitmap(i4, MediaStore.Images.Media.getBitmap(context.getContentResolver(), Uri.parse(str3)));
            } catch (IOException unused) {
                SystemLog.logError("Could not load image: " + str3);
                remoteViews.setImageViewUri(i4, Uri.parse(str3));
            }
        } else {
            if (num != null && ((str2 == null || str2.equals(BuildConfig.APPLICATION_ID)) && (str == null || !str.equals(BuildConfig.APPLICATION_ID)))) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (str2 == null) {
                if (str != null) {
                    i6 = Util.getResId(context, str);
                } else {
                    i6 = -1;
                }
                Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(context, BuildConfig.APPLICATION_ID, str);
                if (drawableFromPackageWithName != null) {
                    Bitmap bitmapFromDrawable = DrawableUtils.getBitmapFromDrawable(drawableFromPackageWithName);
                    if (z3) {
                        remoteViews.setImageViewBitmap(i4, tintImage(bitmapFromDrawable, num.intValue()));
                    } else {
                        remoteViews.setImageViewBitmap(i4, bitmapFromDrawable);
                    }
                } else if (i6 != -1) {
                    remoteViews.setImageViewResource(i4, i6);
                } else if (i5 == 0) {
                    remoteViews.setImageViewResource(i4, R.drawable.not_icon_setup);
                } else {
                    remoteViews.setImageViewResource(i4, i5);
                }
            } else if (str2.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
                Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(str);
                if (decodeBitmapFromUserIconFile != null) {
                    remoteViews.setImageViewBitmap(i4, decodeBitmapFromUserIconFile);
                } else {
                    remoteViews.setImageViewResource(i4, R.drawable.launcher_no_border);
                }
            } else {
                Drawable drawableFromPackageWithName2 = Util.getDrawableFromPackageWithName(context, str2, str);
                if (drawableFromPackageWithName2 == null) {
                    drawableFromPackageWithName2 = Util.getDrawableFromPackage(context, str2, i5);
                }
                if (drawableFromPackageWithName2 != null) {
                    Bitmap bitmapFromDrawable2 = DrawableUtils.getBitmapFromDrawable(drawableFromPackageWithName2);
                    if (z3) {
                        remoteViews.setImageViewBitmap(i4, tintImage(bitmapFromDrawable2, num.intValue()));
                        return;
                    } else {
                        remoteViews.setImageViewBitmap(i4, bitmapFromDrawable2);
                        return;
                    }
                }
                remoteViews.setImageViewResource(i4, R.drawable.not_icon_setup);
            }
        }
    }

    public static Bitmap tintImage(Bitmap bitmap, int i4) {
        if (bitmap == null) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(i4, PorterDuff.Mode.SRC_IN));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(bitmap.getDensity());
        new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static void setImageOnImageView(Context context, ImageView imageView, String str, String str2, int i4, Uri uri, String str3) {
        if (str3 != null) {
            try {
                if (!str3.isEmpty()) {
                    imageView.setImageBitmap(BitmapUtils.textAsBitmap(str3, -1));
                    return;
                }
            } catch (Exception e4) {
                SystemLog.logError("Failed to set image: " + e4.toString());
                imageView.setImageResource(R.drawable.not_icon_setup);
                return;
            }
        }
        if (uri != null) {
            imageView.setImageURI(uri);
        } else if (str2 == null) {
            int resId = str != null ? Util.getResId(context, str) : -1;
            if (resId != -1) {
                imageView.setImageResource(resId);
            } else if (i4 == 0) {
                imageView.setImageResource(R.drawable.not_icon_setup);
            } else {
                imageView.setImageResource(i4);
            }
        } else if (str2.equals(Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(str);
            if (decodeBitmapFromUserIconFile != null) {
                imageView.setImageBitmap(decodeBitmapFromUserIconFile);
            } else {
                imageView.setImageResource(R.drawable.launcher_no_border);
            }
        } else {
            Drawable drawableFromPackageWithName = Util.getDrawableFromPackageWithName(context, str2, str);
            if (drawableFromPackageWithName == null) {
                drawableFromPackageWithName = Util.getDrawableFromPackage(context, str2, i4);
            }
            if (drawableFromPackageWithName != null) {
                imageView.setImageDrawable(drawableFromPackageWithName);
            } else {
                imageView.setImageResource(R.drawable.not_icon_setup);
            }
        }
    }
}
