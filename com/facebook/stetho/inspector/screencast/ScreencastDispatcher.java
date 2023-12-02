package com.facebook.stetho.inspector.screencast;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64OutputStream;
import android.view.View;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.module.Page;
import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public final class ScreencastDispatcher {
    private static final long FRAME_DELAY = 200;
    private Handler mBackgroundHandler;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private HandlerThread mHandlerThread;
    private boolean mIsRunning;
    private JsonRpcPeer mPeer;
    private Page.StartScreencastRequest mRequest;
    private ByteArrayOutputStream mStream;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final BitmapFetchRunnable mBitmapFetchRunnable = new BitmapFetchRunnable();
    private final ActivityTracker mActivityTracker = ActivityTracker.get();
    private final EventDispatchRunnable mEventDispatchRunnable = new EventDispatchRunnable();
    private final RectF mTempSrc = new RectF();
    private final RectF mTempDst = new RectF();
    private Page.ScreencastFrameEvent mEvent = new Page.ScreencastFrameEvent();
    private Page.ScreencastFrameEventMetadata mMetadata = new Page.ScreencastFrameEventMetadata();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BitmapFetchRunnable implements Runnable {
        private BitmapFetchRunnable() {
        }

        private void updateScreenBitmap() {
            Activity tryGetTopActivity;
            if (!ScreencastDispatcher.this.mIsRunning || (tryGetTopActivity = ScreencastDispatcher.this.mActivityTracker.tryGetTopActivity()) == null) {
                return;
            }
            View decorView = tryGetTopActivity.getWindow().getDecorView();
            try {
                if (ScreencastDispatcher.this.mBitmap == null) {
                    float width = decorView.getWidth();
                    float height = decorView.getHeight();
                    float min = Math.min(ScreencastDispatcher.this.mRequest.maxWidth / width, ScreencastDispatcher.this.mRequest.maxHeight / height);
                    int i4 = (int) (width * min);
                    int i5 = (int) (min * height);
                    ScreencastDispatcher.this.mBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.RGB_565);
                    ScreencastDispatcher.this.mCanvas = new Canvas(ScreencastDispatcher.this.mBitmap);
                    Matrix matrix = new Matrix();
                    ScreencastDispatcher.this.mTempSrc.set(0.0f, 0.0f, width, height);
                    ScreencastDispatcher.this.mTempDst.set(0.0f, 0.0f, i4, i5);
                    matrix.setRectToRect(ScreencastDispatcher.this.mTempSrc, ScreencastDispatcher.this.mTempDst, Matrix.ScaleToFit.CENTER);
                    ScreencastDispatcher.this.mCanvas.setMatrix(matrix);
                }
                decorView.draw(ScreencastDispatcher.this.mCanvas);
            } catch (OutOfMemoryError unused) {
                LogUtil.w("Out of memory trying to allocate screencast Bitmap.");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            updateScreenBitmap();
            ScreencastDispatcher.this.mBackgroundHandler.post(ScreencastDispatcher.this.mEventDispatchRunnable.withEndAction(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class CancellationRunnable implements Runnable {
        private CancellationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreencastDispatcher.this.mHandlerThread.interrupt();
            ScreencastDispatcher.this.mMainHandler.removeCallbacks(ScreencastDispatcher.this.mBitmapFetchRunnable);
            ScreencastDispatcher.this.mBackgroundHandler.removeCallbacks(ScreencastDispatcher.this.mEventDispatchRunnable);
            ScreencastDispatcher.this.mIsRunning = false;
            ScreencastDispatcher.this.mHandlerThread = null;
            ScreencastDispatcher.this.mBitmap = null;
            ScreencastDispatcher.this.mCanvas = null;
            ScreencastDispatcher.this.mStream = null;
        }
    }

    /* loaded from: classes3.dex */
    private class EventDispatchRunnable implements Runnable {
        private Runnable mEndAction;

        private EventDispatchRunnable() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public EventDispatchRunnable withEndAction(Runnable runnable) {
            this.mEndAction = runnable;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ScreencastDispatcher.this.mIsRunning && ScreencastDispatcher.this.mBitmap != null) {
                int width = ScreencastDispatcher.this.mBitmap.getWidth();
                int height = ScreencastDispatcher.this.mBitmap.getHeight();
                ScreencastDispatcher.this.mStream.reset();
                Base64OutputStream base64OutputStream = new Base64OutputStream(ScreencastDispatcher.this.mStream, 0);
                ScreencastDispatcher.this.mBitmap.compress(Bitmap.CompressFormat.valueOf(ScreencastDispatcher.this.mRequest.format.toUpperCase()), ScreencastDispatcher.this.mRequest.quality, base64OutputStream);
                ScreencastDispatcher.this.mEvent.data = ScreencastDispatcher.this.mStream.toString();
                ScreencastDispatcher.this.mMetadata.pageScaleFactor = 1;
                ScreencastDispatcher.this.mMetadata.deviceWidth = width;
                ScreencastDispatcher.this.mMetadata.deviceHeight = height;
                ScreencastDispatcher.this.mEvent.metadata = ScreencastDispatcher.this.mMetadata;
                ScreencastDispatcher.this.mPeer.invokeMethod("Page.screencastFrame", ScreencastDispatcher.this.mEvent, null);
                ScreencastDispatcher.this.mMainHandler.postDelayed(this.mEndAction, ScreencastDispatcher.FRAME_DELAY);
            }
        }
    }

    public void startScreencast(JsonRpcPeer jsonRpcPeer, Page.StartScreencastRequest startScreencastRequest) {
        LogUtil.d("Starting screencast");
        this.mRequest = startScreencastRequest;
        HandlerThread handlerThread = new HandlerThread("Screencast Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mPeer = jsonRpcPeer;
        this.mIsRunning = true;
        this.mStream = new ByteArrayOutputStream();
        this.mBackgroundHandler = new Handler(this.mHandlerThread.getLooper());
        this.mMainHandler.postDelayed(this.mBitmapFetchRunnable, FRAME_DELAY);
    }

    public void stopScreencast() {
        LogUtil.d("Stopping screencast");
        this.mBackgroundHandler.post(new CancellationRunnable());
    }
}
