package cs.com.test_navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRlTest1;
    private Button mBtnTest;
    private SeekBar mSeekbar;
    private TextView mTv1;
    private TextView mTv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();


    }

    private void initView() {


        mBtnTest = (Button) findViewById(R.id.btn_test);
        mBtnTest.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                200));
        mBtnTest.setOnClickListener(this);
        mSeekbar = (SeekBar) findViewById(R.id.seekbar);
        mSeekbar.setOnClickListener(this);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv1.setOnClickListener(this);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv2.setOnClickListener(this);

        ViewTreeObserver vto = mBtnTest.getViewTreeObserver();

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                mTv1.setText("正在拖动");
                mTv2.setText("当前数值："+progress);
                Log.d("TestActivity", "mBtnTest.getHeight()-progress:" + (mBtnTest.getHeight() - progress));
                mBtnTest.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        200-progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mTv1.setText("开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mTv1.setText("停止拖动");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test:

                Log.d("TestActivity", "mBtnTest.getHeight():" + mBtnTest.getHeight());
                break;
        }
    }
}
