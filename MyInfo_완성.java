package myInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyInfo extends JFrame implements ListSelectionListener, ActionListener{

	//리스트 변수 선언
	String[] year = {"2005", "2006", "2007", "2008", "2009"};
	Integer[] month = new Integer[12];
	String[] day = new String[31];

	JList<String> listYear = new JList<String>(year);
	JList<Integer> listMonth = new JList<Integer>(month);
	JList<String> listDay = new JList<String>(day);
	
	//스크롤 생성
	JScrollPane scrollMonth = new JScrollPane(listMonth);
	JScrollPane scrollDay = new JScrollPane(listDay);
	
	
	//라디오 버튼 생성
	JRadioButton radio_male = new JRadioButton("남자");
	JRadioButton radio_female = new JRadioButton("여자");
	
	//sample 라벨 생성
	JLabel sample = new JLabel("20501 홍길동");
	
	//checkBox 생성
	JCheckBox check_agree = new JCheckBox("개인정보 제공에 동의합니다.");
	
	//버튼 생성
	JButton btnOk = new JButton("확인");
	JButton btnNo = new JButton("취소");
	
	//폰트 기본값
	Font defaultFont = new Font("굴림", Font.BOLD, 20);
	
	
	MyInfo(){
		
		
		
		// 2개의 리스트에 데이터 넣기
		for(int i=0; i<month.length; i++) {
			month[i] = i+1;                                    //month 배열은 정수값을 담기 때문에 i+1
		}
		for(int i=0; i<day.length; i++) {
			day[i] = Integer.toString(i+1);                    // day 배열은  String 값을 담기 때문에  String 으로 변환해야겠지
		}
		
		//라디오 버튼을 그룹에 추가해서 둘중에 하나만 선택되도록
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radio_male);
		buttonGroup.add(radio_female);
		

		//기본적으로 제공되는 레이아웃 메소드
		initLayout();
		
		//레이아웃 끝....
		//이벤트 달기
		
		listYear.addListSelectionListener(this);                    //리스트에 달아줘야 하는 이벤트 이름 잘보세요
		listMonth.addListSelectionListener(this);
		listDay.addListSelectionListener(this);
		
		radio_male.addActionListener(this);                          //라디오 버튼에 달아줘야 하는 이벤트 이름 잘보세요
		radio_female.addActionListener(this);
		
		btnOk.addActionListener(this);                          //버튼에 달아줘야 하는 이벤트 이름 잘보세요
		btnNo.addActionListener(this);
		
		
		
	}
	

	//기본적으로 제공되는 레이아웃 메소드, 시험에서는 내용을 변경해야 할수도 있습니다.
	private void initLayout() {
		
		JPanel p = new JPanel();
		p.setLayout(null);
		add(p);
		
		//리스트 위치 
		listYear.setBounds(10, 30, 90, 160);
		scrollMonth.setBounds(120, 30, 90, 160);
		scrollDay.setBounds(220, 30, 90, 160);
		
		//라디오 버튼 위치, 폰트값 설정, 남자가 선택되도록
		radio_male.setBounds(320, 30, 80, 50);
		radio_female.setBounds(320, 80, 80, 50);
		
		radio_male.setFont(defaultFont);
		radio_female.setFont(defaultFont);
		
		radio_male.setSelected(true);
		
		
		//라벨위치
		sample.setBounds(10, 180, 500, 50);
		sample.setFont(defaultFont);
		
		//check box
		check_agree.setBounds(10, 300, 500, 50);
		check_agree.setFont(defaultFont);
		
		
		//버튼 2개 위치
		btnOk.setBounds(100, 360, 80, 20);
		btnNo.setBounds(200, 360, 80, 20);
		
		//패널에 붙이기
		p.add(listYear);
		p.add(scrollMonth);
		p.add(scrollDay);
		p.add(radio_male);
		p.add(radio_female);
		p.add(sample);
		p.add(check_agree);
		p.add(btnOk);
		p.add(btnNo);
		
		
		//리스트의 첫번째 항목이 강제 선택되도록 설정해주는 코드
		//만약 setSelectedIndex(3);  요렇게 되어 있다면 리스트의 네번째값이 선택되겠지.
		listYear.setSelectedIndex(0);
		listMonth.setSelectedIndex(0);
		listDay.setSelectedIndex(0);
		
		changeSample();
		
		//기본세팅
		setTitle("수행평가 연습");
		setSize(450, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new MyInfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {      //메소드 이름 잘보세요!! 확인, 취소 , 라디오 버튼이 클릭되면 요게 실행됨.
		
		//확인버튼, 취소버튼 눌렀을때 동작 정의
		
		if(e.getSource() == btnOk) {          //확인버튼을 눌렀을때는 체크박스가 체크되어 있는지 여부를 확인해야 합니다.
			if(check_agree.isSelected() == false) { 
				JOptionPane.showMessageDialog(null, "개인정보제공에 동의해주세요");     //체크박스가 체크되어 있지 않다면 체크해달라고 메시지 띄우기
			}
			else {
				JOptionPane.showMessageDialog(null, "감사합니다.");       //체크박스가 체크되어 있다면 메시지 띄우고 종료
				dispose();
			}
		}
		else if(e.getSource() == btnNo) {    //취소 버튼을 눌렀을떄는 그냥 끄면 됩니다.
			dispose();
		}
		else if((e.getSource() == radio_female) || (e.getSource() == radio_male)) {   //라디오버튼을 눌렀을때는 sample 라벨의 값만 바꿔주면 되니까   changeSample()  메소드 호출
			changeSample();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {    //메소드 이름 잘보세요!! 리스트 값이 바뀌면 요 함수가 실행됨
		
		//선택이 바뀔때마다 변경된 값을 sample 에 표시한다.
		changeSample();
		
	}

	private void changeSample() {
		//[문제4] 함수 내부 구현
		
		String y = listYear.getSelectedValue();        //listYear  리스트는 데이터가 String  이라서 String 변수에 담기
		int m = listMonth.getSelectedValue();          //listMonth  리스트는 데이터가 int  라서 int 변수에 담기
		String d = listDay.getSelectedValue();         //listDay  리스트는 데이터가 String  이라서 String 변수에 담기
		
		String info = "생년월일 : " + y + "년" + m + "월" + d + "일";
		
		if(radio_male.isSelected()) {                    // 라디오버튼 남자가 선택되어 있다면
			info = "성별 : " + "남자 " + info;
		}
		else if(radio_female.isSelected()) {             // 라디오버튼 여자가 선택되어 있다면
			info = "성별 : " + "여자 " + info;
		}
		
		
		sample.setText(info);              // sample 라벨에 info 값 찍어주기.
		
	}

}
