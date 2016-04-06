package com.crazystone.test.datastructure;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.crazystone.test.R;
import com.crazystone.test.datastructure.data.BinaryTree;
import com.crazystone.test.datastructure.data.Tree;
import com.crazystone.test.datastructure.view.MyTreeView;
import com.crazystone.utils.BaseActivity;
import com.crazystone.utils.common.L;
import com.crazystone.utils.common.UIUtils;
import com.crazystone.utils.quickdev.annotation.SetContentView;
import com.crazystone.utils.quickdev.annotation.ViewInject;

import java.util.Iterator;


/**
 * Created by crazystone on 2016/4/5.
 */
@SetContentView(R.layout.activty_tree_view)
public class TreeTestActivity extends BaseActivity {

    @ViewInject(R.id.btn_insert)
    private Button btn_insert;
    @ViewInject(R.id.btn_delete)
    private Button btn_delete;
    @ViewInject(R.id.edt_number)
    private EditText edt_number;
    @ViewInject(R.id.treeview)
    private MyTreeView mTreeView;
    @ViewInject(R.id.btn_search)
    private Button btn_search;
    @ViewInject(R.id.edt_search_number)
    private EditText edt_search;
    private Tree<Integer> mTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTree = new BinaryTree<Integer>();
        $(btn_delete, btn_insert, btn_search);
    }

    Integer number = 0;

    @Override
    public void onClick(View view) {
        if (edt_number.getText() == null && edt_number.getText().toString().trim().equals("")) return;
        else number = Integer.parseInt(edt_number.getText().toString());
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn_insert:
                if (mTree != null) {
                    if (!mTree.search(number)) {
                        mTree.insert(number);
                        L.d("TAG", "tree size:" + mTree.size());

                        Iterator iterator = mTree.iterator();
                        while (iterator.hasNext()) {
                            L.d("TAG", "tree element is:" + iterator.next());
                        }

                        mTreeView.setData((BinaryTree<Integer>) mTree);
                    } else {
                        UIUtils.shortToast(TreeTestActivity.this, "该树中已经有该元素");
                    }
                }
                break;
            case R.id.btn_delete:
                if (mTree != null) {
                    if (mTree.search(number)) {
                        mTree.delete(number);
                        mTreeView.setData((BinaryTree<Integer>) mTree);
                    } else {
                        UIUtils.shortToast(TreeTestActivity.this, "该树中没有该元素");
                    }
                }
                break;
            case R.id.btn_search:
                if (mTree != null) {
                    mTreeView.search(Integer.parseInt(edt_search.getText().toString()));
                }
                break;
        }
    }
}
