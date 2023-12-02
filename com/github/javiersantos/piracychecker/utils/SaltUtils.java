package com.github.javiersantos.piracychecker.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.Nullable;

/* compiled from: SaltUtils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/github/javiersantos/piracychecker/utils/SaltUtils;", "", "Landroid/content/Context;", "context", "", "b", "", "string", "", "a", "getSalt", "[B", "mSalt", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "()Ljava/lang/String;", "saltString", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class SaltUtils {
    public static final SaltUtils INSTANCE = new SaltUtils();

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f18464a;

    private SaltUtils() {
    }

    private final byte[] a(String str) {
        List emptyList;
        boolean z3;
        List<String> split = new Regex(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            byte[] bArr = new byte[strArr.length];
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                bArr[i4] = Byte.parseByte(strArr[i4]);
            }
            return bArr;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final void b(Context context) {
        f18464a = new byte[20];
        Random random = new Random();
        byte[] bArr = f18464a;
        if (bArr != null) {
            for (int i4 = 0; i4 <= 19; i4++) {
                bArr[i4] = (byte) (random.nextInt(600) - 300);
            }
        }
        if (context != null) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString("salty-salt", c()).apply();
        }
    }

    private final String c() {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = f18464a;
        if (bArr != null) {
            int length = bArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (i4 > 0) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                sb.append(String.valueOf((int) bArr[i4]));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    @Nullable
    public final byte[] getSalt(@Nullable Context context) {
        String string;
        if (f18464a == null) {
            byte[] bArr = null;
            if (context != null) {
                try {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    if (defaultSharedPreferences.contains("salty-salt") && (string = defaultSharedPreferences.getString("salty-salt", null)) != null) {
                        bArr = INSTANCE.a(string);
                    }
                } catch (Exception unused) {
                }
            }
            f18464a = bArr;
            if (bArr == null) {
                b(context);
            }
        }
        return f18464a;
    }
}
