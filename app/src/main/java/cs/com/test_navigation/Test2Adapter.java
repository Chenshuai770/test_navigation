package cs.com.test_navigation;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ChenShuai on 2018/11/14/014.
 */

public class Test2Adapter extends BaseQuickAdapter<String ,BaseViewHolder> {
    public Test2Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_test2,item);
    }
}
