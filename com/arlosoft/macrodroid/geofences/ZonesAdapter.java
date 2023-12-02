package com.arlosoft.macrodroid.geofences;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class ZonesAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private List<GeofenceInfo> f12217a;

    /* renamed from: b  reason: collision with root package name */
    private Context f12218b;

    /* renamed from: c  reason: collision with root package name */
    private ZoneClickHandler f12219c;

    /* renamed from: d  reason: collision with root package name */
    private int f12220d;

    /* renamed from: e  reason: collision with root package name */
    private int f12221e;

    /* renamed from: f  reason: collision with root package name */
    private int f12222f;
    @ColorRes

    /* renamed from: g  reason: collision with root package name */
    int f12223g;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.container)
        ViewGroup container;
        @BindView(R.id.radius_info)
        TextView radiusInfo;
        @BindView(R.id.top_bar)
        View topBar;
        @BindView(R.id.zone_image)
        ImageView zoneImage;
        @BindView(R.id.zone_name)
        TextView zoneName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f12224a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f12224a = viewHolder;
            viewHolder.topBar = Utils.findRequiredView(view, R.id.top_bar, "field 'topBar'");
            viewHolder.zoneImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.zone_image, "field 'zoneImage'", ImageView.class);
            viewHolder.container = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.container, "field 'container'", ViewGroup.class);
            viewHolder.zoneName = (TextView) Utils.findRequiredViewAsType(view, R.id.zone_name, "field 'zoneName'", TextView.class);
            viewHolder.radiusInfo = (TextView) Utils.findRequiredViewAsType(view, R.id.radius_info, "field 'radiusInfo'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f12224a;
            if (viewHolder != null) {
                this.f12224a = null;
                viewHolder.topBar = null;
                viewHolder.zoneImage = null;
                viewHolder.container = null;
                viewHolder.zoneName = null;
                viewHolder.radiusInfo = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    public interface ZoneClickHandler {
        void zoneClicked(@NonNull GeofenceInfo geofenceInfo);

        void zoneLongClicked(@NonNull GeofenceInfo geofenceInfo);
    }

    public ZonesAdapter(@NonNull List<GeofenceInfo> list, @NonNull Context context, @NonNull ZoneClickHandler zoneClickHandler, @ColorRes int i4) {
        this.f12217a = list;
        this.f12218b = context;
        this.f12219c = zoneClickHandler;
        this.f12223g = i4;
        this.f12220d = context.getResources().getDimensionPixelSize(R.dimen.zone_map_preview_image_size);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f12221e = displayMetrics.widthPixels;
        this.f12222f = context.getResources().getDimensionPixelOffset(R.dimen.zone_list_map_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(GeofenceInfo geofenceInfo, View view) {
        this.f12219c.zoneClicked(geofenceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(GeofenceInfo geofenceInfo, View view) {
        this.f12219c.zoneLongClicked(geofenceInfo);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12217a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i4) {
        final GeofenceInfo geofenceInfo = this.f12217a.get(i4);
        viewHolder.topBar.setBackgroundResource(this.f12223g);
        viewHolder.zoneName.setText(geofenceInfo.getName());
        TextView textView = viewHolder.radiusInfo;
        textView.setText(geofenceInfo.getRadius() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f12218b.getString(R.string.meters));
        viewHolder.container.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.geofences.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZonesAdapter.this.c(geofenceInfo, view);
            }
        });
        viewHolder.container.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.geofences.i
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean d4;
                d4 = ZonesAdapter.this.d(geofenceInfo, view);
                return d4;
            }
        });
        int i5 = this.f12221e;
        int i6 = i5 > 900 ? i5 / 2 : i5;
        int i7 = i5 > 900 ? this.f12222f / 2 : this.f12222f;
        File file = new File(this.f12218b.getFilesDir().getAbsolutePath(), Constants.MAPS_IMAGE_DIR);
        File file2 = new File(file, geofenceInfo.getId() + ".png");
        if (file2.exists()) {
            Glide.with(this.f12218b).m4158load(file2).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.zoneImage);
            return;
        }
        Glide.with(this.f12218b).m4161load("https://maps.google.com/maps/api/staticmap?center=" + geofenceInfo.getLatitude() + "," + geofenceInfo.getLongitude() + "&zoom=15&size=" + i6 + "x" + i7 + "&sensor=false&key=AIzaSyBQzAX2Z2M1gQlXTKqkP-d0BvUcaPBBdas").apply((BaseRequestOptions<?>) new RequestOptions().fitCenter()).into(viewHolder.zoneImage);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_zone, viewGroup, false));
    }
}
