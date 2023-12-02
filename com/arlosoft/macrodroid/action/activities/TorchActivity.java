package com.arlosoft.macrodroid.action.activities;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NonAppActivity;
import java.io.IOException;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class TorchActivity extends NonAppActivity implements SurfaceHolder.Callback {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2943f = false;

    /* renamed from: g  reason: collision with root package name */
    private static TorchActivity f2944g;

    /* renamed from: d  reason: collision with root package name */
    private Camera f2945d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceHolder f2946e;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        finish();
    }

    public static boolean isTorchActive() {
        return f2943f;
    }

    public static void kill() {
        TorchActivity torchActivity = f2944g;
        if (torchActivity != null) {
            torchActivity.finish();
            f2944g = null;
        }
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.torch_layout);
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        f2944g = this;
        ((Button) findViewById(R.id.torch_layout_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TorchActivity.this.i(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Camera camera = this.f2945d;
        if (camera != null) {
            camera.stopPreview();
            this.f2945d.release();
            this.f2945d = null;
            this.f2946e = null;
        }
        f2943f = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            ((SurfaceView) findViewById(R.id.PREVIEW)).getHolder().addCallback(this);
            Camera open = Camera.open();
            this.f2945d = open;
            Camera.Parameters parameters = open.getParameters();
            parameters.setFlashMode("torch");
            this.f2945d.setParameters(parameters);
            this.f2945d.startPreview();
            f2943f = true;
        } catch (RuntimeException unused) {
            f2943f = false;
            ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.action_camera_flash_camera_failed), 0).show();
            finish();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            this.f2946e = surfaceHolder;
            Camera camera = this.f2945d;
            if (camera != null) {
                camera.setPreviewDisplay(surfaceHolder);
            }
        } catch (IOException unused) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Camera camera = this.f2945d;
        if (camera != null) {
            camera.stopPreview();
            this.f2946e = null;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
    }
}
