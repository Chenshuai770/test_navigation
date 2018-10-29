package cs.com.test_navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTest;
    private BottomNavigationBar mNavigationBar;
    private TextBadgeItem mTextBadgeItem;
    private ShapeBadgeItem mShapeBadgeItem;
    private Button mBtnTest;
    private Button mBtnTest2;
    private Fragment[] mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    private void initFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();
        Fragment5 fragment5 = new Fragment5();

        mFragment = new Fragment[]{fragment1, fragment2, fragment3, fragment4,fragment5};
        beginTransaction.add(R.id.fl_layout,mFragment[0]);
        beginTransaction.add(R.id.fl_layout,mFragment[1]);
        beginTransaction.add(R.id.fl_layout,mFragment[2]);
        beginTransaction.add(R.id.fl_layout,mFragment[3]);
        beginTransaction.add(R.id.fl_layout,mFragment[4]);

        beginTransaction.show(mFragment[0]);
        beginTransaction.hide(mFragment[1]);
        beginTransaction.hide(mFragment[2]);
        beginTransaction.hide(mFragment[3]);
        beginTransaction.hide(mFragment[4]);
        beginTransaction.commit();

    }

    private void initView() {
        mTvTest = (TextView) findViewById(R.id.tv_test);
        mNavigationBar = (BottomNavigationBar) findViewById(R.id.navigationBar);

        mTextBadgeItem = new TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setAnimationDuration(200)
                .setText("55")
                .setHideOnSelect(false);
        mShapeBadgeItem = new ShapeBadgeItem()
                .setShapeColorResource(R.color.colorPrimary)
                .setGravity(Gravity.TOP | Gravity.END)
                .setHideOnSelect(true);


        mNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页").setBadgeItem(mTextBadgeItem).setActiveColorResource(R.color.bule)//设置选中的颜色
                        .setActiveColorResource(R.color.bule))//设为未选中的颜色)
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setBadgeItem(mShapeBadgeItem))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setFirstSelectedPosition(0)
                .initialise();
        mBtnTest = (Button) findViewById(R.id.btn_test);
        mBtnTest.setOnClickListener(this);
        mBtnTest2 = (Button) findViewById(R.id.btn_test2);
        mBtnTest2.setOnClickListener(this);

        mNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Log.d("MainActivity", "position:" + position);
                selectItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
    private void selectItem(int pos){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();


        for (int i = 0; i < mFragment.length; i++) {
            if (i==pos){
                beginTransaction.show(mFragment[i]);
            }else {
                beginTransaction.hide(mFragment[i]);
            }
        }
       beginTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:
                if (mNavigationBar.isHidden()) {
                    mNavigationBar.show();
                } else {
                    mNavigationBar.hide();
                }
                break;
            case R.id.btn_test2:
                if (mTextBadgeItem.isHidden()) {
                    mTextBadgeItem.show();
                } else {
                    mTextBadgeItem.hide();
                }
                break;
        }
    }
}
