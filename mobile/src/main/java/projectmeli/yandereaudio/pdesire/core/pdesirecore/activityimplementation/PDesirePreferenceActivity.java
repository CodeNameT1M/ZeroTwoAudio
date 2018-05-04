package projectmeli.yandereaudio.pdesire.core.pdesirecore.activityimplementation;

import android.app.Fragment;
import android.app.FragmentBreadCrumbs;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

import projectmeli.yandereaudio.pdesire.R;

public abstract class PDesirePreferenceActivity extends AppCompatPreferenceActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0f);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * Returns true if this activity is currently showing the header list.
     */
    @Override
    public boolean hasHeaders() {
        return super.hasHeaders();
    }

    /**
     * Returns true if this activity is showing multiple panes -- the headers
     * and a preference fragment.
     */
    @Override
    public boolean isMultiPane() {
        return super.isMultiPane();
    }

    /**
     * Called to determine if the activity should run in multi-pane mode.
     * The default implementation returns true if the screen is large
     * enough.
     */
    @Override
    public boolean onIsMultiPane() {
        return super.onIsMultiPane();
    }

    /**
     * Called to determine whether the header list should be hidden.
     * The default implementation returns the
     * value given in {@link #EXTRA_NO_HEADERS} or false if it is not supplied.
     * This is set to false, for example, when the activity is being re-launched
     * to show a particular preference activity.
     */
    @Override
    public boolean onIsHidingHeaders() {
        return super.onIsHidingHeaders();
    }

    /**
     * Called to determine the initial header to be shown.  The default
     * implementation simply returns the fragment of the first header.  Note
     * that the returned Header object does not actually need to exist in
     * your header list -- whatever its fragment is will simply be used to
     * show for the initial UI.
     */
    @Override
    public Header onGetInitialHeader() {
        return super.onGetInitialHeader();
    }

    /**
     * Called after the header list has been updated ({@link #onBuildHeaders}
     * has been called and returned due to {@link #invalidateHeaders()}) to
     * specify the header that should now be selected.  The default implementation
     * returns null to keep whatever header is currently selected.
     */
    @Override
    public Header onGetNewHeader() {
        return super.onGetNewHeader();
    }

    /**
     * Called when the activity needs its list of headers build.  By
     * implementing this and adding at least one item to the list, you
     * will cause the activity to run in its modern fragment mode.  Note
     * that this function may not always be called; for example, if the
     * activity has been asked to display a particular fragment without
     * the header list, there is no need to build the headers.
     * <p>
     * <p>Typical implementations will use {@link #loadHeadersFromResource}
     * to fill in the list from a resource.
     *
     * @param target The list in which to place the headers.
     */
    @Override
    public void onBuildHeaders(List<Header> target) {
        super.onBuildHeaders(target);
    }

    /**
     * Call when you need to change the headers being displayed.  Will result
     * in onBuildHeaders() later being called to retrieve the new list.
     */
    @Override
    public void invalidateHeaders() {
        super.invalidateHeaders();
    }

    /**
     * Parse the given XML file as a header description, adding each
     * parsed Header into the target list.
     *
     * @param resid  The XML resource to load and parse.
     * @param target The list in which the parsed headers should be placed.
     */
    @Override
    public void loadHeadersFromResource(int resid, List<Header> target) {
        super.loadHeadersFromResource(resid, target);
    }

    /**
     * Subclasses should override this method and verify that the given fragment is a valid type
     * to be attached to this activity. The default implementation returns <code>true</code> for
     * apps built for <code>android:targetSdkVersion</code> older than
     * {@link Build.VERSION_CODES#KITKAT}. For later versions, it will throw an exception.
     *
     * @param fragmentName the class name of the Fragment about to be attached to this activity.
     * @return true if the fragment class name is valid for this Activity and false otherwise.
     */
    @Override
    protected boolean isValidFragment(String fragmentName) {
        return super.isValidFragment(fragmentName);
    }

    /**
     * Set a footer that should be shown at the bottom of the header list.
     *
     * @param view
     */
    @Override
    public void setListFooter(View view) {
        super.setListFooter(view);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        return super.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

    @NonNull
    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    /**
     * Called when the user selects an item in the header list.  The default
     * implementation will call either
     * {@link #startWithFragment(String, Bundle, Fragment, int, int, int)}
     * or {@link #switchToHeader(Header)} as appropriate.
     *
     * @param header   The header that was selected.
     * @param position The header's position in the list.
     */
    @Override
    public void onHeaderClick(Header header, int position) {
        super.onHeaderClick(header, position);
    }

    /**
     * Called by {@link #startWithFragment(String, Bundle, Fragment, int, int, int)} when
     * in single-pane mode, to build an Intent to launch a new activity showing
     * the selected fragment.  The default implementation constructs an Intent
     * that re-launches the current activity with the appropriate arguments to
     * display the fragment.
     *
     * @param fragmentName  The name of the fragment to display.
     * @param args          Optional arguments to supply to the fragment.
     * @param titleRes      Optional resource ID of title to show for this item.
     * @param shortTitleRes Optional resource ID of short title to show for this item.
     * @return Returns an Intent that can be launched to display the given
     * fragment.
     */
    @Override
    public Intent onBuildStartFragmentIntent(String fragmentName, Bundle args, int titleRes, int shortTitleRes) {
        return super.onBuildStartFragmentIntent(fragmentName, args, titleRes, shortTitleRes);
    }

    /**
     * Like {@link #startWithFragment(String, Bundle, Fragment, int, int, int)}
     * but uses a 0 titleRes.
     *
     * @param fragmentName
     * @param args
     * @param resultTo
     * @param resultRequestCode
     */
    @Override
    public void startWithFragment(String fragmentName, Bundle args, Fragment resultTo, int resultRequestCode) {
        super.startWithFragment(fragmentName, args, resultTo, resultRequestCode);
    }

    /**
     * Start a new instance of this activity, showing only the given
     * preference fragment.  When launched in this mode, the header list
     * will be hidden and the given preference fragment will be instantiated
     * and fill the entire activity.
     *
     * @param fragmentName      The name of the fragment to display.
     * @param args              Optional arguments to supply to the fragment.
     * @param resultTo          Option fragment that should receive the result of
     *                          the activity launch.
     * @param resultRequestCode If resultTo is non-null, this is the request
     *                          code in which to report the result.
     * @param titleRes          Resource ID of string to display for the title of
     *                          this set of preferences.
     * @param shortTitleRes     Resource ID of string to display for the short title of
     */
    @Override
    public void startWithFragment(String fragmentName, Bundle args, Fragment resultTo, int resultRequestCode, int titleRes, int shortTitleRes) {
        super.startWithFragment(fragmentName, args, resultTo, resultRequestCode, titleRes, shortTitleRes);
    }

    /**
     * Change the base title of the bread crumbs for the current preferences.
     * This will normally be called for you.  See
     * {@link FragmentBreadCrumbs} for more information.
     *
     * @param title
     * @param shortTitle
     */
    @Override
    public void showBreadCrumbs(CharSequence title, CharSequence shortTitle) {
        super.showBreadCrumbs(title, shortTitle);
    }

    /**
     * Should be called after onCreate to ensure that the breadcrumbs, if any, were created.
     * This prepends a title to the fragment breadcrumbs and attaches a listener to any clicks
     * on the parent entry.
     *
     * @param title      the title for the breadcrumb
     * @param shortTitle the short title for the breadcrumb
     * @param listener
     */
    @Override
    public void setParentTitle(CharSequence title, CharSequence shortTitle, View.OnClickListener listener) {
        super.setParentTitle(title, shortTitle, listener);
    }

    /**
     * When in two-pane mode, switch the fragment pane to show the given
     * preference fragment.
     *
     * @param fragmentName The name of the fragment to display.
     * @param args         Optional arguments to supply to the fragment.
     */
    @Override
    public void switchToHeader(String fragmentName, Bundle args) {
        super.switchToHeader(fragmentName, args);
    }

    /**
     * When in two-pane mode, switch to the fragment pane to show the given
     * preference fragment.
     *
     * @param header The new header to display.
     */
    @Override
    public void switchToHeader(Header header) {
        super.switchToHeader(header);
    }

    /**
     * Start a new fragment.
     *
     * @param fragment The fragment to start
     * @param push     If true, the current fragment will be pushed onto the back stack.  If false,
     */
    @Override
    public void startPreferenceFragment(Fragment fragment, boolean push) {
        super.startPreferenceFragment(fragment, push);
    }

    /**
     * Start a new fragment containing a preference panel.  If the preferences
     * are being displayed in multi-pane mode, the given fragment class will
     * be instantiated and placed in the appropriate pane.  If running in
     * single-pane mode, a new activity will be launched in which to show the
     * fragment.
     *
     * @param fragmentClass     Full name of the class implementing the fragment.
     * @param args              Any desired arguments to supply to the fragment.
     * @param titleRes          Optional resource identifier of the title of this
     *                          fragment.
     * @param titleText         Optional text of the title of this fragment.
     * @param resultTo          Optional fragment that result data should be sent to.
     *                          If non-null, resultTo.onActivityResult() will be called when this
     *                          preference panel is done.  The launched panel must use
     *                          {@link #finishPreferencePanel(Fragment, int, Intent)} when done.
     * @param resultRequestCode If resultTo is non-null, this is the caller's
     */
    @Override
    public void startPreferencePanel(String fragmentClass, Bundle args, int titleRes, CharSequence titleText, Fragment resultTo, int resultRequestCode) {
        super.startPreferencePanel(fragmentClass, args, titleRes, titleText, resultTo, resultRequestCode);
    }

    /**
     * Called by a preference panel fragment to finish itself.
     *
     * @param caller     The fragment that is asking to be finished.
     * @param resultCode Optional result code to send back to the original
     *                   launching fragment.
     * @param resultData Optional result data to send back to the original
     */
    @Override
    public void finishPreferencePanel(Fragment caller, int resultCode, Intent resultData) {
        super.finishPreferencePanel(caller, resultCode, resultData);
    }

    @Override
    public boolean onPreferenceStartFragment(PreferenceFragment caller, Preference pref) {
        return super.onPreferenceStartFragment(caller, pref);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }
}
