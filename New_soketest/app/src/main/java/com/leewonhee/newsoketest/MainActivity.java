package com.leewonhee.newsoketest;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.leewonhee.newsoketest.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean check=true;
    Button connect_btn;                 // 서버 연결
    Button start_btn;
    EditText ip_edit;               // ip 입력
    TextView show_text;             // 서버 수신값 출력
    // 소켓통신에 필요한것
    private String html = "";
    private Handler mHandler;

    private Socket socket;

    private BufferedReader networkReader;
    private PrintWriter networkWriter;

    private DataOutputStream dos;
    private DataInputStream dis;

    private String ip = "192.168.0.103";            // IP 번호
    private int port = 8080;                          // port 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect_btn = (Button)findViewById(R.id.connect_btn);
        connect_btn.setOnClickListener(this);

        //ip_edit = (EditText)findViewById(R.id.ip_edit);
        show_text = (TextView)findViewById(R.id.show_text);
        start_btn = (Button)findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check=false;
                Log.w("버퍼","정지정지"); // 종료버튼 정지
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.connect_btn:// ip 커넥트
                check=true;
                connect();

        }
    }




    // 로그인 정보 db에 넣어주고 연결시켜야 함.
    void connect(){
        mHandler = new Handler();
        String a = "답장 : ";
        Log.w("connect","연결 하는중");
        // 받아오는거
        Thread checkUpdate = new Thread() {
            public void run() {
                // ip받기
                String newip = ip;

                // 서버 접속
                try {
                    socket = new Socket(newip, port);
                    Log.w("서버 접속됨", "서버 접속됨");
                } catch (IOException e1) {
                    Log.w("서버접속못함", "서버접속못함");
                    e1.printStackTrace();
                }

                Log.w("edit 넘어가야 할 값 : ","안드로이드에서 서버로 연결요청");

                // Buffered가 잘못된듯.
                try {
                    dos = new DataOutputStream(socket.getOutputStream());   // output에 보낼꺼 넣음
                    dis = new DataInputStream(socket.getInputStream());     // input에 받을꺼 넣어짐
                    dos.writeUTF("안드로이드에서 서버로 연결요청");

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.w("버퍼", "버퍼생성 잘못됨");
                }
                Log.w("버퍼","버퍼생성 잘됨");
                check=true;
                while(true) {
                    // 서버에서 받아옴
                    try {
                        check=true;
                        String line = "";
                        int line2;
                        while (true) {
                            //line = (String) dis.readUTF();
                            line2 = (int) dis.read();
                            //Log.w("서버에서 받아온 값 ", "" + line);
                            //Log.w("서버에서 받아온 값 ", "" + line2+check);

                            if(line2 == 1) {
                                if(check==false){
                                    dos.write(99);
                                    Log.w("------서버에서 받아온 값 ",""+ line2);
                                    show_text.setText("off");
                                    socket.close();
                                    break;
                                }
                                Log.w("------서버에서 받아온 값 ",""+ line2);
                                dos.writeUTF(a + line2);
                                show_text.setText("on");
                                dos.flush();
                            }

                        }
                    } catch (Exception e) {

                    }
                }

            }
        };





        // 소켓 접속 시도, 버퍼생성
        checkUpdate.start();
    }


}
