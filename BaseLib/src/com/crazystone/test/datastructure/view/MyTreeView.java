package com.crazystone.test.datastructure.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.crazystone.test.R;
import com.crazystone.test.datastructure.data.BinaryTree;
import com.crazystone.test.datastructure.data.Tree;

import java.math.MathContext;

/**
 * Created by crazystone on 2016/4/5.
 */
public class MyTreeView extends View {

    private Context mContext;
    /*  数据源  */
    private Integer[] mDataArray = new Integer[]{7, 4, 9, 2, 6, 5, 1, 15, 23, 30, 14};
    /* tree画笔  */
    private Paint mPaint;
    /*  tree搜索路径的画笔 */
    private Paint mSearchPaint;
    /* 画笔的宽度  */
    private static final int PAINT_SIZE = 2;
    /* 圆环的半径  */
    private static final int RADIUS = 20;
    /* 文字的字体大小  */
    private static final int TEXT_SIZE = 30;
    /*  纵坐标每层的偏移量  */
    private static final int VERTICAL_OFFSET = 100;
    /*  搜索的关键字 */
    private Integer key;
    /* 是否搜索的boolean变量 */
    private boolean isSearch;

    /*  tree数据结构 */
    private BinaryTree<Integer> mTree;

    public MyTreeView(Context context) {
        this(context, null, 0);
    }

    public MyTreeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTreeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        initPaint();
//        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mTree != null && mTree.getRoot() != null) {
            drawTree(canvas, mTree.getRoot(), getWidth() / 2, 50, getWidth() / 8);
        }
    }


    private void drawTree(Canvas canvas, BinaryTree.TreeNode<Integer> root, int x, int y, int hOffset) {

        //fixme has problems
        if (isSearch) {
            if (mTree.search(key)) {
                canvas.drawCircle(x, y, RADIUS, mSearchPaint);
            }
        } else {
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }

        canvas.drawText(String.valueOf(root.element), x - TEXT_SIZE / 4, y + TEXT_SIZE / 2, mPaint);

        if (root.left != null) {
            drawConnectLeftLine(canvas, x, y, x - hOffset, y + VERTICAL_OFFSET);
            drawTree(canvas, root.left, x - hOffset, y + VERTICAL_OFFSET, hOffset / 2);
        }

        if (root.right != null) {
            drawConnectRightLine(canvas, x, y, x + hOffset, y + VERTICAL_OFFSET);
            drawTree(canvas, root.right, x + hOffset, y + VERTICAL_OFFSET, hOffset / 2);
        }

    }

    /*  画左边链接的线 */
    private void drawConnectLeftLine(Canvas canvas, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(VERTICAL_OFFSET * VERTICAL_OFFSET + (x1 - x2) * (x1 - x2));
        int x11 = (int) (x2 + RADIUS * (x1 - x2) / d);
        int x22 = (int) (x1 - RADIUS * (x1 - x2) / d);
        int y11 = (int) (y2 - RADIUS * VERTICAL_OFFSET / d);
        int y22 = (int) (y1 + RADIUS * VERTICAL_OFFSET / d);
        canvas.drawLine(x11, y11, x22, y22, mPaint);
    }

    /*  画右边连接的线  */
    private void drawConnectRightLine(Canvas canvas, int x1, int y1, int x2, int y2) {
        double d = Math.sqrt(VERTICAL_OFFSET * VERTICAL_OFFSET + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 + RADIUS * (x2 - x1) / d);
        int x22 = (int) (x2 - RADIUS * (x2 - x1) / d);
        int y11 = (int) (y1 + RADIUS * VERTICAL_OFFSET / d);
        int y22 = (int) (y2 - RADIUS * VERTICAL_OFFSET / d);
        canvas.drawLine(x11, y11, x22, y22, mPaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* 初始化数据  */
    private void initData() {
        mTree = new BinaryTree<Integer>(mDataArray);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(PAINT_SIZE);
        mPaint.setColor(getResources().getColor(R.color.red));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(TEXT_SIZE);

        mSearchPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSearchPaint.setStrokeWidth(PAINT_SIZE);
        mSearchPaint.setColor(getResources().getColor(R.color.green));
        mSearchPaint.setStyle(Paint.Style.FILL);
    }

    @Deprecated
    private int calOneCharLenght(char a) {
        return 0;
    }

    public void setData(BinaryTree<Integer> mTree) {
        this.mTree = mTree;
        invalidate();
    }

    public void search(Integer key) {
        this.key = key;
        isSearch = true;
        invalidate();
    }

}
