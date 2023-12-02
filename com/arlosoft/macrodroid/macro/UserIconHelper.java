package com.arlosoft.macrodroid.macro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.data.UserIconData;
import com.arlosoft.macrodroid.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UserIconHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UserIconHelper {
    public static final int $stable = 0;
    @NotNull
    public static final UserIconHelper INSTANCE = new UserIconHelper();

    private UserIconHelper() {
    }

    @JvmStatic
    public static final void importUserIcons(@NotNull Context context, @NotNull List<? extends UserIconData> userIconDataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userIconDataList, "userIconDataList");
        for (UserIconData userIconData : userIconDataList) {
            String str = userIconData.data;
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File userIconDir = FileUtils.getUserIconDir(context);
                        if (!userIconDir.exists()) {
                            userIconDir.mkdirs();
                        }
                        File file = new File(userIconDir, userIconData.fileName);
                        if (!file.exists()) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e4) {
                                fileOutputStream = fileOutputStream2;
                                e = e4;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
    }
}
