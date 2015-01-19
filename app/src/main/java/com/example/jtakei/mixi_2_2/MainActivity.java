package com.example.jtakei.mixi_2_2;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById の引数に、View に割り当てた id を指定する
        // View オブジェクトが返ってくるので、適宜キャストする
        TextView view = (TextView) findViewById(R.id.MyTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

public class MainFragment extends Fragment {
    private FragmentCallbacks mCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (FragmentCallbacks) activity;
        } catch (ClassCastException e) {
            // Fragment が組み込まれる先の Activity に対して FragmentCallbacks  インタフェースの実相を要求するため
            // キャストに失敗した場合は、実行例外としてプログラムのミスであることを示
            throw new IllegalStateException("activity should implement FragmentCallbacks", e);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // LayoutInflater を利用して、レイアウトをリソースとして読み込む
       View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // View を持たない Fragment は、ここで null を返す
        return null;
    }

    public static interface FragmentCallbacks {
        public void onHogehoge();
    }
}