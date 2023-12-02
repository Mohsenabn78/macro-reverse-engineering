package com.oneclickaway.opensource.placeautocomplete.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.oneclickaway.opensource.placeautocomplete.R;
import com.oneclickaway.opensource.placeautocomplete.data.adapter.RecentSearchesAdapter;
import com.oneclickaway.opensource.placeautocomplete.data.adapter.SearchResultAdapter;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.place_details.PlaceDetails;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.PredictionsItem;
import com.oneclickaway.opensource.placeautocomplete.data.model.room.SearchSelectedItem;
import com.oneclickaway.opensource.placeautocomplete.data.model.view.SearchPlacesViewModel;
import com.oneclickaway.opensource.placeautocomplete.data.room.RecentSearchesDB;
import com.oneclickaway.opensource.placeautocomplete.interfaces.SearchPlaces;
import com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity;
import com.oneclickaway.opensource.placeautocomplete.utils.GroupStrategy;
import com.oneclickaway.opensource.placeautocomplete.utils.LoadingManager;
import com.oneclickaway.opensource.placeautocomplete.utils.SearchPlacesStatusCodes;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchPlaceActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020PH\u0002J\b\u0010R\u001a\u00020NH\u0002J\b\u0010S\u001a\u00020PH\u0002J\b\u0010T\u001a\u00020PH\u0002J\b\u0010U\u001a\u00020PH\u0002J\b\u0010V\u001a\u00020PH\u0002J\b\u0010W\u001a\u00020PH\u0016J\u0012\u0010X\u001a\u00020P2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0012\u0010[\u001a\u00020P2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0014J\u0012\u0010^\u001a\u00020P2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020PH\u0002J\b\u0010e\u001a\u00020PH\u0002J\b\u0010f\u001a\u00020PH\u0002J\u0010\u0010g\u001a\u00020P2\u0006\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020PH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u00102R\u001a\u0010>\u001a\u00020?X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020?X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001a\u0010G\u001a\u00020?X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010A\"\u0004\bI\u0010CR\u001a\u0010J\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010*\"\u0004\bL\u0010,R\u000e\u0010M\u001a\u00020NX\u0082.¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/ui/SearchPlaceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;", "Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;", "Landroid/view/View$OnClickListener;", "()V", "apiKey", "", "backImageBtn", "Landroid/widget/ImageView;", "getBackImageBtn", "()Landroid/widget/ImageView;", "setBackImageBtn", "(Landroid/widget/ImageView;)V", "enclosingRadius", "eraseCurrentEntryIV", "getEraseCurrentEntryIV", "setEraseCurrentEntryIV", "gettingPlaceDataDialog", "Landroid/app/Dialog;", "getGettingPlaceDataDialog", "()Landroid/app/Dialog;", "setGettingPlaceDataDialog", "(Landroid/app/Dialog;)V", "liveQueryInEditText", "Landroidx/lifecycle/MutableLiveData;", FirebaseAnalytics.Param.LOCATION, "placeNamET", "Landroid/widget/EditText;", "getPlaceNamET", "()Landroid/widget/EditText;", "setPlaceNamET", "(Landroid/widget/EditText;)V", "recentSearchesDB", "Lcom/oneclickaway/opensource/placeautocomplete/data/room/RecentSearchesDB;", "getRecentSearchesDB", "()Lcom/oneclickaway/opensource/placeautocomplete/data/room/RecentSearchesDB;", "setRecentSearchesDB", "(Lcom/oneclickaway/opensource/placeautocomplete/data/room/RecentSearchesDB;)V", "recentSearchesLL", "Landroid/widget/LinearLayout;", "getRecentSearchesLL", "()Landroid/widget/LinearLayout;", "setRecentSearchesLL", "(Landroid/widget/LinearLayout;)V", "recentSearchesRV", "Landroidx/recyclerview/widget/RecyclerView;", "getRecentSearchesRV", "()Landroid/support/v7/widget/RecyclerView;", "setRecentSearchesRV", "(Landroid/support/v7/widget/RecyclerView;)V", "searchListAdapter", "Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/SearchResultAdapter;", "searchProgressBar", "Landroid/widget/ProgressBar;", "getSearchProgressBar", "()Landroid/widget/ProgressBar;", "setSearchProgressBar", "(Landroid/widget/ProgressBar;)V", "searchResultsRV", "getSearchResultsRV", "setSearchResultsRV", "searchTitleTV", "Landroid/widget/TextView;", "getSearchTitleTV", "()Landroid/widget/TextView;", "setSearchTitleTV", "(Landroid/widget/TextView;)V", "secondaryInfoSubTitleTV", "getSecondaryInfoSubTitleTV", "setSecondaryInfoSubTitleTV", "secondaryInfoTitleTV", "getSecondaryInfoTitleTV", "setSecondaryInfoTitleTV", "secondaryInformationLL", "getSecondaryInformationLL", "setSecondaryInformationLL", "viewModel", "Lcom/oneclickaway/opensource/placeautocomplete/data/model/view/SearchPlacesViewModel;", "attachEraserObserver", "", "attachLiveObservers", "getViewModel", "inflateViews", "initDb", "initDialogForGettingPlaceDetails", "initializeDependency", "onBackPressed", "onClick", "p0", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPlaceItemSelected", "candidateItem", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "onRecantsItemSelected", "savedItem", "Lcom/oneclickaway/opensource/placeautocomplete/utils/GroupStrategy$ListItem;", "setOnClickListeners", "setOnQueryChangeListener", "setRecyclerView", "setSecondaryStateInformation", "pageStatus", "Lcom/oneclickaway/opensource/placeautocomplete/utils/LoadingManager;", "setViewModel", "Config", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
@SuppressLint({"CheckResult"})
/* loaded from: classes6.dex */
public final class SearchPlaceActivity extends AppCompatActivity implements SearchPlaces.PlaceItemSelectedListener, SearchPlaces.RecentItemSelectedListener, View.OnClickListener {
    private String apiKey;
    @NotNull
    public ImageView backImageBtn;
    private String enclosingRadius;
    @NotNull
    public ImageView eraseCurrentEntryIV;
    @NotNull
    public Dialog gettingPlaceDataDialog;
    private MutableLiveData<String> liveQueryInEditText = new MutableLiveData<>();
    private String location;
    @NotNull
    public EditText placeNamET;
    @Nullable
    private RecentSearchesDB recentSearchesDB;
    @Nullable
    private LinearLayout recentSearchesLL;
    @NotNull
    public RecyclerView recentSearchesRV;
    private SearchResultAdapter searchListAdapter;
    @NotNull
    public ProgressBar searchProgressBar;
    @NotNull
    public RecyclerView searchResultsRV;
    @NotNull
    public TextView searchTitleTV;
    @NotNull
    public TextView secondaryInfoSubTitleTV;
    @NotNull
    public TextView secondaryInfoTitleTV;
    @NotNull
    public LinearLayout secondaryInformationLL;
    private SearchPlacesViewModel viewModel;

    /* compiled from: SearchPlaceActivity.kt */
    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/ui/SearchPlaceActivity$Config;", "Landroid/os/Parcelable;", "apiKey", "", FirebaseAnalytics.Param.LOCATION, "enclosingRadius", "searchBarTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "setApiKey", "(Ljava/lang/String;)V", "getEnclosingRadius", "setEnclosingRadius", "getLocation", "setLocation", "getSearchBarTitle", "setSearchBarTitle", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator CREATOR = new Creator();
        @NotNull
        private String apiKey;
        @NotNull
        private String enclosingRadius;
        @NotNull
        private String location;
        @NotNull
        private String searchBarTitle;

        /* compiled from: SearchPlaceActivity.kt */
        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/ui/SearchPlaceActivity$Config$Builder;", "Landroid/os/Parcelable;", "apiKey", "", "(Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "setApiKey", "enclosingRadius", "getEnclosingRadius", "setEnclosingRadius", FirebaseAnalytics.Param.LOCATION, "getLocation", "setLocation", "searchBarTitle", "getSearchBarTitle", "setSearchBarTitle", "build", "Lcom/oneclickaway/opensource/placeautocomplete/ui/SearchPlaceActivity$Config;", "describeContents", "", "setMyLocation", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
        /* loaded from: classes6.dex */
        public static final class Builder implements Parcelable {
            public static final Parcelable.Creator CREATOR = new Creator();
            @NotNull
            private String apiKey;
            @NotNull
            private String enclosingRadius;
            @NotNull
            private String location;
            @NotNull
            private String searchBarTitle;

            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
            /* loaded from: classes6.dex */
            public static class Creator implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Object createFromParcel(@NotNull Parcel in) {
                    Intrinsics.checkParameterIsNotNull(in, "in");
                    return new Builder(in.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Object[] newArray(int i4) {
                    return new Builder[i4];
                }
            }

            public Builder(@NotNull String apiKey) {
                Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
                this.apiKey = apiKey;
                this.location = "";
                this.enclosingRadius = "";
                this.searchBarTitle = "Enter Location";
            }

            @NotNull
            public final Config build() {
                return new Config(this.apiKey, this.location, this.enclosingRadius, this.searchBarTitle);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final String getApiKey() {
                return this.apiKey;
            }

            @NotNull
            public final String getEnclosingRadius() {
                return this.enclosingRadius;
            }

            @NotNull
            public final String getLocation() {
                return this.location;
            }

            @NotNull
            public final String getSearchBarTitle() {
                return this.searchBarTitle;
            }

            public final void setApiKey(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.apiKey = str;
            }

            /* renamed from: setEnclosingRadius  reason: collision with other method in class */
            public final void m4178setEnclosingRadius(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.enclosingRadius = str;
            }

            public final void setLocation(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.location = str;
            }

            @NotNull
            public final Builder setMyLocation(@NotNull String location) {
                Intrinsics.checkParameterIsNotNull(location, "location");
                this.location = location;
                return this;
            }

            /* renamed from: setSearchBarTitle  reason: collision with other method in class */
            public final void m4179setSearchBarTitle(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                this.searchBarTitle = str;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i4) {
                Intrinsics.checkParameterIsNotNull(parcel, "parcel");
                parcel.writeString(this.apiKey);
            }

            @NotNull
            public final Builder setEnclosingRadius(@NotNull String enclosingRadius) {
                Intrinsics.checkParameterIsNotNull(enclosingRadius, "enclosingRadius");
                this.enclosingRadius = enclosingRadius;
                return this;
            }

            @NotNull
            public final Builder setSearchBarTitle(@NotNull String searchBarTitle) {
                Intrinsics.checkParameterIsNotNull(searchBarTitle, "searchBarTitle");
                this.searchBarTitle = searchBarTitle;
                return this;
            }
        }

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
        /* loaded from: classes6.dex */
        public static class Creator implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object createFromParcel(@NotNull Parcel in) {
                Intrinsics.checkParameterIsNotNull(in, "in");
                return new Config(in.readString(), in.readString(), in.readString(), in.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Object[] newArray(int i4) {
                return new Config[i4];
            }
        }

        public Config(@NotNull String apiKey, @NotNull String location, @NotNull String enclosingRadius, @NotNull String searchBarTitle) {
            Intrinsics.checkParameterIsNotNull(apiKey, "apiKey");
            Intrinsics.checkParameterIsNotNull(location, "location");
            Intrinsics.checkParameterIsNotNull(enclosingRadius, "enclosingRadius");
            Intrinsics.checkParameterIsNotNull(searchBarTitle, "searchBarTitle");
            this.apiKey = apiKey;
            this.location = location;
            this.enclosingRadius = enclosingRadius;
            this.searchBarTitle = searchBarTitle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getApiKey() {
            return this.apiKey;
        }

        @NotNull
        public final String getEnclosingRadius() {
            return this.enclosingRadius;
        }

        @NotNull
        public final String getLocation() {
            return this.location;
        }

        @NotNull
        public final String getSearchBarTitle() {
            return this.searchBarTitle;
        }

        public final void setApiKey(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.apiKey = str;
        }

        public final void setEnclosingRadius(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.enclosingRadius = str;
        }

        public final void setLocation(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.location = str;
        }

        public final void setSearchBarTitle(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.searchBarTitle = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i4) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.apiKey);
            parcel.writeString(this.location);
            parcel.writeString(this.enclosingRadius);
            parcel.writeString(this.searchBarTitle);
        }

        public /* synthetic */ Config(String str, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? "Enter Location" : str4);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[LoadingManager.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadingManager loadingManager = LoadingManager.STATE_NO_INTERNET;
            iArr[loadingManager.ordinal()] = 1;
            LoadingManager loadingManager2 = LoadingManager.STATE_ERROR;
            iArr[loadingManager2.ordinal()] = 2;
            LoadingManager loadingManager3 = LoadingManager.STATE_NO_RESULT;
            iArr[loadingManager3.ordinal()] = 3;
            int[] iArr2 = new int[LoadingManager.values().length];
            $EnumSwitchMapping$1 = iArr2;
            LoadingManager loadingManager4 = LoadingManager.STATE_REFRESHING;
            iArr2[loadingManager4.ordinal()] = 1;
            LoadingManager loadingManager5 = LoadingManager.STATE_COMPLETED;
            iArr2[loadingManager5.ordinal()] = 2;
            iArr2[loadingManager.ordinal()] = 3;
            iArr2[loadingManager2.ordinal()] = 4;
            iArr2[loadingManager3.ordinal()] = 5;
            iArr2[LoadingManager.STATE_IDLE.ordinal()] = 6;
            int[] iArr3 = new int[LoadingManager.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[loadingManager4.ordinal()] = 1;
            iArr3[loadingManager5.ordinal()] = 2;
            iArr3[loadingManager.ordinal()] = 3;
            iArr3[loadingManager2.ordinal()] = 4;
            int[] iArr4 = new int[LoadingManager.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[loadingManager5.ordinal()] = 1;
            iArr4[loadingManager4.ordinal()] = 2;
            iArr4[loadingManager2.ordinal()] = 3;
            iArr4[loadingManager.ordinal()] = 4;
            iArr4[loadingManager3.ordinal()] = 5;
        }
    }

    public static final /* synthetic */ SearchResultAdapter access$getSearchListAdapter$p(SearchPlaceActivity searchPlaceActivity) {
        SearchResultAdapter searchResultAdapter = searchPlaceActivity.searchListAdapter;
        if (searchResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
        }
        return searchResultAdapter;
    }

    private final void attachEraserObserver() {
        this.liveQueryInEditText.observe(this, new Observer<String>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachEraserObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@Nullable String str) {
                if (str != null) {
                    if (str.length() > 0) {
                        SearchPlaceActivity.this.getEraseCurrentEntryIV().setVisibility(0);
                        return;
                    }
                }
                SearchPlaceActivity.this.getEraseCurrentEntryIV().setVisibility(8);
            }
        });
    }

    private final void attachLiveObservers() {
        getViewModel().getLiveListOfSearchResultsStream().observe(this, new Observer<List<? extends PredictionsItem>>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$1
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(List<? extends PredictionsItem> list) {
                onChanged2((List<PredictionsItem>) list);
            }

            /* renamed from: onChanged  reason: avoid collision after fix types in other method */
            public final void onChanged2(@Nullable List<PredictionsItem> list) {
                SearchPlaceActivity.access$getSearchListAdapter$p(SearchPlaceActivity.this).setSearchCandidates(list);
            }
        });
        getViewModel().getPlaceDetailsLiveDataStream().observe(this, new Observer<PlaceDetails>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@Nullable PlaceDetails placeDetails) {
                if (placeDetails != null) {
                    Intent intent = new Intent();
                    intent.putExtra(SearchPlacesStatusCodes.INSTANCE.getPLACE_DATA(), placeDetails);
                    SearchPlaceActivity.this.setResult(-1, intent);
                }
                SearchPlaceActivity.this.finishAfterTransition();
            }
        });
        getViewModel().getLoadingPredictionManager().observe(this, new Observer<LoadingManager>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@Nullable LoadingManager loadingManager) {
                if (loadingManager != null) {
                    switch (SearchPlaceActivity.WhenMappings.$EnumSwitchMapping$1[loadingManager.ordinal()]) {
                        case 1:
                            LinearLayout recentSearchesLL = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL.setVisibility(8);
                            SearchPlaceActivity.this.getSearchProgressBar().setVisibility(0);
                            if (SearchPlaceActivity.this.getSecondaryInformationLL().getVisibility() != 0) {
                                SearchPlaceActivity.this.getSearchResultsRV().setVisibility(0);
                                return;
                            }
                            return;
                        case 2:
                            LinearLayout recentSearchesLL2 = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL2 == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL2.setVisibility(8);
                            SearchPlaceActivity.this.getSearchResultsRV().setVisibility(0);
                            SearchPlaceActivity.this.getSearchProgressBar().setVisibility(8);
                            SearchPlaceActivity.this.getSecondaryInformationLL().setVisibility(8);
                            return;
                        case 3:
                            LinearLayout recentSearchesLL3 = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL3 == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL3.setVisibility(8);
                            SearchPlaceActivity.this.setSecondaryStateInformation(LoadingManager.STATE_NO_INTERNET);
                            return;
                        case 4:
                            LinearLayout recentSearchesLL4 = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL4 == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL4.setVisibility(8);
                            SearchPlaceActivity.this.setSecondaryStateInformation(LoadingManager.STATE_ERROR);
                            return;
                        case 5:
                            LinearLayout recentSearchesLL5 = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL5 == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL5.setVisibility(8);
                            SearchPlaceActivity.this.setSecondaryStateInformation(LoadingManager.STATE_NO_RESULT);
                            return;
                        case 6:
                            SearchPlaceActivity.this.getEraseCurrentEntryIV().setVisibility(8);
                            SearchPlaceActivity.this.getSearchResultsRV().setVisibility(8);
                            SearchPlaceActivity.this.getSearchProgressBar().setVisibility(8);
                            SearchPlaceActivity.this.getSecondaryInformationLL().setVisibility(8);
                            LinearLayout recentSearchesLL6 = SearchPlaceActivity.this.getRecentSearchesLL();
                            if (recentSearchesLL6 == null) {
                                Intrinsics.throwNpe();
                            }
                            recentSearchesLL6.setVisibility(0);
                            return;
                    }
                }
                System.out.print((Object) "No loading state detected");
            }
        });
        getViewModel().getLoadingPlaceManager().observe(this, new Observer<LoadingManager>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@Nullable LoadingManager loadingManager) {
                if (loadingManager != null) {
                    int i4 = SearchPlaceActivity.WhenMappings.$EnumSwitchMapping$2[loadingManager.ordinal()];
                    if (i4 == 1) {
                        SearchPlaceActivity.this.getGettingPlaceDataDialog().show();
                        return;
                    } else if (i4 == 2) {
                        SearchPlaceActivity.this.getGettingPlaceDataDialog().cancel();
                        return;
                    } else if (i4 == 3) {
                        SearchPlaceActivity.this.getGettingPlaceDataDialog().cancel();
                        SearchPlaceActivity searchPlaceActivity = SearchPlaceActivity.this;
                        Toast.makeText(searchPlaceActivity, searchPlaceActivity.getString(R.string.no_internet), 1).show();
                        return;
                    } else if (i4 == 4) {
                        SearchPlaceActivity.this.getGettingPlaceDataDialog().cancel();
                        SearchPlaceActivity searchPlaceActivity2 = SearchPlaceActivity.this;
                        Toast.makeText(searchPlaceActivity2, searchPlaceActivity2.getString(R.string.trouble_getting_data), 1).show();
                        return;
                    }
                }
                System.out.print((Object) "No loading state detected");
            }
        });
        getViewModel().getRecentSearchesManager().observe(this, new Observer<LoadingManager>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(@Nullable LoadingManager loadingManager) {
                if (loadingManager != null && SearchPlaceActivity.WhenMappings.$EnumSwitchMapping$3[loadingManager.ordinal()] == 3) {
                    Toast.makeText(SearchPlaceActivity.this, "State Error", 1).show();
                }
            }
        });
        getViewModel().getRecentSearchesData().observe(this, new Observer<List<? extends SearchSelectedItem>>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$attachLiveObservers$6
            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(List<? extends SearchSelectedItem> list) {
                onChanged2((List<SearchSelectedItem>) list);
            }

            /* renamed from: onChanged  reason: avoid collision after fix types in other method */
            public final void onChanged2(@Nullable List<SearchSelectedItem> list) {
                if (list != null) {
                    SearchPlaceActivity.this.getRecentSearchesRV().setLayoutManager(new LinearLayoutManager(SearchPlaceActivity.this));
                    SearchPlaceActivity.this.getRecentSearchesRV().setAdapter(new RecentSearchesAdapter(new GroupStrategy().groupDataByTime(list), SearchPlaceActivity.this));
                }
            }
        });
        attachEraserObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchPlacesViewModel getViewModel() {
        SearchPlacesViewModel searchPlacesViewModel = this.viewModel;
        if (searchPlacesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return searchPlacesViewModel;
    }

    private final void inflateViews() {
        View findViewById = findViewById(R.id.searchTitleTV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.searchTitleTV)");
        this.searchTitleTV = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.searchProgressBar);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.searchProgressBar)");
        this.searchProgressBar = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(R.id.secondaryInformationLL);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.secondaryInformationLL)");
        this.secondaryInformationLL = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.placeNamET);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.placeNamET)");
        this.placeNamET = (EditText) findViewById4;
        View findViewById5 = findViewById(R.id.searchResultsRV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.searchResultsRV)");
        this.searchResultsRV = (RecyclerView) findViewById5;
        View findViewById6 = findViewById(R.id.secondaryInfoTitleTV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.secondaryInfoTitleTV)");
        this.secondaryInfoTitleTV = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.secondaryInfoSubTitleTV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.secondaryInfoSubTitleTV)");
        this.secondaryInfoSubTitleTV = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.backImageBtn);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.backImageBtn)");
        this.backImageBtn = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.recentSearchesRV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.recentSearchesRV)");
        this.recentSearchesRV = (RecyclerView) findViewById9;
        this.recentSearchesLL = (LinearLayout) findViewById(R.id.recentSearchesLL);
        View findViewById10 = findViewById(R.id.eraseCurrentEntryIV);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "findViewById(R.id.eraseCurrentEntryIV)");
        this.eraseCurrentEntryIV = (ImageView) findViewById10;
    }

    private final void initDb() {
        this.recentSearchesDB = RecentSearchesDB.Companion.getInstance(this);
        getViewModel().requestListOfRecentSearches();
    }

    private final void initDialogForGettingPlaceDetails() {
        Dialog dialog = new Dialog(this);
        this.gettingPlaceDataDialog = dialog;
        dialog.setContentView(R.layout.loading_place_details);
        Dialog dialog2 = this.gettingPlaceDataDialog;
        if (dialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gettingPlaceDataDialog");
        }
        Glide.with((FragmentActivity) this).asGif().m4150load(Integer.valueOf(R.raw.loading_spinner)).into((ImageView) dialog2.findViewById(R.id.progressImageIV));
    }

    private final void initializeDependency() {
        Config config;
        String str;
        String str2;
        String str3;
        Intent intent = getIntent();
        SearchPlacesStatusCodes searchPlacesStatusCodes = SearchPlacesStatusCodes.INSTANCE;
        if (intent.hasExtra(searchPlacesStatusCodes.getCONFIG())) {
            Intent intent2 = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
            Bundle extras = intent2.getExtras();
            String str4 = null;
            if (extras != null) {
                config = (Config) extras.getParcelable(searchPlacesStatusCodes.getCONFIG());
            } else {
                config = null;
            }
            if (config != null) {
                str = config.getApiKey();
            } else {
                str = null;
            }
            this.apiKey = str;
            if (config != null) {
                str2 = config.getLocation();
            } else {
                str2 = null;
            }
            this.location = str2;
            if (config != null) {
                str3 = config.getEnclosingRadius();
            } else {
                str3 = null;
            }
            this.enclosingRadius = str3;
            TextView textView = this.searchTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchTitleTV");
            }
            if (config != null) {
                str4 = config.getSearchBarTitle();
            }
            textView.setText(str4);
            return;
        }
        Toast.makeText(this, "Please mention the api key in put-extra", 1).show();
        finish();
    }

    private final void setOnClickListeners() {
        ImageView imageView = this.backImageBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImageBtn");
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.eraseCurrentEntryIV;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eraseCurrentEntryIV");
        }
        imageView2.setOnClickListener(this);
    }

    private final void setOnQueryChangeListener() {
        EditText editText = this.placeNamET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeNamET");
        }
        RxTextView.textChanges(editText).debounce(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribeWith(new DisposableObserver<CharSequence>() { // from class: com.oneclickaway.opensource.placeautocomplete.ui.SearchPlaceActivity$setOnQueryChangeListener$1
            @Override // io.reactivex.Observer
            public void onComplete() {
                System.out.print((Object) "Completed");
            }

            @Override // io.reactivex.Observer
            public void onError(@NotNull Throwable e4) {
                Intrinsics.checkParameterIsNotNull(e4, "e");
                e4.printStackTrace();
            }

            @Override // io.reactivex.Observer
            public void onNext(@NotNull CharSequence t3) {
                MutableLiveData mutableLiveData;
                SearchPlacesViewModel viewModel;
                String str;
                String str2;
                String str3;
                Intrinsics.checkParameterIsNotNull(t3, "t");
                mutableLiveData = SearchPlaceActivity.this.liveQueryInEditText;
                mutableLiveData.postValue(t3.toString());
                viewModel = SearchPlaceActivity.this.getViewModel();
                String obj = t3.toString();
                str = SearchPlaceActivity.this.apiKey;
                if (str == null) {
                    Intrinsics.throwNpe();
                }
                str2 = SearchPlaceActivity.this.location;
                if (str2 == null) {
                    str2 = "";
                }
                str3 = SearchPlaceActivity.this.enclosingRadius;
                if (str3 == null) {
                    str3 = "500";
                }
                viewModel.requestListOfSearchResults(obj, str, str2, str3);
            }
        });
    }

    private final void setRecyclerView() {
        RecyclerView recyclerView = this.searchResultsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultsRV");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.searchListAdapter = new SearchResultAdapter(null, this, 1, null);
        RecyclerView recyclerView2 = this.searchResultsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultsRV");
        }
        SearchResultAdapter searchResultAdapter = this.searchListAdapter;
        if (searchResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
        }
        recyclerView2.setAdapter(searchResultAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSecondaryStateInformation(LoadingManager loadingManager) {
        RecyclerView recyclerView = this.searchResultsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultsRV");
        }
        recyclerView.setVisibility(8);
        ProgressBar progressBar = this.searchProgressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchProgressBar");
        }
        progressBar.setVisibility(8);
        LinearLayout linearLayout = this.secondaryInformationLL;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInformationLL");
        }
        linearLayout.setVisibility(0);
        int i4 = WhenMappings.$EnumSwitchMapping$0[loadingManager.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    System.out.print((Object) "no state detected");
                    return;
                }
                TextView textView = this.secondaryInfoTitleTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoTitleTV");
                }
                textView.setText(getString(R.string.location_not_found));
                TextView textView2 = this.secondaryInfoSubTitleTV;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoSubTitleTV");
                }
                textView2.setText(getString(R.string.please_check_spell_errors));
                return;
            }
            TextView textView3 = this.secondaryInfoTitleTV;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoTitleTV");
            }
            textView3.setText("Oops!");
            TextView textView4 = this.secondaryInfoSubTitleTV;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoSubTitleTV");
            }
            textView4.setText("We're having some trouble connecting to our servers");
            return;
        }
        TextView textView5 = this.secondaryInfoTitleTV;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoTitleTV");
        }
        textView5.setText("No internet");
        TextView textView6 = this.secondaryInfoSubTitleTV;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoSubTitleTV");
        }
        textView6.setText("Please connect to internet and try again");
    }

    private final void setViewModel() {
        ViewModel viewModel = ViewModelProviders.of(this).get(SearchPlacesViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(th…cesViewModel::class.java)");
        this.viewModel = (SearchPlacesViewModel) viewModel;
    }

    @NotNull
    public final ImageView getBackImageBtn() {
        ImageView imageView = this.backImageBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backImageBtn");
        }
        return imageView;
    }

    @NotNull
    public final ImageView getEraseCurrentEntryIV() {
        ImageView imageView = this.eraseCurrentEntryIV;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eraseCurrentEntryIV");
        }
        return imageView;
    }

    @NotNull
    public final Dialog getGettingPlaceDataDialog() {
        Dialog dialog = this.gettingPlaceDataDialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gettingPlaceDataDialog");
        }
        return dialog;
    }

    @NotNull
    public final EditText getPlaceNamET() {
        EditText editText = this.placeNamET;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeNamET");
        }
        return editText;
    }

    @Nullable
    public final RecentSearchesDB getRecentSearchesDB() {
        return this.recentSearchesDB;
    }

    @Nullable
    public final LinearLayout getRecentSearchesLL() {
        return this.recentSearchesLL;
    }

    @NotNull
    public final RecyclerView getRecentSearchesRV() {
        RecyclerView recyclerView = this.recentSearchesRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentSearchesRV");
        }
        return recyclerView;
    }

    @NotNull
    public final ProgressBar getSearchProgressBar() {
        ProgressBar progressBar = this.searchProgressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchProgressBar");
        }
        return progressBar;
    }

    @NotNull
    public final RecyclerView getSearchResultsRV() {
        RecyclerView recyclerView = this.searchResultsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultsRV");
        }
        return recyclerView;
    }

    @NotNull
    public final TextView getSearchTitleTV() {
        TextView textView = this.searchTitleTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTitleTV");
        }
        return textView;
    }

    @NotNull
    public final TextView getSecondaryInfoSubTitleTV() {
        TextView textView = this.secondaryInfoSubTitleTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoSubTitleTV");
        }
        return textView;
    }

    @NotNull
    public final TextView getSecondaryInfoTitleTV() {
        TextView textView = this.secondaryInfoTitleTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInfoTitleTV");
        }
        return textView;
    }

    @NotNull
    public final LinearLayout getSecondaryInformationLL() {
        LinearLayout linearLayout = this.secondaryInformationLL;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondaryInformationLL");
        }
        return linearLayout;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        if (view != null) {
            num = Integer.valueOf(view.getId());
        } else {
            num = null;
        }
        int i4 = R.id.backImageBtn;
        if (num != null && num.intValue() == i4) {
            onBackPressed();
            return;
        }
        int i5 = R.id.eraseCurrentEntryIV;
        if (num != null && num.intValue() == i5) {
            EditText editText = this.placeNamET;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeNamET");
            }
            editText.getText().clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_place);
        setViewModel();
        initDb();
        inflateViews();
        initializeDependency();
        initDialogForGettingPlaceDetails();
        setOnClickListeners();
        setRecyclerView();
        setOnQueryChangeListener();
        attachLiveObservers();
    }

    @Override // com.oneclickaway.opensource.placeautocomplete.interfaces.SearchPlaces.PlaceItemSelectedListener
    public void onPlaceItemSelected(@Nullable PredictionsItem predictionsItem) {
        if (predictionsItem != null) {
            SearchPlacesViewModel viewModel = getViewModel();
            String valueOf = String.valueOf(predictionsItem.getPlaceId());
            String str = this.apiKey;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            viewModel.requestPlaceDetails(valueOf, str);
        }
    }

    @Override // com.oneclickaway.opensource.placeautocomplete.interfaces.SearchPlaces.RecentItemSelectedListener
    public void onRecantsItemSelected(@NotNull GroupStrategy.ListItem savedItem) {
        Intrinsics.checkParameterIsNotNull(savedItem, "savedItem");
        if (savedItem instanceof GroupStrategy.GeneralItem) {
            SearchPlacesViewModel viewModel = getViewModel();
            String placeId = ((GroupStrategy.GeneralItem) savedItem).getSearchSelectedItem().getPlaceId();
            String str = this.apiKey;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            viewModel.requestPlaceDetails(placeId, str);
        }
    }

    public final void setBackImageBtn(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.backImageBtn = imageView;
    }

    public final void setEraseCurrentEntryIV(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.eraseCurrentEntryIV = imageView;
    }

    public final void setGettingPlaceDataDialog(@NotNull Dialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "<set-?>");
        this.gettingPlaceDataDialog = dialog;
    }

    public final void setPlaceNamET(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "<set-?>");
        this.placeNamET = editText;
    }

    public final void setRecentSearchesDB(@Nullable RecentSearchesDB recentSearchesDB) {
        this.recentSearchesDB = recentSearchesDB;
    }

    public final void setRecentSearchesLL(@Nullable LinearLayout linearLayout) {
        this.recentSearchesLL = linearLayout;
    }

    public final void setRecentSearchesRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.recentSearchesRV = recyclerView;
    }

    public final void setSearchProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.searchProgressBar = progressBar;
    }

    public final void setSearchResultsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.searchResultsRV = recyclerView;
    }

    public final void setSearchTitleTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.searchTitleTV = textView;
    }

    public final void setSecondaryInfoSubTitleTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.secondaryInfoSubTitleTV = textView;
    }

    public final void setSecondaryInfoTitleTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.secondaryInfoTitleTV = textView;
    }

    public final void setSecondaryInformationLL(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.secondaryInformationLL = linearLayout;
    }
}
