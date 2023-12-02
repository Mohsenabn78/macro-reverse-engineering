package com.arlosoft.macrodroid.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScreenShotHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nScreenShotHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenShotHelper.kt\ncom/arlosoft/macrodroid/utils/ScreenShotHelper\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,98:1\n350#2:99\n350#2:100\n*S KotlinDebug\n*F\n+ 1 ScreenShotHelper.kt\ncom/arlosoft/macrodroid/utils/ScreenShotHelper\n*L\n76#1:99\n83#1:100\n*E\n"})
/* loaded from: classes3.dex */
public final class ScreenShotHelper {
    public static final int $stable = 0;
    @NotNull
    public static final ScreenShotHelper INSTANCE = new ScreenShotHelper();

    private ScreenShotHelper() {
    }

    @JvmStatic
    @NotNull
    public static final Bitmap getBitmapFromScrollView(@NotNull NestedScrollView scrollView, @NotNull String name, int i4) {
        Intrinsics.checkNotNullParameter(scrollView, "scrollView");
        Intrinsics.checkNotNullParameter(name, "name");
        float f4 = i4 / 100.0f;
        int width = (int) (scrollView.getChildAt(0).getWidth() * f4);
        int height = ((int) (scrollView.getChildAt(0).getHeight() * f4)) + 50;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, height, Bitmap.Config.RGB_565)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(scrollView.getContext(), R.color.md_grey_600));
        paint.setStyle(Paint.Style.STROKE);
        float f5 = 1;
        canvas.drawRect(0.0f, 0.0f, width - f5, height - f5, paint);
        canvas.scale(f4, f4);
        canvas.save();
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(46.0f);
        canvas.drawText(TextUtils.ellipsize(name, textPaint, (width * 2) - 40.0f, TextUtils.TruncateAt.END).toString(), 20.0f, 76.0f, textPaint);
        canvas.translate(0.0f, 100.0f);
        scrollView.layout(0, 0, scrollView.getLayoutParams().width, scrollView.getLayoutParams().height);
        scrollView.draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    @Nullable
    public final Bitmap getScreenshotFromRecyclerView(@NotNull RecyclerView view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        int i5;
        Intrinsics.checkNotNullParameter(view, "view");
        RecyclerView.Adapter adapter = view.getAdapter();
        Bitmap bitmap = null;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            Paint paint = new Paint();
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            int dimensionPixelOffset = view.getContext().getResources().getDimensionPixelOffset(R.dimen.margin_small);
            LruCache lruCache = new LruCache(maxMemory / 8);
            HashMap hashMap = new HashMap();
            int i6 = 0;
            for (int i7 = 0; i7 < itemCount; i7++) {
                RecyclerView.ViewHolder createViewHolder = adapter.createViewHolder(view, adapter.getItemViewType(i7));
                Intrinsics.checkNotNullExpressionValue(createViewHolder, "adapter.createViewHolder…apter.getItemViewType(i))");
                adapter.onBindViewHolder(createViewHolder, i7);
                createViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                View view2 = createViewHolder.itemView;
                view2.layout(0, 0, view2.getMeasuredWidth(), createViewHolder.itemView.getMeasuredHeight());
                createViewHolder.itemView.setDrawingCacheEnabled(true);
                createViewHolder.itemView.buildDrawingCache();
                String valueOf = String.valueOf(i7);
                View view3 = createViewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
                ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = null;
                }
                if (marginLayoutParams != null) {
                    i4 = marginLayoutParams.topMargin;
                } else {
                    i4 = 0;
                }
                hashMap.put(valueOf, Integer.valueOf(i4));
                Bitmap drawingCache = createViewHolder.itemView.getDrawingCache();
                if (drawingCache != null) {
                    lruCache.put(String.valueOf(i7), drawingCache);
                }
                int measuredHeight = createViewHolder.itemView.getMeasuredHeight();
                View view4 = createViewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view4, "holder.itemView");
                ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                } else {
                    marginLayoutParams2 = null;
                }
                if (marginLayoutParams2 != null) {
                    i5 = marginLayoutParams2.topMargin;
                } else {
                    i5 = 0;
                }
                i6 += measuredHeight + i5;
            }
            bitmap = Bitmap.createBitmap(view.getMeasuredWidth() + (dimensionPixelOffset * 2), i6 + dimensionPixelOffset, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(-16777216);
            int i8 = 0;
            for (int i9 = 0; i9 < itemCount; i9++) {
                Object obj = lruCache.get(String.valueOf(i9));
                Intrinsics.checkNotNullExpressionValue(obj, "bitmaCache.get(i.toString())");
                Bitmap bitmap2 = (Bitmap) obj;
                Integer num = (Integer) hashMap.get(String.valueOf(i9));
                if (num == null) {
                    num = 0;
                }
                int intValue = num.intValue();
                canvas.drawBitmap(bitmap2, dimensionPixelOffset, intValue + i8, paint);
                i8 += bitmap2.getHeight() + intValue;
                bitmap2.recycle();
            }
        }
        return bitmap;
    }
}
