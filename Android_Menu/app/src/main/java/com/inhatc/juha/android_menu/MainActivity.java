package com.inhatc.juha.android_menu;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static  final int ID_Group_Text_COLOR = 1;
    public static  final int ID_Group_Text_STYLE = 2;
    public static  final int ID_Group_Text_SIZE = 3;
    public static  final int ID_Group_ARTIST = 4;
    public static  final int ID_Group_ALBUM = 5;
    public static  final int ID_Group_SONG = 6;
    public static  final int ID_Group_MOVIE = 7;

    public static  final int ID_COLOR_RED = 11;
    public static  final int ID_COLOR_GREEN = 12;
    public static  final int ID_COLOR_BLUE = 13;

    public static final int ID_TEXT_NORMAL = 21;
    public static final int ID_TEXT_BOLD = 22;
    public static final int ID_TEXT_ITALIC = 23;

    public static final int ID_TEXTSIZE_10P = 31;
    public static final int ID_TEXTSIZE_18P = 32;
    public static final int ID_TEXTSIZE_24P = 33;

    TextView objTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTxtView = (TextView)findViewById(R.id.textView1);

        registerForContextMenu(objTxtView);
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu mnuTextColor = menu.addSubMenu("Text Color");
        mnuTextColor.add(ID_Group_Text_COLOR, ID_COLOR_RED, 1, "Red");
        mnuTextColor.add(ID_Group_Text_COLOR, ID_COLOR_GREEN, 2, "Green");
        mnuTextColor.add(ID_Group_Text_COLOR, ID_COLOR_BLUE, 3, "Blue");

        SubMenu mnuTextStyle = menu.addSubMenu("Text Style");
        mnuTextStyle.add(ID_Group_Text_STYLE, ID_TEXT_NORMAL, 1, "Normal").setChecked(true);
        mnuTextStyle.add(ID_Group_Text_STYLE, ID_TEXT_BOLD, 2, "Bold").setChecked(true);
        mnuTextStyle.add(ID_Group_Text_STYLE, ID_TEXT_ITALIC, 3, "Italic").setChecked(true);

        SubMenu mnuTextSize = menu.addSubMenu("Text Size");
        mnuTextSize.add(ID_Group_Text_SIZE, ID_TEXTSIZE_10P, 1, "10 Pt");
        mnuTextSize.add(ID_Group_Text_SIZE, ID_TEXTSIZE_18P, 2, "18 Pt");
        mnuTextSize.add(ID_Group_Text_SIZE, ID_TEXTSIZE_24P, 3, "24 Pt");

        SubMenu mnuArtist = menu.addSubMenu("Artist");
        mnuArtist.setIcon(R.drawable.artist);

        SubMenu mnuAlbum = menu.addSubMenu("Album");
        mnuAlbum.setIcon(R.drawable.album);

        SubMenu mnuSong = menu.addSubMenu("Song");
        mnuSong.setIcon(R.drawable.song);

        SubMenu mnuMovie = menu.addSubMenu("Movie");

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Prepare the Screen's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.  You can
     * use this method to efficiently enable/disable items or otherwise
     * dynamically modify the contents.
     * <p>
     * <p>The default implementation updates the system menu items based on the
     * activity's state.  Deriving classes should always call through to the
     * base class implementation.
     *
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case ID_COLOR_RED:
                objTxtView.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxtView.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxtView.setTextColor(Color.BLUE);
                return true;
            case ID_TEXT_NORMAL:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                item.setChecked(true);
                return true;
            case ID_TEXT_BOLD:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                item.setChecked(true);
                return true;
            case ID_TEXT_ITALIC:
                objTxtView.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                item.setChecked(true);
                return true;
            case ID_TEXTSIZE_10P:
                objTxtView.setTextSize(10);
                return true;
            case ID_TEXTSIZE_18P:
                objTxtView.setTextSize(18);
                return true;
            case ID_TEXTSIZE_24P:
                objTxtView.setTextSize(24);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when a context menu for the {@code view} is about to be shown.
     * Unlike {@link #onCreateOptionsMenu(Menu)}, this will be called every
     * time the context menu is about to be shown and should be populated for
     * the view (or item inside the view for {@link AdapterView} subclasses,
     * this can be found in the {@code menuInfo})).
     * <p>
     * Use {@link #onContextItemSelected(MenuItem)} to know when an
     * item has been selected.
     * <p>
     * It is not safe to hold onto the context menu after this method returns.
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        SubMenu mnuTextBackGroundColor = menu.addSubMenu("Text Background Color");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_RED, Menu.NONE, "Red");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_GREEN, Menu.NONE, "Green");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_BLUE, Menu.NONE, "Blue");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    /**
     * This hook is called whenever an item in a context menu is selected. The
     * default implementation simply returns false to have the normal processing
     * happen (calling the item's Runnable or sending a message to its Handler
     * as appropriate). You can use this method for any items for which you
     * would like to do processing without those other facilities.
     * <p>
     * Use {@link MenuItem#getMenuInfo()} to get extra information set by the
     * View that added this menu item.
     * <p>
     * Derived classes should call through to the base class for it to perform
     * the default menu handling.
     *
     * @param item The context menu item that was selected.
     * @return boolean Return false to allow normal context menu processing to
     * proceed, true to consume it here.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case ID_COLOR_RED:
                objTxtView.setBackgroundColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxtView.setBackgroundColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxtView.setBackgroundColor(Color.BLUE);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
