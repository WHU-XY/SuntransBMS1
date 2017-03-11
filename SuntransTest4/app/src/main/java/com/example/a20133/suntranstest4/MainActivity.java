package com.example.a20133.suntranstest4;


        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.PopupWindow;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String[] province = new String[] {"直辖市", "特别行政区","黑龙江"};
    private String[][] pandc = new String[][]{{"北京","上海","天津","重庆"},{"香港","澳门"},
            {"哈尔滨","齐齐哈尔","牡丹江","大庆","伊春","双鸭山","鹤岗","鸡西","佳木斯","七台河","黑河","绥化","大兴安岭"}};
    private ListView mListView;
    private PopupWindow popupWindow;
    private ListView pop_listView;
    private TextView showText;
    private int firstMenuIndex =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView)findViewById(R.id.textView);
        mListView =(ListView)findViewById(R.id.listView);
        mListView.setVisibility(View.GONE);
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,province));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pop_listView.setAdapter(new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,pandc[position]));
                firstMenuIndex = position;
                popupWindow.showAsDropDown(mListView,view.getMeasuredWidth(),-mListView.getMeasuredHeight());
            }
        });

        initPopupWindow();
    }

    private void initPopupWindow() {
        pop_listView = (ListView)LayoutInflater.from(this).inflate(R.layout.popupwindow,null);
        pop_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showText.setText(pandc[firstMenuIndex][position]);
                popupWindow.dismiss();
                mListView.setVisibility(View.GONE);
            }
        });

        popupWindow = new PopupWindow(pop_listView, 150,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setFocusable(true);
    }

    public void showListMenu(View view)
    {
        if(View.VISIBLE == mListView.getVisibility())
        {
            mListView.setVisibility(View.GONE);
        }
        else
        {
            mListView.setVisibility(View.VISIBLE);
        }
    }
}

