package com.heeyjinny.containerspinner

import android.icu.number.Notation.simple
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.heeyjinny.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)

        //스피너에 입력될 가상의 데이터를 가지고 있는 변수를(data) 생성하고 배열데이터(listof()) 입력
        var data = listOf("-선택하세요-","1월","2월","3월","4월","5월","6월")

        //데이터 data와 스피너를 연결해줄 ArratAdapter클래스를 생성하여 변수(adapter)에 저장
        //ArratAdapter 클래스 생성 시 제네릭<>을 사용해 데이터 타입 입력, data가 문자열로 입력됐기 때문에 타입은 String
        //ArratAdapter 클래스 3개의 파라미터 :
        //스피너를 화면에 그리기 위한 컨텍스트, 스피너에 보여줄 목록이 그려질 레이아웃, 어댑터에 사용할 데이터
        //레이아웃 simple_list_item_1 : 텍스트뷰 1개만 가지고 있는 특수 레이아웃, 기본 어댑터에 사용시 입력된 데이터에서 문자열
        //1개를 꺼내 레이아웃에 그려줌
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)

        //데이터를 가지고 있는 어댑터를 스피너 위젯에 연결
        //스피너의 adapter속성에 어탭터클래스를 생성한 변수를 담아줌
        binding.spinner.adapter = adapter


        //스피너 선택 시 선택한 값을 선택 결과 뷰에 보여주기
        //스피너 선택동작 인식 리스너 : onItemSelectedListener 사용하여 메소드 목록 불러오기
        //리스너 사용 시 = object: OnIt 까지만 입력해도 자동완성으로 AdapterView가 적어지도록 되어있음...
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                //파라미터의 대부분 세 번째 파라미터만 사용
                //세 번째 파라미터는 원래 p2로 자동 생성 됐으나 position으로 바꿔서 사용함
                //position : 스피너 목록 선택 시 몇 번째 아이템 인지 알려주는 파라미터

                //리스너에서 넘겨주는 position값으로 data의 해당 위치에 있는 문자 값을 선택결과 뷰에 입력
                binding.result.text = data.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

    }//onCreate
}//MainActivity