package com.example.mygreendao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mygreendao.bean.MockResult;

import java.util.ArrayList;
import java.util.List;

//GreenDao数据库基本类
//GreenDao第二次提交添加注释
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 插入
     */
    private Button mInsert;
    /**
     * 查询
     */
    private Button mCha;
    private TextView mShow;
    private StudentDaoUtil mStudentDaoUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mStudentDaoUtil = new StudentDaoUtil(this);
    }

    private void initView() {
        mInsert = (Button) findViewById(R.id.insert);
        mInsert.setOnClickListener(this);
        mCha = (Button) findViewById(R.id.cha);
        mCha.setOnClickListener(this);
        mShow = (TextView) findViewById(R.id.show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.insert:
                List<MockResult> list = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    MockResult mockResult = new MockResult((long) i, "jiang" + i, 90 + i);
                    list.add(mockResult);
                }
                mStudentDaoUtil.insertMultStudent(list);
                break;
            case R.id.cha:
                List<MockResult> list1 = mStudentDaoUtil.queryAll();
                String s = list1.toString();
                mShow.setText(s);
                break;
        }
    }
}
