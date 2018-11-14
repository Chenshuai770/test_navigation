package cs.com.test_navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cs.com.test_navigation.common.GlideImageLoader;

/**
 * Created by ChenShuai on 2018/10/29/029.
 */

public class Fragment1 extends Fragment {

    private View view;
    private FloatingActionButton fab;
    private AppBarLayout mAppBar;
    private List<Integer> images = new ArrayList<Integer>();
    private RecyclerView mRecyclerView;
    private List<String> mData = new ArrayList<>();
    private Fragment1Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);

        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mData.clear();
        mData.add(getString(R.string.large_text));
        adapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        images.add(R.drawable.abc);
        images.add(R.drawable.cde);
        images.add(R.drawable.kkk);

        mAppBar = (AppBarLayout) view.findViewById(R.id.app_bar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rlv_fm1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new Fragment1Adapter(R.layout.item_f1, mData);
        mRecyclerView.setAdapter(adapter);
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.item_f1_header, null);
        adapter.addHeaderView(headView);

        mAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.d("TTT", "i" + i);
                if (i == 0) {
                    fab.setVisibility(View.VISIBLE);
                } else {
                    fab.setVisibility(View.GONE);
                }
            }
        });

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Banner banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


    }
}
