package com.example.a20133.suntranstest14;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a20133.suntranstest14.databinding.ActivityMainBinding;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = new ArrayList<>();
    ArrayList<String> list3 = new ArrayList<>();
    ArrayList<String> list4 = new ArrayList<>();
    private TextView textView;
    private Button button;

    Employee employee = new Employee("Xie", "Yao", "220V");
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        textView = (TextView) findViewById(R.id.xyTextView);

//        binding.setEmployee(employee);
        binding.setVariable(BR.employee,employee);
        binding.setPresenter(new Presenter());
        button = (Button) findViewById(R.id.id_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Webservicexy webservicexy = new Webservicexy(textView,employee,binding);
                webservicexy.execute();
            }
        });


    }

    public class Presenter {
        public void onTextChanged(CharSequence s, int start, int befor, int count) {
            employee.setFirstname(s.toString());
            binding.setEmployee(employee);
        }

        public void onclick(View view) {
            Toast.makeText(MainActivity.this, "哈哈哈",
                    Toast.LENGTH_SHORT).show();
        }

        public void onclicklistenerBinding() {
            Webservicexy webservicexy = new Webservicexy(textView,employee,binding);
            webservicexy.execute();
            /*new AsyncTask<Object, Object, Void>() {
                @Override
                protected Void doInBackground(Object... params) {
                    try {
                        getRemoteInfo();
                    }  catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                public void getRemoteInfo() throws Exception{
                    String WSDL_URI = "http://www.suntrans.net:8602/WebService.asmx";//wsdl 的uri
                    String namespace = "http://www.suntrans.net/";//namespace
                    String methodName = "Inquiry_Sub_R";//要调用的方法名称

                    SoapObject request = new SoapObject(namespace, methodName);
                    // 设置需调用WebService接口需要传入的两个参数mobileCode、userId
                    request.addProperty("BID", 1);
//        request.addProperty("userId", "");

                    //创建SoapSerializationEnvelope 对象，同时指定soap版本号(之前在wsdl中看到的)
                    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER12);
                    envelope.bodyOut = request;//由于是发送请求，所以是设置bodyOut
                    envelope.dotNet = true;//由于是.net开发的webservice，所以这里要设置为true

                    HttpTransportSE httpTransportSE = new HttpTransportSE(WSDL_URI);
                    httpTransportSE.call(null, envelope);//调用

                    // 获取返回的数据
                    SoapObject object = (SoapObject) envelope.bodyIn;
                    SoapObject soap1 = (SoapObject)object.getProperty(0);
                    SoapObject childs1 = (SoapObject)soap1.getProperty(1);
                    SoapObject soap2 = (SoapObject)childs1.getProperty(0);


                    for(int i=0;i<soap2.getPropertyCount();i++){
                        SoapObject soap3 = (SoapObject)soap2.getProperty(i);
                        for(int j=0;j<soap3.getPropertyCount();j++){
                            switch (i){
                                case 0:
                                    list1.add(j,soap3.getProperty(j).toString());

                                    if(j==1){
                                        String gettime = list1.get(1).substring(0,16);
                                        gettime = gettime.replace("T"," ");
                                        list1.set(1,gettime);

                                    }
                                    break;
                                case 1:
                                    list2.add(j,soap3.getProperty(j).toString());
                                    if(j==1){
                                        String gettime = list2.get(1).substring(0,16);
                                        gettime = gettime.replace("T"," ");
                                        list2.set(1,gettime);
                                    }
                                    break;
                                case 2:
                                    list3.add(j,soap3.getProperty(j).toString());
                                    if(j==1){
                                        String gettime = list3.get(1).substring(0,16);
                                        gettime = gettime.replace("T"," ");
                                        list3.set(1,gettime);
                                    }
                                    break;
                                case 3:
                                    list4.add(j,soap3.getProperty(j).toString());
                                    if(j==1){
                                        String gettime = list4.get(1).substring(0,16);
                                        gettime = gettime.replace("T"," ");
                                        list4.set(1,gettime);
                                    }
                                    break;
                                default:
                                    break;
                            }

                        }

                    }
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    String aa = "100000";
                    employee.setVoltage(aa+"V");
                    binding.setEmployee(employee);
                }
            }.execute();*/

        }

    }

}
