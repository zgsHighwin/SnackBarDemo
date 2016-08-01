package highwin.zgs.snackbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click1(View v) {
        //父布局最好为CoordinaterLayout
        Snackbar snackbar = Snackbar.make(findViewById(R.id.tv), "snackbar", Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ViewGroup.LayoutParams vl = view.getLayoutParams();
        CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, vl.height);
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(Color.RED);   //获取snackbar的文本
        Button snackBarAction = (Button) view.findViewById(R.id.snackbar_action);//获取snackbar的action按钮
        cl.gravity = Gravity.CENTER;  //父布局不是CorrdinatorLayout不起作用
        cl.setMargins(50, 0, 60, 0);                   //设置左右边距
        view.setLayoutParams(cl);
        view.setBackgroundColor(Color.BLUE);       //设置snackbar背景
        ImageView imageView = new ImageView(MainActivity.this);  //添加图片
        imageView.setImageResource(R.mipmap.ic_launcher);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        snackbarLayout.addView(imageView, 0);
        snackbar.setActionTextColor(Color.YELLOW).setAction("clickme", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "helloworld", Toast.LENGTH_SHORT).show();
            }
        }).setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                Toast.makeText(MainActivity.this, "snackbat is dismiss", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                Toast.makeText(MainActivity.this, "snackbar is show", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
