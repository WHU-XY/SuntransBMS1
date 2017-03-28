package com.example.a20133.suntranstest14;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a20133.suntranstest14.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Employee employee = new Employee("Xie","Yao");
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setEmployee(employee);
//        binding.setVariable(BR.employee,employee);
        binding.setPresenter(new Presenter());
    }
    public class  Presenter{
        public void onTextChanged(CharSequence s,int start, int befor,int count){
            employee.setFirstname(s.toString());
            binding.setEmployee(employee);

        }
        public void onclick(View view){
            Toast.makeText(MainActivity.this,"哈哈哈",
                    Toast.LENGTH_SHORT).show();
        }
        public void onclicklistenerBinding(Employee employee){
            Toast.makeText(MainActivity.this,employee.getFirstname(),
                    Toast.LENGTH_SHORT).show();
        }

    }

}
